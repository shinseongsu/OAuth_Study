# 새로운 액세스 토큰 발급

------

> ``` curl -X POST "http://localhost:8080/oauth/token" --user clientadmin:123 -d "grant_type=client_credentials&scope=admin" ```


# 실행 결과 받기

-------

> ``` curl "http://localhost:8080/api/users" -H "Authorization: Bearer f0baa43d-3f5e-4d53-99e1-aa77263b979f (마지막 토큰 받은 고정이 아님)" ```

