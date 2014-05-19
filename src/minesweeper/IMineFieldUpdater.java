package minesweeper;

public interface IMineFieldUpdater {
    void updateCell(Cell cell);
    void updateBoard();
    void changeGameState(GameState newState);
}
