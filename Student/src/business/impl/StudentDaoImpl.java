package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TClass;
import model.TSheet;
import model.TStuinfo;
import model.Tmajor;
import model.Tuser;
import model.Vclass;
import model.Vsheet;
import model.Vstudent;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminUserDAO;
import business.dao.StudentDAO;

@Component("studentdao")
public class StudentDaoImpl implements StudentDAO {
	private iHibBaseDAO hdao = null;

	public StudentDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Vstudent> getVstuList(String wherecondition, int page,
			int pageSize) {
		String hql = "from Vstudent where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by stuinfoid asc";
		List<Vstudent> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getVstuList(String wherecondition) {
		String hql = "select count(stuinfoid)  from Vstudent where isdelete = 0  ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<Vstudent> getVstudentList(int id) {
		String hql = "from Vstudent where isdelete = 0 and calssid ="+id;
		
		hql += "  order by classid asc";
		List<Vstudent> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addStu(TStuinfo user) {
		AdminUserDAO userDAO = new AdminUserDaoImpl();
		Tuser model = new Tuser();
		model.setAccount(user.getStuname());
		model.setIsDel(0);
		model.setPwd("123456");
		model.setRoleId(12);
		model.setUsertype(true);
		model.setUserid(user.getStunum());
		
		Object userid = userDAO.addAdminUser(model);
		if(userid != null && !userid.equals("")){
			user.setUserid(user.getStunum());
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		}
		return false;
	}

	@Override
	public boolean delStu(TStuinfo user) {
		TStuinfo adminuser = (TStuinfo) hdao.findById(TStuinfo.class,
				user.getStuinfoid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TStuinfo user) {
		// TODO Auto-generated method stub
		return hdao.update(user);
	}

	@Override
	public List<Vsheet> getsheetList(String wherecondition, int page,
			int pageSize) {
		String hql = "from Vsheet where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by stuinfoid asc";
		List<Vsheet> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getsheetList(String wherecondition) {
		String hql = "select count(stuinfoid)  from Vsheet where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<Vstudent> getstuList(String wherecondition) {
		String hql = "from Vstudent where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "  order by stuinfoid asc";
		List<Vstudent> list = hdao.select(hql);
		return list;
	}

	@Override
	public TStuinfo getstu(int id) {
		TStuinfo adminuser = (TStuinfo) hdao.findById(TStuinfo.class,id);
		return adminuser;
	}

	@Override
	public List<Vstudent> getstuList(int classid) {
		String hql = "from Vstudent where isdelete = 0 and classid="+classid+ "";
		
		hql += "  order by stuinfoid asc";
		List<Vstudent> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addsheet(TSheet user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean upsheet(TSheet user) {
		return hdao.update(user);
	}

	@Override
	public TSheet getSheet(int id) {
		TSheet adminuser = (TSheet) hdao.findById(TSheet.class,id);
		return adminuser;
	}

	@Override
	public List<Vstudent> getstubyuserid(String userid) {
		String hql = "from Vstudent where  userid like '%"+userid+"%'  ";
		
		List<Vstudent> list =  hdao.select(hql);
		return list;
	}

}
