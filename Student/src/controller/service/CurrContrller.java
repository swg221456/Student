package controller.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

import javafx.scene.layout.VBox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import model.TCourse;
import model.TCurriculum;
import model.Tsemester;




import model.VAdminUser;
import model.VTeacher;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.basic.iHibBaseDAO;
import business.dao.CourseDAO;
import business.dao.CurriculumDAO;
import business.dao.SemesterDAO;
import business.dao.TeacherDAO;
import business.impl.CourseDAOImpl;
import business.impl.CurriculumDaoImpl;
import business.impl.SemesterDaoImpl;
import business.impl.TeacherDaoImpl;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping(value = "curr")
public class CurrContrller {

	/**
	 * 获取学期信息列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getsemester")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String noticename,
			HttpServletResponse response, Model model) {

		SemesterDAO audao = new SemesterDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  semesterName like '%"+noticename+"%'  ";
			
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getSemesterList(opreation);

		List list = audao.getSemesterList(opreation, page, limit);

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
	 * 实现一个学期的添加
	 * 
	 * @param semesterName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addsemester")
	public void addAdminUser( String semesterName, String startdate,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		String str =startdate;
		String enddate="";
		String[] sArray= str.split("\\~"); 
		for (int i = 0; i < sArray.length; ++i){
	         startdate = sArray[0];
	         enddate = sArray[1];
	        }
		startdate += "01:01:00";
		enddate += " 01:01:00";

		SemesterDAO audao = new SemesterDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tsemester user = new Tsemester();
		user.setEnddate(enddate);
		user.setSemesterName(semesterName);
		user.setStartdate(startdate);
		user.setIsdelete(0);
		
		

		if (audao.addSemester(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "学期添加成功";
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
	 * 
	 */
	@RequestMapping(value = "/loacdseme")
	public void GetLoacdLine( HttpServletRequest request,Integer roleID,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		SemesterDAO ardao = new SemesterDaoImpl();
		List list = ardao.getSemesterList();

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
	 * 获取课程信息列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcurr")
	public void getcurrList(HttpServletRequest request, int page,
			int limit, String noticename,Integer semesterid,
			HttpServletResponse response, Model model) {

		CurriculumDAO audao = new CurriculumDaoImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (noticename != null && !noticename.equals("")) {

			
			opreation = "and  semesterName like '%"+noticename+"%'  ";
			
		}
		if (semesterid != null && semesterid!=0) {

			
			opreation = "and  semesterid = '"+semesterid+"'  ";
			
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getVcurrList(opreation);

		List list = audao.getVcurrList(opreation, page, limit);

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
	 * 实现一个课程信息的添加
	 * 
	 * @param semesterName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcurri")
	public void addcurr( String curriName, Integer semesterid,String introduce, String remarks,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		

		CurriculumDAO audao = new CurriculumDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TCurriculum user = new TCurriculum();
		user.setCurriculumName(curriName);
		user.setIntroduce(introduce);
		user.setIsdelete(0);
		user.setRemarks(remarks);
		user.setSemesterid(semesterid);
		
		

		if (audao.addTCurr(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "课程添加成功";
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
	 * 
	 */
	@RequestMapping(value = "/loacdcurr")
	public void GetLoacdcurr( HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		CurriculumDAO ardao = new CurriculumDaoImpl();
		List list = ardao.getVcurrList();

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
	 * 
	 */
	@RequestMapping(value = "/loacdcourseby")
	public void GetLoacdcurrby( HttpServletRequest request,Integer classid,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		HttpSession session = request.getSession();
		VAdminUser user = (VAdminUser) session.getAttribute("loginuser");
		
		TeacherDAO tedao = new TeacherDaoImpl();
		List<VTeacher> vteaList = tedao.getVteacherList(user.getUserid());
		VTeacher vter = new VTeacher();
		for (VTeacher vv:vteaList){
			vter = vv;
		}
		
		CourseDAO ardao = new CourseDAOImpl();
		List list = ardao.getCourseList(vter.getTeacherid(),classid);

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
	 * 获取课程信息列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcourse")
	public void getcourseList(HttpServletRequest request, int page,
			int limit, Integer classid,Integer teacherid,
			HttpServletResponse response, Model model) {

		CourseDAO audao = new CourseDAOImpl();
		// 查询条件
		Expression exp = new Expression();
		String opreation = "";
		if (classid != null && classid!=0) {

			
			opreation = "and  classid like '%"+classid+"%'  ";
			
		}
		if (teacherid != null && teacherid!=0) {

			
			opreation = "and  teacherid = '"+teacherid+"'  ";
			
		}
		
		
		// System.out.println(opreation);
		int allcount = audao.getCourseList(opreation);

		List list = audao.getCourseList(opreation, page, limit);

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
	 * 实现一个课程信息的添加
	 * 
	 * @param semesterName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcourse")
	public void addcourseUser( Integer curriculumid, Integer teacherid,Integer classid, String remakes,
			  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		

		CourseDAO audao = new CourseDAOImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TCourse user = new TCourse();
		
		user.setCurriculumid(curriculumid);
		user.setClassid(classid);
		user.setTeacherid(teacherid);
		user.setIsdelete(0);
		user.setRemakes(remakes);
		
		
		

		if (audao.addTCourse(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "任课添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败或任课已存在";
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
