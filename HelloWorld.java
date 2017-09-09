public class HelloWorld{
	public static void main(String[] args) {
		String ascii_art = ""
        String invalidCharReplaced = ascii_art.replaceAll("[\\\\/:*?\"<>|]", "#");
		System.out.print(invalidCharReplaced);
	}
}