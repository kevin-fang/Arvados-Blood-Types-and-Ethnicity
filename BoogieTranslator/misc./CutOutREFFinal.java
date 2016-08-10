import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class CutOutREFFinal
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		String compare = new String();
		
		// ignore the first lines starting with '#'
		try {
			while (compare.substring(0, 1).equals("#")) {
				compare = sc.nextLine();
			}
		} catch (StringIndexOutOfBoundsException e) {
		}

		while (sc.hasNextLine()) {
			compare = sc.nextLine();
			if(!compare.contains("REF")) {
				System.out.println(compare);
			}
		}
		sc.close();
	}
}