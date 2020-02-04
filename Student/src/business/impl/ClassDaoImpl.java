package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TClass;
import model.TCollege;
import model.Tmajor;
import model.Vclass;
import model.Vmajor;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ClassDAO;

@Component("classdao")
public class ClassDaoImpl implements ClassDAO {
	private iHibBaseDAO hdao = null;

	public ClassDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Vclass> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from Vclass where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by classid asc";
		List<Vclass> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(classid)  from Vclass where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<Vclass> getNoticeList(int id) {
		String hql ="";
		if (id != 0 ) {		
		 hql = "from Vclass where isdelete = 0 and majorid ="+id;
		}else{
		 hql = "from Vclass where isdelete = 0 ";
		}
		
		hql += "  order by classid asc";
		List<Vclass> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addNotice(TClass user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(TClass user) {
		TClass adminuser = (TClass) hdao.findById(TClass.class,
				user.getClassid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TClass user) {
		return hdao.update(user);
	}

}
