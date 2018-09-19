How to run:

* Build and run tests: `./mvnw clean package`
* Run a cluster with 3 active nodes: `docker-compose -f ./src/main/docker/cluster.yml up --scale node=3`
* Get to know which ports are occupied: `docker-compose -f ./src/main/docker/cluster.yml ps`
* Stop the cluster: `docker-compose -f ./src/main/docker/cluster.yml down`
