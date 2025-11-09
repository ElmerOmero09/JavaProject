

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
    // global counter variables for each running totals of categories. 
    double currentNeedsTtotal = 0; 
    double currentWantsTotal = 0;
    double currentSavingsTotal = 0; 
    
    ArrayList<String> needNames = new ArrayList<>();
    ArrayList<Double> needAmounts = new ArrayList<>();
    
    ArrayList<String> wantNames = new ArrayList<>();
    ArrayList<Double> wantAmounts = new ArrayList<>();
    
    ArrayList<String> savingsNames = new ArrayList<>();
    ArrayList<Double> savingAmounts = new ArrayList<>();
    
    public void needsSummary() 
    {
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
        }
    }
    
    public void needsTotal()
    {
        //recursive function to add totals using currentNeedsTotal
    }
    
    public void wantsSummary() {
        System.out.println("-----Wants-----");
        if (needNames.isEmpty()) 
        {
            System.out.println("No spending has occured");
        }
        else 
        {
            for (int i=0; i < wantNames.size(); i++) 
            {
                System.out.println( wantNames.get(i) + " : $" + wantAmounts.get(i) +"\n");
            }
        }
    }
    
    public void savingsSummary() 
    {
        System.out.println("Savings total = $" + budget1.getSavingsTotal());
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
    }
    else {
        System.out.println("Enter percentage allocated to Needs: (enter as decimal)");
        double needsPercentage = scan.nextDouble();
        
        System.out.println("Enter percentage allocated to Wants: (enter as decimal)");
        double wantsPercentage = scan.nextDouble();
        
        System.out.println("Enter percentage allocated to Savings: (enter as decimal)");
        double savingsPercentage = scan.nextDouble();
        
        budget1 = new BudgetLogic(needsPercentage, wantsPercentage, savingsPercentage, income);
        
    }
    
    

    
    
    
    }
}
