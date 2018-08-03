package com.song.controller;

import com.song.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "FastJson测试", tags = { "测试接口" })
@RestController
@RequestMapping("fastjson")
public class FastJsonController {


	/*@CrossOrigin(origins = "http://127.0.0.1:8020")
	@RequestMapping("/test")
	@ResponseBody
	protected User test() {
		User user = new User();
		
		user.setId(1);
		user.setName("jack");
		user.setPassword("jack123");
		user.setBirthday(new Date());
		return user;
	}*/

	@ApiOperation("获取用户信息")
	@ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
	@GetMapping("/test/{name}")
	public User test(@PathVariable("name") String name) {
		User user = new User();

		user.setId(1);
		user.setName(name);
		user.setPassword("jack123");
		user.setBirthday(new Date());

		return user;
	}
}