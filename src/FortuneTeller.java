import java.util.Arrays;
import java.util.Scanner;

public class FortuneTeller {
    private Scanner reader;
    private String firstName;
    private String lastName;
    private int age;
    private int monthOfBirth;
    private String color;
    private int numberOfSiblings;


    public FortuneTeller(){
        this.reader = new Scanner(System.in);
    }

    public void askQuestions() {
        System.out.println(" ****** menu ******  \n At any time you can type:\n " +
                "-> Quit - to quit, but don't you'll miss out on all the fun!\n" +
                "\n Let's begin the seance! \n I'll ask questions first and then I'll tell your future.\n");
        System.out.println("What's your first name? ");

        firstName = reader.nextLine();
        quitCheck(firstName);

        System.out.println("What's your last name? ");

        lastName = reader.nextLine();
        quitCheck(lastName);

        System.out.println("How old are you?");

        String years = reader.nextLine();
        quitCheck(years);
        age = Integer.parseInt(years);


        System.out.println("Put in your birth month as a number. ");

        String month = reader.nextLine();
        quitCheck(month);
        monthOfBirth = Integer.parseInt(month);

        do {
            System.out.println("What's your favourite ROYGBIV color?");
            color = reader.nextLine();
            quitCheck(color);
        }while(help(color));

        System.out.println("How many siblings do have?");

        String siblings = reader.nextLine();
        quitCheck(String.valueOf(siblings));
        numberOfSiblings = Integer.parseInt(siblings);
    }

    private void quitCheck(String input){
        if(input.equalsIgnoreCase("Quit")){
            System.out.println("Nobody likes quitters...");
            System.exit(0);
        }
    }

    private boolean help(String input){

        if(input.equalsIgnoreCase("Help")) {
            System.out.println("The ROYGBIV colors are red, orange, yellow, green, blue, indigo, violet.");
            return true;
        }
        return false;
    }

    public void tellTheFortune(){

        System.out.println( firstName +" "+ lastName + " will retire in "+ yearsUntilRetire() +" years with "+ bankBalance()
        +" in the bank, a vacation home in "+ location() +", and travel by " +transportation()+ ".");
    }

    private String location() {
        if(numberOfSiblings < 0 ){
            return "nowhere";
        }else {
            switch (numberOfSiblings) {
                case 0:
                    return "Nebraska";
                case 1:
                    return "Norway";
                case 2:
                    return "Neverland";
                case 3:
                    return "the Moon";
                default:
                    return "Shire";
            }
        }
    }

    private String transportation(){
        String[] locations = new String[]{"zebra", "hot air balloon", "bike", "rocker", "Tesla","Santa's sleigh", "fairy dust"};
        String[] colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
        if(Arrays.asList(colors).contains(color)){
            return locations[Arrays.asList(colors).indexOf(color)];
        }else{
            return "foot";
        }
    }

    private String bankBalance() {
        if(monthOfBirth > 0 && monthOfBirth < 5){
            return "$ 1 234.45";
        }else if (monthOfBirth < 9){
            return "$ 12 345.67";
        }else if (monthOfBirth < 13){
            return "$ 123 456.78";
        }else{
            return "$ 1.23";
        }
    }

    private String yearsUntilRetire() {
        if(age%2 == 0){
            return "13";
        }else{
            return "31";
        }
    }
}
