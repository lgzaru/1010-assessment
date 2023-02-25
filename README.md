## Developer Assessment Task1 - ROBOT apocalypse

### API Documentation - SWAGGER
  ```sh
  
http://localhost:8082/swagger-ui/#/
   ```
To Run the App
  ```sh
  mvn spring-boot:run
 
   ```


### Instructions


1. To add  survivor you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/addSurvivor
   ```

2. To update a survivor you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/{survivorID}
   ```

3. To get all survivors you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/getAllSurvivors
   ```

4. To flag a survivor you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/flagSurvivor/{survivorID}
   ```

5. To get a survivor by id you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/getSurvivorById/{survivorID}
   ```

6. To get all robots you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/getAllRobots
   ```

7. To get % infected you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/percentageInfectedSurvivor
   ```

8. To get % non- infected you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/percentageNonInfectedSurvivor
   ```

9. Get all infected list you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/allInfected
   ```

10. Get all non-infected list you hit the following endpoint

  ```sh
    http://localhost:8082/api/survivor/allNonInfected
   ```
   
   
