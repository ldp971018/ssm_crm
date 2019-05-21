package com.ldp.ssm.bean;

public class Department {
    private Integer id;

    private String departmentname;

    
    public Department(Integer id, String departmentname) {
		super();
		this.id = id;
		this.departmentname = departmentname;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentname=" + departmentname + "]";
	}
    
}