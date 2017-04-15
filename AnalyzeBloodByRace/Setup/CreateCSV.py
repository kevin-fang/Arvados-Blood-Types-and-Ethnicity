#!/usr/bin/env python
# -*- coding: utf-8 -*-

# This script reads the blood type from a file and creates an output CSV file that consolidates all the data to one file
# Resultant CSV looks like this:
# Sample/Participant	Blood Type
# HG02654				A

import os
import csv

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
