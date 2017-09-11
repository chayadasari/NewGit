package register.controller;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import register.bean.UserBean;
import register.model.User;
import register.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public ModelAndView welcome(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userBean", new UserBean());
		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/registerationform", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userBean", new UserBean());
		return new ModelAndView("register", model);
	}

	@RequestMapping(value = "/CreateAccount", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		System.out.println("hiii");
		// System.out.println(userBean.getFirstName());
		User user = prepareModel(userBean);
		userService.addUser(user);
		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView loginUser(@ModelAttribute("userBean") UserBean userBean, BindingResult result) {
		User user = prepareModel(userBean);
		System.out.println(user.getUsername());
		if ((userService.checkLogin(user.getUsername(), user.getPassword()) == true)) {
			System.out.println("exist");
			return new ModelAndView("home");
		} else {
			return new ModelAndView("redirect:/index.html");
		}
	}

	/*
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public String showForm(Map
	 * model) { LoginForm loginForm = new LoginForm(); model.put("loginForm",
	 * loginForm); return "loginform"; }
	 * 
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * processForm(@Valid LoginForm loginForm, BindingResult result, Map model)
	 * {
	 * 
	 * 
	 * if (result.hasErrors()) { return "loginform"; }
	 * 
	 * 
	 * String userName = "UserName"; String password = "password"; loginForm =
	 * (LoginForm) model.get("loginForm"); if
	 * (!loginForm.getUserName().equals(userName) ||
	 * !loginForm.getPassword().equals(password)) { return "loginform"; }
	 * 
	 * boolean userExists = loginService.checkLogin(loginForm.getUserName(),
	 * loginForm.getPassword()); if(userExists){ model.put("loginForm",
	 * loginForm); return "loginsuccess"; }else{
	 * result.rejectValue("userName","invaliduser"); return "loginform"; }
	 * 
	 * }
	 */
	private User prepareModel(UserBean userBean) {
		// System.out.println(userBean.getFirstName());
		User user = new User();

		user.setFirstname(userBean.getFirstName());
		// System.out.println(user.getFirstname());
		user.setLastname(userBean.getLastName());
		user.setEmail_id(userBean.getEmail_id());
		user.setMobile_no(userBean.getMobile_no());
		user.setUsername(userBean.getUsername());
		user.setPassword(userBean.getPassword());

		return user;

	}

}
