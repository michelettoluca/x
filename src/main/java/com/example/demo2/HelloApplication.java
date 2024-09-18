package com.example.demo2;

import com.example.demo2.x.X;
import com.example.demo2.x.XError;
import com.example.demo2.x.XSchema;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	enum Test {
		PALLE,
		PALLE2
	}

	public static void main(String[] args) {
		XSchema stringSchema = X.string()
			.minLength(3)
			.addValidator((a) -> a.equals("asd") ? null : new XError("asd"))
			.minLength(10)
			.addValidator((a) -> a.contains("222") ? null : new XError("222!!!!"));

//		XNumber num = XBuilder.number()
//			.min(1);
//
//		X asd = num
//			.cl
//			.max(10);


//		System.out.println(stringSchema.safeParse(XBuilder.string()));
		System.out.println(stringSchema.parse("PL2222222222222222E"));
		System.out.println(stringSchema.parse(2));
		System.out.println(stringSchema.parse(null));
//		System.out.println(num.safeParse(-10));
//		System.out.println(num.safeParse(10));
	}
}
