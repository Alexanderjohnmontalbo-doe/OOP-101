import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalQuantity = 0;
        double totalSubtotal = 0.0;
        boolean ordering = true;

        System.out.println("Welcome to the Canteen!");

       
        System.out.print("Are you a student? (Y/N): ");
        String studentAnswer = input.nextLine().trim();
        boolean isStudent = studentAnswer.equalsIgnoreCase("Y") || studentAnswer.equalsIgnoreCase("YES");

        while (ordering) {
            
            System.out.println("\n====== CANTEEN MENU ======");
            System.out.println("1 - Footlong          - $50.00");
            System.out.println("2 - Krabby Patty      - $80.00");
            System.out.println("3 - Adeptus Temptation - $320.00");
            System.out.println("4 - Estus Juice       - $30.00");
            System.out.println("5 - NUKA-COLA        - $25.00");
            System.out.println("==========================");

            
            System.out.print("Enter item number (1-5): ");
            int itemChoice = input.nextInt();

            double itemPrice = 0.0;
            switch (itemChoice) {
                case 1:
                    itemPrice = 50.0;
                    break;
                case 2:
                    itemPrice = 80.0;
                    break;
                case 3:
                    itemPrice = 320.0;
                    break;
                case 4:
                    itemPrice = 30.0;
                    break;
                case 5:
                    itemPrice = 25.0;
                    break;
                default: {
                    System.out.println(" Invalid item selection! Please select an item from 1 to 5.");
                    continue;
                }
            }

           
            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            if (quantity < 1 || quantity > 10) {
                System.out.println(" Invalid quantity! Quantity must be between 1 and 10.");
                continue; 
            }

            
            totalQuantity += quantity;
            totalSubtotal += (itemPrice * quantity);

            System.out.println("--> Added " + quantity + " x Item #" + itemChoice + " to order.");

            
            input.nextLine(); 

            
            System.out.print("\nDo you want to order again? (Y/N): ");
            String orderAgain = input.nextLine().trim();
            if (!orderAgain.equalsIgnoreCase("Y") && !orderAgain.equalsIgnoreCase("YES")) {
                ordering = false; 
            }
        }

        
        double discountRate = 0.0;

        if (isStudent && totalSubtotal >= 500.0) {
            discountRate = 0.15; 
        } else if (isStudent) {
            discountRate = 0.10; 
        } else if (totalSubtotal >= 500.0) {
            discountRate = 0.05; 
        }

        double totalDeduction = totalSubtotal * discountRate;
        double finalAmount = totalSubtotal - totalDeduction;

        
        System.out.println("\n=================================");
        System.out.println("          FINAL RECEIPT          ");
        System.out.println("=================================");
        System.out.println("Total Items Purchased : " + totalQuantity);
        System.out.printf("Total Before Deduction: $%.2f%n", totalSubtotal);
        System.out.printf("Total Deduction (%d%%)  : -$%.2f%n", (int)(discountRate * 100), totalDeduction);
        System.out.printf("Final Amount to Pay   : $%.2f%n", finalAmount);
        System.out.println("=================================");

        input.close();
    }
}