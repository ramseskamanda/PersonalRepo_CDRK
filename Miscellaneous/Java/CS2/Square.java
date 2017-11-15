import java.awt.Rectangle;
import java.util.Scanner;

public class Square extends Rectangle{

	public Square(int x, int y, int side){
		super(side, side);
		this.setLocation(x - (side / 2), y - (side / 2));
	}

	public int getArea(){
		return width*height;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Square.");
		System.out.print("X: ");
		int x = in.nextInt();
		System.out.print("Y: ");
		int y = in.nextInt();
		System.out.print("Size: ");
		int s = in.nextInt();
		Square sq = new Square(x, y, s);
		System.out.println(sq.toString() + "\nArea[area=" + sq.getArea() + "]");

	}

}