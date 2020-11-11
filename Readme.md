Candidates API.

# Getting started

1. Get the project sources:

    
    git clone 

   Or using HTTP(S):
    
    git clone 
    


2. Update the local profil [configuration](./src/main/resources/application.yml). 

3. Launch:
    
    mvn compile spring-boot:run -Djvm.options="-Xms256M -Xmx256M -XX:MaxMetaspaceSize=256m -noverify -XX:TieredStopAtLevel=1 -XX:+AlwaysPreTouch" -Dspring.profiles.active=local -DskipITs
    

   Or using you favorite IDE, add the arguments below:
    
    -Xms256M -Xmx256M -XX:MaxMetaspaceSize=256m -noverify -XX:TieredStopAtLevel=1 -XX:+AlwaysPreTouch -Dspring.profiles.active=local -DskipITs
    


    