package business.dao;

import java.util.List;

import model.TroleB;
import model.Trolesystemmodel;;

public interface AdminRoleDAO {
	/**
	 * 根据条件获取管理员角色列表
	 * 
	 * @return List
	 */
	public List<TroleB> getaAdminUserList(String opreation);

	/**
	 * 根据管理员角色id 删除角色
	 * 
	 * @return true or false
	 */
	public boolean delAdminRole(TroleB role);

	/**
	 * 添加管理员角色同时添加权限
	 * 
	 * @return true or false
	 */
	public boolean addAdminRole(TroleB role);

	/**
	 * 编辑管理员角色
	 * 
	 * @return true or false
	 */
	public boolean edlAdminRole(TroleB role);

	/**
	 * 添加管理员角色
	 * 
	 * @return true or false
	 */
	public boolean addRole(TroleB role);
}
