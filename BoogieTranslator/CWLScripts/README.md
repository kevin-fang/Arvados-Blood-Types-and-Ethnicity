This directory contains CWL scripts used for running BOOGIE on a single compressed (.gz) genome. It contains all the steps of the BOOGIE processing, allowing for a direct output of blood type from a compressed GFF file.

To run the script on Arvados in the cloud:

Make sure you have virtualenv and arvados-cwl-runner installed (see https://doc.arvados.org/user/cwl/cwl-runner.html#setup), as well as the Docker image built from the Dockerfile in `/BoogieTranslator` on Arvados named `kfang/boogie` (or change the dockerPull in the workflow)

1. Activate the virtualenv by running `source ~/venv/bin/activate`

2. Run `arvados-cwl-runner boogie-workflow.cwl --gz_file <genome.gff.gz>`

3. The result will be in an Arvados collection viewable online and will be the output of "parse-results.cwl"

To run locally, make sure that you have the Docker image built and named kfang/boogie on your local machine (or change the dockerPull) and 
use `cwltool` instead of `arvados-cwl-runner`, i.e. `cwltool boogie-workflow.cwl --gz_file <genome.gff.gz>`

* if you run the script locally, the results will be in the directory of boogie-workflow.cwl and the will have an extension of `.parsed`

