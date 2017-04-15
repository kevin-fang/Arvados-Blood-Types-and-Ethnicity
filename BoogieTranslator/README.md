# BOOGIE Translator

Code to translate GFF files into a format that can be read by BOOGIE, a program that predicts a blood type based on a genome. 

## Where's BOOGIE?

Not included in this repository. Request a copy of BOOGIE from here: http://protein.bio.unipd.it/download/ and copy all the files to this directory

### How to run

To convert a gff file into a BOOGIE file, navigate to `/BOOGIE Format from GFF/` or `/BOOGIE Format from GZ/`

Run the following command: 

`java BOOGIEFormat (gz/gff filename) > (desired output filename)`

Then move the output to the directory that contains BOOGIE, and run BOOGIE on it by calling `java -jar BOOGIE.jar <blood group> <translated file>`

All of this code is available for use in Arvados the following pipeline: http://curover.se/su92l-j7d0g-jd1fzgbhl3nfz3c

The Arvados project containing all the work is available here: 

http://curover.se/su92l-j7d0g-jd1fzgbhl3nfz3c

### Miscellaneous information:

The Dockerfile contained in this directory is a simple installation of Linux that contains Java, and installs the necessary scripts for Arvados to be able to use the docker image. It downloads the Boogie Translator, compiles the Java files, and cleans up after itself.

The misc folder contains miscellaneous files used in the creation of the translator.