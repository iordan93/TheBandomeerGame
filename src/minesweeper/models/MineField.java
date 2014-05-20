package minesweeper.models;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MineField {
    private int rows;
    private int columns;
    private int mines;
    private Cell[][] cells;
    private GameState state;
    private Random generator;
    private List<IMineFieldUpdater> fieldUpdaters;

    public MineField(int rows, int columns, int mines, Random generator) {
        // TODO: Check arguments, throw exceptions where appropriate
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.generator = generator;
        this.cells = new Cell[rows][columns];
        this.fieldUpdaters = new ArrayList<>();

        initialize(-1, -1);
    }

    public MineField(int rows, int columns, int mines) {
        this(rows, columns, mines, new Random());
    }

    public Cell getCellAt(int row, int column) {
        throw new NotImplementedException();
    }

    public void setCellAt(int row, int column, Cell cell) {
        throw new NotImplementedException();
    }

    // TODO: Logic for cell interaction; logic for game management (change of status)

    private void initialize(int noMineRow, int noMineCol) {
        // TODO: Generate mines, skip a cell if necessary
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                this.cells[row][col] = new Cell(this, row, col, CellType.UNOPENED);
            }
        }

        for (int i = 0; i < this.mines; i++) {
            int currentRow = generator.nextInt(rows);
            int currentCol = generator.nextInt(columns);
            if (!this.cells[currentRow][currentCol].isMine()) {
                this.cells[currentRow][currentCol].makeMine();
            }
        }

        updateBoard();
    }

    private void updateBoard() {
        for (IMineFieldUpdater updater : fieldUpdaters) {
            updater.updateBoard();
        }
    }
}
