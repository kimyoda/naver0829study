package myshop.controller;

import myshop.data.MyShopDto;
import naver.storage.NcpObjectStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import myshop.service.MyShopService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyShopController {

    private final MyShopService shopService;
    //storage class 선언
    private final NcpObjectStorageService storageService;

    // 버켓네임 지정
    private String bucketName = bucketName = "bitcamp-kyh";

    // 저장할 폴더네임 지정
    private String folderName = "bootmyshop";

    @GetMapping("/")
    public String list(Model model)
    {
        // 총갯수를 얻어온다
        int totalCount = shopService.getTotalCount();

        // 전체 목록 가져오기
        List<MyShopDto> list = shopService.getSangpumList();

        // model 에 저장한다
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        return "myshop/shoplist";
    }

    @GetMapping("/form")
    public String form () {
        return "myshop/shopform";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute MyShopDto dto, @RequestParam("upload") MultipartFile upload) {

        // 네이버 스토리지에 업로드 후 저장된 파일명을 리턴받아서 dto의 photo에 저장
        String photo = storageService.uploadFile(bucketName, folderName, upload);

        dto.setPhoto(photo);
        // db에 insert
        shopService.insertShop(dto);

        return "redirect:./";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("num") int num, Model model) {

        // num에 해당하는 dto 얻기
        MyShopDto dto = shopService.getData(num);
        model.addAttribute("dto", dto);
        return "myshop/shopdetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("num") int num) {

        // db 삭제전에 스토리지의 기존 사진부터 삭제
        // 사진 이름 얻기
        String photo = shopService.getData(num).getPhoto();
        // 스토리지 사진 삭제
        storageService.deleteFile(bucketName, folderName, photo);
        // db 삭제
        shopService.deleteShop(num);
        // 목록으로 이동
        return "redirect:./";
    }
}
