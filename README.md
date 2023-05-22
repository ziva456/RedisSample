# RedisSample
init

## Sample Postman
URL : http://localhost:8080/redisctrl/createdata

## Redis Docker 설정
```yml
version: '3'

services:
  redis:
    image: redis
    container_name: redis
    command: redis-server --appendonly yes
    volumes:
      - ./data:/data
    ports:
      - "6379:6379"
```

## Sample JSON
```json
{
  "id": "userid1",
  "bodyDTO": {
    "element1": "정보3",
    "element2": "정보4"
  }
}
```
