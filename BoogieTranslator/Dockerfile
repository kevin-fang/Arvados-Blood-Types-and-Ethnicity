FROM java:8

RUN apt-get update && \
    apt-get upgrade -y && \
    echo "Finished updating! Now installing Python Arvados API" && \
    apt-get install libcurl4-openssl-dev -y && \
    apt-get install libssl-dev -y && \
    apt-get install python-pip python-dev build-essential -y && \
    pip install --upgrade pip && \
    pip install --upgrade virtualenv && \
    python2.7 -m pip install arvados-cwl-runner && \
    python2.7 -m pip install arvados-python-client && \
    echo "Finished installing Python Arvados API - now downloading BOOGIE Docker file"

RUN wget --output-document=BOOGIERun.tar "https://github.com/kevin-fang/Arvados-Blood-Types-and-Ethnicity/raw/master/BoogieTranslator/BOOGIERun.tar" && \
    tar -xvf BOOGIERun.tar && \
    cd BOOGIERun && \
    wget "https://raw.githubusercontent.com/kevin-fang/Arvados-Blood-Types-and-Ethnicity/master/BoogieTranslator/ParseBoogie.java" && \
    wget "https://raw.githubusercontent.com/kevin-fang/Arvados-Blood-Types-and-Ethnicity/master/BoogieTranslator/BOOGIE%20Format%20from%20GZ/BOOGIEFormat.java" && \
    javac BOOGIEFormat.java && rm BOOGIEFormat.java && javac ParseBoogie.java && rm ParseBoogie.java

RUN rm BOOGIERun.tar
