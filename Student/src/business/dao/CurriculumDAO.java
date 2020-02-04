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
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VCurriculum> getNoticeList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getNoticeList(String wherecondition);
	
	public List<VCurriculum> getNoticeList();

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addNotice(TCurriculum user);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TCurriculum user);

	

	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TCurriculum user);
}
