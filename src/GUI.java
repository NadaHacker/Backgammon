import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GUI extends JPanel implements Observer {

    private Game game;
    protected boolean done;
    static final int[] topHalf = {13, 14, 15, 16, 17, 18, 25, 19, 20, 21, 22, 23, 24, 26};
    static final int[] bottomHalf = {12, 11, 10, 9, 8, 7, 0, 6, 5, 4, 3, 2, 1, 27};

    public GUI(Game g){
        game = g;
        done = false;
        game.register(this);

        this.addMouseListener(new MouseAdapter() {// provides empty implementation of all
            // MouseListener`s methods, allowing us to
            // override only those which interests us
            @Override //I override only one method for presentation
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int[] slots;
                int leftX = 30;
                int rightX = getWidth()/10;
                int vertHalf = getHeight()/2;
                int index = 0;
                int slotDis = getWidth()/13-getWidth()/80-1;

                if (y < vertHalf){
                    slots = topHalf;
                }
                else{
                    slots = bottomHalf;
                }
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX-2, rightX-2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+1, rightX+1, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }

                //-----
                index++;
                leftX += slotDis+3;
                rightX += slotDis+3;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+2, rightX+2, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis+getWidth()/12/2;
                rightX += slotDis+getWidth()/12/2;
                if (x > leftX && x < rightX && y > vertHalf){
                    System.out.println("slot " + slots[index]);
                    markBottom(getGraphics(), leftX+1, rightX+1, getHeight()-getHeight()/22);
                    game.setSlotMove(slots[index]);
                }

                //------------------------------------------------------------------------------

                index = 0;
                leftX = 30;
                rightX = getWidth()/10;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX, rightX, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }

                //-------------------

                index++;
                leftX += slotDis+3;
                rightX += slotDis+3;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis;
                rightX += slotDis;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
                index++;
                leftX += slotDis+getWidth()/12/2;
                rightX += slotDis+getWidth()/12/2;
                if (x > leftX && x < rightX && y < vertHalf ){
                    System.out.println("slot " + slots[index]);
                    markTop(getGraphics(), leftX+2, rightX+2, getHeight()/21);
                    game.setSlotMove(slots[index]);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Image bufferImage = createImage(860, 654);
        paintInitial(bufferImage.getGraphics());
        int width = getWidth();
        int height = getHeight();
        ReplicateScaleFilter crop =
                new ReplicateScaleFilter(width, height);
        ImageProducer prod = new FilteredImageSource(bufferImage.getSource(), crop);
        FilteredImageSource fis = new FilteredImageSource(prod, crop);
        Image croppedImage = createImage(fis);
        g.drawImage(croppedImage, 0, 0, null);
    }

    public void markTop(Graphics g, int lx, int rx, int y){
        g.fillRect(lx-1, y-20, rx-lx, y-10);
    }

    public void markBottom(Graphics g, int lx, int rx, int y){
        g.fillRect(lx, y, rx-lx, 20);
    }

    public void paintInitial(Graphics g) {
        Board copyBoard = new Board();
        for (int i = 0; i < 28; i++) {
            copyBoard.slotArray[i].setStones(game.board.slotArray[i].getStones());
            copyBoard.slotArray[i].setColor(game.board.slotArray[i].getColor());
            copyBoard.slotArray[i].setSymbol(game.board.slotArray[i].getSymbol());
        }

        int width = 860;
        int height = 654;
        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.ORANGE);
        g.fillRect(30, 30, width - 152, height - 59);
        g.setColor(Color.gray);
        g.fillRect(width / 2 - 76, 30, 60, height - 59);

        g.setColor(Color.ORANGE);
        g.fillRect(width - 90, 30, 60, height - 59);

        printSection(g, 30, 84, 57, 30, 300, true,
                topHalf, 0, 29, false, copyBoard);
        printSection(g, 414, 468, 441, 30, 300, true,
                topHalf, 7, 29, true, copyBoard);
        printSection(g, 30, 84, 57,height-29,height-298, false,
                bottomHalf,0, height-83, false, copyBoard);
        printSection(g, 414, 468, 441, height-29, height-298, false,
                bottomHalf,7, height-83, true, copyBoard);

        if (game.dice.diceArray.size() == 1) {
            dice(g, 0, game.dice.diceArray.get(0));
        }
        else if (game.dice.diceArray.size() == 2) {
            dice(g, 0, game.dice.diceArray.get(0));
            dice(g, 110, game.dice.diceArray.get(1));
        }
        else if (game.dice.diceArray.size() > 2){
            dice(g, 0, game.dice.diceArray.get(0));
            dice(g, 110, game.dice.diceArray.get(1));
        }

        g.setFont(new Font("font", Font.BOLD, 20));
        g.setColor(Color.black);
        if (game.done){
            if (game.board.slotArray[26].getStones() == 15) {
                g.drawString("Pink Wins!", 530, 330);
            }
            else{
                g.drawString("White Wins!", 530, 330);
            }
        }
        else {
            if (game.currentColor == "BLACK") {
                g.drawString("Pink's Turn", 530, 330);
            } else if (game.currentColor == "WHITE") {
                g.drawString("White's Turn", 520, 330);
            }
        }
    }

    public void update(){
        this.repaint();
    }

    public void printSection(Graphics g, int leftX, int rightX, int highX, int leftY, int highY,
                             boolean top, int[] slot, int index, int circStart, boolean extra , Board cp) {
        for (int w = 0; w < 7; w++) {
            printTriangles(g, leftX, rightX, highX, leftY, highY, slot[index]);
            leftX += 54;
            rightX += 54;
            highX += 54;
            index++;
        }
        for (int w = 0; w < 7; w++) {
            if (w == 6){
                if (extra == false)
                    leftX+=2;
                else{
                    leftX+=35;
                }
            }
            printTokens(g, top, slot[index-7], leftX-(54*7), circStart, cp.slotArray[slot[index-7]].getColor() , cp);
            leftX += 54;
            index++;
        }
    }

    public void printTriangles(Graphics g, int leftX, int rightX, int highX, int leftY, int highY, int slot){

        if (slot != 0 && slot != 25 && slot != 26 && slot != 27) {
            Polygon p = new Polygon();
            p.addPoint(leftX, leftY);
            p.addPoint(rightX, leftY);
            p.addPoint(highX, highY);
            g.setColor(new Color(148,0,211));
            g.fillPolygon(p);
        }
    }

    public void printTokens(Graphics g, boolean top, int slot, int circX, int circY, String color, Board cp) {

        Color currColor;
        if (color == "BLACK") {
            currColor = Color.magenta;
        } else {
            currColor = Color.WHITE;
        }
        int count = 0;
        int startX = circX;
        int startY = circY;
        while (cp.slotArray[slot].getStones() != 0) {
            if (count == 5 || count == 10){
                circX = startX + 4;
                startX += 4;
                if (top) {
                    circY = startY + 4;
                    startY += 4;
                }
                else{
                    circY = startY -4;
                    startY -= 4;
                }
            }
            g.setColor(Color.BLACK);
            g.fillOval(circX, circY, 54, 54);
            g.setColor(currColor);
            g.fillOval(circX+2, circY+2, 50, 50);
            if (top) {
                circY += 54;
            }
            else{
                circY -= 54;
            }
            cp.slotArray[slot].subtractStone();
            count++;
        }
    }

    public void dice(Graphics g, int shift, Integer d){
        int width = 117 + shift;
        int height = 305;
        g.setColor(Color.WHITE);
        g.fillRect(width, height, 40, 40);
        g.setColor(Color.BLACK);
        if (d == 1){
            dice1(g, shift);
        }
        else if (d == 2){
            dice2(g, shift);
        }
        else if (d == 3){
            dice3(g, shift);
        }
        else if (d == 4){
            dice4(g, shift);
        }
        else if (d == 5){
            dice5(g, shift);
        }
        else if (d == 6){
            dice6(g, shift);
        }
    }

    public void dice1(Graphics g, int shift) {
        g.fillOval(132+ shift, 320, 10, 10);
    }

    public void dice2(Graphics g, int shift) {
        g.fillOval(142+ shift, 310, 10, 10);
        g.fillOval(122+ shift, 330, 10, 10);
    }

    public void dice3(Graphics g, int shift) {
        dice2(g, shift);
        g.fillOval(132+ shift, 320, 10, 10);
    }

    public void dice4(Graphics g, int shift) {
        dice2(g, shift);
        g.fillOval(122+ shift, 310, 10, 10);
        g.fillOval(142+ shift, 330, 10, 10);
    }

    public void dice5(Graphics g, int shift) {
        dice3(g, shift);
        g.fillOval(122+ shift, 310, 10, 10);
        g.fillOval(142+ shift, 330, 10, 10);
    }

    public void dice6(Graphics g, int shift) {
        dice4(g, shift);
        g.fillOval(122+ shift, 320, 10, 10);
        g.fillOval(142+ shift, 320, 10, 10);
    }
}
