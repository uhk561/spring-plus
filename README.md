# SPRING PLUS

본 프로젝트는 기존에 개발되어 있던 Spring Boot 기반 애플리케이션을 대상으로  
주어진 요구사항에 따라 **코드 수정 및 개선 작업만**을 수행한 결과물입니다.

---

## 주요 개선 사항

###  Level 1

- **@Transactional 개선**
    - 읽기 전용 트랜잭션으로 인해 발생하던 데이터 저장 오류 수정

- **JWT 개선**
    - User 엔티티에 `nickname` 컬럼 추가
    - JWT 토큰에 nickname 정보를 포함하여 프론트엔드에서 활용 가능하도록 개선

- **JPA 검색 기능 확장**
    - `weather` 조건 기반 검색 기능 추가
    - 수정일 기준 기간(start / end) 검색 기능 추가
    - JPQL을 사용하여 조건별 조회 로직 구현

- **컨트롤러 테스트 수정**
    - 예외 발생 시 실제 API 응답과 테스트 코드의 기대값 불일치 문제 해결

- **AOP 동작 수정**
    - 관리자 권한 변경 API 실행 **이전**에 로그가 기록되도록 AOP 실행 시점 수정

---

###  Level 2

- **JPA Cascade 적용**
    - Todo 생성 시, 생성한 유저가 담당자로 자동 등록되도록 Cascade 설정 추가

- **N+1 문제 해결**
    - 연관 엔티티 조회 시 Fetch Join을 적용하여 N+1 쿼리 문제 제거

- **QueryDSL 적용**
    - 기존 JPQL 기반 조회 메소드를 QueryDSL로 변경
    - Fetch Join을 활용해 성능 문제 방지

- **Spring Security 도입**
    - 기존 Filter 및 Argument Resolver 기반 인증 구조를 Spring Security로 전환
    - JWT 기반 토큰 인증 방식은 유지
    - 접근 권한 및 유저 권한 기능을 Spring Security 기능으로 대체

---

##  정리

본 과제는 신규 기능 개발이 아닌,  
기존 코드의 문제점을 분석하고 Spring의 권장 방식에 맞게  
구조와 동작을 개선하는 데 중점을 두었습니다.
