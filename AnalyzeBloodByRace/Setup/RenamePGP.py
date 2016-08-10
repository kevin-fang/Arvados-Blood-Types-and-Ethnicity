import os

for filename in os.listdir("."):
    if filename.startswith("hu"):
        os.rename(filename, filename[0:8])
