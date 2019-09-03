package com.emp.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.DeptDao;
import com.emp.dao.DeptLazyDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class DeptDaoTest {
	@Resource
	DeptDao deptDao;

	@Test
	public void testQueryAll() {
		List<Dept> list=deptDao.queryAll();
		for(Dept d:list){
			System.out.println(d);
		}
	}
	
	@Test
	public void testQueryById() {
		Dept d=deptDao.queryById("d001");
		System.out.println(d);
	}
	
	@Test
	public void testAddDept(){
		Dept d=new Dept("d005","财务部","长沙");
		deptDao.addDept(d);
		System.out.println("ok");
		this.testQueryAll();
	}
	
	@Test
	public void testDelDept(){
		deptDao.delDept("d005");
		System.out.println("ok");
		this.testQueryAll();
	}
	
	@Test
	public void testUpdateDept(){
		Dept dept=deptDao.queryById("d001");
		System.out.println(dept);
		dept.setLocation("长沙");
		deptDao.updateDept(dept);
		this.testQueryAll();
	}
	
	@Resource
	private DeptLazyDao deptLazyDao;
	
	@Test
	public void testQueryAll2(){
		List<Dept> list=deptLazyDao.queryAll();
		for(Dept d:list){
			System.out.println(d.getDname());
			System.out.println("~~~~~~~~~~~~~~~");
			for(Emp e:d.getEmps()){
				System.out.println(e.getEname());
			}
			System.out.println("~~~~~~~~~~~~~~~");
		}
	}
	
	@Test 
	public void testQueryById2(){
		Dept dept=deptLazyDao.queryById("d002");
		System.out.println(dept.getDname());
	}
	
	
	@Test 
	public void testQueryByDeptno(){
		List<Dept> list=deptLazyDao.queryByDeptno("d002");
		System.out.println("-------"+list);
		for(Dept d:list){
			List<Emp> emps=d.getEmps();
			for(Emp e:emps){
				System.out.println(d.getDname()+"."+e.getEname());
			}
		}
	}
	
}
