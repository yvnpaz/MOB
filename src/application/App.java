package application;

import application.mob.entity.User;
import application.mob.exception.CustomException;
import application.mob.service.MobService;
import application.mob.service.MobServiceImpl;
import application.mob.utils.UtilsMob;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

	MobService mobService;
	UtilsMob utils;
	User user;

	public App() {
		user = new User();
		mobService = new MobServiceImpl();
		utils = new UtilsMob();
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			/* Label Field */
			Label label = new Label("Calculation: ");
			/* Text Field */
			TextField textFibonacci = new TextField();
			/* Label Field result */
			Label labelWarning = new Label("");
			/* Label Field user */
			Label labelUser = new Label("User: The User hasn't press in the button Fibonacci.");
			/* Button */
			Button btn = new Button("Fibonacci");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					if (textFibonacci.getText() != null && !textFibonacci.getText().isEmpty()
							&& utils.isNumeric(textFibonacci.getText())) {
						int res = 0;
						try {
							res = mobService.fibonacci(utils.stringToInt(textFibonacci.getText()));
							labelWarning.setText("");
							/* User text format */
							user.setNumber(res);
							String userFormat = utils.formatUserText(labelUser.getText());
							String formatResult = (String) utils.concatUsertext(userFormat,
									utils.intToString(user.getNumber()));
							labelUser.setText(formatResult);
						} catch (CustomException e) {
							e.getStackTrace();
							labelWarning.setText("Number too high.");
						}
					} else {
						labelWarning.setText("Put a number in the text box.");
						labelUser.setText("User: ");
					}

				}
			});

			AnchorPane anchor = configureDispositionPanel(label, textFibonacci, labelWarning, labelUser, btn);

			Scene scene = new Scene(anchor, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Mob Project");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AnchorPane configureDispositionPanel(Label label, TextField textFibonacci, Label labelWarning,
			Label labelUser, Button btn) {
		AnchorPane anchor = new AnchorPane();

		AnchorPane.setTopAnchor(label, 10.0);
		AnchorPane.setLeftAnchor(label, 10.0);

		AnchorPane.setTopAnchor(btn, 40.0);
		AnchorPane.setLeftAnchor(btn, 40.0);

		AnchorPane.setTopAnchor(textFibonacci, 40.0);
		AnchorPane.setLeftAnchor(textFibonacci, 110.0);

		AnchorPane.setTopAnchor(labelWarning, 75.0);
		AnchorPane.setLeftAnchor(labelWarning, 110.0);

		AnchorPane.setTopAnchor(labelUser, 110.0);
		AnchorPane.setLeftAnchor(labelUser, 110.0);

		anchor.getChildren().addAll(label, btn, textFibonacci, labelWarning, labelUser);
		return anchor;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
