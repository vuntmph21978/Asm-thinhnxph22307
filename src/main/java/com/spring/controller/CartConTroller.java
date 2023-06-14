package com.spring.controller;

import java.util.Map;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartConTroller {
    private final CartService service = new CartService();
    @RequestMapping("/add/{idProduct}")
    public String themSanPhamVaoGio(@PathVariable(name = "id") Integer idSP){
        service.themSanPham(idSP, 1);
        return "redirect:/cart";
    }

    @GetMapping("/view")
    public String viewCart(Model model){
        Map<Integer, Integer> sanPhamTrongGio = service.xemSanPham();
        model.addAttribute("sanPhamTrongGio",sanPhamTrongGio);
        return "product/cart/view-cart";
    }

    @GetMapping("/delete/{id}")
    public String removeCart(@PathVariable(name ="id") Integer idSP){
        service.remove(idSP);
        return "redirect:/cart";
    }


}
