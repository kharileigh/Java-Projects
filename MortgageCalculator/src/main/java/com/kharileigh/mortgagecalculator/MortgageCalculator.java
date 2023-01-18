/**
 *
 * @author kharileigh
 
 INPUT FROM USER :
 * principal amount
 * interest rate 
 * term / number of years for loan
 ---------------------------------
 OUTPUT TO USER :
 * monthly payment
 * total amount paid throughout whole course of the loan   
 */

package com.kharileigh.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;


public class MortgageCalculator {
    
    // CONSTANT TO STORE MONTHS - used to ensure no magic numbers are written in source code
    private static final int MONTHS_IN_A_YEAR = 12;
    

    public static void main(String[] args) {
        
        /**
         * TAKE ALL INPUT FROM USER NEEDED TO CALCULATE MORTGAGE PAYMENTS
         */
        
        // Used to take input from user
        Scanner scanner = new Scanner(System.in);
        
        // Principal Amount
        System.out.println("Enter the Principal Amount: ");
        double principal = scanner.nextDouble();
        
        // Interest Rate
        System.out.println("\n Enter the Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        
        // Term / Number of Years for Loan
        System.out.println("\n Enter the Term in Years: ");
        int termInYears = scanner.nextInt();
        
        /**
         * CALCULATIONS 
         * Goal : Find Monthly Payment Amount
         
         Principal MULTIPLIED BY 
         
         NUMERATOR : Monthly Interest Rate MULTIPLIED BY (( 1 + Monthly Interest Rate ) RAISED TO THE POWER OF Number of Payments) DIVIDED BY
         -----------------------------------------------------------------------
         DENOMINATOR : ( 1 + Monthly Interest Rate ) RAISED TO THE POWER OF Number of Payments ) MINUS 1
         */
         
        // Monthly Interest Rate
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
        
        // Number of Monthly Payments 
        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;
        
        
        // Monthly Payment
        // Math.pow (x, raises x to the power of y)
        double monthlyPayment = principal * (
            // numerator
            (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
            // denominator
            ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
        );
        
        // Print Monthly Payment to User
        // Number Instance - formats double to a local currency
        System.out.println("Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }
}
