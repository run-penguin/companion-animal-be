# 1. 빌드 단계
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Gradle 파일 복사 (캐싱 최적화)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x ./gradlew

# 의존성 다운로드
RUN ./gradlew dependencies --no-daemon

# 소스 코드 복사 및 빌드
COPY src src
RUN ./gradlew clean build -x test --no-daemon

# 2. 실행 단계
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

# Render의 PORT 환경변수 사용
ENV PORT=8080
EXPOSE ${PORT}

# 애플리케이션 실행
# Render의 PORT 환경변수를 Spring Boot에 전달
ENTRYPOINT ["sh", "-c", "java -jar -Dspring.profiles.active=prod -Dserver.port=${PORT} app.jar"]