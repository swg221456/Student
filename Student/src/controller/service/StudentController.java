package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TNotice;
import model.Tuser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.NoticeDAO;
import business.dao.StudentDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.NoticeDaoImpl;
import business.impl.StudentDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getstudent")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String noticename,Integer classid,Integer collegeid,Integer majorid,
			HttpServletResponse response, Model model) {

		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  stuname like '%"+noticename+"%'  ";
			
		}
		if (classid != null && classid != 0) {
			
			opreation += "and  classid like '%"+classid+"%'  ";
		}
		if (majorid != null && majorid != 0) {
			
			opreation += "and  majorid like '%"+majorid+"%'  ";
		}
		if (collegeid != null && collegeid != 0) {
			
			opreation += "and  collegeid like '%"+collegeid+"%'  ";
		}
		
		
		
		// System.out.println(opreation);
		int allcount = audao.getNoticeList(opreation);

		List list = audao.getNoticeList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}
	
	
	
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getsheet")
	public void getsheetList(HttpServletRequest request, int page,
			int limit, Integer classid,Integer collegeid,Integer majorid,Integer curriculumid,
			HttpServletResponse response, Model model) {

		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		
		if (classid != null && classid != 0) {
			
			opreation += "and  classid like '%"+classid+"%'  ";
		}
		if (majorid != null && majorid != 0) {
			
			opreation += "and  majorid like '%"+majorid+"%'  ";
		}
		if (collegeid != null && collegeid != 0) {
			
			opreation += "and  collegeid like '%"+collegeid+"%'  ";
		}
		if (curriculumid != null && curriculumid != 0) {
			
			opreation += "and  curriculumid like '%"+curriculumid+"%'  ";
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getsheetList(opreation);

		List list = audao.getsheetList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}
	
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getmysheet")
	public void getmysheetList(HttpServletRequest request, int page,
			int limit, Integer semesterid,
			HttpServletResponse response, Model model) {

		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		VAdminUser modle = (VAdminUser) loginuser;
		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		
		
		if (semesterid != null && semesterid != 0) {
			
			opreation += "and  semesterid like '%"+semesterid+"%'  ";
		}
		
		/*if (modle != null ) {
			
			opreation += "and  userid like '%"+modle.getUserid()+"%'  ";
		}
		*/
		
		
		
		// System.out.println(opreation);
		int allcount = audao.getsheetList(opreation);

		List list = audao.getsheetList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addstudent")
	public void addAdminUser( String stuname, String stunum,String agend,String birthday,String phone,String email,String userid,
			String classid,String stucard,
			String remarks,  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		VAdminUser modle = (VAdminUser) loginuser;
		NoticeDAO audao = new NoticeDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TNotice user = new TNotice();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String  createTime = df.format(new Date());
		
		

		if (audao.addNotice(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "新闻添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}
}
