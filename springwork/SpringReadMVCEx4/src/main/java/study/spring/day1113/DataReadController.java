package study.spring.day1113;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 무조건 Controller 생성
@Controller
public class DataReadController {

	@GetMapping("/process1") // 다르면 생략하지 않아야 함
	//@RequestParam("폼 태그의 name") String 변수명: 폼 태그의 name과 변수명이 같을 경우 name은 생략이 가능
	//@RequestParam 자체가 사실 생략이 가능하다(하지만 다른 어노테이션으로 잘못 인식하는 경우를 방지하기 위해 생략안하는게 좋긴하다)
	public String process1(Model model, @RequestParam("name") String irum, @RequestParam String addr, @RequestParam int age) {
	  
	  model.addAttribute("name", irum);
	  model.addAttribute("addr", addr);
	  model.addAttribute("age", age + "세는 " + (age >= 20?"성인":"미성년자")+ "입니다");
	  return "result1";	
	}
	
//	public String process1(HttpServletRequest request, Model model) {
//	  // jsp 처럼 읽어보자(스프링에서는 이렇게 읽지는 않고 방법 중 1개이다)
//	  String name = request.getParameter("name");	
//	  String addr = request.getParameter("addr");
//	  int age = Integer.parseInt(request.getParameter("age"));
//	  
//	  model.addAttribute("name", name);
//	  model.addAttribute("addr", addr);
//	  model.addAttribute("age", age + "세는 " + (age >= 20? "성인":"미성년자") + "입니다");
//	  
//	  return "result1";
//	}
	
	@PostMapping("/process2")
	public String process2(Model model, @RequestParam String message, @RequestParam String animal,
			@RequestParam(defaultValue = "다니엘", required = false) String name) { 
		/*null 일경우 기본값을 "다니엘"로
		 * null값이 들어오더라도 에러가 안나게 할 경우(에러코드 400) required = false
		 * */
		// 폼 태그에 nam이라는 태그는 없다는거 알림
		
		System.out.println(name);
		model.addAttribute("name", name); // 폼 태그에 name이라는 태그는 없다
		model.addAttribute("message", message);
		model.addAttribute("animal", animal);
		return "result2";
	}
	
	//@ModelAttribute : dto 와 같은 이름의 폼태그를 읽어서 모델에 저장한다
	@PostMapping("/process3")
	public String process3(@ModelAttribute ShopDto dto, @RequestParam String today, Model model) { // model에 shopDto라는 이름으로 저장
    //public String process3(@ModelAttribute("dto") ShopDto dto) //model에 dto라는 이름으로 저장
		model.addAttribute("today", today);
		return "result3";
	}
	
	@PostMapping("/process4")
	public String process4(Model model, @RequestParam Map<String, String> map) { // 폼태그의 name이 key로, 입력값이 value로 저장된다.
		
		model.addAttribute("sang", map.get("sang"));
		model.addAttribute("su", map.get("su"));
		model.addAttribute("dan", map.get("dan"));
		model.addAttribute("color", map.get("color"));
		model.addAttribute("photo", map.get("photo"));
		model.addAttribute("today", map.get("today"));
		
		return "result4";
	}
}
