package sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sy.model.User;
import sy.service.UserServiceI;
import sy.service.UserServiceImpl;


@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserServiceI userService = new UserServiceImpl();
	
	/*public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}*/




	@RequestMapping("/showUser")
	public String showUser( String id, HttpServletRequest request) {
		User user = userService.getUserById(id);
		request.setAttribute("user", user);
		System.out.println(11111+"-----------------"+id);
		return "showUser";
	}

}
