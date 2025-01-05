public class ElmoController {
    private SoundPlayer soundPlayer;
    private MovementController movementController;
    private LEDController ledController;
    private SmokeMachineController smokeMachineController;
    private BluetoothController bluetoothController;

    public ElmoController() {
        soundPlayer = new SoundPlayer();
        movementController = new MovementController();
        ledController = new LEDController();
        smokeMachineController = new SmokeMachineController();
        bluetoothController = new BluetoothController();
    }

    public void start() {
        System.out.println("Tickle Me Elmo is starting...");

        // Startup sequence
        soundPlayer.playSound("hello.wav");
        ledController.glowEyes("red");
        movementController.dance();
        smokeMachineController.emitSmoke();

        // Listen for user input
        while (true) {
            String command = bluetoothController.receiveCommand();
            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        switch (command) {
            case "LAUGH":
                soundPlayer.playSound("laugh.wav");
                break;
            case "DANCE":
                movementController.dance();
                break;
            case "SMOKE_ON":
                smokeMachineController.emitSmoke();
                break;
            case "SMOKE_OFF":
                smokeMachineController.stopSmoke();
                break;
            case "EYES_RED":
                ledController.glowEyes("red");
                break;
            case "EYES_BLUE":
                ledController.glowEyes("blue");
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
