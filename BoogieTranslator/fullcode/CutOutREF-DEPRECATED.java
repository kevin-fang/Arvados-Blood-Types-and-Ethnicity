import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class CutOutREF
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		String compare = sc.nextLine();
		while(compare.substring(0, 1).equals("#")) {
			compare = sc.nextLine();
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