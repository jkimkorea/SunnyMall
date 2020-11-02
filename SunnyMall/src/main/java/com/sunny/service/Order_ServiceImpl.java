package com.sunny.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Order_DAO;

@Service
public class Order_ServiceImpl implements Order_Service {

	@Inject
	private Order_DAO dao;
}
