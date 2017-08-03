# Blood Type Analysis by Ethnicity with Arvados

Created by Kevin Fang at Curoverse in 2016.   
This GitHub repo contains the code used to read a blood type from a genome in compressed or uncompressed GFF form and the python scripts for checking accuracy and comparing it with ethnicity data provided in surveys from the Personal Genome Project and the 1000 Genome Project. It does not contain BOOGIE, the Java program used to guess the blood type, only the translator.

`/AnalyzeBloodByEthnicity/` contains python scripts that were used to analyze processed blood types as well as CSV files, so the data can be compared with survey data from the Personal Genome Project and the 1000 Genomes Project

`/BoogieTranslator/` contains a Dockerfile and the Java programs used to translate the GFF files from the Curoverse Paper "Tiling the genome into consistently named subsequences enables precision medicine and machine learning with millions of complex individual data-sets". It also may contain some sample genomes and data that were used in the creation of the translator.
