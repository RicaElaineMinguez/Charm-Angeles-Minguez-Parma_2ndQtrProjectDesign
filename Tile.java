public class Tile {
  private String playerStatus;
  private int criticalMass, numberStatus;
  
  //make location a 2d array of ints
  static Tile[][] grid = new Tile[8][8];

  public String getPlayerStatus(){
    return playerStatus;
  }

  public void setPlayerStatus(String n){
    this.playerStatus = n;
  }

  public int getCriticalMass(){
    return criticalMass;
  }

  public void setCriticalMass(int n){
    this.criticalMass = n;
  }

  public int getNumberStatus(){
    return numberStatus;
  }

  public void setNumberStatus(int n){
    this.numberStatus = n;
  }
  
  public static void makeGrid() {
    
    for(int x = 0; x < 8; x++) {
      for(int y = 0; y < 8; y++) {
        
        Tile tile = new Tile();
        grid[x][y] = tile;
        tile.numberStatus = 0;
        tile.playerStatus = "empty";
        
        if((x == 0 || x == 7) && (y > 0 && y < 7)) {
          tile.criticalMass = 3;
        }
        else if((y == 0 || y == 7) && (x > 0 && x < 7)) {
          tile.criticalMass = 3;
        }
        else if((x == 0 || x == 7) && (y == 0 && y == 7)) {
          tile.criticalMass = 2;
        }
        else tile.criticalMass = 4;
        
      }
    }
  }

  public static void erase(int x, int y) {
    grid[x][y].numberStatus = 0;
    grid[x][y].playerStatus = "empty";
  }

  public static void play(int x, int y, Player A){
    
    if(grid[x][y].numberStatus < A.getCriticalMass() && grid[x][y].numberStatus < grid[x][y].criticalMass){
      
      if(grid[x][y].playerStatus == "empty" || grid[x][y].playerStatus == A.getShape()){
        
        grid[x][y].numberStatus++;
        grid[x][y].playerStatus = A.getShape();
        
      }
    }
    else A.disperse(x, y);
  }

  
}

//list of helpful resources
//https://www.w3schools.com/java/java_arrays_multi.asp
//https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
//https://stackoverflow.com/questions/29226036/java-storing-objects-in-a-multidimensional-array