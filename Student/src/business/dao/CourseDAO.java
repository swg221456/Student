package business.dao;

import java.util.List;

import model.TClass;
import model.TCollege;
import model.TCourse;
import model.TCurriculum;
import model.TNotice;
import model.Tmajor;
import model.Tteacher;
import model.Tuser;
import model.VAdminUser;
import model.VCourse;
import model.VCurriculum;
import model.VTeacher;
import model.Vclass;
import model.Vmajor;
import model.Vsheet;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface CourseDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<VCourse> getNoticeList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getNoticeList(String wherecondition);
	
	public List<VCourse> getNoticeList();
	
	public List<VCourse> getNoticeList(int teacherid,int classid);
	
	public List<Vsheet> getNcourseList(int stuinfoid,int courseid);

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addNotice(TCourse user);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TCourse user);

	
	
	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TCourse user);
}
