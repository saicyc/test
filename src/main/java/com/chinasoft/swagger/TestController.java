package com.chinasoft.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.domain.Test;
import com.chinasoft.domain.User;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api(value = "user-api", description = "有关于用户的CURD操作", position = 5)
@Controller
@RequestMapping(value="/users") 
public class TestController {
	/**
	 * 获取用户信息
	 * @return
	 */
	@ApiOperation(value="获取用户信息列表", notes="获取用户信息列表")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType="query")
	@RequestMapping(value="info", method=RequestMethod.GET)
	@ResponseBody
	public String getUserList(int id){
		
		return "ok1";
	}
	/**
	 * 获取用户信息
	 * @return
	 */
	@ApiOperation(value="获取用户信息", notes="获取用户信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType="path")
	@RequestMapping(value="/info/{id}", method=RequestMethod.GET) 
	@ResponseBody
	public String getUserInfo(@PathVariable int id){
		System.out.println(id);
		return "ok5";
	}
	/**
	 * 创建用户信息
	 * @return
	 */
	@ApiOperation(value="创建用户信息", notes="创建用户信息")
	@RequestMapping(value="/info", method=RequestMethod.POST) 
	@ResponseBody
	public String creatUserInfo(@ModelAttribute User user){
		
		return "ok2";
	}
	/**
	 * 删除用户信息
	 * @return
	 */
	@ApiOperation(value="删除用户信息", notes="删除用户信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType="path")
	@RequestMapping(value="/info/{id}", method=RequestMethod.DELETE) 
	@ResponseBody
	public String deleteUserInfo(@PathVariable int id){
		
		return "ok3";
	}
	/**
	 * 更新用户信息
	 * @return
	 */
	@ApiOperation(value="删除用户信息", notes="删除用户信息",response=Test.class)
	@RequestMapping(value="/info/{id}", method=RequestMethod.PUT) 
	@ResponseBody
	public String updateUserInfo(@PathVariable int id,@ModelAttribute User user){
		Test t = new Test();
		t.setDesc("my test");
		t.setId(user.getId());
		t.setName(user.getName());
		return new Gson().toJson(t);
	}
	
	
}
