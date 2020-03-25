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

import model.TClass;
import model.TCollege;
import model.TNotice;
import model.Tmajor;
import model.Tuser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.ClassDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.NoticeDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.ClassDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.NoticeDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "college")
public class CollegeController {
	
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
	@RequestMapping(value = "getcollege")
	public void getCollegeList(HttpServletRequest request, int page,
			int limit, String noticename,
			HttpServletResponse response, Model model) {

		CollegeDAO audao = new CollegeDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  collegeName like '%"+noticename+"%'  ";
			
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getCollegeList(opreation);

		List list = audao.getCollegeList(opreation, page, limit);

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
	@RequestMapping(value = "/addcollege")
	public void addCollege( String collegeName, String userid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		CollegeDAO audao = new CollegeDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TCollege user = new TCollege();
		user.setCollegeName(collegeName);
		user.setUserid(userid);
		user.setIsdelete(0);
		
		

		if (audao.addCollege(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "学院添加成功";
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
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upcollege")
	public void upCollege(Integer collegeid, String collegeName, String userid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		CollegeDAO audao = new CollegeDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TCollege user = new TCollege();
		user.setCollegeName(collegeName);
		user.setUserid(userid);
		user.setIsdelete(0);
		user.setCollegeid(collegeid);
		
		

		if (audao.update(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "学院修改成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "修改失败";
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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/loacduser")
	public void GetLoacduser( HttpServletRequest request,Integer roleID,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO ardao = new AdminUserDaoImpl();
		List list = ardao.getaAdminUserList(roleID);

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
	
	@RequestMapping(value = "getmajor")
	public void getMajorList(HttpServletRequest request, int page,
			int limit, String noticename,Integer college,
			HttpServletResponse response, Model model) {

		MajorDAO audao = new MajorDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  majorName like '%"+noticename+"%'  ";
			
		}
		if (college != null && college != 0) {
			
			opreation += "and  collegeid like '%"+college+"%'  ";
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getVmajorList(opreation);

		List list = audao.getVmajorList(opreation, page, limit);

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
	@RequestMapping(value = "/addmajor")
	public void addMajor( String majorName, String userid,Integer collegeid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		MajorDAO audao = new MajorDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tmajor user = new Tmajor();
		user.setMajorName(majorName);
		user.setCollegeid(collegeid);
		user.setUserid(userid);
		user.setIsdelete(0);
		
		

		if (audao.addMajor(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "专业添加成功";
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
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upmajor")
	public void upMajor( String majorName, String userid,Integer collegeid,Integer majorid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		MajorDAO audao = new MajorDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tmajor user = new Tmajor();
		user.setMajorName(majorName);
		user.setCollegeid(collegeid);
		user.setUserid(userid);
		user.setIsdelete(0);
		user.setMajorid(majorid);
		
		

		if (audao.update(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "专业修改成功";
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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadcollege")
	public void GetLoacdcollege( HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		CollegeDAO ardao = new CollegeDaoImpl();
		List list = ardao.getCollegeList();

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
	 * 实现车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadmajor")
	public void GetLoacdmajor( HttpServletRequest request,Integer collegeid,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		MajorDAO ardao = new MajorDaoImpl();
		List list = ardao.getVmajorList(collegeid);

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
	
	@RequestMapping(value = "/loadclass")
	public void GetLoacdclass( HttpServletRequest request,Integer majorid,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		ClassDAO ardao = new ClassDaoImpl();
		List list = ardao.getClassList(majorid);

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
	
	@RequestMapping(value = "getclass")
	public void getclass(HttpServletRequest request, int page,
			int limit, String noticename,Integer major,
			HttpServletResponse response, Model model) {

		ClassDAO audao = new ClassDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  className like '%"+noticename+"%'  ";
			
		}
		if (major != null && major != 0) {
			
			opreation += "and  majorid like '%"+major+"%'  ";
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getClassList(opreation);

		List list = audao.getClassList(opreation, page, limit);

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
	@RequestMapping(value = "/addclass")
	public void addcalss( String calssName, String userid,Integer majorid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		ClassDAO audao = new ClassDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TClass user = new TClass();
		user.setClassName(calssName);
		user.setMajorid(majorid);
		user.setUserid(userid);
		user.setIsdelete(0);
		
		

		if (audao.addClass(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "班级添加成功";
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
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upclass")
	public void upcalss( String className, String userid,Integer majorid,Integer classid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		ClassDAO audao = new ClassDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TClass user = new TClass();
		user.setClassName(className);
		user.setMajorid(majorid);
		user.setUserid(userid);
		user.setIsdelete(0);
		user.setClassid(classid);
		
		

		if (audao.update(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "班级修改成功";
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
