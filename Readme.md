# Number Baseball Game (숫자 야구 게임)
Computer가 1에서 9 사이에 생성한 3자리, 4자리 또는 5자리의 비밀 숫자를 player가 맞추는 game입니다. 생성된 숫자는 중복되지 않습니다.
(GUI를 사용하지 않습니다. Console 실행 가능한 환경에서 실행됩니다.)

### Game 목표
- Player는 최소한의 시도로 상대방의 비밀 숫자를 맞추는 것이 목표입니다.
- 정답을 맞추면 게임에서 승리합니다.

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
- (0): 난이도 선택 --> 3자리, 4자리 또는 5자리의 숫자 선택
- (1): 게임 시작 (기본 자리수는 3자리입니다)
- (2): 게임 기록 보기 ---> 게임의 시도회수 표시
- (3): Game 종료

#### 예시 출력
```
환영합니다! 원하시는 번호를 입력해주세요
0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
```

### 주요 기능
#### "validateInput()" Method
"validateInput()"는 player가 문자 또는 1~9 사이에 서로 다른 수를 입력한지 확인하는 method입니다.

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
#### "setDifficultyLevel()" Method
"setDifficultyLevel()" 자리수를 설정하는 method입니다.

```Java
private static void setDifficultyLevel() {
        Scanner input = new Scanner(System.in);

        //무한 loop 시작
        while (true) {
            System.out.println("\n설정하고자 하는 자리수를 입력하세요.(3, 4, 5):");

            try {
                int difficultyChoice = Integer.parseInt(input.next()); //Player로부터 자리수(난이도)의 입력을 받음
                if (difficultyChoice == 3 || difficultyChoice == 4 || difficultyChoice == 5) {
                    difficultyLevel = difficultyChoice;
                    System.out.println(difficultyLevel + "자리수 난이도로 설정되었습니다.");
                    System.out.println("\n< 게임을 시작합니다 >");
                    break; // 올바른 값 입력시 loop가 종료됩니다.
                } else {
                    System.out.println("3, 4, 5 중 하나를 선택해 주세요");
                }

            } catch (NumberFormatException e) {
                System.out.println("입력을 잘 못했습니다. 숫자를 입력해 주세요.");
            }
        }
        startGame(); //자리수 설정 후 Game 시작됩니다.
    }
```
#### "gameRecordsDisplay()" Method
Game의 기록을 보여주는 method입니다.

```Java
  private static final List<Integer> gameAttempts = new ArrayList<>();
  private static void gameRecordsDisplay() {
        if (gameAttempts.isEmpty()) {
            System.out.println("게임의 기록이 없습니다.");
        } else {
            System.out.println("\n< 게임 기록 보기 >");
            for (int i = 0; i < gameAttempts.size(); i++) {
                System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + gameAttempts.get(i));
            }
        }
    }
```

### Feedback
Code를 개선하고 더 나아지게 하기 위해 자유롭게 feedback을 주고 기여해 주세요. 
Feel free to give feedback and make your contributions to improve the code and make it way better.
