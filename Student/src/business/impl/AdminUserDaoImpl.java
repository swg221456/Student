package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Tteacher;
import model.Tuser;
import model.VAdminUser;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminUserDAO;

@Component("adminuserdao")
public class AdminUserDaoImpl implements AdminUserDAO {
	private iHibBaseDAO hdao = null;

	public AdminUserDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VAdminUser> getaAdminUserList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by userid asc";
		List<VAdminUser> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getAdaminUserAmount(String wherecondition) {
		String hql = "select count(userid) from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean addAdminUser(Tuser user) {
		Object id = hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public VAdminUser login(VAdminUser user) {
		VAdminUser user2;

		user2 = (VAdminUser) hdao.findById(VAdminUser.class, user.getUserid());
		if (user2 != null) {
			if (user.getPwd().equals(user2.getPwd())) {
				return user2;
			}
		}

		return null;
	}

	@Override
	public boolean delAdminUser(Tuser user) {
		Tuser adminuser = (Tuser) hdao.findById(Tuser.class,
				user.getUserid());
		return hdao.delete(adminuser);
	}

	@Override
	public boolean updatePwd(String userid, String pwd) {
		Tuser user = (Tuser) hdao.findById(Tuser.class, userid);
		user.setPwd(pwd);
		return hdao.update(user);
	}

	@Override
	public Tuser getuser(String userid) {
		return (Tuser) hdao.findById(Tuser.class, userid);
	}

	@Override
	public boolean update(Tuser user) {
		return hdao.update(user);
	}

	@Override
	public List<VAdminUser> getaAdminUserList(int roleid) {
		String hql = "from VAdminUser where roleID = "+roleid+"";
		
		hql += " order by userid asc";
		List<VAdminUser> list = hdao.select(hql);
		return list;
	}

	@Override
	public List<VAdminUser> getaAdminUserList() {
		String hql = "from VAdminUser ";
		
		hql += " order by userid asc";
		List<VAdminUser> list = hdao.select(hql);
		return list;
	}

	@Override
	public List<VAdminUser> getUserList() {
		String hql = "from VAdminUser where roleID != 1 order by userid asc";
		List<VAdminUser> list = hdao.select(hql);
		return list;
	}

	@Override
	public boolean changeState(String id) {
		
		Tuser modelsql = (Tuser) hdao.findById(
				Tuser.class, id);
		String sql = "";
		if (modelsql.getUsertype()) {
			//sql = "update Tcar set status=false where carId="
				//	+modelsql.getCarId();
			 modelsql.setUsertype(false);
		} else {
			//sql = "update Tcar set status=true where carId="
				//	+ modelsql.getCarId();
			modelsql.setUsertype(true);
		}

		return hdao.update(modelsql);
	}

}
