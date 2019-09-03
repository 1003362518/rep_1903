package com.emp.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.emp.constraint.CheckRange;

//员工类
public class Emp {
	private String empno;// 员工编号
	
	@Pattern(regexp="^[\u4e00-\u9fa5]{2,4}$",message="必须是2-4个字符")
	private String ename;// 姓名
    
	@CheckRange(range={"男","女"},message="性别只能为男或女")
	private String esex;// 性别
	
	@Range(min=18,max=56,message="年龄范围为18-56岁")
	private Integer eage;// 年龄
	@Range(min=3000,max=50000,message="工资范围为3000-50000")
	private Float esalary;// 薪资
	
	private Dept dept;  //部门 关联属性
	
	//@CheckRange(range={"e001","e004","e007"},message="经理只能为e001,e004,e007")
	private Emp mgr; //经理 关联属性

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Emp(String empno, String ename, String esex, Integer eage, Float esalary, Dept dept, Emp mgr) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.esex = esex;
		this.eage = eage;
		this.esalary = esalary;
		this.dept = dept;
		this.mgr = mgr;
	}



	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public Float getEsalary() {
		return esalary;
	}

	public void setEsalary(Float esalary) {
		this.esalary = esalary;
	}
	
	public Dept getDept() {
		return dept;
	}



	public void setDept(Dept dept) {
		this.dept = dept;
	}



	public Emp getMgr() {
		return mgr;
	}
	


	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}



	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", esex=" + esex + ", eage=" + eage + ", esalary=" + esalary
				+ ", dept=" + dept + ", mgr=" + mgr + "]";
	}



	

}
