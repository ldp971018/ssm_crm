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
 * ���Է�ҳЧ��
 * @author return
 * 2019��4��18��
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:aplicationContext.xml","file:src/main/webapp/WEB-INF/SpringMVC-servlet.xml"})
public class Mytest02 {
	//����springmvc��IOC
	@Autowired
	WebApplicationContext context;
	//�����mvc���󣬻�ȡ������Ľ��
	MockMvc mockMvc;
	@Before
	public 	void initMokcMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build()	;
	}
	@Test
	public void testpage() throws Exception {
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/empAll").param("pageNum", "1")).andReturn();
		//����ɹ�֮�����ȡ������
		MockHttpServletRequest request = result.getRequest();
		//��ȡ������
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		
		//�鿴���������
		System.out.println("��ǰҳ�룺"+pageInfo.getPageNum());
		System.out.println("��ǰ����ҳ����"+pageInfo.getPages());
		System.out.println("��ǰ�ܼ�¼����"+pageInfo.getTotal());
		System.out.println("������ѯ��ҳ��");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(" "+i);
		}
		//��ӡ����ѯ������
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

}
