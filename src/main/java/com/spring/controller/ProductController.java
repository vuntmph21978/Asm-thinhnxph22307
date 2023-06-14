package com.spring.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entity.Products;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String productPage(Model model,
			@RequestParam(name = "PageNum", required = false, defaultValue = "1")Integer pageNum,
			@RequestParam(name = "PageSize", required = false, defaultValue = "3")Integer pageSize
			) {
		Pageable pageable = PageRequest.of(pageNum -1, pageSize);
		Page<Products> page = productRepository.findAll(pageable);
		
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list",page.getContent());
		
		return "/users/homeusers";
		
	}
	
	@GetMapping("/list")
	public String productPage1(Model model,
			@RequestParam(name = "PageNum", required = false, defaultValue = "1")Integer pageNum,
			@RequestParam(name = "PageSize", required = false, defaultValue = "3")Integer pageSize
			) {
		Pageable pageable = PageRequest.of(pageNum -1, pageSize);
		Page<Products> page = productRepository.findAll(pageable);
		
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list",page.getContent());
		
		return "/product/list";
		
	}
		
		
		
	@GetMapping("/detail/{id}")
	public String detailPage(@PathVariable Integer id, Model model) {
		model.addAttribute("product",productRepository.findById(id).orElse(null));
		return "users/detailusers";
	}
	
	@GetMapping("/detaill/{id}")
	public String detailPage1(@PathVariable Integer id, Model model) {
		model.addAttribute("product",productRepository.findById(id).orElse(null));
		return "product/detail";
	}
	
//add
	@PostMapping("/add")
	public String productSave(
			@ModelAttribute("product") 
			Products product,
			BindingResult result,
			Model model
			) {
		
		productService.save(product);
		return( "redirect:/product/list");
	}
	
//update
	@PostMapping("update/{id}")
	public String productUpdate(
			@ModelAttribute("updateProduct")
			Products product,
			Model model,
			@PathVariable(name = "id")Integer id
			) {
		Optional<Products>productss = productService.findById(id);
		productService.save(product);
		return ("redirect:/product/list");
		
	}
	
	@GetMapping("/list/delete/{id}")
	public String deleteProduct(
			@ModelAttribute("updateProduct") 
			Products product, Model model,
			@PathVariable(name = "id") Integer id) {
		Optional<Products>productss = productService.findById(id);
		productService.deleteById(id);
		return ("redirect:/product/list");
	}
}
