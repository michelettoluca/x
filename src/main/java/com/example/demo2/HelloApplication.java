package com.example.demo2;

import com.example.demo2.x.XBuilder;
import com.example.demo2.x.XException;
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

	public static void main(String[] args) {
		XSchema schema = XBuilder.string()
			.minLength(3)
			.maxLength(5)
			.equals("Hi")
			.nullable();

		XSchema num = XBuilder.number()
			.min(3)
			.max(1235)
			.equals(3)
			.nullable();

		try {
			schema.parse(123);
		} catch (XException e) {
			throw new RuntimeException(e);
		}
		System.out.println(num.safeParse(123));
	}
}
