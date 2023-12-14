import java.util.Scanner;

public class SpaceAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Space Adventure Game!");
        System.out.println("You are a space explorer on a mission to reach the center of the mysterious galaxy.");

        while (true) {
            System.out.println("\nChoose your action:");
            System.out.println("1. Warp through a wormhole");
            System.out.println("2. Investigate an abandoned space station");
            System.out.println("3. Navigate through an asteroid field");

            int choice = getUserChoice(scanner, 3);

            switch (choice) {
                case 1:
                    System.out.println("You chose to warp through a wormhole. It propels you to a distant region of the galaxy.");
                    System.out.println("You discover an ancient alien artifact that enhances your ship's capabilities.");
                    System.out.println("You continue your journey with improved technology.");
                    break;
                case 2:
                    System.out.println("You decide to investigate an abandoned space station. Inside, you find valuable resources.");
                    System.out.println("However, the station is haunted by malfunctioning AI. You narrowly escape.");
                    System.out.println("You continue your journey with valuable resources.");
                    break;
                case 3:
                    System.out.println("You choose to navigate through an asteroid field. It's a risky path, but you successfully maneuver through.");
                    System.out.println("You find a hidden space outpost where friendly traders offer to upgrade your ship.");
                    System.out.println("You continue your journey with a faster and more resilient spacecraft.");
                    break;
            }

            System.out.println("As you approach the center of the galaxy, you encounter a massive celestial anomaly.");
            System.out.println("Your decisions have led you to this moment. What will you do?");
            System.out.println("1. Attempt to communicate with the anomaly");
            System.out.println("2. Engage in a defensive stance");

            choice = getUserChoice(scanner, 2);

            if (choice == 1) {
                System.out.println("You attempt to communicate with the anomaly. Surprisingly, it responds with a message.");
                System.out.println("The anomaly reveals ancient knowledge and grants you the status of a cosmic guardian.");
                System.out.println("Congratulations! You have successfully reached the center of the galaxy. Game over.");
            } else {
                System.out.println("You engage in a defensive stance, but the anomaly unleashes a powerful energy surge.");
                System.out.println("Your ship is damaged, and you find yourself drifting in space. Game over.");
            }

            break;
        }

        scanner.close();
    }

    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        boolean validInput = false;

        do {
            System.out.print("Enter your choice (1-" + maxChoice + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
        } while (!validInput);

        return choice;
    }
}