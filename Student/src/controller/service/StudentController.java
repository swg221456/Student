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

import model.TCourse;
import model.TNotice;
import model.TSheet;
import model.TStuinfo;
import model.Tuser;
import model.VAdminUser;
import model.VTeacher;
import model.Vstudent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.CourseDAO;
import business.dao.NoticeDAO;
import business.dao.StudentDAO;
import business.dao.TeacherDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.CourseDAOImpl;
import business.impl.NoticeDaoImpl;
import business.impl.StudentDaoImpl;
import business.impl.TeacherDaoImpl;

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
		int allcount = audao.getVstuList(opreation);

		List list = audao.getVstuList(opreation, page, limit);

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
	@RequestMapping(value = "getmystudent")
	public void getmyUserList(HttpServletRequest request, int page,
			int limit, 
			HttpServletResponse response, Model model) {

		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		VAdminUser modle = (VAdminUser) loginuser;
		
		if (modle != null ) {
			
			opreation += "and  userid like '%"+modle.getUserid()+"%'  ";
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getVstuList(opreation);

		List list = audao.getVstuList(opreation, page, limit);

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
	
	
	@RequestMapping(value = "getmystu")
	public void getmyList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		VAdminUser modle = (VAdminUser) loginuser;
		
		if (modle != null ) {
			
			opreation += "and  userid like '%"+modle.getUserid()+"%'  ";
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getVstuList(opreation);

		List<Vstudent> list = audao.getstuList(opreation);
		
		
		

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

		HttpSession session = request.getSession();
		Object loginuser = session.getAttribute("loginuser");
		VAdminUser modle = (VAdminUser) loginuser;
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
		
		if (modle != null ) {
			
			opreation += "and  userid like '%"+modle.getUserid()+"%'  ";
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
	
	/**
	 * 实现学生用户的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upstudent")
	public void upAdminUser( String stuname, String stunum,String agend,Integer classid,
			String birthday,String phone,String email,Integer id, String stucard,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		StudentDAO audao = new StudentDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TStuinfo user = new TStuinfo();
		birthday += " 01:01:00";
		user = audao.getstu(id);
		user.setAgend(agend);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setPhone(phone);
		user.setStucard(stucard);
		user.setStuname(stuname);
		user.setStunum(stunum);
		if(classid != 0){
		user.setClassid(classid);
		}
		HttpSession session = request.getSession();
		session.removeAttribute("stuinfo");
		
		

		if (audao.update(user)) {
			List<Vstudent> vstu = audao.getstubyuserid(user.getUserid());
			for (Vstudent vv:vstu){
				Vstudent vter = vv;
				
				session.setAttribute("stuinfo", vter);
			}
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "信息修改成功";
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
	 * 实现学生用户的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addsheet")
	public void addSheet( Integer classid, Integer courseid,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		StudentDAO audao = new StudentDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TStuinfo user = new TStuinfo();
		List<Vstudent> stuList = audao.getstuList(classid);
		
		CourseDAO coudao = new CourseDAOImpl();
		boolean ad = false;
		boolean up = false;
		for (Vstudent vv:stuList){
			Vstudent vter = vv;
			int stuinfoid = vter.getStuinfoid();
			List list = coudao.getCourseList(stuinfoid, courseid);
			if (list.size() == 0) {
				TSheet sheet = new TSheet();
				sheet.setCourseid(courseid);
				sheet.setIsdelete(0);
				sheet.setStuinfoid(stuinfoid);
				sheet.setEvaluate("");
				sheet.setFraction(0.00);
				sheet.setRemakes("");
				 ad = audao.addsheet(sheet);
			}else {
				 up = true;
			}
			
			
		}
		
		if (ad ==true || up == true) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "信息修改成功";
			
		} else {laydata.code = LayuiData.ERRR;
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
	@RequestMapping(value = "getsheets")
	public void getsheetList(HttpServletRequest request, int page,
			int limit, Integer classid,Integer courseid,
			HttpServletResponse response, Model model) {
		
		HttpSession session = request.getSession();
		VAdminUser user = (VAdminUser) session.getAttribute("loginuser");
		
		TeacherDAO tedao = new TeacherDaoImpl();
		List<VTeacher> vteaList = tedao.getVteacherList(user.getUserid());
		VTeacher vter = new VTeacher();
		for (VTeacher vv:vteaList){
			vter = vv;
		}

		StudentDAO audao = new StudentDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		
		
		if (classid != null && classid != 0) {
			
			opreation += "and  classid like '%"+classid+"%'  ";
		}
		if (courseid != null && courseid != 0) {
			
			opreation += "and  courseid like '%"+courseid+"%'  ";
		}
		if (vter.getTeacherid() != null && vter.getTeacherid() != 0) {
			
			opreation += "and  teacherid like '%"+vter.getTeacherid()+"%'  ";
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
	 * 实现学生用户的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upsheet")
	public void upsheet( Integer sheetid, String fraction,String evaluate,Integer courseid,Integer stuinfoid,String remakes,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		StudentDAO audao = new StudentDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TSheet user = new TSheet();
		user.setCourseid(courseid);
		user.setEvaluate(evaluate);
		user.setFraction(Double.parseDouble(fraction));
		user.setIsdelete(0);
		user.setStuinfoid(stuinfoid);
		user.setSheetid(sheetid);
		user.setRemakes(remakes);
		
		
		
		

		if (audao.upsheet(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "信息修改成功";
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
	
	
	
}
