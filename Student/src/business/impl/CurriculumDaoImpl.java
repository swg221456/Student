package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TClass;
import model.TCurriculum;
import model.Tmajor;
import model.VCurriculum;
import model.Vclass;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CurriculumDAO;

@Component("curriculumdao")
public class CurriculumDaoImpl implements CurriculumDAO {
	private iHibBaseDAO hdao = null;

	public CurriculumDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VCurriculum> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VCurriculum where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by curriculumid asc";
		List<VCurriculum> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(curriculumid)  from VCurriculum where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<VCurriculum> getNoticeList() {
		String hql = "from VCurriculum where isdelete = 0 order by curriculumid asc";
		List<VCurriculum> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addNotice(TCurriculum user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(TCurriculum user) {
		TCurriculum adminuser = (TCurriculum) hdao.findById(TCurriculum.class,
				user.getCurriculumid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TCurriculum user) {
		return hdao.update(user);
	}

}
