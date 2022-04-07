# How to run the poc

* build a docker container that conatins the spring boot app
  **spring-boot:build-image**

* start a kubernetes cluster locally - for example you may use docker for desktop and start kubernetes

* install the helm chart into the local cluster
  **helm install leader-app ./charts --namespace poc --create-namespace**

Have a look at the logs of the pods (replicas = 2). Only one pod will log: _SingletonService has been started on the master pod_


In case you want to access the rest endpoint use:
**kubectl port-forward service/leader-app-service 8080**

In case of an upgrade use
**helm upgrade leader-app ./charts --namespace poc**

In case you want to remove the namespace use
**kubectl delete namespace poc**

## Hints
In the application.yaml the following specifies the config map name that is used to store and retrieve the leader
cloud.kubernetes.leader.config-map-name=leader

In your code you only need to listen to the OnGrantedEvent and OnRevokedEvent to be informed about the leadership.

The app will read and modify the config map in the k8s cluster. That's why there must be a role and a role binding that grants these permissions.

To make it simple the tests are disabled. Otherwise the app would try to talk to a kubernetes cluster. This must be solved by a profile that is only active in the kubernetes environment.
