# EMS 프로젝트

## DBMS 연동 도구
* mysql-connector-;
* mybatis
* mybatis-spring
* spring-jdbc
* commons-dbcp

## 파일 업로드 도구
* commons-io
* commons-fileupload

## JSON 관련 도구
* jackson-bind

## 메일 전송 도구
* java-mail
```
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>

```

## 암호화 도구
* Spring Security Core
* jasypt
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>1.9.3</version>
</dependency>

```
```
		<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt-spring31 -->
		<dependency>
			<groupId>org.jasypt</groupId>
			<artifactId>jasypt-spring31</artifactId>
			<version>${org.jasypt-version}</version>
		</dependency>

```

## 데이터 유효성 검사 도구
* 서버(Controller) 단에서 데이터 유효성 검사 도구
* validation api
```
<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>

```
* hibernate validation
```
<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>

```
* Spring framework 5.x 버전에서는 서버단 유효성 검사를 위하여 framework 관련 요소를 추가해주어야한다
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context-support</artifactId>
    <version>5.3.21</version>
</dependency>

```
