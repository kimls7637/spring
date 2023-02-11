package model;

import java.util.ArrayList;

public class DAO {
	private ArrayList<String> datas;
	public ArrayList<String> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<String> datas) {
		this.datas = datas;
	}
	public boolean insert(String str) {
		try {
			datas.add(str);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	public ArrayList<String> selectAll() {
		return datas;
	}
}
