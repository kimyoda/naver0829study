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
	
	private String bucketName = "bitcamp-lmh"; // 각자 자기의 버켓 이름(지금은 인증때문에 안돼서 못함)
	private String bucketFolder = "photo"; // 버켓에 등록된 업로드할 폴더 명
	
	String fileName;
	
	@PostMapping("/storage/addphoto")
	public String addPhoto(@RequestParam MultipartFile upload) {
		
		// 스토리지에 업로드
		fileName = storageServie.uploadFile(bucketName, bucketFolder, upload);
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/" + fileName + "?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		
		return photo80; 
	}
}
