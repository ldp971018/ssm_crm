package com.ldp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.ssm.bean.Department;
import com.ldp.ssm.dao.DepartmentMapper;
import com.ldp.ssm.service.DepartmentService;
/**
 * ҵ��ӿ�ʵ����
 * @author return
 * 2019��4��19��
 */
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * ��ѯ���в�����Ϣ
	 */
	@Override
	public List<Department> deptAll() {
		return departmentMapper.selectByExample(null);
	}

}
