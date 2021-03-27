import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static String insert(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if(string.length() != 5  ) {
            System.out.println("your command size is smaller than expected");
            return insert();
        }
        if((string.charAt(0) < 'A' || string.charAt(0) > 'C') ||
                (Character.getNumericValue(string.charAt(2)) < 1 || Character.getNumericValue(string.charAt(2)) > 3)
                    ||(Character.getNumericValue(string.charAt(4)) < 1 || Character.getNumericValue(string.charAt(4)) > 9)
                        ||(string.charAt(1) != ':' || string.charAt(3) != ':')){
            System.out.println("Please insert valid command");
            return insert();
        }
        return string;
    }
    public static void main(String[] args){
        VendorMachine vendorMachine = new VendorMachine();
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Cola());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Fanta());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Sprite());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Leys());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Doritos());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Pringles());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Twix());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new Mars());
        }
        for(int i = 0; i < 10; i++){
            vendorMachine.fillMachne(new KitKat());
        }

        Command command = new Command(insert());
        vendorMachine.initCommand(command);
        ArrayList<Product> list = vendorMachine.getProduct();

        for(Product i : list)
            System.out.println(i.toString());

    }
}
