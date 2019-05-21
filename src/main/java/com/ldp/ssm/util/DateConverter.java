package com.ldp.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.exception.MyException;
import com.mysql.fabric.xmlrpc.base.Data;
/**
 * 自定义日期转换	
 * 实现converter接口，
 * 其中第一个参数表示数据源
 * 第二个参数表示需要转换后的目标类型
 * @author return
 * 2019年4月12日
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
			new MyException("日期转换异常");
			e.printStackTrace();
		}
		return null;
	}

}
