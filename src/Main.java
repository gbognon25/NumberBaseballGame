import java.util.*;

public class Main {

    private static final List<Integer> gameAttempts = new ArrayList<>(); // Game 기록 저장 List의 생성
    private static int difficultyLevel = 3; // 기본 자리수(난이도)는 3자리로 합니다.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //무한 loop 시작
        while (true) {
            System.out.println("\n환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
            int userChoice = input.nextInt(); // 선택 입력

            switch (userChoice) {
                case 0:
                    setNumberCount();  //자리수 정
                    break;

                case 1:
                    startGame(); // Game 시작
                    break;

                case 2:
                    gameRecordsDisplay(); // Game 기록 보기
                    break;

                case 3:
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return; // Game 종료

                default:
                    System.out.println("올바른 숫자를 입력해주세요!");

            }
        }

    }

    //자리수를 설정하는 Method (0번을 누른시)
    private static void setNumberCount() {
        Scanner input = new Scanner(System.in);

        //무한 loop 시작
        while (true) {
            System.out.println("\n설정하고자 하는 자리수를 입력하세요.(3, 4, 5):");

            try {
                int difficultyChoice = input.nextInt(); //Player로부터 자리수(난이도)의 입력을 받음

                if (difficultyChoice == 3 || difficultyChoice == 4 || difficultyChoice == 5) {
                    difficultyLevel = difficultyChoice;
                    System.out.println(difficultyLevel + "자리수 난이도로 설정되었습니다.");
                    System.out.println("\n< 게임을 시작합니다 >");
                    break; // 올바른 값 입력시 loop가 종료됩니다.
                } else {
                    System.out.println("3, 4, 5 중 하나를 선택해 주세요");
                }
            }
            // 사용자가 숫자가 아닌 값을 입력했을 때 발생하는 예외 처리
            catch (NumberFormatException e) {
                System.out.println("입력을 잘 못했습니다. 숫자를 입력해 주세요.");
            }
        }
        startGame(); //자리수 설정 후 Game 시작됩니다.
    }

    // Game을 시작하는 Method (1번을 누른시)
    private static void startGame() {
        BaseballGame game = new BaseballGame(difficultyLevel); //BaseballGame Class의 instance화
        int gamePlayed = game.play();
        gameAttempts.add(gamePlayed); //시도 횟수 기록 저장
    }

    // Game의 기록을 보여주는 Method (2번을 누른시)
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
}
