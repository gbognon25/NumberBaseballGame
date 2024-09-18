import java.util.*;

public class Main {

    private static final List <Integer> gameAttempts = new ArrayList<>(); // Game 기록 저장 List의 생성

    public static void main(String[] args) {
//        System.out.println("< Game을 시작합니다 !!!>");
//        System.out.println("Game Over !!! 시도 횟수: " + gamePlayed);

        Scanner inputChoice = new Scanner(System.in);

        while (true) {
            System.out.println("\n환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("\n1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choice = inputChoice.nextInt(); // 선택 입력

            switch (choice) {
                case 1:
                    startGame();
                    break;

                case 2:
                    gameRecordsDisplay();
                    break;

                case 3:
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;

                default:
                    System.out.println("올바른 숫자를 입력해주세요!");

            }
        }

    }

    // Game을 시작하는 Method (1번을 누른시)
    private static void startGame () {
        BaseballGame game = new BaseballGame();
        int gamePlayed = game.play();
        gameAttempts.add(gamePlayed);
    }

    // Game의 기록을 보여주는 Method (2번을 누른시)
    private static void gameRecordsDisplay() {
        if (gameAttempts.isEmpty()) {
            System.out.println("게임의 기록이 없습니다.");
        }
        else {
            System.out.println("< 게임 기록 보기 >");
            for (int i = 0; i < gameAttempts.size(); i++) {
                System.out.println((i+1) + "번째 게임 : 시도 횟수 - " + gameAttempts.get(i));
            }
        }
    }
}
