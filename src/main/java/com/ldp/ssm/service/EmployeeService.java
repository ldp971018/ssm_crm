package com.ldp.ssm.service;

import java.util.List;

import com.ldp.ssm.bean.Employee;

/**
 * Ա����ҵ��ӿ�
 * @author return
 * 2019��4��18��
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
