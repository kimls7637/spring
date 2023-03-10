package ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.DAO;
import view.View;

@Component
public class Ctrl {
	@Autowired
	private View view;
	@Autowired
	private DAO dao;
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
