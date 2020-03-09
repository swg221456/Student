package business.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;










import model.TAdminRole;
import model.TSystemModel;
import model.TroleB;
import model.Trolesystemmodel;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminRoleDAO;
import business.dao.RoleSysModelDAO;
import business.dao.SystemModelDAO;

@Component("adminroledao")
public class AdminRoleDaoImpl implements AdminRoleDAO {
	private iHibBaseDAO bdao;

	public AdminRoleDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TroleB> getRolelist(String opreation) {
		String hql = "from TroleB";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by roleID asc";
		List<TroleB> list = bdao.select(hql);
		return list;

	}

	
	@Override
	public boolean delAdminRole(TroleB role) {
		TroleB rolesql = (TroleB) bdao.findById(TroleB.class,
				role.getRoleId());

		return bdao.delete(rolesql);
	}

	@Override
	public boolean addAdminRole(TroleB role) {
		Object id =  bdao.insert(role);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean edlAdminRole(TroleB role) {
		TroleB rolesql = (TroleB) bdao.findById(TroleB.class,
				role.getRoleId());
		rolesql.setRoleName(role.getRoleName());
		role.setRemark(role.getRemark());
		return false;
	}

	@Override
	public boolean addRole(TroleB role) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String  createTime = df.format(new Date());
		Object id =  bdao.insert(role);
		if (id != null && !id.equals("")) {
			SystemModelDAO dao = new SystemModelDAOImpl();
			List<TSystemModel> model = dao.getTSystemModelList();
			for (TSystemModel aaa : model) {
				RoleSysModelDAO rdao = new RoleSysModelDaoImpl();
				Trolesystemmodel rolemodel = new Trolesystemmodel();
				rolemodel.setRoleId(Integer.parseInt(id.toString()));
				rolemodel.setIsedit(false);
				
				rolemodel.setSysid(aaa.getId());
				boolean cun2 = rdao.addRoleModel(rolemodel);
				if(cun2 == false){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
