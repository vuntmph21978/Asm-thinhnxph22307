package com.spring.controller;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Products;
import com.spring.entity.Users;
import com.spring.repository.UsersRepository;
import com.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserService userService;
	
	//login
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new Users());
		return "login";
	}
	
	@GetMapping("/signup")
	public String showsignupForm(Model model) {
		model.addAttribute("user",new Users());
		return "signup";
		
	}
	
	@GetMapping("/taikhoan")
	public String authPage(Model model,
			@RequestParam(name = "PageNum", required = false, defaultValue = "1")Integer pageNum,
			@RequestParam(name = "PageSize", required = false, defaultValue = "3")Integer pageSize
			) {
		Pageable pageable = PageRequest.of(pageNum -1, pageSize);
		Page<Users> page = usersRepository.findAll(pageable);
		
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("lists",page.getContent());
		
		return "product/taikhoan";
		
	}
	
	@GetMapping("/detailtk/{id}")
	public String detailPage2(@PathVariable Integer id, Model model) {
		model.addAttribute("user",usersRepository.findById(id).orElse(null));
		return "product/detailtaikhoan";
	}
	
	//login
	@PostMapping("/login")
	public String checkLogin(
			@Valid @ModelAttribute("user") Users user,
			BindingResult result,
			HttpSession session,
			Model model
	) {

		if(result.hasErrors()) {
			return "login";
		}
		
		Users userFromDB = usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userFromDB != null) {
			session.setAttribute("userLogged", userFromDB);
			return "redirect:/product/home";
		}
		
		//login failed
		model.addAttribute("message", "Username or password incorrect");
		return "login";
	}
	
	//signup
	@PostMapping("/add")
	public String authSave(
			@ModelAttribute("user")
			Users user,
			BindingResult result,
			Model model
			) {
		usersRepository.save(user);
		return "redirect:/login";
	}
	
	
	//update
		@PostMapping("updatee/{id}")
		public String authUpdate(
				@ModelAttribute("updateAuth")
				Users user,
				Model model,
				@PathVariable(name = "id")Integer id
				) {
			Optional<Users>users = userService.findById(id);
			userService.register(user);
			return ("rediret:/taikhoan");
			
		}
		
		@GetMapping("deletee/{id}")
		public String deleteAuth(
				@ModelAttribute("updateAuth") 
				Users user, 
				Model model,
				@PathVariable(name = "id") Integer id) {
			Optional<Users>users = userService.findById(id);
			userService.deleteById(id);
			return ("redirect:/taikhoan");
		}
	

	
	

}
