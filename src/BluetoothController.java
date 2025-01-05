import java.util.Scanner;

public class BluetoothController {
    public String receiveCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command for Elmo: ");
        return scanner.nextLine();
    }
}
