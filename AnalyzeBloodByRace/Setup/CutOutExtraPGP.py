import os

for filename in os.listdir("."):
    if filename.startswith("hu"):
        txt = open(filename, "r")
	stringToReplace = txt.read()
	stringToReplace = stringToReplace.replace("Blood type is: ", "")
	write = open(filename, "w")
        write.write(stringToReplace)
