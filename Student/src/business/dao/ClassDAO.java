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
	 * 根据条件获取班级列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Vclass> getClassList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的班级
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getClassList(String wherecondition);
	
	public List<Vclass> getClassList(int id);

	/**
	 * 实现一个班级的添加
	 * 
	 * @param user
	 */

	public boolean addClass(TClass user);

	

	/**
	 * 实现一个班级的删除
	 * 
	 * @param user
	 */

	public boolean delClass(TClass user);

	

	

	/**
	 * 更新班级
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TClass user);
}
