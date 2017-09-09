public class HiddenMessages{
	public static void main(String[] args) {
		SimpleImageHandler img1 = new SimpleImageHandler("X:/User/Documents/Java/CS1/location1.bmp");
		SimpleImageHandler img2 = new SimpleImageHandler("X:/User/Documents/Java/CS1/location2.bmp");
		SimpleImageHandler img3 = new SimpleImageHandler("X:/User/Documents/Java/CS1/location3.bmp");

		img1 = solve_img1(img1);
		img2 = solve_img2(img2);
		img3 = solve_img3(img3);

		img1.showImage();
		img2.showImage();
		img3.showImage();
		System.out.println("The three locations are: The Sydney Opera House, The Roman Colloseum, and an unknown place with something like a church and some buildings.");
		System.out.println("Ahh! Also... Why not Python?");
	}

	public static SimpleImageHandler solve_img1(SimpleImageHandler img){
		int[][] img_reds = img.getRedValues();
		for(int i = 0; i < img_reds.length; i++)
			for(int j = 0; j < img_reds[0].length; j++)
				img_reds[i][j] *= 10;
		img.setRedValues(img_reds);
		return img;
	}

	public static SimpleImageHandler solve_img2(SimpleImageHandler img){
		int multiplier = 10;
		int[][] img_reds = img.getRedValues();
		int[][] img_greens = img.getGreenValues();
		int[][] img_blues = img.getBlueValues();
		for(int i = 0; i < img_reds.length; i++){
			for(int j = 0; j < img_reds[0].length; j++){
				img_reds[i][j] *= multiplier;
				img_greens[i][j] *= multiplier;
				img_blues[i][j] *= multiplier;
			}
		}
		img.setRedValues(img_reds);
		img.setGreenValues(img_greens);
		img.setBlueValues(img_blues);
		return img;
	}

	public static SimpleImageHandler solve_img3(SimpleImageHandler img){
		int multiplier = 4;
		int[][] img_reds = img.getRedValues();
		int[][] img_greens = img.getGreenValues();
		int[][] img_blues = img.getBlueValues();
		for(int i = 0; i < img_reds.length; i++){
			for(int j = 0; j < img_reds[0].length; j++){
				img_reds[i][j] = 0;
				img_greens[i][j] *= multiplier;
				img_blues[i][j] = 0;
			}
		}
		img.setRedValues(img_reds);
		img.setGreenValues(img_greens);
		img.setBlueValues(img_blues);
		return img;
	}
}
