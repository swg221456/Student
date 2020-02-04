package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TCourse;
import model.Tteacher;
import model.VCourse;
import model.VTeacher;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CourseDAO;

@Component("coursedao")
public class CourseDaoImpl implements CourseDAO {
	private iHibBaseDAO hdao = null;

	public CourseDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VCourse> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VCourse where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by courseid asc";
		List<VCourse> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(courseid)  from VCourse where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<VCourse> getNoticeList() {
		String hql = "from VCourse where isdelete = 0  order by teacherid asc";
		List<VCourse> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addNotice(TCourse user) {
		String hql = "from VCourse where curriculumid = "+user.getCurriculumid()+" "
				+ " and teacherid = "+user.getTeacherid()+""
				+ " and classid = "+user.getClassid()+""
				+ " and isdelete = 0  order by teacherid asc";
		List<VCourse> list = hdao.select(hql);
		if (list.size() == 0) {
			Object id =  hdao.insert(user);
			if (id != null && !id.equals("")) {

				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean delAdminUser(TCourse user) {
		TCourse adminuser = (TCourse) hdao.findById(TCourse.class,
				user.getCourseid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TCourse user) {
		return hdao.update(user);
	}

}
