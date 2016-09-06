This directory contains CWL scripts used for running BOOGIE on compress (.gz) genomes.

To run:

Make sure you have virtualenv and arvados-cwl-runner installed, as well as the kfang/boogie Docker image built from the Dockerfile in `/BoogieTranslator`

1. Activate the virtualenv by running `source /venv/bin/activate`

2. Run `arvados-cwl-runner boogie-workflow.cwl --gz-file <genome.gz>`

3. The results will be in an Arvados collection viewable online.
