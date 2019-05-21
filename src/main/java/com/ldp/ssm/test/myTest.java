package com.ldp.ssm.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.session.SqlSession;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//配置Spring单元测试

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldp.ssm.bean.Employee;
import com.ldp.ssm.bean.EmployeeExample;
import com.ldp.ssm.dao.EmployeeMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class myTest {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	@Test
	public void test01() {
		/*Employee employee=new Employee("杨繁荣", "110@qq.com", new Date(), new Date(), null, 1);
		int count = employeeMapper.insertSelective(employee);
		System.out.println(count);*/
		
		//测试批量操作 前提条件需要配置以下信息
		/*<!-- 配置一个可以执行批量的sqlSession -->*/
		/*<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
			<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
			<constructor-arg name="executorType" value="BATCH"></constructor-arg>
		</bean>*/
		
	/*	EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 100; i++) {
			String uuid=UUID.randomUUID().toString().substring(0, 5);
			mapper.insertSelective(new Employee(uuid, uuid+"@163.com",  new Date(), new Date(), null, 1));
		}*/
		//关联查询数据
		Employee employee = employeeMapper.selectByPrimaryKeyWithDept(1);
//		Employee employee = employeeMapper.selectByPrimaryKey(1);
		System.out.println(employee);
	}
	
	@Test 	
	public void tetspage() {
		PageHelper.startPage(6,10);
		List<Employee> eList =employeeMapper.selectByExampleWithDept(null);
		//使用pageInfo包装查询后的数据，只需要将pageinfo交给页面
		//里面封装详细的分页数据
		PageInfo pi=new PageInfo<>(eList,5);
		System.out.println("当前页码："+pi.getPageNum());
		System.out.println("总页码："+pi.getPages());
		System.out.println("总记录数："+pi.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] nums = pi.getNavigatepageNums();
		for (int i : nums) {
			System.out.print(" "+i);
		}
		//获取员工数据
		List<Employee> list = pi.getList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}
}
