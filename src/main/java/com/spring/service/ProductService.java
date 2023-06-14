package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Products;
import com.spring.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public java.util.List<Products> findAll() {
		return productRepository.findAll();
	}

	public Products save(Products product) {
		return productRepository.save(product);
	}

	public void deleteById(Integer id) {
		 productRepository.deleteById(id);
	}

	public Optional<Products> findById(Integer id) {
		return productRepository.findById(id);
	}
}
