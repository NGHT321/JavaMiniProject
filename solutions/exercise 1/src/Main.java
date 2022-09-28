import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("What would you like to set up?");
        System.out.println("1. Stopwatch");
        System.out.println("2. Timer");
        System.out.println("3. Exit");

        String choice = SCANNER.nextLine().trim();

        if(choice.equals("1") || choice.equalsIgnoreCase("Stopwatch")) {
            activateStopwatch();
        } else if (choice.equals("2") || choice.equalsIgnoreCase("Timer")) {
            activateTimer();
        }
        else if(choice.equals("3") || choice.equalsIgnoreCase("Exit")){
            System.exit(0);
        }
        else {
            System.err.println("Invalid input.");
        }
    }

    private static void activateTimer() {
        try {
            System.out.println("Enter the hours: ");
            int hours = SCANNER.nextInt();

            System.out.println("Enter the minutes: ");
            int minutes = SCANNER.nextInt();

            System.out.println("Enter the seconds: ");
            int seconds = SCANNER.nextInt();

            Timer timer = new Timer(new Time(0, 0, 0).add(new Time(hours, minutes, seconds)));
            System.out.println("Starting timer...");
            new Thread(timer).start();
        } catch (Exception e) {
            System.err.println("Invalid input.");
        }
    }

    private static void activateStopwatch() {
        Stopwatch stopwatch = new Stopwatch(new Time(0, 0, 0));
        System.out.println("Starting stopwatch...");
        new Thread(stopwatch).start();
    }
}
