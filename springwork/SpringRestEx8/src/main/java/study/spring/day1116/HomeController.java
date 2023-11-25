package study.spring.day1116;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home/start";
	}
}
