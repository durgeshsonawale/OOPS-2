import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    private double beans, milk, water;
    private int Coffee_Count = 0;

    public int moneyBox = 0;

    public CoffeeMachine(){ //Default Constructor Initialization...
        this.beans=0;
        this.milk=0;
        this.water=0;
    }
    private void SetIngredient(){   //Calling for Filling Ingredient...
        System.out.println("\nFilling...");
        this.beans = 500.0;
        this.milk = 2000;
        this.water= 4000;
        System.out.println("Filling Completed.");
    }
    private void GetIngredient(){   //To Get Status
        System.out.println("Available Beans "+String.format("%.1f",this.beans));
        System.out.println("Available Milk(ml) "+String.format("%.1f", this.milk));
        System.out.println("Available Water(ml) "+String.format("%.1f", this.water));
    }
//    private void CleanMachine(){    //Initialization with Null in order to Clean Machine
//        System.out.println("\nCleaning Machine...");
//        this.beans = 0;
//        this.milk = 0;
//        this.water= 0;
//        System.out.println("Cleaning Completed.");
//    }
    private void makeCoffee(){  //Coffee Selection Menu
        System.out.println("\n ------------------ ");
        System.out.println("""
                |   Select Type:   |
                 ------------------\s
                | 1:  Espresso     |
                | 2:  Latte        |
                | 3:  Cappuccino   |
                | 0:  To Discard   |""");
        System.out.println(" ------------------ \n");
        char type = scan.next().charAt(0);
        switch (type) {
            case '1' -> this.Espresso();     //Call to Espresso Method
            case '2' -> this.Latte();      //Call to Latte Method
            case '3' -> this.Cappuccino();  //Call to Cappuccino Method
            case '0' -> {
            }
        }
    }
    private void Espresso(){
        if(this.beans >= 16 && this.water >= 250){
            System.out.println("\nMaking Espresso...");
            System.out.println("\nTaking 16 Beans.");
            this.beans = this.beans - 16;
            System.out.println("Taking 250ml of Water.");
            this.water = this.water - 250;
            System.out.println("\nYour Espresso is Ready.");
            this.Coffee_Count++;
            System.out.println("Please pay : 4$.");
            moneyBox += 4;
        }
        else{
            System.out.println("\nAvailable Beans "+String.format("%.1f",this.beans));
            System.out.println("Available Water(ml) "+String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please fill before Making Coffee.");
        }
    }
    private void Latte(){
        if(this.beans >= 20 && this.milk >= 75 && this.water >= 350){
            System.out.println("\nMaking Latte...");
            System.out.println("\nTaking 20 Beans.");
            this.beans = this.beans - 20;
            System.out.println("Taking 75ml of Milk.");
            this.milk = this.milk - 75;
            System.out.println("Taking 350ml of Water.");
            this.water = this.water - 350;
            System.out.println("\nYour Latte is Ready.");
            this.Coffee_Count++;
            System.out.println("Please pay : 7$.");
            moneyBox += 7;
        }
        else{
            System.out.println("\nAvailable Beans "+String.format("%.1f",this.beans));
            System.out.println("Available Milk(ml) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(ml) "+String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please fill before Making Coffee.");
        }
    }

    private void Cappuccino(){
        if(this.beans >= 12 && this.milk >= 100 && this.water >= 200){
            System.out.println("\nMaking Cappuccino...");
            System.out.println("\nTaking 20 Beans.");
            this.beans = this.beans - 12;
            System.out.println("Taking 75ml of Milk.");
            this.milk = this.milk - 100;
            System.out.println("Taking 350ml of Water.");
            this.water = this.water - 200;
            System.out.println("\nYour Cappuccino is Ready.");
            this.Coffee_Count++;
            System.out.println("Please pay : 6$.");
            moneyBox += 6;
        }
        else{
            System.out.println("\nAvailable Beans "+String.format("%.1f",this.beans));
            System.out.println("Available Milk(ml) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(ml) "+String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please fill before Making Coffee.");
        }
    }
    public void start(){    //public Start to access all private method of this class
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("|                   Coffee Machine Simulator                   |");
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("\nCurrent Status: ");
        this.GetIngredient();
        boolean status = true;
        while(status){
            System.out.println("\n -------------------------------- ");
            System.out.println("""
                    |1:     Status of Ingredient     |
                     --------------------------------\s
                    |2:      Fill Ingredient         |
                     --------------------------------\s
                    |3:        Make Coffee           |
                     --------------------------------\s
                    |4: How many Coffee We have made?|
                     --------------------------------\s
                    |5:       Amount Earned          |
                    --------------------------------\s
                    |6:           Exit               |
                    --------------------------------\s
                    |7:       Empty Money Box        |""");

            System.out.println(" -------------------------------- \n\n");
            char ans = CoffeeMachine.scan.next().charAt(0);
            switch (ans) {
                case '1' -> {
                    System.out.println("------------- Status ------------");
                    this.GetIngredient();
                    System.out.println("---------------------------------");
                }
                case '2' -> this.SetIngredient();
                case '3' -> this.makeCoffee();
                case '4' -> System.out.println("\nWe Have Made " + this.Coffee_Count + " Coffees.");
                case '5' -> System.out.println("\nTotal Earnings "+ this.moneyBox + ".");
                case '6' -> {
                    System.out.println("\nExiting...\n");
                    status = false;
                }
                case '7' -> {
                    System.out.println("Please enter machine pass :");
                    int pass = scan.nextInt();
                    if(pass == 1234) {
                        System.out.print("Money taken " + moneyBox + ".");
                        moneyBox = 0;
                    }
                    else
                    {
                        System.out.println("Wrong pass.");
                    }
                }
            }
        }
    }
}
