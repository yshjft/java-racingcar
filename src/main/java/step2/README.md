## 기능 요구사항
1. 빈 문자열 또는 null 값을 입력할 경우, 0을 반환한다.
2. 숫자 하나를 문자열로 입력할 경우, 해당 숫자를 반환한다.
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우, 두 숫자의 합을 반환한다.
4. 구분자를 컴마(,) 외에 콜론(:)을 사용할 수 있다.
5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. 
6. "//"와 "\n" 문자 사이에 문자열(커스텀 구분자)이 없을 경우, RuntimeException 예외가 발생해야 한다.
6. 음수를 전달할 경우, RuntimeException 예외가 발생해야 한다.