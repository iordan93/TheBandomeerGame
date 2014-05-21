package minesweeper.models;

import minesweeper.Settings;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        int mines = getNeighborMines();
        this.setContent(type, mines);
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
        if (this.type == CellType.UNOPENED)
            if (this.isMine()) {
                this.type = CellType.FLAGGED_MINE;
                setContent(CellType.FLAGGED_MINE, 0);
            } else {
                this.type = CellType.FLAG;
                setContent(CellType.FLAG, 0);
            }
    }

    public boolean isQuestionMark() {
        return this.type == CellType.QUESTION_MARK;
    }

    public void placeQuestionMark() {
        if (this.isFlagged()) {
            this.type = CellType.QUESTION_MARK;
            setContent(CellType.QUESTION_MARK, 0);
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
                if (getNeighborMines() == 0) {
                	for(int i = -1 ; i < 2 ; i++){
                    	for(int y = - 1; y < 2 ; y++){
                    		if(){
                    		}
                    		
                    	}
                    }
                }

                this.type = CellType.NUMBER;
            case MINE:
                this.type = CellType.HIT_MINE;
                // TODO: Game lost
        }
    }

    public int getNeighborMines() {
        if (neighborMines == -1) {
            for(int i = -1 ; i < 2 ; i++){
            	for(int y = - 1; y < 2 ; y++){
            		if(this.MineField.getCellat(this.row + i , this.column + y).isMine()){
            			neighbourMines++;
            		}           		
            	}
            }
        } else {
            return neighborMines;
        }

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
}
