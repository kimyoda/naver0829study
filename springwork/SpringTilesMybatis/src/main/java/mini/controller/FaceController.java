package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaceController {
	
	@GetMapping("/face")
	public String face() {
		return "face/content";
	}
}
