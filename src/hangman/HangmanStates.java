package hangman;

import java.util.List;

public abstract class HangmanStates {
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

    protected String getHangmanStates(int index) {
        return hangmanStates.get(index);
    }
}
