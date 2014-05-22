package minesweeper.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MineField {
    private int rows;
    private int columns;
    private int mines;
    private Cell[][] cells;
    private GameState state;
    private int remainingMinesCount;

    private Random random;
    private List<IMineFieldUpdater> fieldUpdaters;

    public MineField(int rows, int columns, int mines, Random random) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.random = random;
        this.cells = new Cell[rows][columns];
        this.fieldUpdaters = new ArrayList<>();
        this.remainingMinesCount = mines;
        this.state = GameState.NEW;

        initialize();
    }

    public MineField(int rows, int columns, int mines) {
        this(rows, columns, mines, new Random());
    }

    // region Properties
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public int getRemainingMinesCount() {
        return remainingMinesCount;
    }

    public void setRemainingMinesCount(int remainingMinesCount) {
        this.remainingMinesCount = remainingMinesCount;
    }

    public int getRemainingFieldsCount() {
        int count = this.rows * this.columns;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.cells[i][j].isVisited() || this.cells[i][j].getType() == CellType.FLAGGED_MINE){
                    count--;
                }
            }
        }

        return count;
    }

    public Cell getCellAt(int row, int column) {
        return this.cells[row][column];
    }

    public void setCellAt(int row, int column, Cell cell) {
        this.cells[row][column] = cell;
    }

    public void setState(GameState state){
        this.state = state;
    }
    // endregion

    private void initialize() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                this.cells[row][col] = new Cell(this, row, col, CellType.UNOPENED);
            }
        }

        updateBoard();
    }

    public void placeMines(int noMineRow, int noMineCol) {
        for (int i = 0; i < this.mines; i++) {

            int currentRow = random.nextInt(rows);
            int currentCol = random.nextInt(columns);

            if ((currentRow == noMineRow && currentCol == noMineCol) || this.cells[currentRow][currentCol].isMine()) {
                i--;
            } else {
                this.cells[currentRow][currentCol].makeMine();
            }
        }

        this.state = GameState.IN_PROGRESS;
        updateBoard();
    }

    private void updateBoard() {
        for (IMineFieldUpdater updater : fieldUpdaters) {
            updater.updateBoard();
        }
    }

    public boolean isGameWon() {
        return remainingMinesCount == 0 || getRemainingFieldsCount() == this.mines;
    }

    private boolean isGameOver(){
        return isGameWon() || this.state == GameState.LOST;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                switch (this.cells[i][j].getType()) {
                    case UNOPENED:
                        sb.append("-");
                        break;
                    case NUMBER:
                        sb.append(this.cells[i][j].getContent());
                        break;
                    case MINE:
                        sb.append("*");
                        break;
                    case FLAGGED_MINE:
                        sb.append("#");
                        break;
                    case HIT_MINE:
                        sb.append("~");
                        break;
                    case FLAG:
                        sb.append("^");
                        break;
                    case QUESTION_MARK:
                        sb.append("?");
                        break;
                }

                sb.append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
