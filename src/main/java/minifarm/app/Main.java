package minifarm.app;

import minifarm.ui.ScannerInputReader;

/**
 * Entry point aplikasi MiniFarm Simulator CLI.
 */
public class Main {
    public static void main(String[] args) {
        GameContext context = new GameContext();
        ScannerInputReader inputReader = new ScannerInputReader();
        AppController controller = new AppController(context, inputReader);
        controller.start();
    }
}

