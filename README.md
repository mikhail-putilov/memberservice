How-to:

* Build and run tests: `mvn clean package`
* Run a cluster: `docker-compose -f ./src/main/docker/cluster.yml up --scale node=3`
* Get to know which ports are occupied: `docker-compose -f ./src/main/docker/cluster.yml ps`
* Stop the cluster: `docker-compose -f ./src/main/docker/cluster.yml down`
