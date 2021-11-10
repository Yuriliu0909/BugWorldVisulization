package Bugworld;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BugWorld2 extends Application {
	//set panes
	int width = 700, height = 400;
	int width2 = 800, height2 = 500;
	
	private final Pane pane1 = new Pane();
	private final Pane pane2 = new Pane();

	//set button   
	private final Button play = new Button("play");
	private final Button pause = new Button("Pause");
	private final Button stop = new Button("Stop");
	
	//set arraylist of objects
	private ArrayList<Bug> bugs = new ArrayList<>();
	private ArrayList<Plant> plants = new ArrayList<>();
	
	public Scene layout() throws NumberFormatException {
		//set hbox as outside pane
	    HBox hbox = new HBox(10);
	    hbox.setPadding(new Insets(5,5,5,5));
	    hbox.setStyle("-fx-background-color:lightgrey");
	
	    //set vbox as side to put button
	    VBox vbox = new VBox(10);
	    vbox.setPrefWidth(100);
	    vbox.setPadding(new Insets(5,5,5,5));
	    vbox.setAlignment(Pos.CENTER);
	    vbox.getChildren().addAll(play,pause,stop);
	    
	    //set inside pane size
	    pane1.setPrefWidth(width);
	    pane1.setPrefHeight(height);
	    pane1.setStyle("-fx-background-color:lightblue");
	    
	    //set button size
	    play.setPrefWidth(80);
	    pause.setPrefWidth(80);
	    stop.setPrefWidth(80);
	    //set scene
	    hbox.getChildren().addAll(vbox,pane1);
	    pane2.getChildren().add(hbox);
		Scene scene = new Scene(pane2, width2,height2);
		 return scene;
		 }
		

	@Override
	public void start(Stage primaryStage) throws Exception {
		//add bugs and plants
		Image image = new Image("ladybug.png",100,100, false, false);
		Ladybug lb1 = new Ladybug(image, "bug", Color.BLACK, 0, 0, 10 ,(float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		Ladybug lb2 = new Ladybug(image, "bug", Color.PURPLE, 0, 0, 10, (float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		bugs.add(lb1);
		bugs.add(lb2);
		
		Image image2 = new Image("beetle.png",150,100, false, false);
		Beetle b1 = new Beetle(image2, "bug", Color.LIGHTBLUE, 0, 0, 20,  (float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		Beetle b2 = new Beetle(image2, "bug", Color.YELLOW, 0, 0, 15, (float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		bugs.add(b1);
		bugs.add(b2);
		
		
		Image image3 = new Image("ant.png",150,100, false, false);
		Ant a1 = new Ant(image3, "bug", Color.LIGHTBLUE, 0, 0, 20,  (float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		Ant a2 = new Ant(image3, "bug", Color.YELLOW, 0, 0, 15, (float) (Math.random() * width),
				(float) (Math.random() * height), 1.5f, 1.5f);
		bugs.add(a1);
		bugs.add(a2);
		
		Image image4 = new Image("tree.png",100,100,false,false);
		Plant p1 = new Plant((int) (Math.random() * (width-25)), (int) (Math.random() * (height-25)), (int) (Math.random() * 50),Color.GREEN,image4);
		Plant p2 = new Plant((int) (Math.random() * (width-25)), (int) (Math.random() * (height-25)), (int) (Math.random() * 50),Color.GREEN,image4);
		plants.add(p1);
		plants.add(p2);
		
		pane1.getChildren().addAll(lb1, lb2,b1,b2,a1,a2,p1,p2);

		//set frame
		KeyFrame frame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//Animation 
				for (Bug b : bugs) {
					if (b.getTranslateX() < b.getRadius()
							|| b.getTranslateX() + b.getRadius() > pane1.getWidth()) {
						b.setDx(b.getDx() * (-1));

					}

					if (b.getTranslateY() < b.getRadius()
							|| b.getTranslateY() + b.getRadius() > pane1.getHeight()) {
						b.setDy(b.getDy() * (-1));

					}
					
					b.setPosX(b.getPosX() + b.getDx());
					b.setPosY(b.getPosY() + b.getDy());

					b.setTranslateX(b.getPosX());
					b.setTranslateY(b.getPosY());

				}
			}

		});

		//set timeline 
		Timeline timeline = new Timeline();
		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
		timeline.getKeyFrames().add(frame);
		timeline.play();
		
		//add functions to buttons
	       pause.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						timeline.pause();
					}
				});
		
		
	       play.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						timeline.play();
					}
				});
		
	      stop.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					timeline.stop();
				}
			});
	      
	      //set stage
	    Image icon = new Image("ladybug.png");
	    primaryStage.getIcons().add(icon);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Bug world");
		primaryStage.setScene(layout());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}