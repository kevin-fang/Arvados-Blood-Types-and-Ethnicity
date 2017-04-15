#Setup

`AnalyzeForCorrectness-PGP.py` checks the results output by Arvados and compares it to the data in the PGP CSV file to output a percentage of accuracy. This was written only for the Harvard PGP, because the 1000 Genomes Project does not provide blood types in the surveys.

`StripExtraTitleInfo.py` renames the output from the long name from the pipeline such as to just the name of the user's genome. For example, it would rename  "hu123456.gffBloodTypeparsed.txt" to "hu12345678." It is needed to cut out extra text from the file name and needs to be run before running the analysis scripts. Works for both 173 PGP genome files and the 433 1000 Genomes Project genome files.

`CreateCSV.py` creates a CSV file containing all the participants and their blood types
