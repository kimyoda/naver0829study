package study.spring.day1114;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;

@Controller
public class PhotoUploadController {
   
   @PostMapping("/member/upload1")
   public String upload1(@ModelAttribute("mdto") MemberDto dto, @RequestParam MultipartFile upload, 
         HttpServletRequest request) {
      
      // ���ε��� ������Ʈ ���� ��� ���ϱ�
      String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
      System.out.println(path);
      
      // ���ϸ��� dto �� ����
      // ���ϸ��� �����ϰ� ������
      String photo = UUID.randomUUID().toString();
      dto.setPhoto(photo);
      
      // ���ε�
      try {
         upload.transferTo(new File(path + "/" + photo));
      } catch (IllegalStateException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "member/result1";
   }
   
   @PostMapping("/member/upload2")
   public String upload2(@ModelAttribute("mdto") MemberDto dto, HttpServletRequest request,
		   @RequestParam ArrayList<MultipartFile> upload) {
      
	  String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
	  // ���ϸ��� ������ ����
	  String photo = "";
	  
	  // �������� ������ ���ε��ؾ��ϹǷ� �ݺ����� ������
	  for (MultipartFile m:upload) {
		  // ������ ������ ��´�
		  String fname = UUID.randomUUID().toString();
		  photo += fname + ",";
		  
		  // ���ε�
		  try {
			m.transferTo(new File(path+ "/" + fname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  // ������ �ĸ� ����
	  photo = photo.substring(0, photo.length()-1);
	  // dto�� �ֱ�
	  dto.setPhoto(photo);
	  return "member/result2";
   }
   
   @PostMapping("/member/upload3")
   public String upload3(@ModelAttribute("mdto") MemberDto dto, HttpServletRequest request, 
		   @RequestParam MultipartFile upload, @RequestParam("upload2") MultipartFile upload2) {
	   
	   String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
	   
	   String photo1 = UUID.randomUUID().toString();
	   String photo2 = UUID.randomUUID().toString();
	   dto.setPhoto(photo1);
	   dto.setPhoto2(photo2);
	   
       try {
		upload.transferTo(new File(path + "/" + photo1));
		upload2.transferTo(new File(path + "/" + photo2));
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return "member/result3";
   }
   
   
}