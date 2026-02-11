FROM ubuntu:latest
LABEL authors="jarod"

ENTRYPOINT ["top", "-b"]