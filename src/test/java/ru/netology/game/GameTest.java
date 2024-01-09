package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player goblin = new Player(1, "Гоблин", 500);
        Player troll = new Player(2, "Тролль", 600);
        Game game = new Game();

        game.register(goblin);
        game.register(troll);
        int actual = game.round("Гоблин", "Тролль");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player goblin = new Player(1, "Гоблин", 600);
        Player troll = new Player(2, "Тролль", 500);
        Game game = new Game();

        game.register(goblin);
        game.register(troll);
        int actual = game.round("Гоблин", "Тролль");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayerEquals() {
        Player goblin = new Player(1, "Гоблин", 500);
        Player troll = new Player(2, "Тролль", 500);
        Game game = new Game();

        game.register(goblin);
        game.register(troll);
        int actual = game.round("Гоблин", "Тролль");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player goblin = new Player(1, "Гоблин", 500);
        Player troll = new Player(2, "Тролль", 600);
        Game game = new Game();

        game.register(goblin);
        game.register(troll);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Варвара", "Тролль")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player goblin = new Player(1, "Гоблин", 500);
        Player troll = new Player(2, "Тролль", 600);
        Game game = new Game();

        game.register(goblin);
        game.register(troll);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Гоблин", "Варвара")
        );
    }
}
