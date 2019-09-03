package com.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.entity.Dept;
import com.emp.entity.Emp;
import com.emp.service.DeptService;
import com.emp.service.EmpService;
import com.emp.utils.PageBean;

@Controller
public class EmpController {
	//注入业务层对象
	@Resource
	private EmpService empService;
	@Resource
	private DeptService deptService;
	
	private void loadEmp(HttpSession session){
		Map<String,String> map=new HashMap<String,String>();
		map.put("男", "男");
		map.put("女", "女");
		session.setAttribute("map", map);
		List<Dept> depts=deptService.queryAllDepts();
		session.setAttribute("depts", depts);
		List<Emp> mgrs=empService.queryMgrs();
		session.setAttribute("mgrs", mgrs);
	}
	//分页查询
	@RequestMapping("/emp/list")
	public String queryByPage(
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="3")Integer pageSize,Model model){
		PageBean<Emp> pageBean=empService.queryByPage(pageNo, pageSize);
		//将pageBean放入作用域
		model.addAttribute("pageBean", pageBean);
		return "ListEmp";
		
	}
	
	//条件分页查询
	@RequestMapping("/emp/conditionList")
	public String queryCondition(
			@RequestParam(value="pageNo",required=false,defaultValue="1") Integer pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue="3")Integer pageSize,
			@RequestParam(value="cd",required=false,defaultValue="")String cd,Model model,HttpSession session){
		PageBean<Emp> pageBean=empService.queryByCondition(pageNo, pageSize, cd);
		//将pageBean和cd放入作用域中
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("cd", cd);
		return "ListCondition";
	}
	
	//跳转到添加页面
	@RequestMapping("/emp/toAddEmp")
	public String toAddEmp(@ModelAttribute("emp") Emp emp,HttpSession session){
		loadEmp(session);
		return "AddEmp";
	}
	
	//添加员工
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmp(@Valid Emp emp,BindingResult br){
		if(br.getErrorCount()>0){
			return "AddEmp";
		}
		String empno=UUID.randomUUID().toString();
		emp.setEmpno(empno);
		empService.addEmp(emp);
		return "redirect:/emp/conditionList";
	}
	
	//跳转到修改页面
	@RequestMapping("/emp/toUpdate")
	public String toUpdate(@ModelAttribute("emp")Emp emp,@Param("empno")String empno,Model model,HttpSession session){
		loadEmp(session);
		emp=empService.queryEmpById(empno);
		model.addAttribute("emp", emp);
		return "UpdateEmp";
	}
	
	//修改员工
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(@Valid Emp emp,BindingResult br,HttpSession session,
			HttpServletRequest request){
		if(br.getErrorCount()>0){

			return "UpdateEmp";
		}
		empService.updateEmp(emp);
		//从session中去出pageBean和查询条件
		PageBean<Emp> pageBean=(PageBean)session.getAttribute("pageBean");
		pageBean=empService.queryByCondition(pageBean.getPageNo(),pageBean.getPageSize()
				, (String)session.getAttribute("cd"));
		session.setAttribute("pageBean", pageBean);
		return "redirect:/emp/redit";
		
	}

	
	@RequestMapping("/emp/redit")
	public String List(){
		return "ListCondition";
	}
	
	//删除员工
	@RequestMapping(value="/emp/{empno}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("empno") String empno){
		System.out.println("~~~~~~~~~~~~~"+empno);
		empService.deleteEmp(empno);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "redirect:/emp/conditionList";
	}
	

}
