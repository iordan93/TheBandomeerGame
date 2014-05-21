package minesweeper;

public class Settings {
    public static final String GAME_NAME = "Bandomeer Minesweeper";

    public static final int INITIAL_ROWS = 9;
    public static final int INITIAL_COLS = 9;
    public static final int INITIAL_MINES = 10;


    public static class CellContents {
        public static final int UNOPENED = -1;
        public static final int MINE = -2;
        public static final int FLAGGED_MINE = -3;
        public static final int HIT_MINE = -5;
        public static final int QUESTION_MARK = -7;
    }
}
