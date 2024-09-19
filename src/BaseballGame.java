import java.util.*;

public class BaseballGame {
    //Field 선언
    private final String randomNumber;  // random 숫자의 field 선언
    private final int difficultyLevel; // 자리수(난이도)를 저장하는 field 선언

    //생성자
    public BaseballGame(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;   //난이도에 따른 자리수 설정
        this.randomNumber = generatedRandNum(); // 생성자가 random 숫자를 생성한다
    }

    //Game의 진행 Method
    public int play() {
        Scanner scanner = new Scanner(System.in);
        int gameTries = 0; // Game 시도횟수 초기화

        //무한 loop 시작
        while (true) {

            try {
                // Player에게 입력값을 받음
                System.out.print("\nPlayer 숫자 입력: ");
                String playerInput = scanner.next();

                //올바른 입력값을 받았는지 검증
                if (!validateInput(playerInput)) {
                    System.out.println("올바르지 않은 입력값입니다. 1~9 사이에 서로 다른 " + difficultyLevel + "자리 숫자를 입력하세요.");
                    continue;
                }

                // Game 시도횟수 증가
                gameTries++;

                //Strike와 Ball의 개수 계산 및 정답여부 확인
                int strikes = countStrike(playerInput);
                int balls = countBall(playerInput);

                if (strikes == difficultyLevel) {
                    System.out.println("정답입니다.");
                    break;
                } else if (strikes == 0 && balls == 0) {
                    System.out.println("Out");
                } else {
                    System.out.println(strikes + " Strike(s), " + balls + " Ball(s).");
                }
            } catch (Exception e) {
                System.out.println("오류 발생:" + e.getMessage());
            }
        }
        return gameTries;
    }

    // Computer가 1~9 사이에 서로 다른 random 숫자를 생성하는 Method.
    //Random 숫자의 자리수는 Player가 입력한 값의 자리수와 동일해야 합니다.
    private String generatedRandNum() {
        List<Integer> digitsNumbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            digitsNumbers.add(i);
        }

        //random 숫자 shuffle
        Collections.shuffle(digitsNumbers);

        //생성된 int의 List 객체를 문자열로 변환하고 문자열을 반환합니다.
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < difficultyLevel; i++) {
            randomNumber.append(digitsNumbers.get(i));
        }
        return randomNumber.toString();
    }

    //Player가 1~9 사이에 서로 다른 수를 입력한지 확인하는 Method
    //Player가 입력한 값의 자리수는 선택한 난이도와 동일해야 합니다.
    protected boolean validateInput(String input) {

        //Player의 입력란 자리수 확인
        if (input.length() != difficultyLevel) {
            return false;
        }
        //'toCharArray' Method을 통해 Player가 입력한 숫자를 char type Set Collection으로 변환합니다.
        //그리고 입력 값에 문자, '0' 또는 중복이 있는지 확인
        Set<Character> numSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character) || character == '0' || !numSet.add(character)) {
                return false;
            }
        }
        return true;
    }

    //Strike의 수를 세는 Method
    private int countStrike(String input) {
        int strikes = 0;
        for (int i = 0; i < difficultyLevel; i++) {
            if (input.charAt(i) == randomNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    //Ball의 수를 세는 Method
    private int countBall(String input) {
        int balls = 0;
        for (int i = 0; i < difficultyLevel; i++) {
            if (input.charAt(i) != randomNumber.charAt(i) && randomNumber.indexOf(input.charAt(i)) >= 0) {
                balls++;
            }
        }
        return balls;
    }
}
