cwlVersion: v1.0
class: CommandLineTool
requirements:
 InlineJavascriptRequirement: {}
hints:
 DockerRequirement:
  dockerPull: kfang/boogienew
stdout: $(inputs.results_file.nameroot + '.parsed')
baseCommand: ["java", "-cp",  "/BOOGIERun/", "ParseBoogie"]
inputs:
 results_file:
  type: File
  inputBinding:
   position: 1
outputs:
 parsed_file:
  type: stdout
#  type: File
#  outputBinding:
#   glob: "$(inputs.gz_file.nameroot + '.bg')"
