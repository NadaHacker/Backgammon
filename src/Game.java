import java.util.ArrayList;

public class Game implements Subject{
    protected Dice dice = new Dice();
    protected Board board;
    protected String currentColor;
    protected int slotFrom = 100;
    protected int slotTo = 100;
    protected boolean firstInput;
    protected boolean done;
    protected ArrayList<Observer> observer;

    Game(){
        this.board = new Board();
        firstInput = true;
        currentColor = dice.firstMove();
        observer = new ArrayList();
    }

    public void notifyObserver(){
        for (Observer observer: observer){
            observer.update();
        }
    }

    public void register(Observer o){
        observer.add(o);
    }

    public void setSlotMove(int slot){
        if (firstInput) {
            slotFrom = slot;
            firstInput = false;
        }
        else{
            slotTo = slot;
            firstInput = true;
        }
        if(firstInput && slotTo != 100 && slotFrom != 100) {
            theLoop();
        }
    }

    public void theLoop() {
        if (!done) {
            if (moveOption()) {
                if (checkMove(slotFrom, slotTo)) {
                    doMove(slotFrom, slotTo);
                    notifyObserver();
                    if (dice.diceArray.size() == 0) {
                        switchTurns();
                    }
                } else {
                    System.out.println("Invalid Move");
                    notifyObserver();
                }
            } else {
                System.out.println("There is no possible move");
                System.out.println();
                switchTurns();
            }
        }
    }

    public void doMove(int from, int to) {
        if (board.isHomeMove(currentColor)) {
            if (currentColor == "BLACK") {
                dice.removeDice(dice.diceHome(Math.abs(from-to)));
            } else if (currentColor == "WHITE") {
                dice.removeDice(dice.diceHome(Math.abs(from-to)));
            }
            board.slotArray[to].addStone();
            board.slotArray[to].setColor(currentColor);
            board.slotArray[from].subtractStone();
            return;
        }
        board.slotArray[from].subtractStone();
        if (board.slotArray[from].getStones() == 0 && from != 25 && from != 0) {
            board.slotArray[from] = new Slot();
            dice.removeDice(Math.abs(from-to));
        }
        else{
            dice.removeDice(Math.abs(from-to));
        }

        // if its bearof
        if (board.slotArray[to].getStones() == 1 && board.slotArray[to].getColor() != currentColor) {
            board.slotArray[to].setColor(currentColor);
            board.moveBearoff(currentColor);
        }
        else {
            board.slotArray[to].addStone();
            board.slotArray[to].setColor(currentColor);
        }
    }

    public void switchTurns() {
        if (currentColor == "BLACK") {
            System.out.println("Player 2's turn!");
            currentColor = "WHITE";
        } else {
            System.out.println("Player 1's turn!");
            currentColor = "BLACK";
        }
        dice.rollDice();
        done = board.gameOver();
        notifyObserver();
    }


    public boolean checkMove(int from, int to) {
        if (from == to) {
            // not valid
            return false;
        }
        // is from slot the right color
        if (board.slotArray[from].getColor() != currentColor) {
            //invalid
            //System.out.println("from not right color");
            return false;
        }
        // is to slot valid for the move
        if (board.slotArray[to].getColor() != currentColor && board.slotArray[to].getColor() != "NONE"
                && board.slotArray[to].getStones() != 1) {
            // valid
            //System.out.println("Slot to is valid");
            return false;
        }
        if (board.isHomeMove(currentColor) == false) {
            if (board.hasBearOff(currentColor) == false) {
                // is normal move

                // is the slot difference one of the dice options
                if (!dice.isDice(Math.abs(from - to))) {
                    //invalid
                    //System.out.println("option not a dice");
                    return false;
                }

                // slots are in range
                if (from > 24 || from < 1 || to > 24 || to < 1) {
                    // invalid
                    ///System.out.println("slot out of range");
                    return false;
                }
                // is the move in the right direction
                if (currentColor == "BLACK") {
                    if (to <= from) {
                        //invalid
                        ///System.out.println("move in wrong direction");
                        return false;
                    }
                } else if (currentColor == "WHITE") {
                    if (to >= from) {
                        //invalid
                        //System.out.println("move in wrong direction");
                        return false;
                    }
                }
            }
            // is bear off
            else {
                if (currentColor == "BLACK") {
                    if (from != 0) {
                        // move is not from bearof
                        //System.out.println("Slot is not from bearoff");
                        return false;
                    }
                    // slots are in range
                    if (to > 6 || to < 1) {
                        // invalid
                        //System.out.println("slot out of range");
                        return false;
                    }
                } else if (currentColor == "WHITE") {
                    if (from != 25) {
                        // move is not from bearof
                        //System.out.println("Slot is not from bearoff");
                        return false;
                    }
                    // slots are in range
                    if (to < 19 || to > 24) {
                        // invalid
                        ///System.out.println("slot out of range");
                        return false;
                    }
                }
            }
        }
        // is home slot
        else {

            if (from > 25) {
                // not from a valid position
                return false;
            }
            // is the move in the right direction
            if (currentColor == "BLACK") {
                if (to <= from) {
                    //invalid
                    //System.out.println("move in wrong direction");
                    return false;
                }
                if (to == 25) {
                    // is the slot difference one of the dice options
                    if (!dice.isHomeMoveDice(to - from)) {
                        //invalid
                        //System.out.println("dice not big enough");
                        return false;
                    }
                }
                // is the slot difference one of the dice options
                else if ((slotTo-1)-slotFrom > dice.diceHome((slotTo-1)-slotFrom)) {
                    //invalid
                    //System.out.println("option not a dice");
                    return false;
                }
            } else if (currentColor == "WHITE") {
//                if (to >= from) {
//                    //invalid
//                    //System.out.println("move in wrong direction");
//                    return false;
//                }
                if (to == 0) {
                    // is the slot difference one of the dice options
                    if (!dice.isHomeMoveDice(from - to)) {
                        return false;
                    }
                }
//                // is the slot difference one of the dice options
//                if (!dice.isHomeMoveDice(27-(to - from)))  {
//                    return false;
//                }
            }
        }
        return true;
    }

    public boolean moveOption() {
        boolean valid = false;
        if (currentColor == "BLACK") {
            if (!board.isHomeMove(currentColor)) {
                for (int i = 0; i < 26; i++) {
                    int temp = i + dice.diceArray.get(0);
                    if (temp < 28) {
                        if (checkMove(i, temp)) {
                            return true;
                        }
                    }
                    if (dice.diceArray.size() > 1) {
                        temp = i + dice.diceArray.get(1);
                        if (temp < 28) {
                            if (dice.diceArray.size() > 1) {
                                if (checkMove(i, temp)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }else {
                valid = true;
            }
        }
        if (currentColor == "WHITE") {
            if (!board.isHomeMove(currentColor)) {
                for (int i = 0; i < 26; i++) {
                    int temp = i - dice.diceArray.get(0);
                    if (temp > 0) {
                        if (checkMove(i, temp)) {
                            return true;
                        }
                    }
                    if (dice.diceArray.size() > 1) {
                        temp = i - dice.diceArray.get(1);
                        if (temp > 0) {
                            if (dice.diceArray.size() > 1) {
                                if (checkMove(i, temp)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }else{
                valid = true;
            }
        }
        return valid;
    }
}
