import java.io.*;
import java.lang.String;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ParseBoogie
{
	public static void main(String[] args) throws IOException {
		File io = new File(args[0]);
		Scanner sc = new Scanner(io);
		ArrayList<String> guesses = new ArrayList<String>();

		String compare = sc.nextLine();

		while (sc.hasNextLine()) {
			try {
				if (compare.substring(0, 9).equals("Chromatid")) {
					guesses.add(mostCommonOccurence(returnTypes(removeExtra(compare))));
				}
				compare = sc.nextLine();
			} catch (StringIndexOutOfBoundsException e) {
				compare = sc.nextLine();
			}
		}

		int aCount = 0;
		int bCount = 0;
		int oCount = 0;
		for (String type : guesses) {
			if (type.equals("A")) {
				aCount++;
			} else if (type.equals("B")) {
				bCount++;
			} else {
				oCount++;
			}
		}

		//System.out.print("Blood type is: ");
		if (aCount > bCount) {
			System.out.println("A");
		} else if (bCount > aCount) {
			System.out.println("B");
		} else if (aCount == bCount && aCount != 0) {
			System.out.println("AB");
		} else {
			System.out.println("O");
		}
	}

	private static String removeExtra(String toParse) {
		return toParse.substring(18, toParse.length() - 1);
	}

	private static String[] returnTypes(String line) {
		String[] types = line.split(" or ");
		for (int i = 0; i < types.length; i++) {
			types[i] = types[i].substring(0, 1);
		}

		return types;
	}

	public static String mostCommonOccurence(String[] readList) {
		int maxCounts = 0;
		int aCounts;
		int bCounts;
		int oCounts;

		List<String> list = Arrays.asList(readList);

		aCounts = Collections.frequency(list, "A");
		bCounts = Collections.frequency(list, "B");
		oCounts = Collections.frequency(list, "O");

		if (aCounts > bCounts) {
			return "A";
		} else if (bCounts > aCounts) {
			return "B";
		} else {
			return "0";
		}
	}
}
