
module Pk1Ueb09 {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	opens pk1.rv.gui to javafx.controls, javafx.base, javafx.graphics;
	opens pk1.rv.fachlogik to javafx.controls, javafx.base, javafx.graphics;
}