package minesweeper.controllers;

import javafx.scene.control.Button;

public class CoordsButton extends Button {
    public int row;
    public int col;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
