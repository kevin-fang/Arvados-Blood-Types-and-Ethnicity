cwlVersion: v1.0
class: CommandLineTool
hints:
 DockerRequirement:
  dockerPull: kfang/boogienew
stdout: "output.txt"
baseCommand: ["java", "-cp",  "/BOOGIERun/", "BOOGIEFormat"]
inputs:
 gz-file:
  type: File
  inputBinding:
   position: 1
outputs:
 boogie-file:
  type: File
  outputBinding:
   glob: "output.txt"
