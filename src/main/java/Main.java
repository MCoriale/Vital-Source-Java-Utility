import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args){
        System.out.println("Running main");
        KeyBoardInteractor interactor = new KeyBoardInteractor();
        //interactor.quickTrialInteractions();
        interactor.addDelay(5);
        interactor.handleOneInputInteraction(new Range(3, 4));
        //System.out.println(KeyEvent.VK_3);
    }

}
