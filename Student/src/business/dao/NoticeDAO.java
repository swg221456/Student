package business.dao;

import java.util.List;

import model.TNotice;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface NoticeDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TNotice> getNoticeList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getNoticeList(String wherecondition);

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addNotice(TNotice user);

	

	/**
	 * 实现一个新闻的删除
	 * 
	 * @param user
	 */

	public boolean delNotice(TNotice user);

	

	

	/**
	 * 更新新闻
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TNotice user);
}
