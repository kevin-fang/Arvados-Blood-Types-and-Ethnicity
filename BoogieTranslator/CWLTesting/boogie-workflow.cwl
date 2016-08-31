cwlVersion: v1.0
class: Workflow
requirements:
 InlineJavascriptRequirement: {}

inputs:
 inp: File
 ex: File

outputs:
 classout:
  type: File
  outputSource: parse-results/parsed.txt

steps:
 format:
  run: translate.cwl
  in:
   gz-file: inp
   extractfile: ex
  out: [boogie_out]

