package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TCollege;
import model.Tsemester;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SemesterDAO;

@Component("semesterDAO")
public class SemesterDaoImpl implements SemesterDAO {
	private iHibBaseDAO hdao = null;

	public SemesterDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<Tsemester> getSemesterList(String wherecondition, int page,
			int pageSize) {
		String hql = "from Tsemester where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "  order by semesterid asc";
		List<Tsemester> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getSemesterList(String wherecondition) {
		String hql = "select count(semesterid)  from Tsemester where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean addSemester(Tsemester user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delSemester(Tsemester user) {
		Tsemester adminuser = (Tsemester) hdao.findById(Tsemester.class,
				user.getSemesterid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(Tsemester user) {
		return hdao.update(user);
	}

	@Override
	public List<Tsemester> getSemesterList() {
		String hql = "from Tsemester where isdelete = 0 ";
		
		hql += "  order by semesterid asc";
		List<Tsemester> list = hdao.select(hql);
		return list;
	}

}
