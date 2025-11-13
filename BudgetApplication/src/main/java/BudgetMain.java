
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author noahn
 */
import java.util.ArrayList;
import java.util.Scanner;  
        
public class BudgetMain 
{
    // Global variables used
    // crate a scanner for input
    static Scanner scan = new Scanner(System.in);
    static String income;
    static String standard = " ";

    static BudgetLogic budget1; 
    // global counter variables for each running totals of categories. 
    double currentNeedsTotal = 0; 
    double currentWantsTotal = 0;
    double currentSavingsTotal = 0; 
    
    static ArrayList<String> needNames = new ArrayList<>();
    static ArrayList<Double> needAmounts = new ArrayList<>();
    
    static ArrayList<String> wantNames = new ArrayList<>();
    static ArrayList<Double> wantAmounts = new ArrayList<>();
    
    static ArrayList<String> savingsNames = new ArrayList<>();
    static ArrayList<Double> savingAmounts = new ArrayList<>();
    
    // recursive function to add up arraylist amounts. takes a list, takes the last 
    // value of that list, creates a sublist that removes that last value and passes that 
    // sublist through the recursive function to get the next item. 
    public static double recursiveSum(ArrayList<Double> list)
    {
        int size = list.size(); 
        
        if(size == 0)
        {
            return 0;
        }
        else
        {
            // start with the last value
            double lastValue = list.get(size-1);
            
            // create a new list without the last value of the list versoin you are in
            ArrayList<Double> sublist = new ArrayList<>(list.subList(0, size-1));
            
            return lastValue + recursiveSum(sublist);
        }
        
    }
    
    public static void needsSummary() {
        System.out.println("-----Needs-----");
        if (needNames.isEmpty()) 
        {
            System.out.println("No spending has occured");
        }
        else 
        {
            for (int i=0; i < needNames.size(); i++) 
            {
                System.out.println( needNames.get(i) + " : $" + needAmounts.get(i) + "\n");
            }
            System.out.printf("Remaining Balance: $%.2f%n", (budget1.getNeedsTotal() - recursiveSum(needAmounts)));
            System.out.printf("Needs Total Spent: $%.2f%n", recursiveSum(needAmounts));
        }
    }
    
    public static void wantsSummary() {
        System.out.println("-----Wants-----");
        if (wantNames.isEmpty()) 
        {
            System.out.println("No spending has occured");
        }
        else 
        {
            for (int i=0; i < wantNames.size(); i++) 
            {
                System.out.println( wantNames.get(i) + " : $" + wantAmounts.get(i) +"\n");
            }
            System.out.printf("Remaining Balance: $%.2f%n", (budget1.getWantsTotal() - recursiveSum(wantAmounts)));
            System.out.printf("Wants Total Spent: $%.2f%n", recursiveSum(wantAmounts));
        }
    }
    
    public static void savingsSummary() 
    {
        System.out.println("-----Savings-----");
        if (savingAmounts.isEmpty()) 
        {
            System.out.println("No savings spending has occured");
            System.out.println("Balance: $" + (budget1.getSavingsTotal()));
        }
        else 
        {
            for (int i=0; i < savingAmounts.size(); i++) 
            {
               System.out.println(savingsNames.get(i) + " : $" + savingAmounts.get(i) + "\n");
            }
            System.out.printf("Savings Total: $%.2f%n", recursiveSum(savingAmounts));
            System.out.printf("Total Savings: $%.2f%n", budget1.getSavingsTotal() + recursiveSum(savingAmounts));
        }
    }
    
    // Exception handling - FOR DOUBLES 
    public static double validateDouble(String prompt)
    {
        while(true)
        {
            double value; 
            try
            {
                System.out.println(prompt);
                value = Double.parseDouble(scan.nextLine().trim());
                
                if (value < 0)
                {
                    System.out.println("Make sure you enter a positive double as your entry.");
                    continue; // restarts the while loop
                }
                return value; 
            }
            catch(NumberFormatException e)
            {
                System.out.println("Make sure you enter a number as your entry.");
            }
        }
    }
    
    // EXCEPTION HANDLING FOR INTEGERS
    public static int validateInt(String prompt)
    {
        while(true)
        {
            int value; 
            try
            {
                System.out.println(prompt);
                value = Integer.parseInt(scan.nextLine().trim());
                
                if(value < 0)
                {
                    System.out.println("Make sure you enter a valid positive integer as your entry.");
                    continue;
                }
                return value;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Make sure you enter a number as your entry.");
            }
        }
    }
    
    public static void main(String[] args) 
    {
    //loops for input,output, and adding items to correct categories
    Double incomeChecked = validateDouble("What is your income for this month? ");
     
    budget1 = new BudgetLogic(incomeChecked);
    budget1.calculateCategories();
    
    //user menu where they can add things, view summaries, and exit
    boolean menu = true;
    while (menu) {
        String stringInput;
        double costInput; 
        System.out.println("-----Menu-----");
        System.out.println("1 - Add Needs");
        System.out.println("2 - Add Wants");
        System.out.println("3 - Add Savings");
        System.out.println("4 - View Needs Summary");
        System.out.println("5 - View Wants Summary");
        System.out.println("6 - View Savings Summary"); //IDK if we want this or not - removed reset percentages
        System.out.println("7 - Exit");
        
        int choice = validateInt("Enter your menu selection selection.");
        
        if (choice == 1) {
            int num = validateInt("How many expenses are you entering under the Needs category this month?:");
            for (int i=0; i < num; i++) {
                System.out.println("Name of expense: ");
                stringInput = scan.nextLine();
                needNames.add(stringInput);
                
                costInput = validateDouble("Expense amount:");
                needAmounts.add(costInput);
                budget1.addNeed(costInput);
            }
        }
        else if (choice == 2) {
            int num = validateInt("How many expenses are you entering under the Wants category this month?");
            for (int i=0; i < num; i++) {
                System.out.println("Name of expense: ");
                stringInput = scan.nextLine();
                wantNames.add(stringInput);
                
                costInput = validateDouble("Expense amount:");
                wantAmounts.add(costInput);
                budget1.addWant(costInput);
                //scan.nextLine();
            }
        }
        else if (choice == 3) {
            // a similar loop as the one above for savings.
            int num = validateInt("How many savings accounts did you contribute to this month?");
            for (int i=0; i < num; i++) {
                System.out.println("Savings account: ");
                stringInput = scan.nextLine();
                savingsNames.add(stringInput);
                
                costInput = validateDouble("Amount saved under this account:");
                savingAmounts.add(costInput);
                budget1.addSaving(costInput);
            }
        }
        else if (choice == 4) {
            needsSummary();
        }
        else if (choice == 5) {
            wantsSummary();
        }
        else if (choice==6) {
            savingsSummary();

        }
        else if (choice == 7) {
            menu = false;
            System.out.println("Here is your budget overview for this month:");
            needsSummary();
            wantsSummary();
            savingsSummary();
            System.out.println("Thank you for using this program.");
        }
        else {
            System.out.println("Enter a valid menu option");
        }
    }
    }
}

