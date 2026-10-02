# Rain

A Spring Boot starter project (Maven + Gradle) — minimal Java backend with a HelloWorld REST endpoint.

项目包含：

- Maven (pom.xml)
- Gradle (build.gradle)
- src/main/java/com/example/rain/RainApplication.java (Spring Boot 主类)
- src/main/java/com/example/rain/HelloController.java (示例 REST 接口)

快速开始（Maven）：

```bash
# 使用 Maven
./mvnw clean package
./mvnw spring-boot:run
# 或
mvn clean package
mvn spring-boot:run
```

快速开始（Gradle）：

```bash
# 使用 Gradle
./gradlew bootRun
# 或
./gradlew build
java -jar build/libs/rain-0.0.1-SNAPSHOT.jar
```

访问示例接口：

GET http://localhost:8080/hello

Git 本地推送示例：

```bash
# 在本地项目目录中
git init
git add .
git commit -m "Initial Spring Boot project"
git branch -M main
git remote add origin https://github.com/Elowen102/Rain.git
git push -u origin main
```

如果你要我：
- 添加 Dockerfile
- 配置 GitHub Actions CI
- 切换为 Kotlin / 使用 Spring WebFlux

告诉我你想继续的方向。