package business.dao;

import java.util.List;

import model.TNotice;
import model.Tsemester;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface SemesterDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Tsemester> getNoticeList(String wherecondition, int page,
			int pageSize);
	
	public List<Tsemester> getNoticeList();

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

	public boolean addNotice(Tsemester user);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delAdminUser(Tsemester user);

	

	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tsemester user);
}
