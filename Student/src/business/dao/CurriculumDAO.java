package business.dao;

import java.util.List;

import model.TClass;
import model.TCollege;
import model.TCurriculum;
import model.TNotice;
import model.Tmajor;
import model.Tuser;
import model.VAdminUser;
import model.VCurriculum;
import model.Vclass;
import model.Vmajor;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface CurriculumDAO {

	/**
	 * 根据条件获取课程列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VCurriculum> getVcurrList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的课程
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getVcurrList(String wherecondition);
	
	/**
	 * 获取所有课程
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public List<VCurriculum> getVcurrList();

	/**
	 * 实现一个课程的添加
	 * 
	 * @param user
	 */

	public boolean addTCurr(TCurriculum user);

	

	/**
	 * 实现一个课程的删除
	 * 
	 * @param user
	 */

	public boolean delTCurr(TCurriculum user);

	

	

	/**
	 * 更新课程
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TCurriculum user);
}
