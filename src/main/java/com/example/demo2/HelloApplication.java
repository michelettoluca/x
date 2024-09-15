package com.example.demo2;

import com.example.demo2.x.XBuilder;
import com.example.demo2.x.XSchema;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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
		XSchema stringSchema = XBuilder.string()
			.minLength(3)
			.in(List.of(Test.values()), Test::name)
			.nullable();

		XSchema num = XBuilder.number()
			.min(3)
			.equals(3);


		System.out.println(num.safeParse(XBuilder.string()));
		System.out.println(num.safeParse(2D));
		System.out.println(num.safeParse(2F));
		System.out.println(num.safeParse(2L));
		System.out.println(num.safeParse(2));
	}
}
