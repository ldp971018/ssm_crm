package com.ldp.ssm.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer id;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
    		,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String lastname;

    //@Email
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
    		message="邮箱格式不正确")
    private String email;

    private Date birth;

    private Date createtime;

    private String empImage;

    private Integer departmentId;
    
    private Department department;
    
    
    
	public Employee(Integer id, String lastname, String email, Date birth, Date createtime, String empImage,
			Integer departmentId) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.email = email;
		this.birth = birth;
		this.createtime = createtime;
		this.empImage = empImage;
		this.departmentId = departmentId;
	}

	public Employee(String lastname, String email, Date birth, Date createtime, String empImage, Integer departmentId) {
		super();
		this.lastname = lastname;
		this.email = email;
		this.birth = birth;
		this.createtime = createtime;
		this.empImage = empImage;
		this.departmentId = departmentId;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage == null ? null : empImage.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", email=" + email + ", birth=" + birth
				+ ", createtime=" + createtime + ", empImage=" + empImage + ", departmentId=" + departmentId
				+ ", department=" + department + "]";
	}
    
}