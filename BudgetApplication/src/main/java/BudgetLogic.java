/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author noahn
 */
import java.util.ArrayList;
import java.util.List;

public class BudgetLogic {
    //this class can handle monetary logic
    private double needs; //50%
    private double wants; //30%
    private double savings; //20%
    private double income; 
    private double needsTotal;
    private double wantsTotal;
    private double savingsTotal;
    
    //add Array lists for showing items in each category
    //add methods for getting totals spent displayed
    
    public BudgetLogic (double income) {
        needs = .50;
        wants = .30;
        savings = .20;
        this.income = income;
    }
    
    public BudgetLogic(double needs, double wants, double savings, double income)
    {
        this.needs = needs;
        this.wants = wants; 
        this.savings = savings;
        this.income = income;
    }
   
    
    //getters and setters
    public double GetNeeds() {
        return needs;
    }
    public double GetWants() {
        return wants;
    }
    public double GetSavings() {
        return savings;
    }
    public double getIncome() {
        return income;
    }
    public double getNeedsTotal() {
        return needsTotal;
    }
    public double getWantsTotal() {
        return wantsTotal;
    }
    public double getSavingsTotal() {
        return savingsTotal;
    }
    //_________________________________________________________________________

    public void setNeeds(double needs) {
        this.needs = needs;
    }

    public void setWants(double wants) {
        this.wants = wants;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setNeedsTotal(double needsTotal) {
        this.needsTotal = needsTotal;
    }

    public void setWantsTotal(double wantsTotal) {
        this.wantsTotal = wantsTotal;
    }

    public void setSavingsTotal(double savingsTotal) {
        this.savingsTotal = savingsTotal;
    }
    
    //__________________________________________________________________________
    
    //logic methods
    public void calculateCategories() {
        needsTotal = income * .5;
        wantsTotal = income * .3;
        savingsTotal = income *.2;
    }
    
    
}