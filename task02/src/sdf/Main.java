package sdf;

import java.io.Console;

public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome.");
        Console con = System.console();        

        int last=0,num1=0,num2=0;
        Boolean exitCal =false;

        while(!exitCal){
            
            String input[] = con.readLine().split(" ");

            if(input[0].equals("exit")){
                break;
            }
            else if(input[0].equalsIgnoreCase("$last")){
                num1=last;
            }
            else{
                num1=Integer.parseInt(input[0]);
            }

            if(input[2].equalsIgnoreCase("$last")){
                num2=last;
            }
            else{
                num2=Integer.parseInt(input[2]);
            }
            
            switch(input[1]){
                
                case "+":
                last = num1+num2;
                System.out.println(last);
                break;

                case "-":
                last = num1-num2;
                System.out.println(last);
                break;
                
                case "/":
                last = num1/num2;
                System.out.println(last);
                break;

                case "*":
                case "X":
                case "x":
                last = num1*num2;
                System.out.println(last);
                break;

                default:
                System.out.println("Invalid Please enter again");

            }
        }

        System.out.println("Bye bye");
    }
}