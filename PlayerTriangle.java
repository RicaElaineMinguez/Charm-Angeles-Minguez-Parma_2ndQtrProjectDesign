public class PlayerTriangle extends Player{
  public PlayerTriangle(String n, int LX, int LY, int CM){
    super( n,"Triangle", LX,  LY, 3);
  }

public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) { 
      Tile.grid[x+1][y].setPlayerStatus("Triangle");
       Tile.grid[x-1][y+1].setPlayerStatus("Triangle");
      Tile.grid[x-1][y-1].setPlayerStatus("Triangle");

      Tile.grid[x+1][y].setNumberStatus(Tile.grid[x+1][y].getNumberStatus() + 1);
       Tile.grid[x-1][y+1].setNumberStatus(Tile.grid[x-1][y+1].getNumberStatus() + 1);
       Tile.grid[x-1][y-1].setNumberStatus(Tile.grid[x-1][y-1].getNumberStatus() + 1);


      Tile.grid[x][y].setPlayerStatus("empty");
      Tile.grid[x][y].setNumberStatus(0);
    } 

  Tile.nextTurn();
}
}