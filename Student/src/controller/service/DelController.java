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

import model.TAdminRole;
import model.TClass;
import model.TCollege;
import model.TCourse;
import model.TCurriculum;
import model.TNotice;
import model.Tmajor;
import model.Tsemester;
import model.Tteacher;
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
import business.dao.CourseDAO;
import business.dao.CurriculumDAO;
import business.dao.MajorDAO;
import business.dao.NoticeDAO;
import business.dao.SemesterDAO;
import business.dao.TeacherDAO;
import business.impl.AdminUserDaoImpl;
import business.impl.ClassDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.CourseDAOImpl;
import business.impl.CurriculumDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.NoticeDaoImpl;
import business.impl.SemesterDaoImpl;
import business.impl.TeacherDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "del")
public class DelController {
	
	/**
	 * 删除新闻信息
	 */
	@RequestMapping(value = "delnotice")
	public void getAdminUserList(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		NoticeDAO audao = new NoticeDaoImpl();
		TNotice user = new TNotice();
		user.setNoticeid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delNotice(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除教师信息
	 */
	@RequestMapping(value = "delteacher")
	public void delteacher(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		TeacherDAO audao = new TeacherDaoImpl();
		Tteacher user = new Tteacher();
		user.setTeacherid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delTteacher(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除学院信息
	 */
	@RequestMapping(value = "delcollege")
	public void delcollege(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		CollegeDAO audao = new CollegeDaoImpl();
		TCollege user = new TCollege();
		user.setCollegeid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delCollege(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除专业信息
	 */
	@RequestMapping(value = "delmajor")
	public void delmajor(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		MajorDAO audao = new MajorDaoImpl();
		Tmajor user = new Tmajor();
		user.setMajorid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delMajor(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除班级信息
	 */
	@RequestMapping(value = "delclass")
	public void delclass(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		ClassDAO audao = new ClassDaoImpl();
		TClass user = new TClass();
		user.setClassid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delClass(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除学期信息
	 */
	@RequestMapping(value = "delsemester")
	public void delsemester(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		SemesterDAO audao = new SemesterDaoImpl();
		Tsemester user = new Tsemester();
		user.setSemesterid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delSemester(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除课程信息
	 */
	@RequestMapping(value = "delcurr")
	public void delcurr(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		CurriculumDAO audao = new CurriculumDaoImpl();
		TCurriculum user = new TCurriculum();
		user.setCurriculumid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delTCurr(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
	 * 删除任课信息
	 */
	@RequestMapping(value = "delcourse")
	public void delcourse(HttpServletRequest request,  
			  Integer id,
			HttpServletResponse response, Model model) {
		CourseDAO audao = new CourseDAOImpl();
		TCourse user = new TCourse();
		user.setCourseid(id);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (audao.delTCourse(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";
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
