package com.ldp.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.exception.MyException;
import com.mysql.fabric.xmlrpc.base.Data;
/**
 * �Զ�������ת��	
 * ʵ��converter�ӿڣ�
 * ���е�һ��������ʾ����Դ
 * �ڶ���������ʾ��Ҫת�����Ŀ������
 * @author return
 * 2019��4��12��
 */
public  class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String date) {
		System.out.println("data====================="+date);
		Date result=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			result =sdf.parse(date);
			return result;
		} catch (Exception e) {
			new MyException("����ת���쳣");
			e.printStackTrace();
		}
		return null;
	}

}
