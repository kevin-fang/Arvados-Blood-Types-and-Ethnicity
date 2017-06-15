#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Reads from CSVFiles/phenotypes-basic2015.csv and the BOOGIE guesses and prints the percentage of correct guesses.

import os
import csv

# search CSV file for name and return blood type for respective name
def searchCSV(name):
	# replace open(...) with open(location of blood csv)
	with open("./CSVFiles/phenotypes-basic2015.csv") as csvFile:
		reader = csv.DictReader(csvFile)
		for row in reader:
			if row["Participant"] == name:
				try:
					bloodType = row["Blood Type"][0]
					if (bloodType != "D"):
						csvFile.close()
						return bloodType
				except:
					pass
	csvFile.close()
	return None

#used for calculations
correct = 0.00
wrong = 0.00

#for every person found, search in PGP and compare
pgpDirectory = "./173-HarvardPGP/"
for filename in os.listdir(pgpDirectory):
	if filename.startswith("hu"):
		person = open(pgpDirectory + filename)
		csvSearch = searchCSV(filename)
		if csvSearch != None:
			personBlood = person.read().rstrip()
			if (csvSearch == personBlood):
				correct += 1
			else:
				wrong += 1

print "################################"
print "#           RESULTS            #"
print "#             OF               #"
print "#          ANALYSIS            #"
print "################################"

print "Correct: " + str(int(correct))
print "Incorrect: " + str(int(wrong))
print "Total Tested: " + str(int(correct + wrong))

print "Accuracy: " + str(correct / (correct + wrong))
