package Bugworld;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Plant extends Circle {
	private int x, y, size;

	public Plant(int x, int y, int size,Color col,Image image) {
		this.y = y;
		this.x = x;
		this.size = size;
		setCenterX(x);
		setCenterY(y);
		setRadius(size);
		setFill(col);
		setFill(new ImagePattern(image));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getSymbol() {
		return ("" + size).charAt(0);
	}


}
