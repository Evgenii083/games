import org.junit.jupiter.api.Assertions;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test {
    Game game = new Game();

    @org.junit.jupiter.api.Test
    public void checkFindFunction() {
        StrengthComparator strengthComparator = new StrengthComparator();
        Player player1 = new Player(1, "Player1", 4);
        Player player2 = new Player(2, "Player2", 5);
        Player player5 = new Player(5, "Player5", 4);
        Player player7 = new Player(7, "Player 7", 3);
        game.register(player1);
        game.register(player2);
        game.register(player5);
        game.register(player7);

        List<Player> expected = Arrays.asList(player7, player1, player5, player2);
        ArrayList<Player> resList = game.showRegisterPlayers();
        Collections.sort(resList, strengthComparator);
        Assertions.assertEquals(expected, resList);
    }

    @org.junit.jupiter.api.Test
    public void checkRegistration() {
        Player player1 = new Player(1, "Alex", 4);
        game.register(player1);

        boolean expected = true;
        boolean actual = game.checkRegistration(player1);
        Assertions.assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test

    public void shouldGetException() {
        Player player1 = new Player(1, "Alex", 4);
        boolean thrown = false;

        try {
            game.checkRegistration(player1);
        } catch (NotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @org.junit.jupiter.api.Test
    public void checkRoundWhenPlayer1StrongestThenPlayer2() {
        Player player1 = new Player(1, "Alexias", 14);
        Player player3 = new Player(3, "Bombita", 7);
        game.register(player1);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Alexias", "Bombita");
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void checkRound2WhenPlayer2StrongestThenPlayer1() {
        Player player1 = new Player(4, "Izumir", 9);
        Player player2 = new Player(6, "Killer77", 11);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Izumir", "Killer77");
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void checkRound3WhenPlayersStrengthIsTheSame() {
        Player player1 = new Player(4, "Eagle", 10);
        Player player2 = new Player(6, "Sonny", 10);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Eagle", "Sonny");
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void checkRoundWhenOneOfThePlayersHasNoRegistration() {
        Player player1 = new Player(4, "Izumir", 9);
        Player player2 = new Player(6, "Killer77", 11);
        boolean thrown = false;
        game.register(player1);
        try {
            game.round("Izumir", "Killer77");
        } catch (NotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    public void checkRoundWhenAnotherPlayersHasNoRegistration() {
        Player player1 = new Player(4, "Izumir", 9);
        Player player2 = new Player(6, "Killer77", 11);
        boolean thrown = false;
        game.register(player2);
        try {
            game.round("Izumir", "Killer77");
        } catch (NotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    public void checkRoundWhenNameOfOnePlayerIsWrong() {
        Player player1 = new Player(4, "Izumir", 9);
        Player player2 = new Player(6, "Killer77", 11);
        boolean thrown = false;
        game.register(player1);
        game.register(player2);
        try {
            game.round("Izu", "Killer77");
        } catch (NotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}