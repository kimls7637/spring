package test;

import java.util.ArrayList;

public class TestBean {
	private ArrayList<String> datas;
	public ArrayList<String> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<String> datas) {
		this.datas = datas;
	}
	public void insert(String str) {
		datas.add(str);
	}
	public ArrayList<String> selectAll() {
		return datas;
	}
}
