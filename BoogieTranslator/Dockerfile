FROM java:8

RUN apt-get update && \
    apt-get upgrade && \
    echo Updated && \
    apt-get install libcurl4-openssl-dev -y && \
    apt-get install libssl-dev -y && \
    apt-get install python-pip python-dev build-essential -y && \
    pip install --upgrade pip && \
    pip install --upgrade virtualenv && \
    python2.7 -m pip install arvados-python-client && \
    wget "bit.ly/1YojA7J" && \
    tar -xvf 1YojA7J && \
    cd BOOGIERun && javac BOOGIEFormat.java && rm BOOGIEFormat.java && javac ParseBoogie.java && rm ParseBoogie.java

RUN rm 1YojA7J
