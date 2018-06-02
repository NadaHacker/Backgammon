import java.util.ArrayList;
import java.util.Random;

public class Dice {
    protected Random r;
    protected ArrayList<Integer> diceArray = new ArrayList<>();

    Dice(){ r = new Random(); }

    public void rollDice(){
        this.clearDice();
        int diceA = r.nextInt(6)+1;
        int diceB = r.nextInt(6)+1;
        if (diceA == diceB) {
            diceArray.add(diceA);
            diceArray.add(diceA);
            diceArray.add(diceA);
            diceArray.add(diceA);
        }
        else{
            diceArray.add(diceA);
            diceArray.add(diceB);
        }
    }

    public void clearDice(){
        for (int i =0; diceArray.size() != 0; i++){
            diceArray.remove(0);
        }
    }

    public void removeDice(int dice){
        diceArray.remove(diceArray.indexOf(dice));
    }

    public boolean isDice(int dice){
        return diceArray.contains(dice);
    }

    public boolean isHomeMoveDice(int num){
        if (diceArray.size() >1) {
            if (num > diceArray.get(0) || num > diceArray.get(1)) {
                // no dice is big enough
                return false;
            }
        }
        else{
            if (num > diceArray.get(0)){
                return false;
            }
        }
        return true;
    }
    public int diceHome(int num){ // num == 5
        int smaller;
        if (diceArray.size() >1) {
            if (diceArray.get(0) == diceArray.get(1)) {
                return diceArray.get(0);
            }
            if (diceArray.get(0) < diceArray.get(1)) {
                smaller = diceArray.get(0);
            } else {
                smaller = diceArray.get(1);
            }
            if (num <= smaller) {
                return smaller;
            } else if (num < diceArray.get(0) && num < diceArray.get(1)) {
                if (diceArray.get(0) < diceArray.get(1)) {
                    return diceArray.get(0);
                } else {
                    return diceArray.get(1);
                }
            }
        }
        else{
            return diceArray.get(0);
        }
        return 0;
    }

    public String firstMove(){
        this.rollDice();
        while (this.diceArray.get(0) == this.diceArray.get(1)){
            this.clearDice();
            this.rollDice();
        }
        if (this.diceArray.get(0) > this.diceArray.get(1)){
            return "BLACK";
        }
        else{
            return "WHITE";
        }
    }
}
