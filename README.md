rdap-client
=======================
A Java client library for RDAP (Registration Data Access Protocol)


## Quick Start

### Add maven dependence

### Simple Example
```java

RdapClient client = RdapProvider.create(RdapConst.SOURCE_APNIC).build();
String ip = "1.2.4.0";
Network network = client.ip(ip, 24);
LOG.info("{} {}", ip, network);

```
