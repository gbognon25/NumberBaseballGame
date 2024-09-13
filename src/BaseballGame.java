import java.util.*;

public class BaseballGame {
    private String randomNumber;

    // 생성자가 random 숫자를 생성한다
    public BaseballGame() {
        this.randomNumber = generatedRandNum();
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);

        int gameTries = 0; // Game 시도횟수
        while (true) {
            // 1. 유저에게 입력값을 받음
            // 2. 올바른 입력값을 받았는지 검증
            // 3. 게임 진행횟수 증가
            // 4. 스트라이크 개수 계산
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            // 6. 볼 개수 계산
            // 7. 힌트 출력
            System.out.print("\nPlayer 숫자 입력 : ");
            String playerInput = scanner.nextLine();

            if (!validateInput(playerInput)) {
                System.out.println("올바르지 않은 값입니다.");
                continue;
            }

            // Game 시도횟수 증가
            gameTries++;

            int strikes = countStrike(playerInput);
            int balls = countBall(playerInput);

            if (strikes == 3) {
                System.out.println("축하합니다~!!!");
                break;
            }
            else if (strikes == 0 && balls == 0) {
                System.out.println("Out");
            }
            else {
                System.out.println(strikes + " Strike(s), " + balls + " Ball(s).");
            }
        }

        System.out.println("\n정답은: " + randomNumber); //정답 출력
        return gameTries;
    }

    // Computer가 1~9 사이에 서로 다른 3자리 random 숫자를 생성하는 Method
    private String generatedRandNum() {
        List<Integer> digitsNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digitsNumbers.add(i);
        }

        //random 숫자 shuffle
        Collections.shuffle(digitsNumbers);

        //생성된 숫자를 문자열로 변환하고 반환
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            randomNumber.append(digitsNumbers.get(i));
        }
        return randomNumber.toString();
    }

    //Player가 1~9 사이에 서로 다른 3자리 수를 입력한지 확인하는 Method
    protected boolean validateInput(String input) {

        //Player의 입력이 3자리 수인지 확인
        if (input.length() != 3) return false;

        //'toCharArray' Method을 통해 Player가 입력한 숫자를 Set으로 변환합니다.
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
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == randomNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    //Ball의 수를 세는 Method
    private int countBall(String input) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) != randomNumber.charAt(i) && randomNumber.indexOf(input.charAt(i)) >= 0) {
                balls++;
            }
        }
        return balls;
    }
}
