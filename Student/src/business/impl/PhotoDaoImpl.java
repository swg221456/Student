package business.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Component;

import model.TCurriculum;
import model.TphotoInfo;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.PhotoDAO;
@Component("photodao")
public class PhotoDaoImpl implements PhotoDAO {
	
	private iHibBaseDAO bdao = null;

	public PhotoDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public TphotoInfo getPhotoById(int id) {
		TphotoInfo title = (TphotoInfo) bdao.findById(TphotoInfo.class,id);
		
		return title;
	}

	@Override
	public Object addPhoto(TphotoInfo model) {
		Object id =  bdao.insert(model);
		if (id != null && !id.equals("")) {

			return id;
		}
		return false;
	}

	

	@Override
	public boolean upPhoto(TphotoInfo model) {
		return bdao.update(model);
	}



	@Override
	public List<TphotoInfo> getPhotos(int status) {
		String sql = " from TphotoInfo where ifDel =   ?";
		Object[] para = {status};
		
		List<TphotoInfo> modl = bdao.select(sql, para);
		return modl;	
		}

	@Override
	public boolean deleteAllPhotos(int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enablePhoto(int id) {
		TphotoInfo photo = (TphotoInfo) bdao.findById(TphotoInfo.class, id);
		photo.setIsDel(0);
		return bdao.update(photo);
	}

	@Override
	public boolean disenablePhoto(int id) {
		TphotoInfo photo = (TphotoInfo) bdao.findById(TphotoInfo.class, id);
		photo.setIsDel(1);
		return bdao.update(photo);
	}



}
