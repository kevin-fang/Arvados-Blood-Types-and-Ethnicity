import java.io.*;
import java.lang.String;
import java.util.Scanner;

// tool: searches for each instance of a string and prints out the line along with its execution time - used for testing BOOGIE Formatter

public class FindLine
{
	public static void main(String[] args) throws IOException {
		long l = System.nanoTime();
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String compare = sc.nextLine();
			if (compare.contains(args[1])) {
				System.out.println(compare);
				System.out.println("Execution time: " + ((System.nanoTime() - l) / 1000000) + "ms");
			}
		}
		System.out.println("Done");
		System.out.println("Execution time: " + ((System.nanoTime() - l) / 1000000) + "ms");
	}
}
