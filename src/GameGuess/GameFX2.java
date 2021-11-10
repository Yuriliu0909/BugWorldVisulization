package GameGuess;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameFX2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
        primaryStage.setTitle("Game Guess!");

		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setStyle("-fx-background-color:lightyellow");
		
		//Defining the Name text field
		final TextField name = new TextField();
		name.setPromptText("Enter your number.");
		name.setPrefColumnCount(10);
		name.getText();
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		
		//Defining the Submit button
		Button submit = new Button("Guess");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		
		//Defining the Clear button
		Button clear = new Button("Clear");
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);
		
		//Adding a Label
		final Label label = new Label("guess number:");
		GridPane.setConstraints(label, 0, 3);
		GridPane.setColumnSpan(label, 2);
		grid.getChildren().add(label);

		//Setting an action for the Submit button
		submit.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		    public void handle(ActionEvent e) {
			try {
			int guess = 1;
			int target = (int) Math.floor(Math.random() * 10) + 1;
			while (guess < 10) {
				if ((name.getText() != null && !name.getText().isEmpty())) {
				int number = Integer.parseInt(name.getText());
				if (target > number) {
					 label.setText(name.getText() +  ", "
				                + "target is higher");
				} else if (target == number) {
	            	label.setText(name.getText() +  ", "
			                + "you win!");
					break;
				} else {
	            	label.setText(name.getText() +  ", "
			                + "target is lower");
				} }else {
		            label.setText("You have not left a number.");
		        }
				guess = guess + 1;
			}
		}catch (NumberFormatException nfe) {
    	    throw new NumberFormatException("The number entered, " + name.getText()+ " is invalid.");
     }
			}
		}
		 );
	
		 
		//Setting an action for the Clear button
		clear.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		    public void handle(ActionEvent e) {
		        name.clear();
		        label.setText(null);
		    }
		});
		
		Image icon = new Image("dragon.png");
		primaryStage.getIcons().add(icon);
		primaryStage.setScene(new Scene(grid,300,250));
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
