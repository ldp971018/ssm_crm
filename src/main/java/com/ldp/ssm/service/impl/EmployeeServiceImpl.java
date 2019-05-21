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
 * 员工的业务接口实现类
 * @author return
 * 2019年4月18日
 */
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper;
	/**
	 * 查看所有员工信息
	 */
	@Override
	public List<Employee> getEmpAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
	/**
	 * 添加员工信息
	 */
	@Override
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	
	/**
	 * 校验是否存在此用户
	 * 返回true说明可以用此用户名
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
	 * 查信息数据
	 */
	@Override
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKeyWithDept(id);
	}
	/**
	 * 修改员工数据
	 */
	@Override
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * 进行批量删除
	 */
	@Override
	public void deleteBatch(List<Integer> del_ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}
	/**
	 * 进行单个删除
	 */
	@Override
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

}
