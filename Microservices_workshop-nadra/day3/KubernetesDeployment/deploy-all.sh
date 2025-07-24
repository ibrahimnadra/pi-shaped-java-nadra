#!/bin/bash

set -e  # Exit on error

echo "Deploying MySQL..."
cd mysql
kubectl apply -f mysql-pvc.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml
cd ..

echo "Waiting for MySQL to be ready..."
kubectl wait --for=condition=ready pod -l app=mysql --timeout=120s

echo "Deploying Player Service..."
cd player-service
kubectl apply -f player-service-deployment.yaml
kubectl apply -f player-cluster-ip-service.yaml
kubectl apply -f player-node-port-service.yaml
cd ..

echo "Deploying Team Service..."
cd team-service
kubectl apply -f team-service-deployment.yaml
kubectl apply -f team-cluster-ip-service.yaml
kubectl apply -f team-node-port-service.yaml
cd ..

echo "Done."
