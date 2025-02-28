# Run locally

```
mvn package
mvn exec:java -Dexec.mainClass=com.max.App
```

# Run In Docker:
```
docker run -itu0 --entrypoint sh -v`pwd`:/work -w /work -v ~/.kube:/root/.kube chainguard/jdk:latest-dev
apk add maven
mvn package
mvn exec:java -Dexec.mainClass=com.max.App
```

## With Chainguard's FIPS image
```
docker run -itu0 --entrypoint sh -v`pwd`:/work -w /work -v ~/.kube:/root/.kube cgr.dev/chainguard-private/jdk-fips:latest-dev
apk add maven
mvn package
mvn exec:java -Dexec.mainClass=com.max.App
.....
[INFO] --- exec:3.5.0:java (default-cli) @ k8s2 ---
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
Feb 28, 2025 5:47:01 PM org.bouncycastle.jsse.provider.PropertyUtils getBooleanSecurityProperty
INFO: Found boolean security property [keystore.type.compat]: true
Feb 28, 2025 5:47:01 PM org.bouncycastle.jsse.provider.PropertyUtils getStringSecurityProperty
INFO: Found string security property [jdk.tls.disabledAlgorithms]: MD5, SSLv3, TLSv1, TLSv1.1, RC4, DES, MD5withRSA, DH keySize < 1024, EC keySize < 224, 3DES_EDE_CBC, anon, NULL, secp112r1, secp112r2, secp128r1, secp128r2, secp160k1, secp160r1, secp160r2, secp192k1, secp192r1, secp224k1, secp224r1, secp256k1, sect113r1, sect113r2, sect131r1, sect131r2, sect163k1, sect163r1, sect163r2, sect193r1, sect193r2, sect233k1, sect233r1, sect239k1, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, brainpoolP256r1, brainpoolP320r1, brainpoolP384r1, brainpoolP512r1
Feb 28, 2025 5:47:01 PM org.bouncycastle.jsse.provider.PropertyUtils getStringSecurityProperty
INFO: Found string security property [jdk.certpath.disabledAlgorithms]: MD2, MD5, RSA keySize < 1024, DSA keySize < 1024, EC keySize < 224, SHA1, secp112r1, secp112r2, secp128r1, secp128r2, secp160k1, secp160r1, secp160r2, secp192k1, secp192r1, secp224k1, secp224r1, secp256k1, sect113r1, sect113r2, sect131r1, sect131r2, sect163k1, sect163r1, sect163r2, sect193r1, sect193r2, sect233k1, sect233r1, sect239k1, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, brainpoolP256r1, brainpoolP320r1, brainpoolP384r1, brainpoolP512r1
Feb 28, 2025 5:47:02 PM org.bouncycastle.jsse.provider.PropertyUtils getStringSystemProperty
INFO: Found string system property [java.home]: /usr/lib/jvm/java-21-openjdk
Feb 28, 2025 5:47:02 PM org.bouncycastle.jsse.provider.PropertyUtils getStringSystemProperty
INFO: Found string system property [javax.net.ssl.trustStoreType]: FIPS
Feb 28, 2025 5:47:02 PM org.bouncycastle.jsse.provider.ProvTlsClient notifyHandshakeBeginning
INFO: [client #1 @6391093b] opening connection to kubernetes.docker.internal:6443
Feb 28, 2025 5:47:02 PM org.bouncycastle.jsse.provider.ProvTlsClient notifyHandshakeComplete
INFO: [client #1 @6391093b] established connection with kubernetes.docker.internal:6443
Feb 28, 2025 5:47:02 PM org.bouncycastle.jsse.provider.ProvTlsClient notifyConnectionClosed
INFO: [client #1 @6391093b] disconnected from kubernetes.docker.internal:6443
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

```

# Further Reading
This example based on code from:

https://github.com/fabric8io/kubernetes-client

Where there are many more examples.