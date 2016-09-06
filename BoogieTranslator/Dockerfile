FROM java:8

RUN apt-get update && \
    apt-get upgrade -y && \ 
    echo Finished updating! Now installing Python Arvados API && \
    apt-get install libcurl4-openssl-dev -y && \
    apt-get install libssl-dev -y && \
    apt-get install python-pip python-dev build-essential -y && \
    pip install --upgrade pip && \
    pip install --upgrade virtualenv && \
    python2.7 -m pip install arvados-cwl-runner && \
    python2.7 -m pip install arvados-python-client && \
    echo Finished installing Python Arvados API - now downloading BOOGIE Docker file && \
    wget "https://github.com/kfang1233/Using-Arvados-to-Analyze-Blood-Types-and-Race/raw/master/BoogieTranslator/BOOGIERun.tar" && \
    tar -xvf BOOGIERun.tar && \
    cd BOOGIERun && javac BOOGIEFormat.java && rm BOOGIEFormat.java && javac ParseBoogie.java && rm ParseBoogie.java

RUN rm BOOGIERun.tar
