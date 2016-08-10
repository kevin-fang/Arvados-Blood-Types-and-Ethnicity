# BOOGIE Translator

Code to translate TSV and GFF files into what can be read by BOOGIE, a program that generates a "guess" of a blood type based on a genome. 

## Where's BOOGIE?

It's not included in this repository. Just request a copy of BOOGIE from here: http://protein.bio.unipd.it/download/ and copy all the files to this directory

### How to run

To convert a gff file into a BOOGIE file, navigate to `fullcode\` 

To directly convert a gzipped gff file to BOOGIE, navigate to  `fullcodefromgz\`

Run the following command: 

`java BOOGIEFormat (gz/gff filename) > (desired output filename)`

Then move the output to the directory that contains BOOGIE, and run BOOGIE on it.

All of this code is available for use in Arvados the following pipeline: http://curover.se/su92l-j7d0g-jd1fzgbhl3nfz3c

### Miscellaneous information:

The Dockerfile contained in this directory is a simple installation of Linux that contains Java, and installs the necessary scripts for Arvados to be able to use the docker image. It downloads the Boogie Translator, compiles the Java files, and cleans up after itself.

The misc. folder contains old files used in the creation of the translator.
