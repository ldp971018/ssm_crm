package com.ldp.ssm.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 员工的控制层
 * @author return
 * 2019年4月18日
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.exception.MyException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldp.ssm.bean.Employee;
import com.ldp.ssm.bean.Msg;
import com.ldp.ssm.service.EmployeeService;
import com.ldp.ssm.util.UploadUtils;

@Controller
public class EmployeeController {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private EmployeeService employeeService;
	
	
	/**
	 * 单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	
	
	/**
	 * 查询的单个员工数据
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee =employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * 检查用户名是否可用
	 * @param lastname
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLastname")
	public Msg checkLastname(@RequestParam("lastname")String lastname) {
		//先判断用户名是否是合法的表达式;
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!lastname.matches(regx)){
			return Msg.fail().add("checkname_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}
		//进入数据库 查询数据查看是否存在
		boolean flag=employeeService.checkLastname(lastname);
		if (flag) {
			return Msg.success();
		}else {
			return Msg.fail().add("checkname_msg", "用户名已存在");
		}
	}
	

	/**
	 * 显示所有数据
	 * 
	 * @param pageNum
	 * @return
	 */
	@ResponseBody // 返回josn格式数据
	@RequestMapping("/empAll")
	public Msg getPageinfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		// 引入分页插件进行分页查询
		System.out.println("正在返回json数据");
		PageHelper.startPage(pageNum, 10);
		List<Employee> eList = employeeService.getEmpAll();
		// 使用pageInfo包装查询后的数据，只需要将pageinfo交给页面
		// 里面封装详细的分页数据
		PageInfo pageInfo = new PageInfo<>(eList, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * 员工保存
	 * 1、支持JSR303校验（需要添加@@Valid）,BindingResult result
	 * 2、导入Hibernate-Validator
	 * 3、规定制定是post的请求
	 * @param multipartFile
	 * @param employee
	 * @param BindingResult//用于返回校验的信息
	 * @return
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@RequestParam("upload") MultipartFile multipartFile,
			@Valid Employee employee,BindingResult result) {
		if (multipartFile != null) {
			String path = servletContext.getRealPath("/upload");
			// 一个目录存放多个相同文件是会覆盖，进行随机赋值名
			System.out.println(multipartFile.getOriginalFilename());
			String uuidFileName = UploadUtils.getUuidFileName(multipartFile.getOriginalFilename());
			// 创建文件目录:文件过多，加载太慢，使用目录分离
			String realpath = UploadUtils.getPath(uuidFileName);
			// 创建目录
			String url = path + realpath;
			File file = new File(url);
			// 判断是否存在
			if (!file.exists()) {
				file.mkdirs();
			}
			// 开始上传
			File destFile = new File(url + "/" + uuidFileName);
			try {
				multipartFile.transferTo(destFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("上传文件失败");
			}
			System.out.println(url + "/" + uuidFileName);
			employee.setEmpImage("upload" + realpath + "/" + uuidFileName);
		}
		
		if(result.hasErrors()){
			//校验失败，应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名："+fieldError.getField());
				System.out.println("错误信息："+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	
	/**
	 * 如果直接发送ajax=PUT形式的请求
	 * 封装的数据
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * 问题：
	 * 请求体中有数据；
	 * 但是Employee对象封装不上；
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * 原因：
	 * Tomcat：
	 * 		1、将请求体中的数据，封装一个map。
	 * 		2、request.getParameter("empName")就会从这个map中取值。
	 * 		3、SpringMVC封装POJO对象的时候。
	 * 				会把POJO中每个属性的值，request.getParamter("email");
	 * AJAX发送PUT请求引发的血案：
	 * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
	 * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * 解决方案；
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/empUpdate/{id}",method=RequestMethod.POST)
	public Msg saveEmp(@RequestParam("uploadImage") MultipartFile multipartFile,
			Employee employee,HttpServletRequest request){
		if (multipartFile != null) {
			String path = servletContext.getRealPath("/upload");
			// 一个目录存放多个相同文件是会覆盖，进行随机赋值名
			System.out.println(multipartFile.getOriginalFilename());
			String uuidFileName = UploadUtils.getUuidFileName(multipartFile.getOriginalFilename());
			// 创建文件目录:文件过多，加载太慢，使用目录分离
			String realpath = UploadUtils.getPath(uuidFileName);
			// 创建目录
			String url = path + realpath;
			File file = new File(url);
			// 判断是否存在
			if (!file.exists()) {
				file.mkdirs();
			}
			// 开始上传
			File destFile = new File(url + "/" + uuidFileName);
			try {
				multipartFile.transferTo(destFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("上传文件失败");
			}
			System.out.println(url + "/" + uuidFileName);
			employee.setEmpImage("upload" + realpath + "/" + uuidFileName);
		}
		System.out.println("将要更新的员工数据："+employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
}
