# Using Arvados to Analyze Blood Types and Race

This GitHub repo contains the code used to read a blood type from a genome and the python scripts for checking accuracy and comparing it with race data. It does not contain BOOGIE, the Java program used to guess the blood type, only the translator.

`/AnalyzeBloodByRace` contains python scripts that were used to analyze processed blood types and compare them to a csv file downloaded from the Personal Genome Project and the 1000 Genomes Project

`/BoogieTranslator` contains a Dockerfile and the Java programs used to translate the GFF files from the Curoverse Paper "Tiling the genome into consistently named subsequences enables precision medicine and machine learning with millions of complex individual data-sets". It also may contain some sample genomes and data that were used in the creation of the translator.
