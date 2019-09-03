package com.emp.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.emp.constraint.CheckRange;

//Ա����
public class Emp {
	private String empno;// Ա�����
	
	@Pattern(regexp="^[\u4e00-\u9fa5]{2,4}$",message="������2-4���ַ�")
	private String ename;// ����
    
	@CheckRange(range={"��","Ů"},message="�Ա�ֻ��Ϊ�л�Ů")
	private String esex;// �Ա�
	
	@Range(min=18,max=56,message="���䷶ΧΪ18-56��")
	private Integer eage;// ����
	@Range(min=3000,max=50000,message="���ʷ�ΧΪ3000-50000")
	private Float esalary;// н��
	
	private Dept dept;  //���� ��������
	
	//@CheckRange(range={"e001","e004","e007"},message="����ֻ��Ϊe001,e004,e007")
	private Emp mgr; //���� ��������

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
