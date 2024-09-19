# Number Baseball Game (숫자 야구 게임)
Computer가 1에서 9 사이에 생성한 3 또는 4 또는 5자리의 비밀 숫자를 player가 맞추는 game입니다. 생성된 숫자는 중복되지 않습니다.
(GUI를 사용하지 않습니다. Console 실행 가능한 환경에서 실행됩니다.)

### Project 정보
- Project Type: 개인 Project
- Programming language: Java
- IDE: IntelliJ 2024.1.6
- Runtime version: 17.0.11+1-b1207.30 aarch64
- VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.

### Game 진행
- Player는 computer의 비밀 숫자를 추측하기 위해 시도합니다.
- 각 추측에 대해 게임은 다음과 같은 정보를 제공합니다:
    - "Strike": 추측한 숫자가 비밀 숫자의 정확한 위치에 맞아떨어질 경우
    - "Ball": 추측한 숫자가 비밀 숫자에 포함되어 있지만 위치가 맞지 않을 경우
    - "Out": 추측한 숫자가 비밀 숫자에 전혀 포함되어 있지 않을 경우

### Game Option
- (0): 난이도 선택
- (1): 게임 시작 (기본 자리수는 3자리입니다)
- (2): 게임 기록 보기
- (3): Game 종료

#### 예시 출력
```
환영합니다! 원하시는 번호를 입력해주세요
0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
```

### 주요 기능
#### validateInput () Method


``` Java
protected boolean validateInput(String input) {
        //Player의 입력란 자리수 확인
        if (input.length() != difficultyLevel) {
            return false;
        }
        //'toCharArray' Method을 통해 Player가 입력한 숫자를 char type Set Collection의 객체로 변환합니다.
        //그리고 입력 값에 문자, '0' 또는 중복이 있는지 확인
        Set<Character> numSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character) || character == '0' || !numSet.add(character)) {
                return false;
            }
        }
        return true;
    }
```