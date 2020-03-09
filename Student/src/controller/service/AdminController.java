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
import model.Tteacher;
import model.Tuser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.NoticeDAO;
import business.dao.TeacherDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.NoticeDaoImpl;
import business.impl.TeacherDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "admin2")
public class AdminController {
	
	/**
	 * 获取公告信息列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getnotice")
	public void getNoticeList(HttpServletRequest request, int page,
			int limit, String noticename,
			HttpServletResponse response, Model model) {

		NoticeDAO audao = new NoticeDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			 opreation = "and  noticeName like '%"+noticename+"%'  ";
			
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
	 * 实现一个公告信息的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addnotice")
	public void addNotice(String noticeName,String noticecontent,
			String remarks, HttpServletRequest request,
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
		user.setIsdelete(0);
		user.setNoticecontent(noticecontent);
		user.setNoticeName(noticeName);
		user.setRemarks(remarks);
		user.setUserid(modle.getUserid());
		user.setCreatedate(createTime);
		

		if (audao.addNotice(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "公告添加成功";
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
	
	/**
	 * 获取教师信息列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getteacher")
	public void getTeacherList(HttpServletRequest request, int page,
			int limit, String noticename,
			HttpServletResponse response, Model model) {

		TeacherDAO audao = new TeacherDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			 opreation = "and  teaName like '%"+noticename+"%'  ";
			
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getteacherList(opreation);

		List list = audao.getteacherList(opreation, page, limit);

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
	 * 
	 */
	@RequestMapping(value = "/loacduser")
	public void GetLoacdLine( HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO ardao = new AdminUserDaoImpl();
		List list = ardao.getUserList();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

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
	 * 实现一个公告信息的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addteacher")
	public void addteacher( String teaName, String teaphone,
			String userid,String teasex,  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		TeacherDAO audao = new TeacherDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tteacher user = new Tteacher();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String  createTime = df.format(new Date());
		user.setIsdelete(0);
		user.setAuditstatus(false);
		user.setTeaName(teaName);
		user.setTeaphone(teaphone);
		user.setTeasex(teasex);
		user.setUserid(userid);
		
		

		if (audao.addTteacher(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "教师添加成功";
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

	
	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "changestate")
	public void changeUserState(Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		TeacherDAO smdao = new  TeacherDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.changeState(id)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "启用成功";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "启用失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "changeuser")
	public void changeUser(String userid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		AdminUserDAO smdao = new  AdminUserDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.changeState(userid)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "启用成功";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "启用失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/loacdtea")
	public void GetLoacdtear( HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		TeacherDAO ardao = new TeacherDaoImpl();
		List list = ardao.getteacherList();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

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
}
