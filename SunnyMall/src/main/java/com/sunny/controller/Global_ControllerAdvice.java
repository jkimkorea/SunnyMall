package com.sunny.controller;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sunny.service.Product_Service;

@ControllerAdvice(basePackages = {"com.sunny.controller"})
public class Global_ControllerAdvice {

	@Inject
	private Product_Service service;
	
	//1차 카테고리 불러오기
	@ModelAttribute
	public void categoryList(Model model) throws Exception{
		System.out.println("Global_Controller Start=======");
		model.addAttribute("userCategoryList",service.mainCGList());
	}
}
