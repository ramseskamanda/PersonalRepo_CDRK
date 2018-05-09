public class Cell {
    CellState state;

    public Cell(State s){ this.state = (s == State.alive) ? new CellAlive() : new CellDead();  }

}