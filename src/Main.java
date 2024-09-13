import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        System.out.println("< Game을 시작합니다 !!!>");
        int gamePlayed = game.play();
        System.out.println("Game Over !!! 시도 횟수: " + gamePlayed);

    }
}
