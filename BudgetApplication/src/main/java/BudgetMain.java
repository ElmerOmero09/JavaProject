

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
    static double income;
    static String standard = " ";
    static BudgetLogic budget1;
    
    static ArrayList<String> needNames = new ArrayList<>();
    static ArrayList<Double> needAmounts = new ArrayList<>();
    
    static ArrayList<String> wantNames = new ArrayList<>();
    static ArrayList<Double> wantAmounts = new ArrayList<>();
    
    static ArrayList<String> savingsNames = new ArrayList<>();
    static ArrayList<Double> savingAmounts = new ArrayList<>();
    
    public static void needsSummary() {
        double runningTotal = 0.0;
        System.out.println("-----Needs-----");
        if (needNames.isEmpty()) {
            System.out.println("No spending has occured");
        }
        else {
            for (int i=0; i < needNames.size(); i++) {
                System.out.println( needNames.get(i) + " : $" + needAmounts.get(i) + "\n");
                runningTotal += needAmounts.get(i);
            }
            System.out.println("Remaining Balance: $" + (budget1.getNeedsTotal() - budget1.needsSpent));
        }
    }
    
    public static void wantsSummary() {
        double runningTotal = 0.0;
        System.out.println("-----Wants-----");
        if (needNames.isEmpty()) {
            System.out.println("No spending has occured");
        }
        else {
            for (int i=0; i < wantNames.size(); i++) {
                System.out.println( wantNames.get(i) + " : $" + wantAmounts.get(i) +"\n");
                runningTotal += wantAmounts.get(i);
            }
            System.out.println("Remaining Balance: $" + (budget1.getNeedsTotal() - budget1.wantsSpent));
        }
    }
    
    public static void savingsSummary() {
        System.out.println("Savings total: $" + budget1.getSavingsTotal());
    }
    
    public static void validateStandard()
    {
        while( !standard.equals("Yes") && !standard.equals("yes") && !standard.equals("YES") && !standard.equals("No") && !standard.equals("no") && !standard.equals("no"))
        {
            System.out.println("Enter a valid answer. Yes or No?");
            standard = scan.nextLine(); 
        }
    }
    
    // Exception handling
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
                    System.out.println("Enter a positive number");
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
    //method to recursively add items to proper category
    
    
    System.out.println("What is your income?");
    income = scan.nextDouble();
    
    System.out.println("Do you want to implement your own financial rule?");
    standard = scan.nextLine(); 
    //validation of standard 
    validateStandard();
    
    //BudgetLogic budget1 = new BudgetLogic(income); 
    if (standard.equalsIgnoreCase("no")) {
        budget1 = new BudgetLogic(income);
        budget1.calculateCategories();
    }
    else {
        System.out.println("Enter percentage allocated to Needs: (enter as decimal)");
        double needsPercentage = scan.nextDouble();
        
        System.out.println("Enter percentage allocated to Wants: (enter as decimal)");
        double wantsPercentage = scan.nextDouble();
        
        System.out.println("Enter percentage allocated to Savings: (enter as decimal)");
        double savingsPercentage = scan.nextDouble();
        
        budget1 = new BudgetLogic(needsPercentage, wantsPercentage, savingsPercentage, income);
        //budget1.calculateCategories();
        
    }
    
    //user menu where they can add things, view summaries, and exit
    boolean menu = true;
    while (menu) {
        String stringInput;
        double costInput; 
        System.out.println("-----Menu-----");
        System.out.println("1 - Add Needs");
        System.out.println("2 - Add Wants");
        System.out.println("3 - View Needs Summary");
        System.out.println("4 - View Wants Summary");
        System.out.println("5 - View Savings Summary");
        System.out.println("6 - Reset Percentages"); //IDK if we want this or not
        System.out.println("7 - Exit");
        
        int choice = scan.nextInt();
        scan.nextLine();
        
        if (choice == 1) {
            System.out.println("Quantity of needs to enter:");
            int num = scan.nextInt();
            scan.nextLine();
            for (int i=0; i < num; i++) {
                System.out.println("Name of item: ");
                stringInput = scan.nextLine();
                needNames.add(stringInput);
                
                System.out.println("Cost of item: ");
                costInput = scan.nextDouble();
                needAmounts.add(costInput);
                budget1.addNeed(costInput);
                scan.nextLine();
            }
        }
        else if (choice == 2) {
            System.out.println("Quantity of wants to enter:");
            int num = scan.nextInt();
            scan.nextLine();
            for (int i=0; i < num; i++) {
                System.out.println("Name of item: ");
                stringInput = scan.nextLine();
                wantNames.add(stringInput);
                
                System.out.println("Cost of item: ");
                costInput = scan.nextDouble();
                wantAmounts.add(costInput);
                budget1.addWant(costInput);
                scan.nextLine();
            }
        }
        else if (choice == 3) {
            needsSummary();
        }
        else if (choice == 4) {
            wantsSummary();
        }
        else if (choice == 5) {
            savingsSummary();
        }
        else if (choice==6) {
            //add something to allow changing percentage allocations
        }
        else if (choice == 7) {
            menu = false;
            System.out.println("Budget Education Successfull"); //wrote this as a joke, couldnt think of an exit message
        }
        else {
            System.out.println("Enter a valid option");
        }
        
    }
    
    

    
    
    
    }
}
