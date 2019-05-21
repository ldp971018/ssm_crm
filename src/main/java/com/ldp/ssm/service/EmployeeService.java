package com.ldp.ssm.service;

import java.util.List;

import com.ldp.ssm.bean.Employee;

/**
 * 员工的业务接口
 * @author return
 * 2019年4月18日
 */

public interface EmployeeService {

	List<Employee> getEmpAll();

	void saveEmp(Employee employee);

	boolean checkLastname(String lastname);

	Employee getEmp(Integer id);

	void updateEmp(Employee employee);

	void deleteBatch(List<Integer> del_ids);

	void deleteEmp(Integer id);

}
