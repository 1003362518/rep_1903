package com.emp.entity;

import java.util.List;

import com.emp.constraint.CheckRange;

//������
public class Dept {
	@CheckRange(range={"d001","d002","d003"},message="���ű��ֻ��Ϊd001,d002,d003")
	private String deptno;// ���ű��
	private String dname;// ��������
	private String location;//���ŵ�ַ
	private List<Emp> emps; //ĳ�����������е�Ա��  many=@Many
	

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
