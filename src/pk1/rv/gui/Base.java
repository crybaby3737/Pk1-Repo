package pk1.rv.gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Base extends Stage {


public abstract Scene createScene();

public void showScene() {
	this.setScene(createScene());
	this.show();
}

}
