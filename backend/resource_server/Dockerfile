FROM bellsoft/liberica-openjdk-alpine:17
RUN ["mkdir", "project"]
WORKDIR ./project
RUN ["apk", "add", "maven"]
CMD ["mvn", "spring-boot:run"]