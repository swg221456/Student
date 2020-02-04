package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TSystemLog;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemLogDAO;

import common.properties.OperType;

@Component("systemlogdao")
public class SystemLogDaoImpl implements SystemLogDAO {
	private iHibBaseDAO hdao = null;

	public SystemLogDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	
	@Override
	public List getAllOperType() {
		List list = new ArrayList();
		for (String s : OperType.OPERTYPES) {
			list.add(s);
		}
		return list;
	}

	
	@Override
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize) {
		String hql = "from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<TSystemLog> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	
	@Override
	public int getSystemLogAmount(String wherecondition) {
		String hql = "select count(id) from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public List<TSystemLog> getSystemLogList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TSystemLog ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List list = hdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	
	@Override
	public boolean deleteLogById(Integer id) {
		return hdao.delete(TSystemLog.class, id);
	}

	
	@Override
	public Integer addLog(TSystemLog record) {
		return (Integer) hdao.insert(record);
	}


	@Override
	public TSystemLog getLogById(String id) {
		return (TSystemLog) hdao.findById(TSystemLog.class, id);
	}

	

	@Override
	public boolean deleteLogById(List<Object> listlog) {
		// TODO Auto-generated method stub
		return hdao.delete(listlog);
	}
}
