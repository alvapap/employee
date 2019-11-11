# employee
# Getting Started

## Create Volume
```docker
docker create -v /var/lib/postgresql/data --name PostgresData alpine
```

## Build the Dockerfile of the project
```docker
docker build ./ -t employee-app
```
## Run docker-compose
```docker
docker-compose up -d
```
## Create tables in postgresql
Create
```sql
CREATE TABLE employees (
  id         	SERIAL,
  firstName     TEXT,
  lastName      TEXT,

  PRIMARY KEY (id)
);
```
