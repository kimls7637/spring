package prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("app")
public class Controller {
	@Autowired
	private Model model;
	@Autowired
	private View view;

	public void startApp() {
		while(true) {
			int act=view.menu();
			if(act==1) {
				model.insert(view.action01());
			}
			else if(act==2) {
				view.action03(model.selectAll(view.action02()));
			}
			else {
				return;
			}
		}
	}
}
