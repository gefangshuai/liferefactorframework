package net.wincn.mybatis.web;

import net.wincn.mybatis.service.FooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	private FooService fooService;
	@RequestMapping("/index")
	public void index() {
		fooService.getUser();
	}
}
