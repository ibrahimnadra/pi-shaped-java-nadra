# Exercise for Day 3: Service Discovery

## Objective
Design and implement a microservices system that uses Service Discovery to dynamically route requests across multiple services via Eureka (or Kubernetes DNS) and expose them through a centralized API Gateway. Integrate load balancing.

---

## Tasks Completed with Eureka Server
For the Eureka server, i have created the folder `EurekaServerServiceDiscovery`, with its own README file containing detailed instructions on how to set up the Eureka server and the microservices.

---

## Tasks Completed with Kubernetes DNS
For the Kubernetes DNS, I have created the folder `KubernetesDnsServiceDiscovery`, with its own README file containing detailed instructions on how to set up the microservices using Kubernetes DNS.

---

## Core Concept Questions

### What’s the difference between client-side and server-side service discovery?
Client-side service discovery involves the client (or consumer) of a service determining the location of service instances and making requests directly to them. The client uses a discovery client to query a service registry (like Eureka) to find available instances.
Server-side service discovery, on the other hand, involves a load balancer or API gateway that queries the service registry and routes requests to the appropriate service instances. The client does not need to know about the service instances; it simply sends requests to the load balancer or gateway.

### How does Eureka detect dead service instances?
Eureka detects dead service instances through a heartbeat mechanism. Each registered service instance sends a heartbeat to the Eureka server at regular intervals (default is 30 seconds). If the Eureka server does not receive a heartbeat from a service instance within a specified timeout period (default is 90 seconds), it considers that instance as dead and removes it from the registry.

### Why is the /actuator/health endpoint important for service discovery?
The `/actuator/health` endpoint is important for service discovery because it provides a way for the service registry (like Eureka) to check the health status of registered services. This endpoint can return information about the service's readiness and liveness, allowing the service registry to determine if a service instance is healthy and should be included in routing decisions. If a service instance is unhealthy, it can be excluded from the list of available instances.

### How does lb:// routing in Gateway work with DiscoveryClient?
The `lb://` routing in Spring Cloud Gateway works with the DiscoveryClient by allowing the gateway to route requests to service instances registered in a service registry (like Eureka). When a request is made to a URI prefixed with `lb://`, the gateway uses the DiscoveryClient to look up the available instances of the specified service. It then selects one of those instances (using load balancing strategies) and forwards the request to that instance.

### What happens when a registered service goes down?
When a registered service goes down, the Eureka server detects it through the heartbeat mechanism. If the service does not send a heartbeat within the specified timeout period, Eureka marks that service instance as unavailable and removes it from the registry. Consequently, any requests routed through the API Gateway or other clients will no longer be directed to that instance, ensuring that only healthy instances are used for routing.

### Compare Eureka, Consul, and Kubernetes DNS-based discovery.
Eureka, Consul, and Kubernetes DNS-based discovery are all service discovery mechanisms, but they have different features and use cases:
- **Eureka**: A service discovery server developed by Netflix, primarily used in Spring Cloud applications. It provides features like client-side load balancing, health checks, and instance registration. It is well-integrated with Spring Boot and Spring Cloud.
- **Consul**: A service discovery and configuration management tool developed by HashiCorp. It provides features like health checks, key-value storage, and multi-datacenter support. Consul can be used with various programming languages and frameworks, not just Java.
- **Kubernetes DNS-based discovery**: In Kubernetes, service discovery is built into the platform using DNS. Each service is assigned a DNS name, and Kubernetes automatically manages the routing of requests to the appropriate pods. This approach is tightly integrated with Kubernetes' orchestration capabilities and does not require an external service discovery server.

### How does Spring LoadBalancer choose which instance to call?
Spring LoadBalancer uses various load balancing strategies to choose which instance to call. By default, it uses a round-robin strategy, where requests are distributed evenly across all available instances. However, it can also be configured to use other strategies such as random selection, weighted response time, or custom strategies defined by the developer. The choice of instance is made based on the available instances registered in the service registry (like Eureka) and the selected load balancing strategy.

---