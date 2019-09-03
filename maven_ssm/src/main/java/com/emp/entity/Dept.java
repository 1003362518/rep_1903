package com.emp.entity;

import java.util.List;

import com.emp.constraint.CheckRange;

//部门类
public class Dept {
	@CheckRange(range={"d001","d002","d003"},message="部门编号只能为d001,d002,d003")
	private String deptno;// 部门编号
	private String dname;// 部门名称
	private String location;//部门地址
	private List<Emp> emps; //某个部门下所有的员工  many=@Many
	

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Dept(String deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}



	public Dept(String deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}

	public String getDeptno() {
		return deptno;
	}
	
	

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", location=" + location + "]";
	}
	
	

}
