package business.dao;

import java.util.List;

import model.TCollege;
import model.TNotice;
import model.Tuser;
import model.VAdminUser;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface CollegeDAO {

	/**
	 * 根据条件获取学院列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TCollege> getCollegeList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getCollegeList(String wherecondition);
	
	public List<TCollege> getCollegeList();

	/**
	 * 实现一个学院的添加
	 * 
	 * @param user
	 */

	public boolean addCollege(TCollege user);

	

	/**
	 * 实现一个学院的修改
	 * 
	 * @param user
	 */

	public boolean delCollege(TCollege user);

	

	

	/**
	 * 更新学院
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TCollege user);
}
