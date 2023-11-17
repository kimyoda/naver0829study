package data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDao {
	
	@Autowired
	private SqlSession session;
	private String nameSpace = "data.dao.PhotoDao";
	
	public void insertPhoto(PhotoDao dto) {
		session.insert(nameSpace + "insertPhoto", dto);
	}
	
	public List<PhotoDao> getAllPhoto() {
		return session.selectList(nameSpace + "selectAllPhotos");
	}
	
	public void deletePhoto(int num) {
		session.delete(nameSpace + "deletPhoto", num);
	}
}
