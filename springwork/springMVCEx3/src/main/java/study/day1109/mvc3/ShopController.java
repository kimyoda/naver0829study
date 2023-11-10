package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Controller�� ������ controller�� �����ؾ��Ѵ� 
@Controller
// @RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/shop/{path}")
	//public String list(@PathVariable("path") String path) : path�� �������� ���� ��� ����
	public String list(@PathVariable String path, Model model) {
		System.out.println(path);
		String shopinfo = "";
		if (path.equals("list1")) {
			shopinfo = "���ǽ� ��ǰ ���";
		} else if(path.equals("list2")) {
			shopinfo = "���� ��ǰ ���";
		} else {
			shopinfo = "�Ǽ����� ��ǰ ���";
		}
		
		// ��ǰ ��� ���
		List<ShopDto> list = new ArrayList<ShopDto>();
		if (path.equals("list")) {
			list.add(new ShopDto("ȭ��Ʈ���ǽ�", "2.jpg", 99000));
			list.add(new ShopDto("����Ƽ���ǽ�", "25.jpg", 45000));
			list.add(new ShopDto("���̽����ǽ�", "28.jpg", 68000));
			list.add(new ShopDto("û���ǽ�", "34.jpg", 23000));
		} else if(path.equals("list2")) {
			list.add(new ShopDto("���ڽ���", "12.jpg", 150000));
			list.add(new ShopDto("�����", "14.jpg", 980000));
			list.add(new ShopDto("�÷�����", "15.jpg", 33000));
		} else {
			list.add(new ShopDto("������", "19.jpg", 11000));
			list.add(new ShopDto("�Ӹ���", "30.jpg", 230000));
			list.add(new ShopDto("���ֹ���", "21.jpg", 55000));			
			list.add(new ShopDto("�Ӹ���", "26.jpg", 9000));			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	@GetMapping("food/morning/brunch")
	public String list2(Model model) {
		model.addAttribute("message", "������ �귱ġ �޴���");
		model.addAttribute("today", new Date());
		
		List<BrunchFoodDto> list = new ArrayList<BrunchFoodDto>();
		 
		list.add(new BrunchFoodDto("������", "11.jpg", "����� ������"));
		list.add(new BrunchFoodDto("������", "8.jpg", "��⵵ ������"));
		list.add(new BrunchFoodDto("�¹���", "9.jpg", "��⵵ �д��"));
		
		model.addAttribute("list", list);
		return "list2";
	}
	
	
	@GetMapping("food/photo/detail")
	public String list3(Model model) {

		List<BrunchFoodDto> list = new ArrayList<BrunchFoodDto>();
		 
		list.add(new BrunchFoodDto("���ϴ�", "K-034.png", "���ֵ� ���ν�"));
		list.add(new BrunchFoodDto("���½�", "K-035.png", "��⵵ ������"));
		list.add(new BrunchFoodDto("�¹ξ�", "K-043.png", "��⵵ �д��"));
		
		model.addAttribute("list", list);
		return "list3";
	}
	
	// ����� �ڵ�, dto���̵� �����ϴ�
	//@GetMapping("/food/morning/brunch")
	// public String brunch(Model model) {
	// model.addAttribute("message", "������ �귱ġ �޴���");
	// model.addAttribute("today", new Date());
	// List<String> list = new ArrayList<String>();
	// list.add("K-034.png");
	// list.add("K-035.png");
	// list.add("K-043.png");
	// model.addAttribute("list",list);
	// return "list2";
	// }
	
	// ����� �ڵ� Servelt�̱� ������ ���, ������ ��Ʈ�ѷ��� ����� �� �������־���
	// @GetMapping("/food/photo/detail")
	// public ModelAndView detail() {
	// ModelAndView mview = new ModelAndView();
	// List<String> list = new ArrayList<String>();
	// list.add("11.jpg");
	// list.add("8.jpg");
	// list.add("9.jpg");
	// mview.addObject("food", list);
	// mview.addObject("name", "�̹���");
	// mview.addObject("addr", "����� ������");
	// mview.setViewName("list3");
	// return mview;
	// }
}	 

				
	
