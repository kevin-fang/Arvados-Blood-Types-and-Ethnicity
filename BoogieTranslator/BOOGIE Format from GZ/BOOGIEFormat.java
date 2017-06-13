import java.io.*;
import java.lang.String;
import java.util.zip.GZIPInputStream;
import java.util.HashMap;

public class BOOGIEFormat
{
	public static void main(String[] args) throws IOException {

		GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(args[0]));
		BufferedReader br = new BufferedReader(new InputStreamReader(gzip));
		final long startTime = System.currentTimeMillis();

		// format should be: chr# coord1 coord2 nucleotide1 nucleotide2 hom/het in BOOGIE file
		// preformat is : ch# cgh ref/snp/indel coord1 coord2 . + . alleles g/ref allele
		// if there is a slash, then it is heterozygous
		// if person is het for two things not reference, need to make two lines
		// ignore the first few lines that contain "#" in the beginning

		String compare = br.readLine();
		while(compare.substring(0, 1).equals("#")) {
			compare = br.readLine();
		}
		while (compare != null) {
			HashMap<String, String> data = new HashMap<String, String>();
			// makes sure that it's only working with mutations
			if(!compare.contains("REF")) {
				// delete irrelevant information
				compare = compare.replaceAll("[.,+,db_xref,dbnsp:]", "");
				compare = compare.replace("CGI", "");
				compare = compare.replace("ch", "chr");
				compare = compare.replace(" ", "");
				// divide and split sections
				compare = compare.replaceAll("\\s+", ";");
				String[] dataTemp = compare.split(";");

				// assign chromosome number
				data.put("chr#", dataTemp[0]);
				// remove irrelevant text from alleles
				String alleleInfo = dataTemp[4].replace("alll", "");
				// assign zygosity
				if (alleleInfo.contains("/")) {
					data.put("zygosity", "het");
				} else {
					data.put("zygosity", "hom");
				}

				// assign refallele
				for (int i = 4; i < dataTemp.length; i++) {
					if (dataTemp[i].contains("alll")) {
					data.put("refallele", dataTemp[i].replace("alll", ""));
					}
				}

				// assign coord1 & coord2, fix off bases
				int coord1Loc = new Integer(dataTemp[2]);
				coord1Loc -= 1;
				data.put("coord1", Integer.toString(coord1Loc));
				int coord2Loc = new Integer(dataTemp[3]);
				coord2Loc -= 1;
				data.put("coord2", Integer.toString(coord2Loc));

				if (coord2Loc < coord1Loc) {
					data.put("coord2", Integer.toString(coord1Loc));
				}

				// assign allele and print out info, filter out homozygous in the process
				if (data.get("zygosity").equals("het")) {
					alleleInfo = alleleInfo.replace(data.get("refallele"), "");
					alleleInfo = alleleInfo.replace("/", "");
					// String[] hetAlleles = alleleInfo.split("/");
				}
				data.put("allele", alleleInfo);

				// create string to print out and remove carriage return
				String add = (data.get("chr#") + " " + data.get("coord1") + " " + data.get("coord2") + " "
					+ data.get("refallele") + " " + data.get("allele") + " " + data.get("zygosity") + "\n");
				add = add.replaceAll("\\r", "");
				System.out.print(add);
			}
			compare = br.readLine();
			}
		final long endTime = System.currentTimeMillis();
		br.close();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
}
