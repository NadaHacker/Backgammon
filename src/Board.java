public class Board {
    public static final int TOTALPLACES = 28;
    protected Slot[] slotArray;

    public Board(){
        slotArray = new Slot[TOTALPLACES];
        for (int i = 0; i < TOTALPLACES; i++) {
            slotArray[i] = new Slot();
        }
        slotArray[0].setColor("BLACK");
        slotArray[0].setStones(0);

        slotArray[1].setColor("BLACK");
        slotArray[1].setStones(2);
        slotArray[6].setColor("WHITE");
        slotArray[6].setStones(5);
        slotArray[8].setColor("WHITE");
        slotArray[8].setStones(3);
        slotArray[8].setStones(3);
        slotArray[12].setColor("BLACK");
        slotArray[12].setStones(5);
        slotArray[13].setColor("WHITE");
        slotArray[13].setStones(5);
        slotArray[17].setColor("BLACK");
        slotArray[17].setStones(3);
        slotArray[19].setColor("BLACK");
        slotArray[19].setStones(5);
        slotArray[24].setColor("WHITE");
        slotArray[24].setStones(2);

        slotArray[25].setColor("WHITE");
        slotArray[25].setStones(0);

        slotArray[26].setColor("BLACK");
        slotArray[26].setStones(0);

        slotArray[27].setColor("WHITE");
        slotArray[27].setStones(0);
    }

    public void moveBearoff(String currentColor) {
        if (currentColor == "BLACK") {
            //move white to bearoff
            slotArray[25].addStone();
            slotArray[25].setColor("WHITE");
        } else {
            //move black to bearoff
            slotArray[0].addStone();
            slotArray[0].setColor("BLACK");
        }
    }


    public boolean gameOver() {
        if (slotArray[26].getStones() == 15) {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (slotArray[27].getStones() == 15) {
            System.out.println("Player 2 wins!");
            return true;
        }
        return false;
    }

    public Boolean hasBearOff(String color) {
        if (color == "BLACK") {
            if (slotArray[0].getStones() > 0) {
                return true;
            } else {
                return false;
            }
        } else if (color == "WHITE") {
            if (slotArray[25].getStones() > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isHomeMove(String color) {
        if (color == "BLACK") {
            for (int i = 0; i < 19; i++) {
                if (slotArray[i].getStones() > 0 && slotArray[i].getColor() == "BLACK") {
                    return false;
                }
            }
            return true;
        } else if (color == "WHITE") {
            for (int i = 25; i > 6; i--) {
                if (slotArray[i].getStones() > 0 && slotArray[i].getColor() == "WHITE") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
