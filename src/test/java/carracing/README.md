## 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## TODO
### Step2 리뷰반영
- [x] Pattern 객체를 상수처리
- [x] 배열에서 컬렉션 API로 변경
- [x] Stream API 구현
- [x] 유효성 검증 일급객체 사용
- [x] 테스트 메서드 네이밍 및 DisplayName 수정

### Step3
- [x] 자동차를 N대 만큼 생성한다.
- [x] 자동차를 움직이게 한다.
- [x] 자동차를 랜덤값(0~9)만큼 움직일 수 있게한다.
- [x] 자동차가 랜덤값이 4이상일 때만 움직이게 한다.
- [x] 화면을 출력한다.
- [x] 화면에서 값을 입력한다.

### 리팩토링
- [x] InputView로 화면 입력을 구현한다.
- [x] ResultView로 화면 출력을 구현한다.

- [x] 문자열계산기를 책임사슬패턴으로 구현해본다.
- [X] 레이싱을 전략패턴으로 구현해본다.