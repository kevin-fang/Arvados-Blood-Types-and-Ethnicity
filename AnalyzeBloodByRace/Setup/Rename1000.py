import os

for filename in os.listdir("."):
    if filename.startswith("data"):
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
