import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nDo you want to Start Machine Y or N ?");
        char ans;
        ans = scan.next().charAt(0);
        if(ans == 'Y' || ans == 'y'){
            CoffeeMachine cm = new CoffeeMachine();     //Instances For CoffeeMachine
            cm.start();
            System.out.println("Shutting Down...\n");
        }else
            System.out.println("Shutting Down...\n");
    }
}