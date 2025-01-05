import com.fazecast.jSerialComm.SerialPort;

public class LEDController {
    private SerialPort arduinoPort;

    public LEDController() {
        arduinoPort = SerialPort.getCommPort("COM3");
        arduinoPort.setBaudRate(9600);
        if (arduinoPort.openPort()) {
            System.out.println("Connected to Arduino for LED control!");
        }
    }

    public void glowEyes(String color) {
        if (arduinoPort.isOpen()) {
            String command = "EYES_" + color.toUpperCase() + "\n";
            try {
                arduinoPort.getOutputStream().write(command.getBytes());
                arduinoPort.getOutputStream().flush();
            } catch (Exception e) {
                System.err.println("Error sending LED command: " + e.getMessage());
            }
        }
    }
}
