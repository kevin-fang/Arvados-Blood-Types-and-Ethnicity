package com.curoverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // preformat is: chrom# pos id ref alt qual filter info format
        // postformat is: chrom# coord1 coord2 nucleotide1 nnucleotide2 hom/het
	    File f = new File(args[0]);
	    Scanner sc;
	    try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return;
        }

	    String compare = sc.nextLine();
	    while (compare.substring(0, 1).equals("#")) {
	        compare = sc.nextLine();
        }

        int counter = 0;
        while (sc.hasNextLine() && counter < 20) {
	        compare = sc.nextLine();
	        String[] dataVals = compare.split("\t");
	        System.out.println(Arrays.toString(dataVals));
	        counter++;
        }
    }
}
