package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TCollege;
import model.Tmajor;
import model.Vmajor;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.MajorDAO;

@Component("majordao")
public class MajorDaoImpl implements MajorDAO {
	private iHibBaseDAO hdao = null;

	public MajorDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Vmajor> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from Vmajor where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "  order by majorid asc";
		List<Vmajor> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(majorid)  from Vmajor where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean addNotice(Tmajor user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(Tmajor user) {
		Tmajor adminuser = (Tmajor) hdao.findById(Tmajor.class,
				user.getMajorid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(Tmajor user) {
		return hdao.update(user);
	}

	@Override
	public List<Vmajor> getNoticeList(int id) {
		String hql = "from Vmajor where isdelete = 0 and collegeid="+id;
		
		hql += " order by majorid asc";
		List<Vmajor> list = hdao.select(hql);
		return list;
	}

}
