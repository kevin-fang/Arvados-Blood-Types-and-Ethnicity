#!/usr/bin/env python
# -*- coding: utf-8 -*-

# This application compares the blood types found through the GFF and the blood types found through the PGP website.

import os
import csv


# dictionary containing the race and associated blood type data
raceDict = {}
#for every person found, search in PGP and compare

with open('outputBlood.csv', 'wb') as csvfile:
	writer = csv.writer(csvfile, dialect='excel')
	writer.writerow(["Sample/Participant"] + ["Blood Type"])
	for filename in os.listdir("."):
		if filename.startswith("hu") or filename.startswith("HG") or filename.startswith("NA"):	
			person = open(filename)
			blood = person.read()
			if blood != None:
				writer.writerow([filename] + [blood.rstrip()])
