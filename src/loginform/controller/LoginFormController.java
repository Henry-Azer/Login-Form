package loginform.controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {
	
	@GetMapping("/")
	public String home() {
		
		return "Home";
	}
	
	@GetMapping("/LoginPage")
	public String loginPage() {
		
		return "Login-Page";
	}
	
	@GetMapping("/Leaders")
	public String leaderPage() {
		
		return "Leaders-Page";
	}
	
	@GetMapping("/Systems")
	public String systemPage() {
		
		return "Systems-Page";
	}
	
	@GetMapping("/AccessDenied")
	public String accessDeniedPage() {
		
		return "Access-Denied";
	}
	
	
}
