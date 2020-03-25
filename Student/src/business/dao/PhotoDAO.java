package business.dao;

import java.util.List;

import model.TphotoInfo;

public interface PhotoDAO {

	/**
	 * 根据图片资源编号获得图片对象
	 * @param id 图片资源编号
	 * @return 图片资源对象
	 */
	public TphotoInfo getPhotoById(int id);
	
	/**
	 * 在数据库中添加一条图片资源记录
	 * @param obj 图片资源对象
	 * @return int 成功返回图片资源的主键key，失败返回0
	 */
	public Object addPhoto(TphotoInfo obj);
	/**
	 * 将指定状态的所有图片资源删除
	 * @param id 图片状态
	 * @return boolean成功返回true，失败返回false
	 */
	public boolean deleteAllPhotos(int status);
	/**
	 * 修改图片信息
	 * @param model 需要修改的图片资源
	 * @return boolean成功返回true，失败返回false
	 */
	public boolean upPhoto(TphotoInfo model);
	
	/**
	 * 启用图片资源
	 * @param id
	 * @return
	 */
	public boolean enablePhoto(int id);
	
	/**
	 * 停用图片资源
	 * @param id
	 * @return
	 */
	public boolean disenablePhoto(int id);
	
	/**
	 * 根据状态获得对应的所有的图片的资源信息，如果status为0，则返回所有状态的图片资源信息
	 * @param status 图片资源状态
	 * @return 图片资源列表
	 */
	public List<TphotoInfo> getPhotos(int status);
	
	
}
