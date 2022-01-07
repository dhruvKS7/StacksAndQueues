/*
Dhruv K. Saligram
3/3/2020
This program implements the stacks and queues data structures
This class implements the stack data structure
*/
//Package below:
package stacksandqueues;
//Imports below:
import java.util.Scanner;
//Creating class below:
public class Stack {
    //Instance variables below:
    private int back;
    private int numberOfElements;
    private static int[] stack;
    //Creating constructor below:
    public Stack() {
        //Setting variables below:
        this.back = 0;
        this.numberOfElements = 0;
        stack = new int[100];
    }
    //Creating constructor below:
    public Stack(int[] stack) {
        //Setting variables below:
        this.back = 0;
        this.numberOfElements = 0;
        this.stack = stack;
    }
    //Creating method to add new numbers to top of stack below:
    public void push(int number) {
        //Testing if stack is full below:
        if (stack.length == this.numberOfElements) {
            System.out.println("STACK IS FULL - PLEASE POP, DISPLAY, OR EXIT");
        } else {
            //Setting back index to the previous position closer to the start of the array below:
            this.back--;
            //Inserting new number at the front of the stack below:
            stack[this.back] = number;
            //Incrementing the total number of elements below:
            this.numberOfElements++;
        }
    }
    //Creating method to remove existing members from top of stack below:
    public void pop() {
        //Testing if stack is empty below:
        if (isEmpty()) {
            System.out.println("STACK IS EMPTY - PLEASE PUSH OR EXIT");
        } else {
            System.out.println("POPPED VALUE: " + stack[this.back]);
            //Setting popped value to 0 below:
            stack[this.back] = 0;
            //Setting back index to the next position closer to the end of the array below:
            this.back++;
            //Decrementing the total number of elements below:
            this.numberOfElements--;
        }
    }
    //Creating method to test if queue is empty below:
    public boolean isEmpty() {
        //Testing if the total number of elements is 0 below:
        return (this.numberOfElements == 0);
    }
    //Creating method to display stack below:
    public void display() {
        //Running for loop from back index to the end of the array below:
        for (int i=this.back; i<stack.length; i++) {
            //Printing value below:
            System.out.println(stack[i]);
        }
    }
    //Creating main method below:
    public static void main(String[] args) {
        //Creating object of class below:
        Stack stackCommands = new Stack();
        //Creating Scanner for user input below:
        Scanner reader = new Scanner(System.in);
        //Setting back index beyond the final index in the array to be decremented once the stack is pushed below:
        stackCommands.back = stack.length;
        //Prompting user for input below:
        System.out.println("ENTER A NUMBER FOR THE STACK, 'pop', 'display', OR TYPE 'exit' TO END");
        //Receiving user input below:
        String inputString = reader.nextLine();
        //Testing if user wants to exit below:
        while (!inputString.equals("exit")) {
            //Determining if user's inputted value is an integer or a separate command below:
            try {
                //Parsing user input to integer below:
                int input = Integer.parseInt(inputString);
                //Calling method to add new number to top of stack below:
                stackCommands.push(input);
            //Determining that user's input was not an integer below:
            } catch (NumberFormatException e) {
                //Determining what command the user would like to execute below:
                if (inputString.equals("pop")) {
                    //Calling method to remove existing member from top of stack below:
                    stackCommands.pop();
                } else if (inputString.equals("display")) {
                    //Calling method to display stack below:
                    stackCommands.display();
                } else {
                    //Alerting user that their command was not recognized below:
                    System.out.println("COMMAND NOT UNDERSTOOD");
                }
            }
            //Prompting user for input below:
            System.out.println("ENTER A NUMBER FOR THE STACK, 'pop', 'display', OR TYPE 'exit' TO END");
            //Receiving user input below:
            inputString = reader.nextLine();
        }
    }
}