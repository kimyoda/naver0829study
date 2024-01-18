package guest.controller;

import guest.data.GuestDao;
import guest.data.GuestDto;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @PostMapping("/guest/insert")
    public void insert(@RequestBody GuestDto dto) {

        // 미리 업로드 한 photo를 dto 에 넣기
        dto.setPhoto(photo);

        // db insert
        guestDao.addGuest(dto);

        // photo 초기화
        photo = null;

    }

    @GetMapping("/guest/list")
    public List<GuestDto> list () {
        return guestDao.getAllGuestDto();
    }

    @DeleteMapping("/guest/delete")
    public void delete(@RequestParam("guestNum") int guestNum) {
        guestDao.deleteGuest(guestNum);
    }
}
