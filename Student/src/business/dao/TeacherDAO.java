package business.dao;

import java.util.List;

import model.TClass;
import model.TCollege;
import model.TCurriculum;
import model.TNotice;
import model.Tmajor;
import model.Tteacher;
import model.Tuser;
import model.VAdminUser;
import model.VCurriculum;
import model.VTeacher;
import model.Vclass;
import model.Vmajor;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface TeacherDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VTeacher> getteacherList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getteacherList(String wherecondition);
	
	public List<VTeacher> getteacherList();
	
	public List<VTeacher> getVteacherList(String userid);

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addTteacher(Tteacher user);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delTteacher(Tteacher user);

	
	/**
	 * 根据菜单id 改变菜单是否删除
	 * 
	 * @param rolemodelid
	 * @return true or false
	 */
	public boolean changeState(int teacherid);
	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Tteacher user);
}
