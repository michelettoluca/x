module com.example.demo2 {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.demo2 to javafx.fxml;
	exports com.example.demo2;
	exports com.example.demo2.x;
	opens com.example.demo2.x to javafx.fxml;
}
