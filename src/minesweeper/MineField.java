package minesweeper;

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
        this.fieldUpdaters = new ArrayList<IMineFieldUpdater>();

        initialize();
    }

    public MineField(int rows, int columns, int mines) {
        this(rows, columns, mines, new Random());
    }

    // TODO: Getters and setters

    // TODO: Logic for cell interaction; logic for game management (change of status)

    private void initialize() {
        // TODO: Generate mines, skip a cell if necessary

        updateBoard();
    }

    private void updateBoard(){
        for (IMineFieldUpdater updater: fieldUpdaters){
            updater.updateBoard();
        }
    }
}
