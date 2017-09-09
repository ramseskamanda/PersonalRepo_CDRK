import java.util.Scanner;

public class Rectangle{
	private int width;
	private int height;

	public Rectangle() {
		this.width = 10;
		this.height = 5;
	}

	public Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}

	public int getArea(){
		return this.width*this.height;
	}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Rectangle rectv2 = new Rectangle(12, 4);
		int area_rect = rect.getArea();
		int area_rectv2 = rectv2.getArea();
		System.out.println("rect1 area: " + area_rect +
						   " rect2 area: " + area_rectv2);
	}
}