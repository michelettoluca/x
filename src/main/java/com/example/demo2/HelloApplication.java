package com.example.demo2;

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

	public static void main(String[] args) {
		XSchema schema = XBuilder.string()
			.minLength(3)
			.maxLength(5)
			.nullable();

		System.out.println(schema.parse("Hello"));
		System.out.println(schema.parse("Hi"));
		System.out.println(schema.parse("Welcome"));
		System.out.println(schema.parse(null));
		System.out.println(schema.parse(getObject()));
	}

	public static Object getObject() {
		return 1;
	}
}
