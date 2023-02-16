package test;

import java.util.List;

public class DaoBean {

	private List<String> datas;
	
	public void setDatas(List<String> datas) {
		this.datas = datas;
	}
	
	public boolean insert(String data) {
		try {
			datas.add(data);	
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public List<String> selectAll(){
		return datas;
	}

}
