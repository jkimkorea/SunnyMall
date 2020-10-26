package com.sunny.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Cart_DAO;

@Service
public class Cart_ServiceImpl implements Cart_Service {

	@Inject
	private Cart_DAO dao;
	
	
}
