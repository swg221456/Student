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
	 * 根据条件获取学期列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Tsemester> getSemesterList(String wherecondition, int page,
			int pageSize);
	
	public List<Tsemester> getSemesterList();

	/**
	 * 根据条件获取符合条件的学期
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getSemesterList(String wherecondition);

	/**
	 * 实现一个学期的添加
	 * 
	 * @param user
	 */

	public boolean addSemester(Tsemester user);

	

	/**
	 * 实现一个学期的删除
	 * 
	 * @param user
	 */

	public boolean delSemester(Tsemester user);

	

	

	/**
	 * 更新学期
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tsemester user);
}
