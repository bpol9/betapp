### About
A Java Spring Boot server to handle sport games and their odds.

### Starting the server
* A PostgreSQL server is needed to run at `localhost:5432` with database named `bettingapp` and username/password: `postgres/postgres`
* The server can be started at localhost:8080 with the command: `mvnw clean spring-boot:run`

### The following Web API endpoints are supported
* Get an existing match: `GET localhost:8080/api/match/{match_id}`
* Add a match: `POST localhost:8080/api/match`
  
   Example JSON request body:```
    {
    "teamA": "OSFP",
    "teamB": "PAO",
    "matchDate": "2025-03-14",
    "matchTime": "21:15",
    "sport": "Basketball",
    "description": "OSFP-PAO",
    "odds": [
        {
            "specifier": "1",
            "odds": "1.52"
        },
        {
            "specifier": "2",
            "odds": "2.50"
        }
    ]
  }```
* Add odds to an existing match: `POST localhost:8080/api/match/add-odds`

  For example JSON body: ```
  {
    "matchId": 1,
    "odds": "3.05",
    "specifier": "X"
  }```
* Delete an existing match: `DELETE localhost:8080/api/match/{match_id}`
* Update the odds of an existing match: `PATCH localhost:8080/api/edit-odds`

  For example JSON body: ```
  {
    "matchId": 1,
    "odds": "3.05",
    "specifier": "2"
  }```
* Update the match date/time: `PATCH localhost:8080/api/edit-start-time`

   For example JSON body: ```
   {
    "matchId": 1,
    "time": "21:30",
    "date": "2025-07-31"
   }```
