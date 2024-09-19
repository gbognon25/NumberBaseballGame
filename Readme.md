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

