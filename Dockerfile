FROM openjdk:14-alpine
COPY build/libs/mn-custom-validation-*-all.jar mn-custom-validation.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mn-custom-validation.jar"]