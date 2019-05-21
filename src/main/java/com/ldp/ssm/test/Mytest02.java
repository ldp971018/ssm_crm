package com.ldp.ssm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.ldp.ssm.bean.Employee;

/**
 * 测试分页效果
 * @author return
 * 2019年4月18日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:aplicationContext.xml","file:src/main/webapp/WEB-INF/SpringMVC-servlet.xml"})
public class Mytest02 {
	//传入springmvc的IOC
	@Autowired
	WebApplicationContext context;
	//虚拟的mvc请求，获取到处理的结果
	MockMvc mockMvc;
	@Before
	public 	void initMokcMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build()	;
	}
	@Test
	public void testpage() throws Exception {
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/empAll").param("pageNum", "1")).andReturn();
		//请求成功之后可以取出数据
		MockHttpServletRequest request = result.getRequest();
		//获取到属性
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		
		//查看里面的数据
		System.out.println("当前页码："+pageInfo.getPageNum());
		System.out.println("当前的总页数："+pageInfo.getPages());
		System.out.println("当前总计录数："+pageInfo.getTotal());
		System.out.println("连续查询的页码");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(" "+i);
		}
		//打印出查询的数据
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

}
