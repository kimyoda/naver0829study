package naver.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StorageRestController {
	@Autowired
	private NcpObjectStorageService storageServie;
	
	private String bucketName = "bitcamp-lmh"; // ���� �ڱ��� ���� �̸�(������ ���������� �ȵż� ����)
	private String bucketFolder = "photo"; // ���Ͽ� ��ϵ� ���ε��� ���� ��
	
	String fileName;
	
	@PostMapping("/storage/addphoto")
	public String addPhoto(@RequestParam MultipartFile upload) {
		
		// ���丮���� ���ε�
		fileName = storageServie.uploadFile(bucketName, bucketFolder, upload);
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/" + fileName + "?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		
		return photo80; 
	}
}
