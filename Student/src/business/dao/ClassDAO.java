package business.dao;

import java.util.List;

import model.TClass;
import model.TCollege;
import model.TNotice;
import model.Tmajor;
import model.Tuser;
import model.VAdminUser;
import model.Vclass;
import model.Vmajor;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface ClassDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Vclass> getNoticeList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getNoticeList(String wherecondition);
	
	public List<Vclass> getNoticeList(int id);

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addNotice(TClass user);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TClass user);

	

	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TClass user);
}
