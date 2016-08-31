cwlVersion: v1.0
class: CommandLineTool
hints:
 DockerRequirement:
  dockerPull: kfang/boogienew
stdout: "output.txt"
baseCommand: ["java", "BOOGIERun/BOOGIEFormat"]
inputs:
 gz-file:
  type: File
outputs:
 boogie-file:
  type: File
  outputBinding:
   glob: "output.txt"
