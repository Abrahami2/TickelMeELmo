import com.fazecast.jSerialComm.SerialPort;

public class SmokeMachineController {
    private SerialPort arduinoPort;

    public SmokeMachineController() {
        arduinoPort = SerialPort.getCommPort("COM3");
        arduinoPort.setBaudRate(9600);
        if (arduinoPort.openPort()) {
            System.out.println("Connected to Arduino for Smoke Machine control!");
        }
    }

    public void emitSmoke() {
        sendCommand("SMOKE_ON");
    }

    public void stopSmoke() {
        sendCommand("SMOKE_OFF");
    }

    private void sendCommand(String command) {
        if (arduinoPort.isOpen()) {
            try {
                arduinoPort.getOutputStream().write((command + "\n").getBytes());
                arduinoPort.getOutputStream().flush();
            } catch (Exception e) {
                System.err.println("Error sending smoke machine command: " + e.getMessage());
            }
        }
    }
}
