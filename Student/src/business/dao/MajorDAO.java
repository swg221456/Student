package business.dao;

import java.util.List;

import model.TCollege;
import model.TNotice;
import model.Tmajor;
import model.Tuser;
import model.VAdminUser;
import model.Vmajor;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface MajorDAO {

	/**
	 * 根据条件获取专业列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Vmajor> getVmajorList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的专业
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getVmajorList(String wherecondition);
	
	public List<Vmajor> getVmajorList(int id);

	/**
	 * 实现一个专业的添加
	 * 
	 * @param user
	 */

	public boolean addMajor(Tmajor user);

	

	/**
	 * 实现一个专业的删除
	 * 
	 * @param user
	 */

	public boolean delMajor(Tmajor user);

	

	

	/**
	 * 更新专业
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tmajor user);
}
