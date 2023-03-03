# https://yoojin-cell.com/ 접속 도메인 주소 입니다.

## 개인적으로 운영하고 있는 홈페이지 이며 싸이월드 감성으로 만들고 싶어서 프론트는 클론 코딩으로 구현 하였고 백엔드는 Spring Security, 
Spring Data Jpa, QueryDsl, Swagger, EC2(ubuntu),S3, Route53, Certificate Manager, RDS(MySQL), ELB(현재는 내린상태), 
Nginx 등을 이용하여 구현 하였습니다. ELB 는 msa 를 공부해보며 적용을 해 봤고 트래픽 분산이 필요 없는 자그마한 홈페이지라 현재는 내린상태 입니다. (한달정도 운영 했더니 2만원이 나오더라구요 ㅠ)

현재 동작하는 기능은 사진첩 폴더 이며 생성 후 쿼리 dsl을 이용하여 조회결과를 반환(페이징 처리 가능 코드) 페이지가 로딩될때 ajax 요청으로 결과를 불러온 후 html append로 나타냅니다.

# https://yoojin-cell.com/swagger-ui/index.html 스웨거(api 문서) 주소 입니다.

