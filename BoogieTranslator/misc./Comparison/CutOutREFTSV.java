import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class CutOutREFTSV
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		String compare = new String();
		
		// ignore the first two lines
		for (int i = 0; i < 13; i++) {
			sc.nextLine();
		}

		while (sc.hasNextLine()) {
			compare = sc.nextLine();
			if(!compare.contains("ref") && !compare.contains("no-call")) {
				System.out.println(compare);
			}
		}
		sc.close();
	}
}
