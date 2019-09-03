package com.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.DeptDao;
import com.emp.entity.Dept;
import com.emp.service.DeptService;

@Service//实例化将类放入容器中
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;
	
	@Override
	public List<Dept> queryAllDepts() {
		return deptDao.queryAll();
	}


}
