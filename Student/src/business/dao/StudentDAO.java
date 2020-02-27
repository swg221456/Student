package business.dao;

import java.util.List;

import model.TClass;
import model.TCollege;
import model.TNotice;
import model.TSheet;
import model.TStuinfo;
import model.Tmajor;
import model.Tuser;
import model.VAdminUser;
import model.Vclass;
import model.Vmajor;
import model.Vsheet;
import model.Vstudent;

/**
 * 管理端管理员用户业务接口
 * 
 * @author Administrator
 *
 */
public interface StudentDAO {

	/**
	 * 根据条件获取新闻列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<Vstudent> getNoticeList(String wherecondition, int page,
			int pageSize);
	
	public List<Vstudent> getstuList(String wherecondition);
	
	public List<Vsheet> getsheetList(String wherecondition, int page,
			int pageSize);
	public int getsheetList(String wherecondition);

	/**
	 * 根据条件获取符合条件的新闻
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getNoticeList(String wherecondition);
	
	public List<Vstudent> getNoticeList(int id);
	
	public List<Vstudent> getstuList(int classid);

	/**
	 * 实现一个新闻的添加
	 * 
	 * @param user
	 */

	public boolean addNotice(TStuinfo user);
	
	public boolean addsheet(TSheet user);
	public boolean upsheet(TSheet user);
	public TSheet getSheet(int id);
	
	public TStuinfo getstu(int id);

	

	/**
	 * 实现一个新闻的修改
	 * 
	 * @param user
	 */

	public boolean delAdminUser(TStuinfo user);

	

	

	/**
	 * 更新管理员用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(TStuinfo user);
}
