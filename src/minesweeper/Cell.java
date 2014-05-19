package minesweeper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Cell {
    private int row;
    private int column;
    private CellType type;
    private int content;
    private boolean isVisited;
    private boolean isMine;
    private boolean isFlagged;
    private boolean isQuestionMark;
    private int neighborMines = -1;
    private MineField mineField;

    public Cell(MineField mineField, int row, int column, CellType type, boolean isMine) {
        // TODO: Check row and col against minefield constraints
        this.mineField = mineField;
        this.row = row;
        this.column = column;
        this.type = type;
        int mines = getNeighborMines();
        this.setContent(type, mines);
        this.isMine = isMine;
    }

    public Cell(MineField mineField, int row, int column, CellType type) {
        this(mineField, row, column, type, false);
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
        return isVisited;
    }

    public boolean isMine() {
        return isMine;
    }

    public void makeMine() {
        this.isMine = true;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void flag() {
        if (!this.isFlagged && !this.isQuestionMark) {
            this.isFlagged = true;
        }
    }

    public void unflag() {
        if (this.isFlagged) {
            this.isFlagged = false;
        }
    }

    public boolean isQuestionMark() {
        return isQuestionMark;
    }

    public void placeQuestionMark() {
        if (this.isFlagged) {
            this.isQuestionMark = true;
        }
    }

    public void removeQuestionMark() {
        if (this.isQuestionMark) {
            this.isQuestionMark = false;
        }
    }
    //endregion

    public void visit() {
        switch (this.type) {
            case FLAGGED_MINE:
            case FLAG:
            case NUMBER:
            case HIT_MINE:
                return;
            case UNOPENED:
            case QUESTION_MARK:
                if (getNeighborMines() == 0) {
                    // TODO: Recursively open this and the neighboring cells (this can be a method of the MineField class)
                }

                this.type = CellType.NUMBER;
            case MINE:
                this.type = CellType.HIT_MINE;
                // TODO: Game lost
        }

    }

    public int getNeighborMines() {
        if (neighborMines == -1) {
            /* TODO: Calculate neighbor mines with respect to the cell's minefield
            Don't forget to set the field this.neighborMines before returning it:
            neighborMines = ...;*/
        } else {
            return neighborMines;
        }

        throw new NotImplementedException();
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
            case FLAG:
                this.content = Settings.CellContents.FLAG;
                break;
            case QUESTION_MARK:
                this.content = Settings.CellContents.QUESTION_MARK;
                break;
        }
    }
}
