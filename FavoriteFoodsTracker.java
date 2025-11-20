import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 Dashira Fletcher
 */
/**
 This program lists favorite foods from a text file. 
 */
public class FavoriteFoodsTracker 
{
	public static void main(String[] arg) throws FileNotFoundException
	{
		Scanner in = new Scanner(System.in);
		ArrayList<String> foods = read_foods("foods.txt");
		
		print_foods(foods);
		
		String response;
		System.out.print("Enter a food to count: ");
		response = in.next();
		
		count_occurrence(response, foods);
		reversed_order(foods);
		in.close();
	}
	/**
	 Reads in foods from the text file.
	 @param file_name name of the text file
	 @return ArrayList named foods
	 */
	public static ArrayList<String> read_foods(String file_name) throws FileNotFoundException
	{
		File input_file = new File("foods.txt");
		Scanner input = new Scanner(input_file);
		ArrayList<String> foods = new ArrayList<String>();
		
		while (input.hasNextLine())
		{
			String food_item = input.nextLine();
			foods.add(food_item);
		}
		input.close();
		return foods;
	}
	/**
	 Counts the number of items in the passed through the ArrayList and prints its contents. 
	 * @param data ArrayList whose contents are counted and printed.
	 */
	public static void print_foods(ArrayList<String> data)
	{
		System.out.println("Total items: " + data.size());
		System.out.println("Foods:");
		
		for (String element : data)
		{
			System.out.println(element);
		}
	}
	/**
	 Counts the occurrence of a food in the list  
	 * @param answer user's response for what they want to count
	 * @param items items in the ArrayList that are analyzed to be counted.
	 */
	public static void count_occurrence(String answer, ArrayList<String> items)
	{
		int count = 0;
		
		for (String element : items)
		{
			if(element.equals(answer))
			{
				count++;
			}
		}
		System.out.println(answer + " appears " + count + " times.");
	}
	/**
	 Reverses the order of the contents of the ArrayList.
	 * @param content contents of the ArrayList.
	 * @return the reversed order of the initial ArrayList.
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<String> reversed_order(ArrayList<String> content) throws FileNotFoundException
	{
		ArrayList<String> items = new ArrayList<String>();
		
		for (int index = content.size() - 1; index >= 0; index--)
		{
			items.add(content.get(index));
		}
		System.out.println("Foods in reverse:");
		PrintWriter output_file = new PrintWriter("reversed_foods.txt");
		
		for (String component : items)
		{
			output_file.println(component);
			System.out.println(component);
		}
		output_file.close();
		return items;
	}
}