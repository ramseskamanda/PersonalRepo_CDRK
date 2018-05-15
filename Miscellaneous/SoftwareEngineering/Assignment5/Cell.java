public enum Cell {
    alive(new CellAlive()),
    dead(new CellDead());

    CellState state;

   	Cell(CellState s){
    	this.state = s;
    }

}