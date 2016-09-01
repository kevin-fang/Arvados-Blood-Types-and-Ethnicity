#!/usr/bin/env python
# -*- coding: utf-8 -*-

# This application compares the blood types found through the GFF and the blood types found through the PGP website. To use, drop in the genomes folder and type "python

import os
import csv

# search CSV file for name and return blood type for respective name
def searchCSV(name):
	# replace open(...) with open(location of blood csv)
	with open("../phenotypes-basic2015.csv") as csvFile:
		reader = csv.DictReader(csvFile)
		for row in reader:
			#print row["Participant"] + " " + row["1.1 \xe2\x80\x94 Blood Type"]
			if row["Participant"] == name:
				try:
					bloodType = row["1.1 \xe2\x80\x94 Blood Type"][0]
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
for filename in os.listdir("."):
	if filename.startswith("hu"):
		person = open(filename)
		csvSearch = searchCSV(filename)
		if csvSearch != None:
			personBlood = person.read().rstrip()
			if (csvSearch == personBlood):
				correct += 1
        			print ("CORRECT - csv: " + csvSearch + " " + "person: " + personBlood)
			else: 
				wrong += 1	
	        		print ("INCORRECT - csv: " + csvSearch + " " + "person: " + personBlood +  ", genome: " + filename)
