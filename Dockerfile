FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080

ENTRYPOINT ["top", "-b"]