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
 * Ա���Ŀ��Ʋ�
 * @author return
 * 2019��4��18��
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
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//����ɾ��
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//��װid�ļ���
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
	 * ��ѯ�ĵ���Ա������
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
	 * ����û����Ƿ����
	 * @param lastname
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLastname")
	public Msg checkLastname(@RequestParam("lastname")String lastname) {
		//���ж��û����Ƿ��ǺϷ��ı��ʽ;
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!lastname.matches(regx)){
			return Msg.fail().add("checkname_msg", "�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����");
		}
		//�������ݿ� ��ѯ���ݲ鿴�Ƿ����
		boolean flag=employeeService.checkLastname(lastname);
		if (flag) {
			return Msg.success();
		}else {
			return Msg.fail().add("checkname_msg", "�û����Ѵ���");
		}
	}
	

	/**
	 * ��ʾ��������
	 * 
	 * @param pageNum
	 * @return
	 */
	@ResponseBody // ����josn��ʽ����
	@RequestMapping("/empAll")
	public Msg getPageinfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		// �����ҳ������з�ҳ��ѯ
		System.out.println("���ڷ���json����");
		PageHelper.startPage(pageNum, 10);
		List<Employee> eList = employeeService.getEmpAll();
		// ʹ��pageInfo��װ��ѯ������ݣ�ֻ��Ҫ��pageinfo����ҳ��
		// �����װ��ϸ�ķ�ҳ����
		PageInfo pageInfo = new PageInfo<>(eList, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * Ա������
	 * 1��֧��JSR303У�飨��Ҫ���@@Valid��,BindingResult result
	 * 2������Hibernate-Validator
	 * 3���涨�ƶ���post������
	 * @param multipartFile
	 * @param employee
	 * @param BindingResult//���ڷ���У�����Ϣ
	 * @return
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@RequestParam("upload") MultipartFile multipartFile,
			@Valid Employee employee,BindingResult result) {
		if (multipartFile != null) {
			String path = servletContext.getRealPath("/upload");
			// һ��Ŀ¼��Ŷ����ͬ�ļ��ǻḲ�ǣ����������ֵ��
			System.out.println(multipartFile.getOriginalFilename());
			String uuidFileName = UploadUtils.getUuidFileName(multipartFile.getOriginalFilename());
			// �����ļ�Ŀ¼:�ļ����࣬����̫����ʹ��Ŀ¼����
			String realpath = UploadUtils.getPath(uuidFileName);
			// ����Ŀ¼
			String url = path + realpath;
			File file = new File(url);
			// �ж��Ƿ����
			if (!file.exists()) {
				file.mkdirs();
			}
			// ��ʼ�ϴ�
			File destFile = new File(url + "/" + uuidFileName);
			try {
				multipartFile.transferTo(destFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ϴ��ļ�ʧ��");
			}
			System.out.println(url + "/" + uuidFileName);
			employee.setEmpImage("upload" + realpath + "/" + uuidFileName);
		}
		
		if(result.hasErrors()){
			//У��ʧ�ܣ�Ӧ�÷���ʧ�ܣ���ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ�����"+fieldError.getField());
				System.out.println("������Ϣ��"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	
	/**
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1��������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ�����װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/empUpdate/{id}",method=RequestMethod.POST)
	public Msg saveEmp(@RequestParam("uploadImage") MultipartFile multipartFile,
			Employee employee,HttpServletRequest request){
		if (multipartFile != null) {
			String path = servletContext.getRealPath("/upload");
			// һ��Ŀ¼��Ŷ����ͬ�ļ��ǻḲ�ǣ����������ֵ��
			System.out.println(multipartFile.getOriginalFilename());
			String uuidFileName = UploadUtils.getUuidFileName(multipartFile.getOriginalFilename());
			// �����ļ�Ŀ¼:�ļ����࣬����̫����ʹ��Ŀ¼����
			String realpath = UploadUtils.getPath(uuidFileName);
			// ����Ŀ¼
			String url = path + realpath;
			File file = new File(url);
			// �ж��Ƿ����
			if (!file.exists()) {
				file.mkdirs();
			}
			// ��ʼ�ϴ�
			File destFile = new File(url + "/" + uuidFileName);
			try {
				multipartFile.transferTo(destFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ϴ��ļ�ʧ��");
			}
			System.out.println(url + "/" + uuidFileName);
			employee.setEmpImage("upload" + realpath + "/" + uuidFileName);
		}
		System.out.println("��Ҫ���µ�Ա�����ݣ�"+employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
}
