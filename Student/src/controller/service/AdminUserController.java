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

import model.TStuinfo;
import model.Tteacher;
import model.Tuser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.StudentDAO;
import business.dao.TeacherDAO;
import business.factory.DAOFactory;
import business.impl.AdminUserDaoImpl;
import business.impl.StudentDaoImpl;
import business.impl.TeacherDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * 管理员用户contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "admin")
public class AdminUserController {
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
	@RequestMapping(value = "getuser")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String realname, Integer roleid,
			HttpServletResponse response, Model model) {

		AdminUserDAO audao = new AdminUserDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("realname", realname, String.class);
			exp.orRightBraLike("userid", realname, String.class);
		}
		if (roleid != null && roleid != 0) {
			exp.andEqu("roleid", roleid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getAdaminUserAmount(opreation);

		List list = audao.getaAdminUserList(opreation, page, limit);

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
	@RequestMapping(value = "/addadminuser")
	public void addAdminUser(String userid, String realname,
			String pwd, Integer roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO audao = new AdminUserDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tuser user = new Tuser();
		user.setUserid(userid);
		user.setAccount(realname);
		user.setIsDel(0);
		user.setRoleId(roleid);
		user.setPwd(pwd);
		user.setUsertype(true);

		if (audao.addAdminUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "管理员用户添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "管理员用户添加失败";
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
	@RequestMapping(value = "/adduser")
	public void addUser(String userid, String realname,
			String pwd, Integer roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
		session.setAttribute("realname", realname);
		session.setAttribute("pwd", pwd);
		session.setAttribute("roleid", roleid);
		
		Object id = session.getAttribute("roleid");
		
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		

		if (id != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "教师用户注册成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "管理员用户注册失败";
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
	 * 实现一个教师用户的注册
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addteach")
	public void addteacher(String teaName, String teaphone,
			String teasex,  HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		HttpSession session = request.getSession();
		AdminUserDAO dao = new AdminUserDaoImpl();
		
		String userid = session.getAttribute("userid").toString();
		String realname = session.getAttribute("realname").toString();
		String pwd = session.getAttribute("pwd").toString();
		String roleid = session.getAttribute("roleid").toString();
		
		TeacherDAO audao = new TeacherDaoImpl();
		
		Tuser u1 = new Tuser();
		u1.setAccount(realname);
		u1.setIsDel(0);
		u1.setPwd(pwd);
		u1.setRoleId(Integer.parseInt(roleid));
		u1.setUsertype(false);
		u1.setUserid(userid);
		
		

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
		
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		
		if(dao.addAdminUser(u1)){
		if (audao.addNotice(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "教师用户注册成功，请等待审核";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "教师用户注册失败";
		}
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
	 * 实现一个学生用户的注册
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addstu")
	public void addstu(String stuname, String stunum,String agend,String birthday,String phone,String email,
			Integer classid,String stucard, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);
		
		HttpSession session = request.getSession();
		AdminUserDAO dao = new AdminUserDaoImpl();
		
		String userid = session.getAttribute("userid").toString();
		String realname = session.getAttribute("realname").toString();
		String pwd = session.getAttribute("pwd").toString();
		String roleid = session.getAttribute("roleid").toString();
		
		StudentDAO audao = new StudentDaoImpl();
		
		Tuser u1 = new Tuser();
		u1.setAccount(realname);
		u1.setIsDel(0);
		u1.setPwd(pwd);
		u1.setRoleId(Integer.parseInt(roleid));
		u1.setUsertype(true);
		u1.setUserid(userid);
		
		

		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TStuinfo user = new TStuinfo();
		birthday += " 01:01:00";
		user.setUserid(userid);
		user.setAgend(agend);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setPhone(phone);
		user.setStucard(stucard);
		user.setStuname(stuname);
		user.setStunum(stunum);
		user.setClassid(classid);
		user.setIsdelete(0);
		
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		
		if(dao.addAdminUser(u1)){
		if (audao.addNotice(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "学生用户注册成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "学生用户注册失败";
		}
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
	 * 实现一个用户的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/upadminuser")
	public void upAdminUser(String userid, String realname,
			String pwd, Integer roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO audao = new AdminUserDaoImpl();
		LayuiData laydata = new LayuiData();
		// String md5Str = EnCriptUtil.fix(userid, pwd);
		// String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		Tuser user = new Tuser();
		user = audao.getuser(userid);
		user.setUserid(userid);
		user.setAccount(realname);
		user.setRoleId(roleid);
		user.setPwd(pwd);

		if (audao.update(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "用户修改成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "用户修改失败";
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
	 * 实现一个用户的退出
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/logoutsystem")
	public void logoutsystem(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "退出成功";
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个管理员用户的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/deladminuser")
	public void delAdminUser(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model)
			throws IOException {

		AdminUserDAO adao = DAOFactory.getAdminUserDAO();
		Tuser user = new Tuser();
		user.setAccount(userid);
		LayuiData laydata = new LayuiData();
		if (adao.delAdminUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
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
	 * 实现一个管理员用户的登陆
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "adminlogin")
	public void AdminUserLogin(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		AdminUserDAO audao = DAOFactory.getAdminUserDAO();
		LayuiData laydata = new LayuiData();

		VAdminUser user = new VAdminUser();
		user.setUserid((String) userid);
		user.setPwd(pwd);
		HttpSession session = request.getSession();
		VAdminUser loginuser = audao.login(user);
		if (loginuser != null && loginuser.getUsertype()==true) {
			session.setAttribute("loginuser", loginuser);
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "登陆成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "登陆失败";
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
