package hangman;

import java.util.List;

public class HangmanStates {
    private final List<String> hangmanStates = List.of(
            """
            +---+
            |   |
            |
            |
            |
            |
            ========
           """,
            """
             +---+
             |   |
             |   O
             |
             |
             |
             ========
            """, """
            +---+
            |   |
            |   O
            |   |
            |
            |
            ========
            """, """
            +---+
            |   |
            |   O
            |  /|
            |
            |
            ========
            """, """
            +---+
            |   |
            |   O
            |  /|\\
            |
            |
            ========
            """, """
            +---+
            |   |
            |   O
            |  /|\\
            |  /
            |
            ========
            """, """
            +---+
            |   |
            |   O
            |  /|\\
            |  / \\
            |
            ========
            """
    );

    public String getHangmanStates(int index) {
        return hangmanStates.get(index);
    }
}
