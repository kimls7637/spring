package test;

import java.util.ArrayList;
import java.util.List;

// 유사 DAO
public class DBean {
	private ArrayList<String> datas; // 디비 역할, 의존관계

	public List<String> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<String> datas) {
		this.datas = datas;
	}

	public boolean insert(String msg) { // 외부로부터 받는 값
		try {
			datas.add(msg);	
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public ArrayList<String> selectAll(){
		return datas;
	}

	@Override
	public String toString() {
		return "DBean [datas=" + datas + "]";
	}


}
