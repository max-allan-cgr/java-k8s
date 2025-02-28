package com.max;

// package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
            // Load YAML manifest into Java object
            Pod pod = k8s.pods().load(App.class.getResourceAsStream("/test-pod.yaml")).item();
            // Apply manifest onto Kubernetes cluster
            k8s.pods().inNamespace("default").resource(pod).create();
        }
    }
}    



