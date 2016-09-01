cwlVersion: v1.0
class: Workflow
requirements:
 InlineJavascriptRequirement: {}
 DockerRequirement:
  dockerPull: kfang/boogienew

inputs:
 gz_file:
  type: File

outputs:
 parsed_file:
  type: File
  outputSource: parse/parsed_file

steps:
 format:
  run: translate.cwl
  in:
   gz_file: gz_file
  out: [boogie_file]
 boogie:
  run: run-boogie.cwl
  in:
   boogie_file: format/boogie_file
  out: [results_file]
 parse:
  run: parse-results.cwl
  in:
   results_file: boogie/results_file
  out: [parsed_file]
