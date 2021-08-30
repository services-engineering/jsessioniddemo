### Traefik stick sessions demo

This project is made up of four parts. The Java project is a Spring Boot Web application with a single API endpoint. The Docker build will build this project into a container that can be pushed to a registry for consumption. The Kubernetes Deployment can be used to deploy the container to Kubernetes and configure the Traefik Ingress Controller to serve up traffic using stick sessions. A standard 1.8.1 Konvoy cluster was used, but different versions can be experimented with.


Java Project

The Java Project is a Spring Boot starter. See the `pom.xml` file for details about what dependencies are used.

The project can be started by running in IntelliJ or from the command line using the following command. You will need java and maven installed on your machine.

```bash
mvn spring-boot:run
```

Docker Build

If you want to run locally, but do not want to install Java and Maven. You can still do so by building out the Docker container and running it locally on Docker.

```bash
docker build -t servicesengineering/jsessionid-demo:0.4 . 
```

Then run it with this command.

```bash
docker run -it --rm -p 8080:8080 jsessionid-demo:0.4
```

Once you have the Docker image created you can push it to a registry like this.

```bash
docker push servicesengineering/jsessionid-demo:0.4
```

It would now be pullable from this registry. Note that you would need to substitute your registry and version number for what is given in the above example commands.

Kubernetes Deployment

You can deploy the entire application using Kubernetes and the supplied `deploy.yaml` file.

```bash
kubectl apply -f deploy.yaml
```

The Ingress configuration will be picked up by Traefik and you can now hit the service on the ingress endpoint.

Konovy Cluster

An 1.8.1 standard Konvoy (DKP) cluster was used for this testing. This configuration and service should work all the way back in previous versions. There is nothing that has changed enough in recent versions to have effected this project.

Endpoints

`http://localhost:8080/getsession`

`https://<your ingress endpoint>/getsession`