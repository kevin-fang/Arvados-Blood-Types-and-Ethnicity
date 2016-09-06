cwlVersion: v1.0
class: CommandLineTool
requirements:
 InlineJavascriptRequirement: {}
hints:
 DockerRequirement:
  dockerPull: kfang/boogie
stdout: $(inputs.gz_file.nameroot + '.bg')
baseCommand: ["java", "-cp",  "/BOOGIERun/", "BOOGIEFormat"]
inputs:
 gz_file:
  type: File
  inputBinding:
   position: 1
outputs:
 boogie_file:
  type: stdout
#  type: File
#  outputBinding:
#   glob: "$(inputs.gz_file.nameroot + '.bg')"
