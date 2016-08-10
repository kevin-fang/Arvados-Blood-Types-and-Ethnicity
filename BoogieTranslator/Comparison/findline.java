import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class findline
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		String compare = new String();
		for (int i = 0; i < 20; i++) sc.nextLine();
		while (sc.hasNextLine()) {
			compare = sc.nextLine();
			String dataTemp[] = compare.split("\\s+");
			if (dataTemp[2].equals("19126625")) {
				System.out.println(compare);
				break;
			}
		}
	}
}
