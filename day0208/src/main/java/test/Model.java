package test;

import java.util.List;

public class Model {
	private List<String> datas;
	public void setDatas(List<String> datas) {
		this.datas = datas;
	}
	public boolean insert(String vo) {
		datas.add(vo);
		return true;
	}
	public List<String> selectAll(String vo){
		return datas;
	}
}
