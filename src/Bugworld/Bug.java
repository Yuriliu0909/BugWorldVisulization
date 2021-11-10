package Bugworld;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Bug extends Circle {
	private Image image;
	private String name;
	private Color color;
	private int x, y;
	private int radius;
	private float posX, posY, dx, dy;


	/**
	 * @param image
	 * @param name
	 * @param color
	 * @param x
	 * @param y
	 * @param radius
	 * @param posX
	 * @param posY
	 * @param dx
	 * @param dy
	 */
	public Bug(Image image, String name, Color color, int x, int y, int radius, float posX, float posY, float dx,
			float dy) {
		this.name = name;
		this.color = color;
		setFill(color);
		setCenterX(x);
		setCenterY(y);
		setRadius(radius);
		setFill(new ImagePattern(image));
		this.posX = posX;
		this.posY = posY;
		this.dx = dx;
		this.dy = dy;
	}

//	public Bug(String sp, String n, Color color, int x, int y, int radius, int e, float posX, float posY, float dx,
//			float dy) {
//		this.species = sp;
//		this.name = n;
//		setFill(color);
//		setCenterX(x);
//		setCenterY(y);
//		setRadius(radius);
//		this.posX = posX;
//		this.posY = posY;
//		this.dx = dx;
//		this.dy = dy;
//	}

//	//overload
//	public Bug(String sp, String n, Color color, int x, int y, int radius, int e, float posX, float posY, float dx,
//			float dy,ImageView iv) {
//		this.species = sp;
//		this.name = n;
//		setFill(color);
//		setCenterX(x);
//		setCenterY(y);
//		setRadius(radius);
//		this.posX = posX;
//		this.posY = posY;
//		this.dx = dx;
//		this.dy = dy;
//		
//	}
//
//
//	public Bug(String sp, String n, char sym, int x, int y, int e) {
//		species = sp;
//		name = n;
//		symbol = sym;
//		this.x = x;
//		this.y = y;
//		energy = e;
//		id = totalBugs++;
//	}
//
//	public Bug() {
//		species = "Bug";
//		name = "Freddy";
//		symbol = '@';
//		x = 10;
//		y = 10;
//		energy = 100;
//		id = totalBugs++;
//	}

	public void move(char dir) {
		if (dir == 'N') {
			y -= 1;
		} else if (dir == 'S') {

			y += 1;
		} else if (dir == 'E') {

			x++;
		} else {
			setX(getX() - 1);
			x--;
		}
	}

//	public String getSpecies() {
//		return species;
//	}
//
//	public void setSpecies(String species) {
//		this.species = species;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public char getSymbol() {
//		return symbol;
//	}
//
//	public void setSymbol(char symbol) {
//		this.symbol = symbol;
//	}

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
//
//	public int getEnergy() {
//		return energy;
//	}
//
//	public void setEnergy(int energy) {
//		this.energy = energy;
//	}
//
//
//	public String toString() {
//		return species + symbol + id + "(" + x + "," + y + ")";
//	}

	

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}



	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}




	
	

}
