package minesweeper.models;

import minesweeper.Settings;

public class Cell {
    private int row;
    private int column;
    private CellType type;
    private int content;
    private int neighborMines = -1;
    private MineField mineField;

    public Cell(MineField mineField, int row, int column, CellType type) {
        // TODO: Check row and col against minefield constraints
        this.mineField = mineField;
        this.row = row;
        this.column = column;
        this.type = type;
        // int mines = getNeighborMines();
        // this.setContent(type, mines);
    }

    // region Properties
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CellType getType() {
        return type;
    }

    public int getContent() {
        return content;
    }

    public boolean isVisited() {
        return this.type == CellType.NUMBER || this.type == CellType.HIT_MINE;
    }

    public boolean isMine() {
        return this.type == CellType.MINE;
    }

    public void makeMine() {
        this.type = CellType.MINE;
        setContent(CellType.MINE, 0);
    }

    public boolean isFlagged() {
        return this.type == CellType.FLAG || this.type == CellType.FLAGGED_MINE;
    }

    public void flag() {
        if (!this.isVisited())
            if (this.isMine()) {
                this.type = CellType.FLAGGED_MINE;
                this.mineField.setRemainingMinesCount(this.mineField.getRemainingMinesCount() - 1);
                setContent(CellType.FLAGGED_MINE, 0);
            } else {
                this.type = CellType.FLAG;
                setContent(CellType.FLAG, 0);
            }
    }

    public boolean isQuestionMark() {
        return this.type == CellType.QUESTION_MARK;
    }

    public void toggleQuestionMark() {
        if (this.isFlagged()) {
            this.type = CellType.QUESTION_MARK;
            setContent(CellType.QUESTION_MARK, 0);
        } else if (this.isQuestionMark()) {
            this.type = CellType.UNOPENED;
            setContent(CellType.UNOPENED, 0);
        }
    }
    // endregion

    public void visit() {
        switch (this.type) {
            case FLAGGED_MINE:
            case FLAG:
            case NUMBER:
            case HIT_MINE:
                break;
            case UNOPENED:
            case QUESTION_MARK:
                int mines = this.getNeighborMines();
                this.type = CellType.NUMBER;
                setContent(CellType.NUMBER, mines);

                if (mines == 0) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (isWithinBounds(this.row + x, this.column + y)) {
                                Cell currentCell = this.mineField.getCellAt(this.row + x, this.column + y);
                                if (currentCell.type == CellType.UNOPENED ||
                                        currentCell.isQuestionMark()) {
                                    currentCell.visit();
                                }
                            }
                        }
                    }
                }
                break;
            case MINE:
                this.type = CellType.HIT_MINE;
                this.mineField.setState(GameState.LOST);
                break;
        }
    }

    public int getNeighborMines() {
        if (neighborMines == -1) {
            neighborMines = 0;
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    if (isWithinBounds(this.row + x, this.column + y) &&
                            this.mineField.getCellAt(this.row + x, this.column + y).isMine()) {
                        neighborMines++;
                    }
                }
            }
        }

        return neighborMines;
    }

    private void setContent(CellType type, int number) {
        switch (type) {
            case UNOPENED:
                this.content = Settings.CellContents.UNOPENED;
                break;
            case NUMBER:
                this.content = number;
                break;
            case MINE:
                this.content = Settings.CellContents.MINE;
                break;
            case FLAGGED_MINE:
                this.content = Settings.CellContents.FLAGGED_MINE;
                break;
            case HIT_MINE:
                this.content = Settings.CellContents.HIT_MINE;
                break;
            case QUESTION_MARK:
                this.content = Settings.CellContents.QUESTION_MARK;
                break;
        }
    }

    private boolean isWithinBounds(int row, int column) {
        return row >= 0 && row < this.mineField.getRows() && column >= 0 && column < this.mineField.getColumns();
    }
}
