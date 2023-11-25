package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Controller는 무조건 controller를 선언해야한다 
@Controller
// @RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/shop/{path}")
	//public String list(@PathVariable("path") String path) : path와 변수명이 같을 경우 생략
	public String list(@PathVariable String path, Model model) {
		System.out.println(path);
		String shopinfo = "";
		if (path.equals("list1")) {
			shopinfo = "원피스 상품 목록";
		} else if(path.equals("list2")) {
			shopinfo = "슈즈 상품 목록";
		} else {
			shopinfo = "악세서리 상품 목록";
		}
		
		// 상품 목록 담기
		List<ShopDto> list = new ArrayList<ShopDto>();
		if (path.equals("list")) {
			list.add(new ShopDto("화이트원피스", "2.jpg", 99000));
			list.add(new ShopDto("스포티원피스", "25.jpg", 45000));
			list.add(new ShopDto("레이스원피스", "28.jpg", 68000));
			list.add(new ShopDto("청원피스", "34.jpg", 23000));
		} else if(path.equals("list2")) {
			list.add(new ShopDto("샤넬슈즈", "12.jpg", 150000));
			list.add(new ShopDto("구찌슈즈", "14.jpg", 980000));
			list.add(new ShopDto("플랫슈즈", "15.jpg", 33000));
		} else {
			list.add(new ShopDto("리본핀", "19.jpg", 11000));
			list.add(new ShopDto("머리띠", "30.jpg", 230000));
			list.add(new ShopDto("진주반지", "21.jpg", 55000));			
			list.add(new ShopDto("머리끈", "26.jpg", 9000));			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	@GetMapping("food/morning/brunch")
	public String list2(Model model) {
		model.addAttribute("message", "오늘의 브런치 메뉴들");
		model.addAttribute("today", new Date());
		
		List<BrunchFoodDto> list = new ArrayList<BrunchFoodDto>();
		 
		list.add(new BrunchFoodDto("준일좌", "11.jpg", "서울시 강남구"));
		list.add(new BrunchFoodDto("원태좌", "8.jpg", "경기도 성남시"));
		list.add(new BrunchFoodDto("승민좌", "9.jpg", "경기도 분당시"));
		
		model.addAttribute("list", list);
		return "list2";
	}
	
	
	@GetMapping("food/photo/detail")
	public String list3(Model model) {

		List<BrunchFoodDto> list = new ArrayList<BrunchFoodDto>();
		 
		list.add(new BrunchFoodDto("준일님", "K-034.png", "제주도 용인시"));
		list.add(new BrunchFoodDto("원태승", "K-035.png", "경기도 성남시"));
		list.add(new BrunchFoodDto("승민씨", "K-043.png", "경기도 분당시"));
		
		model.addAttribute("list", list);
		return "list3";
	}
	
	// 강사님 코드, dto없이도 가능하다
	//@GetMapping("/food/morning/brunch")
	// public String brunch(Model model) {
	// model.addAttribute("message", "오늘의 브런치 메뉴들");
	// model.addAttribute("today", new Date());
	// List<String> list = new ArrayList<String>();
	// list.add("K-034.png");
	// list.add("K-035.png");
	// list.add("K-043.png");
	// model.addAttribute("list",list);
	// return "list2";
	// }
	
	// 강사님 코드 Servelt이기 때문에 사용, 옛날에 컨트롤러를 사용할 때 정해져있었다
	// @GetMapping("/food/photo/detail")
	// public ModelAndView detail() {
	// ModelAndView mview = new ModelAndView();
	// List<String> list = new ArrayList<String>();
	// list.add("11.jpg");
	// list.add("8.jpg");
	// list.add("9.jpg");
	// mview.addObject("food", list);
	// mview.addObject("name", "이문희");
	// mview.addObject("addr", "서울시 강남구");
	// mview.setViewName("list3");
	// return mview;
	// }
}	 

				
	
