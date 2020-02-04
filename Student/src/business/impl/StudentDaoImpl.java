package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TClass;
import model.TStuinfo;
import model.Tmajor;
import model.Vclass;
import model.Vsheet;
import model.Vstudent;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.StudentDAO;

@Component("studentdao")
public class StudentDaoImpl implements StudentDAO {
	private iHibBaseDAO hdao = null;

	public StudentDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Vstudent> getNoticeList(String wherecondition, int page,
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
	public int getNoticeList(String wherecondition) {
		String hql = "select count(stuinfoid)  from Vstudent where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<Vstudent> getNoticeList(int id) {
		String hql = "from Vstudent where isdelete = 0 and calssid ="+id;
		
		hql += "  order by classid asc";
		List<Vstudent> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addNotice(TStuinfo user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(TStuinfo user) {
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

}
