rdap-client
=======================
A Java client library for RDAP (Registration Data Access Protocol)


## Quick Start

### Add maven dependency
```xml
<dependency>
    <groupId>io.github.dzh</groupId>
    <artifactId>rdap-client</artifactId>
    <version>2019.3.16-SNAPSHOT</version>
</dependency>
```

### Simple example
```java

RdapClient client = RdapProvider.create(RdapConst.SOURCE_APNIC).build();
String ip = "1.2.4.0";
Network network = client.ip(ip, 24);
LOG.info("{} {}", ip, network);

```
