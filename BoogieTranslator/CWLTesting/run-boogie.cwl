cwlVersion: v1.0
class: CommandLineTool
requirements:
 InlineJavascriptRequirement: {}
hints:
 DockerRequirement:
  dockerPull: kfang/boogie
stdout: $(inputs.boogie_file.nameroot + '.res')
baseCommand: ["java", "-jar", "/BOOGIERun/BOOGIE.jar", "/BOOGIERun/bloodGroups/ABO.csvb"]
inputs:
 boogie_file:
  type: File
  inputBinding:
   position: 1
outputs:
 results_file:
  type: stdout
