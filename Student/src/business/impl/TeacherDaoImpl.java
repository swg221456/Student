package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TCurriculum;
import model.Tteacher;
import model.VCurriculum;
import model.VTeacher;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.TeacherDAO;

@Component("teacherdao")
public class TeacherDaoImpl implements TeacherDAO {
	private iHibBaseDAO hdao = null;

	public TeacherDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VTeacher> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VTeacher where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "   order by teacherid asc";
		List<VTeacher> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(teacherid)  from VTeacher where isdelete = 0";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<VTeacher> getNoticeList() {
		String hql = "from VTeacher where isdelete = 0 and auditstatus = false order by teacherid asc";
		List<VTeacher> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean addNotice(Tteacher user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delAdminUser(Tteacher user) {
		Tteacher adminuser = (Tteacher) hdao.findById(Tteacher.class,
				user.getTeacherid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean changeState(int teacherid) {
		Tteacher modelsql = (Tteacher) hdao.findById(
				Tteacher.class, teacherid);
		String sql = "";
		if (modelsql.getAuditstatus()) {
			//sql = "update Tcar set status=false where carId="
				//	+modelsql.getCarId();
			 modelsql.setAuditstatus(false);
		} else {
			//sql = "update Tcar set status=true where carId="
				//	+ modelsql.getCarId();
			modelsql.setAuditstatus(true);
		}

		return hdao.update(modelsql);
	}

	@Override
	public boolean update(Tteacher user) {
		return hdao.update(user);
	}

	@Override
	public List<VTeacher> getteacher(String userid) {
		String hql = "from VTeacher where userid = '"+userid+"' ";
		List<VTeacher> list = hdao.select(hql);
		return list;
	}

}
