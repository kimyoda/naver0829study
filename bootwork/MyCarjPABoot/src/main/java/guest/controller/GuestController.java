package guest.controller;

import guest.data.GuestDao;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class GuestController {

    //storage class 선언
    private final NcpObjectStorageService storageService;

    // dao 선언
    private final GuestDao guestDao;

    // 업로드한 파일명 저장
    String photo;

    // 버켓네임 지정
    private String bucketName = bucketName = "bitcamp-kyh";

    // 저장할 폴더네임 지정
    private String folderName = "bootmyshop";

    // 사진만 먼저 업로드 하기
    @PostMapping("/guest/upload")
    public String uploadFile(@RequestParam("upload") MultipartFile upload) {
        photo = storageService.uploadFile(bucketName, folderName, upload);
        return photo;
    }
}
