package com.ldp.ssm.util;

import java.util.UUID;

//ͨ���˹����࣬���������ļ�����
public class UploadUtils {
	/*
	 * ����ļ�����
	 */
	public static String getUuidFileName(String fileName) {
		//1.���Ȼ���ļ����С�.����λ������
		int index=fileName.lastIndexOf(".");
		//2.�õ��ļ���׺
		String ext=fileName.substring(index);
		//3.����������
		String name=UUID.randomUUID().toString().replace("-", "")+ext;
		return name;
	}
	/*
	 * ����ļ�Ŀ¼
	 */
	public static String getPath(String uuidFileName) {
		int code1=uuidFileName.hashCode();
		int d1=code1& 0xf;//��Ϊһ��Ŀ¼
		int code2=code1 >>4;
		int d2=code2& 0xf;//��Ϊ����Ŀ¼ 	
		return "/"+d1+"/"+d2;
	} 
}
