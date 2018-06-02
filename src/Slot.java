public class Slot {

    private String color;
    private int stones;
    private String symbol;

    public Slot(){
        color = "NONE";
        stones = 0;
        symbol = "|";
    }

    public String getColor() { return color;}

    public void setColor(String newColor){
        color = newColor;
        if (color == "BLACK")
            symbol = "X";
        else
            symbol = "0";
    }

    public void setStones(int numStones){
        stones = numStones;
    }

    public int getStones(){ return stones; }

    public String getSymbol() { return symbol; }

    public void setSymbol(String sym) { symbol = sym; }

    public void subtractStone(){ stones--; }

    public void addStone() { stones++; }
}
