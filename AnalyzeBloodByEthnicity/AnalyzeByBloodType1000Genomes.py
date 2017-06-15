#!/usr/bin/env python
# -*- coding: utf-8 -*-

# This script reads all the blood types from the 433-1000Genomes folder and all the ethnicities from CSVFiles/1000genomesethnicities.csv and prints a formatted table to the standard output.

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
	with open("CSVFiles/1000genomesethnicities.csv") as csvFile:
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
#for every person found, search in PGP and compare
genomesProjectDirectory = "./433-1000Genomes/"

for filename in os.listdir(genomesProjectDirectory):
	if filename.startswith("HG") or filename.startswith("NA"):
		person = open(genomesProjectDirectory + filename)
		race = searchCSVForRace(filename) # this is the race of the person
		blood = person.read().rstrip()
		if blood != None and race != None and race != "None":
			#print repr(blood)
			try:
				if blood == "A":
					raceDict[race].incrementA()
				elif blood == "B":
					raceDict[race].incrementB()
				elif blood == "O":
					raceDict[race].incrementO()
				elif blood == "AB":
					raceDict[race].incrementAB()
			except:
				raceDict[race] = BloodStorage()
				if blood == "A":
					raceDict[race].incrementA()
				elif blood == "B":
					raceDict[race].incrementB()
				elif blood == "O":
					raceDict[race].incrementO()
				elif blood == "AB":
					raceDict[race].incrementAB()
for race in raceDict:
	print race + ":\n" + str(raceDict[race])
