package business.impl;

import java.util.List;

import model.Trolesystemmodel;
import model.Trolesystemmodel;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RoleSysModelDAO;
import common.properties.OperType;

@Component("rolesysmodeldao")
public class RoleSysModelDaoImpl implements RoleSysModelDAO {
	private iHibBaseDAO bdao;

	public RoleSysModelDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	

	
	@Override
	public boolean addRoleModel(List<Object> rolemodellist) {

		return bdao.insertList(rolemodellist);
	}

	
	@Override
	public boolean updataRoleModel(int rolemodelid) {
		Trolesystemmodel rolemodelsql = (Trolesystemmodel) bdao.findById(
				Trolesystemmodel.class, rolemodelid);
		if (rolemodelsql.getIsedit()) {
			rolemodelsql.setIsedit(false);
		} else {
			rolemodelsql.setIsedit(true);
		}
		return bdao.update(rolemodelsql);
	}

	@Override
	public boolean addRoleModel(Trolesystemmodel rolemodel) {
		Object id =  bdao.insert(rolemodel);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

}
