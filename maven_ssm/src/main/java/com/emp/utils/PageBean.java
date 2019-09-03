package com.emp.utils;

import java.util.List;

//��ҳ�������
public class PageBean<E> { //����E�����������������
	private Integer pageNo=1;//��ǰҳ��
	private Integer pageSize=3;//ҳ����
	private List<E> list;   //��ǰҳ������
	private Integer tatalCount;//���з�ҳ���ܼ�¼��
	
	//��һҳ   ${previous}
	public Integer getPrevious(){
		return this.pageNo==1?1:this.pageNo-1;
		//return this.pageNo>1?this.pageNo-1:1;
	}
	
	//��һҳ   ${next}
	public Integer getNext(){
		return this.pageNo==getLast()?getLast():this.pageNo+1;
	}
	
	//��ҳ  jspҳ��ȡֵ ${first}
	public Integer getFirst(){
		return 1;
	}
	
	//βҳ ${list}
	public Integer getLast(){
		return getTotalPages();
	}
	
	//��ҳ�� ${totalPages}
	public Integer getTotalPages(){
		return tatalCount%pageSize==0?
				tatalCount/pageSize:tatalCount/pageSize+1;
	}
	
	//��õ�ǰҳҳ��
	//��JSPҳ���ȡ���ֵ  ${pageNo}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getTatalCount() {
		return tatalCount;
	}
	public void setTatalCount(Integer tatalCount) {
		this.tatalCount = tatalCount;
	}
	
	
	
}
