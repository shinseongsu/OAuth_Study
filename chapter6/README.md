토큰얻기

> curl -X POST --user clientapp:123456 "http://localhost:8080/oauth/token" -H "accept: application/json" -H "content-type: application/x-www-form-urlencoded" -d "grant_type=password&username=seongsu&password=123&scope=read_profile"
