package com.ldp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.ssm.bean.Employee;
import com.ldp.ssm.bean.EmployeeExample;
import com.ldp.ssm.bean.EmployeeExample.Criteria;
import com.ldp.ssm.dao.EmployeeMapper;
import com.ldp.ssm.service.EmployeeService;

/**
 * Ա����ҵ��ӿ�ʵ����
 * @author return
 * 2019��4��18��
 */
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper;
	/**
	 * �鿴����Ա����Ϣ
	 */
	@Override
	public List<Employee> getEmpAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
	/**
	 * ���Ա����Ϣ
	 */
	@Override
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	
	/**
	 * У���Ƿ���ڴ��û�
	 * ����true˵�������ô��û���
	 */
	@Override
	public boolean checkLastname(String lastname) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andLastnameEqualTo(lastname);
		int count = employeeMapper.countByExample(example);
		return count==0;
	}
	/**
	 * ����Ϣ����
	 */
	@Override
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKeyWithDept(id);
	}
	/**
	 * �޸�Ա������
	 */
	@Override
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * ��������ɾ��
	 */
	@Override
	public void deleteBatch(List<Integer> del_ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}
	/**
	 * ���е���ɾ��
	 */
	@Override
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

}
