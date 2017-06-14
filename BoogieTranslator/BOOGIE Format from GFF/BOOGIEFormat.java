import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.HashMap;
import java.util.Arrays;

public class BOOGIEFormat
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);

		// format should be: chr# coord1 coord2 nucleotide1 nucleotide2 hom/het in BOOGIE file
		// preformat is : ch# cgh ref/snp/indel coord1 coord2 . + . alleles g/ref allele
		// if there is a slash, then it is heterozygous
		// if person is het for two things not reference, need to make two lines
		// ignore the first few lines that contain "#" in the beginning
		
		String compare = sc.nextLine();
		while(compare.substring(0, 1).equals("#")) {
			compare = sc.nextLine();
		}

		while (sc.hasNextLine()) {
			compare = sc.nextLine();
			// makes sure that it's only working with mutations
			if(!compare.contains("REF")) {
				// delete irrelevant information
				compare = compare.replaceAll("[.,+,db_xref,dbnsp:]", "");
				compare = compare.replace("ch", "chr");
				compare = compare.replace(" ", "");
				// divide and split sections
				compare = compare.replaceAll("\\s+", ";");
				String[] dataTemp = compare.split(";");

				// assign chromosome number
				String chrNum = dataTemp[0];
				// remove irrelevant text from alleles
				String alleleInfo = dataTemp[5].replace("alll", "");
				// assign zygosity
				String zygosity;
				if (alleleInfo.contains("/")) {
					zygosity = "het";
				} else {
					zygosity = "hom";
				}
				String refallele = "-";

				// assign refallele
				for (int i = 4; i < dataTemp.length; i++) {
					if (dataTemp[i].contains("alll")) {
						refallele = dataTemp[i].replace("alll", "");
					}
				}
				
				// assign coord1 & coord2, fix off bases
				//System.out.println("data: " + Arrays.toString(dataTemp));
				int coord1 = new Integer(dataTemp[3]);
				coord1 -= 1;
				int coord2 = new Integer(dataTemp[4]);
				coord2 -= 1;

				if (coord2 < coord1) {
					coord2 = coord1;
				}

				// assign allele and print out info, filter out homozygous in the process
				if (zygosity.equals("het")) {
					alleleInfo = alleleInfo.replace(refallele, "");
					alleleInfo = alleleInfo.replace("/", "");
					// String[] hetAlleles = alleleInfo.split("/");
				}
				String allele = alleleInfo;

				// create string to print out and remove carriage return
				String add = (chrNum + " " + coord1 + " " + coord2 + " "
					+ refallele + " " + allele + " " + zygosity + "\n");
				add = add.replaceAll("\\r", "");
				System.out.print(add);			
			}
		}
		sc.close();
	}
}
