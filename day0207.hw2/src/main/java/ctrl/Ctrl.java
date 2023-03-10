package ctrl;

import model.DAO;
import view.View;

public class Ctrl {
	private View view;
	private DAO dao;
	public void setView(View view) {
		this.view = view;
	}
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	public void startApp() {
		while(true) {
			int action = view.printMenu();
			if(action == 1) {
				view.printResult(dao.insert(view.getStr()));
			}
			else if(action == 2) {
				view.printDatas(dao.selectAll());
			}
			else {
				view.powerOff();
				break;
			}
		}
	}
}
