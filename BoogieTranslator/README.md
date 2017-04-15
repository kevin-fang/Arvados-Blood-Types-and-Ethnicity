# BOOGIE Translator

Code to translate GFF files into a format that can be read by BOOGIE, a program that predicts a blood type based on a genome.

## How to run

To convert a gff file into a BOOGIE file, navigate to `/BOOGIE Format from GFF/` or `/BOOGIE Format from GZ/`

Run the following command:

`java BOOGIEFormat (gz/gff filename) > (desired output filename)`

Then move the output to the directory that contains BOOGIE, and run BOOGIE on it by calling `java -jar BOOGIE.jar <blood group> <translated file>`

All of this code is available for use in Arvados the following pipeline: http://curover.se/su92l-j7d0g-jd1fzgbhl3nfz3c

The Arvados project containing all the work is available here:
http://curover.se/su92l-j7d0g-jd1fzgbhl3nfz3c

## Where's BOOGIE?

Not included in this repository. Request a copy of BOOGIE from here: http://protein.bio.unipd.it/download/, build a tar and change the Dockerfile `wget` location to the location of your BOOGIE tar.

Note that you cannot build the Docker image without the copy of BOOGIE. BOOGIEFormat.tar only contains BOOGIE. It looks like this:

`BOOGIERun.tar`  
`|── BOOGIERun`  
`|   ├── BOOGIE.jar`  
`|   ├── bloodGroups`  
`|   |   ├── ABO.csvb`

In the Dockerfile, replace `wget --output-document=BOOGIERun.tar "<direct download link to BOOGIE online>" && \`. In addition, the Dockerfile uses the java:8 image, so run `docker pull java:8` before building the Docker image. The BOOGIE Docker image can then be built by navigating to the directory containing the Dockerfile and running: `docker build -t kfang/boogie .`

### Miscellaneous information:

The Dockerfile contained in this directory is a simple installation of Linux that contains Java, and installs the necessary scripts for Arvados to be able to use the Docker image. It downloads BOOGIE, the BOOGIE Translator, compiles the Java, and cleans up after itself.

The misc folder contains miscellaneous files used in the creation of the translator.
