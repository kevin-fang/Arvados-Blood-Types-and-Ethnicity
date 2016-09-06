This directory contains CWL scripts used for running BOOGIE on a single compressed (.gz) genome. It contains all the steps, from unzipping to translation to parsing.

To run on Arvados:

Make sure you have virtualenv and arvados-cwl-runner installed, as well as the Docker image built from the Dockerfile in `/BoogieTranslator` on Arvados named kfang/boogie (or change the DockerPull in the workflow)

1. Activate the virtualenv by running `source ~/venv/bin/activate`

2. Run `arvados-cwl-runner --local boogie-workflow.cwl --gz_file <genome.gz>`

3. The results will be in an Arvados collection viewable online and will be the "output of parse-results.cwl"

To run locally, make sure that you have the Docker image built and named kfang/boogie on your local machine (or change the DockerPull) and 
use `cwltool` instead of `arvados-cwl-runner`

* if you run the script locally, the results will be in the directory of boogie-workflow.cwl and the results will have an extension of `.parsed`

