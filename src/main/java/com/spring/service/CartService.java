package com.spring.service;

import com.spring.entity.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;

@Service
@SessionScope
public class CartService {

    private final Cart cart = new Cart();

    public void themSanPham(Integer sphamId, Integer soLuong) {
        Map<Integer, Integer> dsSanPham = cart.getDanhSachSanPham();
        if (dsSanPham.containsKey(sphamId)) {
            Integer soLuongHienTai = dsSanPham.get(sphamId);
            Integer soLuongMoi = soLuongHienTai + soLuong;
            dsSanPham.put(sphamId, soLuongMoi);
        } else {
            dsSanPham.put(sphamId, soLuong);
        }
    }

    public Map<Integer, Integer> xemSanPham() {
        return cart.getDanhSachSanPham();
    }

    public void remove(int sanPhamId) {
        cart.getDanhSachSanPham().remove(sanPhamId);
    }

}
