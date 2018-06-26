package com.github.controller;

import com.github.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Controller
@RequestMapping
public class TestController {

	@Resource private DataSource dataSource;
	@Resource private OrderService orderService;

	@ResponseBody
	@GetMapping({"", "/", "index"})
	public Object index() {

		System.err.println(dataSource);

		orderService.demo();

		return "success";
	}

	@ResponseBody
	@RequestMapping("page")
	public Object page() {

		return "success";
	}

}
