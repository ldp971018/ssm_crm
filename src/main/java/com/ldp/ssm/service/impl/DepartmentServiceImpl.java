package com.ldp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.ssm.bean.Department;
import com.ldp.ssm.dao.DepartmentMapper;
import com.ldp.ssm.service.DepartmentService;
/**
 * 业务接口实现类
 * @author return
 * 2019年4月19日
 */
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 查询所有部门信息
	 */
	@Override
	public List<Department> deptAll() {
		return departmentMapper.selectByExample(null);
	}

}
