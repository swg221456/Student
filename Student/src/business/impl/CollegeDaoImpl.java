package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TCollege;
import model.TNotice;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CollegeDAO;

@Component("collegedao")
public class CollegeDaoImpl implements CollegeDAO {
	private iHibBaseDAO hdao = null;

	public CollegeDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TCollege> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from TCollege where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "  order by collegeid asc";
		List<TCollege> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(collegeid)  from TCollege where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean addNotice(TCollege user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(TCollege user) {
		TCollege adminuser = (TCollege) hdao.findById(TCollege.class,
				user.getCollegeid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TCollege user) {
		return hdao.update(user);
	}

	@Override
	public List<TCollege> getNoticeList() {
		String hql = "from TCollege  where isdelete = 0 ";
		
		hql += "  order by collegeid asc";
		List<TCollege> list = hdao.select(hql);
		return list;
	}

}
