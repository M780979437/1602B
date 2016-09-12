package com.jk.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homeController")
public class HomeController extends BaseController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
}
