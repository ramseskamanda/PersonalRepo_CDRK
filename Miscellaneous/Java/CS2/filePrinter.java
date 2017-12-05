/*
Write a program that asks a user for a file name and prints the number of characters, words,
and lines in that file.
*/

import java.util.*;
import java.io.*;

public class filePrinter{

	public static void AssignmentOne(String file){
		String[] file_read = readFromFile(file);
		int num_lines = file_read.length;
		int num_words = 0;
		int num_characters = 0;
		for(String line: file_read){
			String[] words = line.split(" ", -1);
			num_words += words.length;
			for(String word: words){
				num_characters += word.length();
			}
		}
		System.out.println("Lines: " + num_lines);
		System.out.println("Words: " + num_words);
		System.out.println("Characters: " + num_characters);		
	}

	public static void AssignmentTwo(String[] files, String word){
		String[] text;
		boolean found = false;
		for(String file: files){
			text = readFromFile(file);
			for(String line: text)
				if(line.contains(word)){
					System.out.println(word + " is in " + file + ": " + line);
					found = true;
				}
		}
		if(!found) System.out.println("Word not found.");
	}

	public static String[] readFromFile(String file){
		String[] text_array;
		try{
			FileReader f = new FileReader(file);
			BufferedReader br = new BufferedReader(f);
			String line;
			ArrayList<String> text = new ArrayList<String>();
			System.out.println("File " + file + " contains: ");
			while((line = br.readLine()) != null){
				System.out.println(line);
				text.add(line);
			}
			text_array = text.toArray(new String[0]);
		} catch(IOException e){text_array = new String[]{"FileNotFound"};}
		return text_array;
	}

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//String file = in.nextLine();
		String[] files = new String[args.length - 1];
		for(int i = 0; i < args.length - 1; i++)
			files[i] = args[i+1];
		String word = args[0];
		System.out.println(word);
		//AssignmentOne(file);
		AssignmentTwo(files, word);
	}
}