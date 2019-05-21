package com.ldp.ssm.handler;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldp.ssm.bean.Department;
import com.ldp.ssm.bean.Msg;
import com.ldp.ssm.dao.DepartmentMapper;
import com.ldp.ssm.service.DepartmentService;

@Controller
public class DepartmentConrtoller {
	
	@Autowired
	private DepartmentService departmentService;
	
	//查询所有部门数据（JSON）
	@RequestMapping("/deptAll")
	@ResponseBody
	public Msg deptAll() {
		List<Department> list = departmentService.deptAll();
		return Msg.success().add("depts", list);
	}
}
