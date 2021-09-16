import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyBoardInteractor {
    private Robot keyboardRobot;

    public KeyBoardInteractor() {
        try {
            this.keyboardRobot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void handleOneInputInteraction(Range currentRange){
        this.bringUpPrintScreen();
        this.enterPagesOnPrintScreen(currentRange);
        this.addDelay(60);
        this.handlePrintingScreenWindow();

    }

    private void bringUpPrintScreen(){
        this.keyboardRobot.delay(100);
        this.keyboardRobot.keyPress(KeyEvent.VK_CONTROL);
        this.keyboardRobot.keyPress(KeyEvent.VK_P);
        this.keyboardRobot.keyRelease(KeyEvent.VK_CONTROL);
        this.keyboardRobot.keyRelease(KeyEvent.VK_P);
        this.keyboardRobot.delay(100);
    }

    private void enterPagesOnPrintScreen(Range currentRange){
        clearField();
        enterPageValue(currentRange.start);
        this.keyboardRobot.keyPress(KeyEvent.VK_TAB);
        this.keyboardRobot.keyRelease(KeyEvent.VK_TAB);
        clearField();
        enterPageValue(currentRange.end);
        this.keyboardRobot.keyPress(KeyEvent.VK_TAB);
        this.keyboardRobot.keyRelease(KeyEvent.VK_TAB);
        this.keyboardRobot.delay(100);
        this.keyboardRobot.keyPress(KeyEvent.VK_ENTER);
        this.keyboardRobot.delay(100);
        this.keyboardRobot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void enterPageValue(int value){
        ArrayList<Integer> asciiValues = this.convertNumberToASCII(value);
        for(Integer current: asciiValues){
            this.keyboardRobot.delay(100);
            this.keyboardRobot.keyPress(current);
            this.keyboardRobot.keyRelease(current);
        }
    }

    private void clearField(){
        for(int i = 0; i < 4; i++) {
            this.keyboardRobot.delay(100);
            this.keyboardRobot.keyPress(KeyEvent.VK_DELETE);
            this.keyboardRobot.delay(100);
            this.keyboardRobot.keyRelease(KeyEvent.VK_DELETE);
        }
    }

    private void handlePrintingScreenWindow(){
        this.keyboardRobot.delay(100);
        this.keyboardRobot.keyPress(KeyEvent.VK_F);
        this.keyboardRobot.keyRelease(KeyEvent.VK_F);
        this.keyboardRobot.keyPress(KeyEvent.VK_O);
        this.keyboardRobot.keyRelease(KeyEvent.VK_O);
        this.keyboardRobot.delay(100);
        for(int i = 0; i < 12; i++) {
            this.keyboardRobot.keyPress(KeyEvent.VK_TAB);
            this.keyboardRobot.keyRelease(KeyEvent.VK_TAB);
            this.keyboardRobot.delay(100);
        }
        this.keyboardRobot.keyPress(KeyEvent.VK_ENTER);
        this.keyboardRobot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void handleAllInteractions(){}

    public void quickTrialInteractions(){
        this.keyboardRobot.keyPress(KeyEvent.VK_CONTROL);
        this.keyboardRobot.keyPress(KeyEvent.VK_SHIFT);
        this.keyboardRobot.keyPress(KeyEvent.VK_ESCAPE);
    }

    public void addDelay(int seconds){
        int milliseconds = seconds * 1000;
        this.keyboardRobot.delay(milliseconds);
    }

    public ArrayList<Integer> convertNumberToASCII(int value){
        ArrayList<Integer> valueInASCII = new ArrayList<Integer>();
        while(value > 0){
            int digit = value % 10;
            digit = digit + 48;
            valueInASCII.add(0, digit);
            value = value / 10;
        }
        return valueInASCII;
    }

}
