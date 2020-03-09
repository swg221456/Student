package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TNotice;
import model.Tuser;
import model.VAdminUser;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.NoticeDAO;

@Component("noticedao")
public class NoticeDaoImpl implements NoticeDAO {
	private iHibBaseDAO hdao = null;

	public NoticeDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TNotice> getNoticeList(String wherecondition, int page,
			int pageSize) {
		String hql = "from TNotice where isdelete = 0  ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += "  order by noticeid asc";
		List<TNotice> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getNoticeList(String wherecondition) {
		String hql = "select count(noticeid)   from TNotice where isdelete = 0 ";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	@Override
	public boolean addNotice(TNotice user) {
		Object id =  hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public boolean delNotice(TNotice user) {
		TNotice adminuser = (TNotice) hdao.findById(TNotice.class,
				user.getNoticeid());
		adminuser.setIsdelete(1);
		return hdao.update(adminuser);
	}

	@Override
	public boolean update(TNotice user) {
		return hdao.update(user);
	}

}
