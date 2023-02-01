import java.util.ArrayList;

public abstract class Player {
  protected String name;
  protected String shape;
  protected int locationX, locationY, criticalMass;

  public static ArrayList<Player> playerList = new ArrayList<>();

  public Player(String n, String s, int LX, int LY, int CM){
    name = n;
    shape = s;
    locationX = LX;
    locationY = LY;
    criticalMass = CM;
    playerList.add(this);
  }

  public String getName(){
    return name;
  }

  public String getShape(){
    return shape;
  }

  public int getLocationX(){
    return locationX;
  }

  public int getLocationY(){
    return locationY;
  }

  public int getCriticalMass(){
    return criticalMass;
  }

  
  
  public void click(int x, int y) {
    Tile.play(x, y, this);
    Tile.nextTurn();
  }
  
  public abstract void disperse(int x, int y);
}