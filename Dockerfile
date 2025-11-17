# Étape 1 : utiliser une image Java 17
FROM eclipse-temurin:17-jdk

# Étape 2 : créer un répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : copier le JAR généré par Maven
COPY target/SupplyChainX-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : exposer le port de ton application
EXPOSE 9090

# Étape 5 : commande pour exécuter ton application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
