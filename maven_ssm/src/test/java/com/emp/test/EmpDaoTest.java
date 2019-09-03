package com.emp.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.EmpDao;
import com.emp.dao.EmpLazyDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class EmpDaoTest {
	@Resource
	private EmpDao empDao;
	@Test
	public void testQueryAll() {
		List<Emp> emps=empDao.queryAll();
		for(Emp e:emps){
			/*System.out.println(e.getEmpno()+"."+e.getEname()+"."+e.getDept().getDname()
					+"."+e.getMgr().getEname());*/
			System.out.println(e);
		}
	}
	
	@Test
	public void testQueryById(){
		Emp  e=empDao.queryById("e645");
		System.out.println(e);
	}
	
	@Test
	public void testQueryLikeName(){
		List<Emp> es=empDao.queryLikeName("��");
		for(Emp e:es){
			System.out.println(e);
		}
	}
	
	@Test
	public void testAddEmp(){
		Emp emp=new Emp();
		emp.setEmpno("e645");
		emp.setEname("����");
		emp.setEsex("Ů");
		emp.setEsalary(31151F);
		emp.setEage(23);
		//����һ�����Ŷ���
		Dept dept=new Dept();
		dept.setDeptno("d002");
		emp.setDept(dept);
		//����һ���������
		Emp mgr=new Emp();
		mgr.setEmpno("e001");
		emp.setMgr(mgr);
		//��e���󱣴浽���ݿ���
		empDao.addEmp(emp);
		System.out.println("ok");
		
	}
	
	@Test
	public void testDelete(){
		empDao.deleteEmp("e645");
		System.out.println("ok");
	}
	
	@Test
	public void testUpdate(){
		 Emp e=empDao.queryById("e002");
		System.out.println(e);
		e.setEsalary(60000F);
		e.getDept().setDeptno("d002");
		e.getMgr().setEmpno("e004");
		empDao.updateEmp(e);
		System.out.println("ok");
	}
	
	@Test
	public void testQueryByDeptno(){
		List<Emp> list=empDao.queryByDept("d002");
		for(Emp e:list){
			System.out.println(e);
		}
	}
	
	@Test
	public void testQueryMgr(){
		List<Emp> list=empDao.queryMgr();
		for(Emp e:list){
			System.out.println(e);
		}
	}
	@Resource
	private EmpLazyDao empLaryDao;
	
	@Test//����������
	public void testLary(){
		Emp e =empLaryDao.queryById("e002");
		System.out.println(e.getEname());
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(e.getDept().getDname());
	}
	
	@Test//����������
	public void testLary2(){
		List<Emp> es=empLaryDao.queryAll();
		for(Emp e:es){
			
			System.out.println(e.getEname()+"."+e.getDept().getDname());
		}
	}
	
	@Test//����������
	public void testLary3(){
		List<Emp> es=empLaryDao.queryByDept("d002");
		for(Emp e:es){
			
			System.out.println(e.getEname()+"."+e.getDept().getDname());
		}
	}
	
	@Test//����������
	public void testLary4(){
		List<Emp> es=empLaryDao.queryLikeName("��");
		for(Emp e:es){
			
			System.out.println(e.getEname()+"."+e.getDept().getDname());
		}
	}
	

}
