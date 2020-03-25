package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TphotoInfo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.PhotoDAO;
import business.impl.PhotoDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * 处理来自于富文本编辑器的图片上传
 * 1、接受上传文件
 * 2、创建文件在服务器上的存储路径
 * 3、保存文件在路径中
 * 4、在T_photo表中创建图片资源记录，并获得该图片记录id
 * 5、返回结果给jsp页面
 * @author zhang jin sheng
 *
 */
public class EditFileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;  
	  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doPost(request, response);
    }  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	//定义一个用于返回值的json类型对象
    	LayuiEdiePicData respjson = new LayuiEdiePicData();
    	
        String fileName = null;//上传到servlet的文件名
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
      
        //存放文件的相对路径，博主照片一般存放在realPath代表的路径中，
        //因此realaPath通常接受的参数就是博主的userid
        String relaPath = request.getParameter("path");
        
        //如果上传的是博文的图片文件，则该titleid作为在博主目录下的子目录名称
        String titleid = request.getParameter("titleid");
        
        //将path和titleid组成一个相对路径
        //如果titleid不为空，则上传的是博文图片，路径为<用户名>\<博文id>
        //如果titleid为空，则上传的是博主图片，路径仅为<用户名>\
        if(titleid!=null && !titleid.equals("")){
        	relaPath = relaPath +"\\" + titleid;
        }
        
        //如果网页还有其它参数，则以下的循环将把其它参数一并的取出来
        Enumeration em = request.getParameterNames();
        while(em.hasMoreElements()){
        	String s = (String)em.nextElement();
        }
      
        ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());// 解析    //创建上传文件对象
		
		try {
			//itemList保存有从jsp中获取出来的图片的全路径名称
			List itemList = upload.parseRequest(request); //从请求对象中获得对象列表
			for (Iterator it = itemList.iterator(); it.hasNext();) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField())// 如果是非表单数据
				{	
					if(item.getName().length()<=0)return;//表示后面的文件域没有选中文件

					//方式二：采用文件输入输出流，输出文件 
					// 统一Linux与windows的路径分隔符
					fileName =item.getName().replace("/", "\\");
					//c:\xxx\xxx
					if(fileName.lastIndexOf("\\")!=-1){  //如果取到的文件地址拥有目录路径，则将目录路径去除
						fileName = fileName.substring(fileName.lastIndexOf("\\"));
					}
					
					 //项目在服务器上的路径,因为上传文件需要保存在服务器路径中
					String path = "";
					if(relaPath==null || relaPath.equals("")){
						path =  "e:\\tomcatupload\\bbs\\" ;
					}else{
						path = "e:\\tomcatupload\\bbs\\" + relaPath +"\\";
					}

	               
	                //根据路径和文件名创建路径和文件
	                File f = new File(path, fileName);
					f.getParentFile().mkdirs();// 保证路径存在
	
					InputStream ins = item.getInputStream();
					OutputStream ous = new FileOutputStream(f);
					byte[] tmp = new byte[1024];
					int len = -1;
					//从上传文件对象中读取数据，并写入到创建的服务器文件中
					while ((len = ins.read(tmp)) != -1) {
						ous.write(tmp, 0, len);
					}
					ous.close();
					ins.close();
					
					//图片资源上传成功后，将在T_Photo表中创建一条图片资源的管理记录
					PhotoDAO daos = new PhotoDaoImpl();
					TphotoInfo photo = new TphotoInfo();
					photo.setPhotopath(relaPath+"\\"+fileName);
					photo.setIsDel(0);
					int photoid = Integer.parseInt(daos.addPhoto(photo).toString());
					
					respjson.code = ResponseJSON.FLAG_SUCC; //获取数据成功
					respjson.msg = "文件上传成功"; 
					LayuiPic picdata = new LayuiPic("../upload1/"+relaPath+"\\"+fileName,fileName,photoid);
					respjson.data = picdata;
				}
			}
	    }  catch (Exception e) {  
	        e.printStackTrace(); 
	        respjson.code = ResponseJSON.FLAG_FAIL; //获取数据失败
			respjson.msg = "文件上传失败";
	    }  
          
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//System.out.println(JSON.toJSONString(respjson));
		out.write(JSON.toJSONString(respjson));
    } 
    
    public String getRootPath(String path){
		String rootpath;
		int pos = path.lastIndexOf("\\");
		rootpath = path.substring(0, pos);
		pos = rootpath.lastIndexOf("\\");
		rootpath = rootpath.substring(0, pos+1);
		return rootpath;
	}		
}
