package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.CartItem;
import com.spring.entity.Products;
import com.spring.service.CartService;
import com.spring.service.ProductService;
import com.spring.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartService cartService;
    @Autowired
    CartService icartService;

    @GetMapping("/view")
    public String viewCart(Model model){
        model.addAttribute("sanPhamTrongGio",cartService.getAllItems());
        model.addAttribute("total",cartService.getAmount());
        return "/product/cart";
    }

    @RequestMapping("add/{idProduct}")
    public String addItemToCart(@PathVariable("idProduct") Integer id, @RequestParam("quantity") Integer quantity) {
        Optional<Products> product = productService.findById(id);
        if (product.isPresent()) {
            if (quantity > 0) {
                CartItem itemToAdd = null;
                List<CartItem> cartItems = cartService.getCartItems();

                // Kiểm tra sản phẩm tồn tại 
                for (CartItem item : cartItems) {
                    if (item.getId() == product.get().getId()) {
                        itemToAdd = item;
                        break;
                    }
                }

                if (itemToAdd == null) {
                    //chưa tồn tại trong giỏ hàng, tạo mới đối tượng, thêm vào giỏ hàng
                    itemToAdd = new CartItem();
                    itemToAdd.setId(product.get().getId());
                    itemToAdd.setName(product.get().getName());
                    itemToAdd.setPrice(product.get().getPrice());
                    itemToAdd.setQty(quantity);
                    itemToAdd.setImage(product.get().getImage());
                    cartService.add(itemToAdd);
                } else {
                    // sản phẩm tồn tại trong giỏ hàng, tăng số lượng
                    itemToAdd.setQty(itemToAdd.getQty() + quantity);
                    cartService.update(itemToAdd.getId(), itemToAdd.getQty());
                }
            }
        }

        return "redirect:/shopping-cart/view";
    }

    @GetMapping("/clear")
    public String clearCart(){
        cartService.clear();
        return "redirect:/shopping-cart/view";
    }
    @GetMapping("/delete/{idProduct}")
    public String removeItemCart(@PathVariable("idProduct") Integer id){
        cartService.remove(id);
        return "redirect:/shopping-cart/view";

    }
    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id,@RequestParam("qty") Integer qty){
        cartService.update(id,qty);
        return "redirect:/shopping-cart/view";
    }

    @GetMapping("/bill")
    public String viewBill(Model model) {
        model.addAttribute("sanPhamTrongGio",cartService.getAllItems());
        model.addAttribute("total",cartService.getAmount());

        return "/product/bill";
    }

    @GetMapping( value = {"/success"})
    public String viewSuccess() {
        return "product/successForm";
    }
}
