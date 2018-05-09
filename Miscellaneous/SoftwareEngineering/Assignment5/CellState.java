public abstract class CellState{

    public boolean state;

    boolean isAlive(){ return state; }
    void SetState(boolean s){ state = s; };
}