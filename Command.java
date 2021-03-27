public class Command {
    public char productType;
    public int productID;
    public int count;
    public Command(String command){
        if(command.length() >= 5 && command.charAt(1) == ':' && command.charAt(3) == ':' ) {

            if (command.charAt(0) == 'A' || command.charAt(0) == 'B' || command.charAt(0) == 'C')
                productType = command.charAt(0);
            if(Character.getNumericValue(command.charAt(2)) >= 0 && Character.getNumericValue(command.charAt(2)) <= 3)
                productID = Character.getNumericValue(command.charAt(2));
            if(Character.getNumericValue(command.charAt(4)) >= 0 && Character.getNumericValue(command.charAt(4)) <= 9)
                count = Character.getNumericValue(command.charAt(4));

        }
    }
}
