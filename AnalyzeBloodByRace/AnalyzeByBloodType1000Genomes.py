#!/usr/bin/env python
# -*- coding: utf-8 -*-

# This application compares the blood types found through the GFF and the blood types found through the PGP website.

import os
import csv

class BloodStorage:
	#bloodTypes: [A, B, O, AB]
	def __init__(self):
		self.bloodTypes = [0, 0, 0, 0]
	def __str__(self):
		return "" + str(self.bloodTypes[0]) + "\t" + str(self.bloodTypes[1]) + "\t" + str(self.bloodTypes[2]) + "\t" + str(self.bloodTypes[3])
	def incrementA(self): 
		self.bloodTypes[0] += 1;
	def incrementB(self): 
		self.bloodTypes[1] += 1;
	def incrementAB(self): 	
		self.bloodTypes[2] += 1;
	def incrementO(self): 
		self.bloodTypes[3] += 1;

# search CSV file for name and return blood type for respective name
def searchCSVForRace(name):
	with open("../1000genomesethnicities.csv") as csvFile:
		reader = csv.DictReader(csvFile)
		for row in reader:
			if row["Sample"] == name:
				try:
					race = row["Population Description"]
					if race != "No response" and race != "":
						csvFile.close()
						return race
				except: 
					csvFile.close()
					return None
	csvFile.close()
	return None

# dictionary containing the race and associated blood type data
raceDict = {}
count = 0
#for every person found, search in PGP and compare
for filename in os.listdir("."):
	if filename.startswith("HG") or filename.startswith("NA"):
		person = open(filename)
		race = searchCSVForRace(filename) # this is the race of the person
		blood = person.read()
		if race != None and blood != None:
			count += 1
			try:
				if blood == "A\n":
					raceDict[race].incrementA()
				elif blood == "B\n": 
					raceDict[race].incrementB()
				elif blood == "O\n": 
					raceDict[race].incrementO()
				elif blood == "AB\n": 
					raceDict[race].incrementAB()
			except:
				raceDict[race] = BloodStorage()
				if blood == "A\n":
					raceDict[race].incrementA()
				elif blood == "B\n": 
					raceDict[race].incrementB()
				elif blood == "O\n": 
					raceDict[race].incrementO()
				elif blood == "AB\n": 
					raceDict[race].incrementAB()

for race in raceDict:
	print race + ":\t" + str(raceDict[race])

print count
