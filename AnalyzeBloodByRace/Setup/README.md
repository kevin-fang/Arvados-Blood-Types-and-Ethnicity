#Setup

`AnalyzeForCorrectness.py` checks the results output by Arvados and compares it to the data in the CSV file to output a percentage of accuracy. This was written only for the Harvard PGP, because the 1000 Genomes Project does not provide blood types

`CutOutExtra1000.py` and `CutOutExtraPGP.py` cut out the "Blood type is: " from the "arvadosdirect" files. Works in respective folders with correct scripts

`Rename*.py` renames the output from the long name to just the name of the user's genome. Works in both respective folders with correct scripts

`CreateCSV.py` creates a CSV file containing all the participants and their blood types
