# baseCRM

Test requires [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Maven](http://maven.apache.org/download.cgi).

---

How to run test:

`mvn clean test`

You can also use some switches to run test on other host:

`mvn clean test -Durl=http://www.some.other.instance.of.base.com`

and with other credentials:

`mvn clean test -Duser=Some_User -Dpassword=S3cret_Password`
