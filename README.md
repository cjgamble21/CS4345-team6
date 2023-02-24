# TASystem Team 6 Project

You have two options for running this project: **IntelliJ** or **Docker**

## Running with IntelliJ

This project's config file is currently setup to run with docker. 
If you'd like to keep on using IntelliJ, go into `./Backend/conf/application.conf` and change the 
`default.url` line to the following: <br />
```jdbc
default.url = "jdbc:mysql://localhost:3306/TASystem?allowPublicKeyRetrieval=true&useSSL=false"
```
Now go into `./Frontend/conf/application.conf` and change the `backend.url` line to the following: <br />
```jdbc
backend.url = "http://localhost:9005"
```

After these changes, you should be able to make the database connection through IntelliJ as well as the API connection.

## Running with Docker 

If you'd like to run this project in Docker, it's stupid easy. 

Just two steps: 

* Make sure `Docker Desktop` is installed and running, and that `docker-compose` is installed

* Go into the project root and type `docker-compose up`

That's all you have to do. The first build will probably take up to 10 minutes; that's expected. 
After the first build, it should take about 2-3 minutes for the containers to start. 
Also, anytime you save your code the containers will reload and the changes should be reflected. <br />
Once you're done working, it's a good idea to type `docker-compose down` and close the containers.
