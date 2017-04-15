# Kevin Fang, 2016
# Strips extra title information from filename; works for both PGP and 1000 Genomes

import os

# loop through every file in the directory and rename if needed
for filename in os.listdir("."):
    if filename.startswith("hu"): # genome is from the Personal Genome Project
        os.rename(filename, filename[0:8])

    elif filename.startswith("data"): # genome is from the 1000 Genomes Project
        firstAppearance = 0;
        secondAppearance = 0;
        count = 0
        firstAlready = False;
        for letter in filename:
            if letter == "_" and firstAlready == False:
                firstAppearance = count
                firstAlready = True
            elif letter == "_" and firstAlready == True and secondAppearance == 0:
                secondAppearance = count
            count += 1
        os.rename(filename, filename[firstAppearance + 1:secondAppearance])
