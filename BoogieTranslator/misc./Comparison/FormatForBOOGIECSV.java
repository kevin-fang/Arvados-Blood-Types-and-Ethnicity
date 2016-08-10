import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.HashMap;
import java.util.Arrays;

public class FormatForBOOGIECSV
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);

		// postformat should be: chr# coord1 coord2 nucleotide1 nucleotide2 hom/het in BOOGIE file
		// preformat is : locus ploidy allele chromosome begin end vartype reference alleleseq varscorevaf varscoreeaf varquality haplink xref
		// if there is a slash, then it is heterozygous
		// if person is het for two things not reference, need to make two lines

		String compare = new String();
		while (sc.hasNextLine()) {
			HashMap<String, String> data = new HashMap<String, String>();
			compare = sc.nextLine();
			String dataTemp[] = compare.split("\\s+");
			data.put("chr#", dataTemp[3]);
			data.put("coord1", dataTemp[4]);
			data.put("coord2", dataTemp[5]);
			data.put("refallele", dataTemp[7]);
			data.put("allele", dataTemp[8]);
			data.put("zygosity", "het");
			
			if (dataTemp[6].equals("ins")) {
				data.put("allele", data.get("refallele"));
				data.put("refallele", "-");
			} else if (dataTemp[6].equals("del")) {
				data.put("allele", "-");
			}

			// assign allele and print out info
			if (data.get("zygosity").equals("het")) {
				String add = (data.get("chr#") + " " + data.get("coord1") + " " + data.get("coord2") + " " 
						+ data.get("refallele") + " " + data.get("allele") + " " + data.get("zygosity") + "\n");
				add = add.replaceAll("\\r", "");
			System.out.print(add);				
			}
		}
		sc.close();
	}
}

