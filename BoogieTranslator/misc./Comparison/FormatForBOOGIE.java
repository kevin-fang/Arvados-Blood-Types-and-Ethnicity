import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.HashMap;

public class FormatForBOOGIE
{
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);

		// format should be: chr# coord1 coord2 nucleotide1 nucleotide2 hom/het in BOOGIE file
		// preformat is : ch# cgh ref/snp/indel coord1 coord2 . + . alleles g/ref allele
		// if there is a slash, then it is heterozygous
		// if person is het for two things not reference, need to make two lines

		String compare = new String();
		while (sc.hasNextLine()) {
			HashMap<String, String> data = new HashMap<String, String>();
			compare = sc.nextLine();
			compare = compare.replaceAll("[.,+,db_xref,dbnsp:]", "");
			compare = compare.replace("CGI", "");
			compare = compare.replace("ch", "chr");
			compare = compare.replace(" ", "");
			compare = compare.replaceAll("\\s+", ";");
			String[] dataTemp = compare.split(";");
			data.put("chr#", dataTemp[0]);			
			data.put("coord2", dataTemp[3]);
			String alleleInfo = dataTemp[4].replace("alll", "");

			// assign zygosity
			if (alleleInfo.contains("/")) {
				data.put("zygosity", "het");
			} else {
				data.put("zygosity", "hom");
			}

			// fix coordinates
			System.out.println(dataTemp[2]);
			int chromNum = new Integer(dataTemp[2]);
			chromNum -= 1;
			data.put("coord1", Integer.toString(chromNum));

			// assign refallele
			for (int i = 4; i < dataTemp.length; i++) {
				if (dataTemp[i].contains("alll")) {
				data.put("refallele", dataTemp[i].replace("alll", ""));
				}
			}

			// assign allele and print out info
			if (data.get("zygosity").equals("het")) {
				alleleInfo = alleleInfo.replace(data.get("refallele"), "");
				alleleInfo = alleleInfo.replace("/", "");
				data.put("allele", alleleInfo);
				String add = (data.get("chr#") + " " + data.get("coord1") + " " + data.get("coord2") + " " 
					+ data.get("refallele") + " " + data.get("allele") + " " + data.get("zygosity") + "\n");
				add = add.replaceAll("\\r", "");
				if (data.get("chr#").equals("chr1") || data.get("chr#").equals("chr2") || data.get("chr#").equals("chr4") || data.get("chr#").equals("chr6") || 
					data.get("chr#").equals("chr7") || data.get("chr#").equals("chr9") || data.get("chr#").equals("chr11") || data.get("chr#").equals("chr12") || 
					data.get("chr#").equals("chr15") || data.get("chr#").equals("chr17") || data.get("chr#").equals("chr18") || data.get("chr#").equals("chr19") || 
					data.get("chr#").equals("chr22") || data.get("chr#").equals("chrx")) {
						System.out.print(add);
				}
			}
		}
		sc.close();
	}
}

