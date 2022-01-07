/*
Dhruv K. Saligram
3/3/2020
This program implements the stacks and queues data structures
This class implements the queue data structure
*/
//Package below:
package stacksandqueues;
//Imports below:
import java.util.Scanner;
//Creating class below:
public class Queue {
    //Instance variables below:
    private int front;
    private int back;
    private int numberOfElements;
    private static int[] queue;
    //Creating constructor below:
    public Queue() {
        //Setting variables below:
        this.front = 0;
        this.back = -1;
        this.numberOfElements = 0;
        queue = new int[100];
    }
    //Creating constructor below:
    public Queue(int[] queue) {
        //Setting variables below:
        this.front = 0;
        this.back = -1;
        this.numberOfElements = 0;
        this.queue = queue;
    }
    //Creating method to add new numbers to back of queue below:
    public void enqueue(int number) {
        //Testing if queue is full below:
        if (queue.length == this.numberOfElements) {
            System.out.println("QUEUE IS FULL - PLEASE DEQUEUE, DISPLAY, OR EXIT");
        } else {
            //Setting back index to the next position below:
            this.back = advanceIndex(this.back);
            //Setting next position to new number below:
            queue[this.back] = number;
            //Incrementing the total number of elements below:
            this.numberOfElements++;
        }
    }
    //Creating method to remove existing members from front of queue below:
    public void dequeue() {
        //Testing if queue is empty below:
        if (isEmpty()) {
            System.out.println("QUEUE IS EMPTY - PLEASE ENQUEUE OR EXIT");
        } else {
            System.out.println("DEQUEUED VALUE: " + queue[this.front]);
            //Setting dequeued value to 0 below:
            queue[this.front] = 0;
            //Advancing front index below:
            this.front = advanceIndex(this.front);
            //Decrementing the total number of elements below:
            this.numberOfElements--;
        }
    }
    //Creating method to advance index to next available position below:
    public int advanceIndex(int index) {
        //Returning new index below:
        return (index + 1) % queue.length;
    }
    //Creating method to test if queue is empty below:
    public boolean isEmpty() {
        //Testing if the total number of elements is 0 below:
        return (this.numberOfElements == 0);
    }
    //Creating method to display queue below:
    public void display() {
        //Checking if last element exists before the first element in terms of index position below:
        if (this.front > this.back) {
            //Running for loop from front index to end of queue below:
            for (int i = this.front; i < queue.length; i++) {
                //Printing value below:
                System.out.print(queue[i] + ", ");
            }
            //Running for loop from start of queue to back index below:
            for (int i = 0; i <= this.back; i++) {
                //Testing if the value about to be printed is the last value in the queue below:
                if (i == this.back) {
                    //Printing value below:
                    System.out.print(queue[i] + ".");
                } else {
                    //Printing value below:
                    System.out.print(queue[i] + ", ");
                }
            }
            //Printing blank space for formatting below:
            System.out.println("");
        } else {
            //Running for loop from front index to back index below:
            for (int i = this.front; i <= this.back; i++) {
                //Testing if the value about to be printed is the last value in the queue below:
                if (i == this.back) {
                    //Printing value below:
                    System.out.print(queue[i] + ".");
                } else {
                    //Printing value below:
                    System.out.print(queue[i] + ", ");
                }
            }
            //Printing blank space for formatting below:
            System.out.println("");
        }
    }
    //Creating main method below:
    public static void main(String[] args) {
        //Creating object of class below:
        Queue queueCommands = new Queue();
        //Creating Scanner for user input below:
        Scanner reader = new Scanner(System.in);
        //Prompting user for input below:
        System.out.println("ENTER A NUMBER FOR THE QUEUE, 'deque', 'display', OR TYPE 'exit' TO END");
        //Receiving user input below:
        String inputString = reader.nextLine();
        //Testing if user wants to exit below:
        while (!inputString.equals("exit")) {
            //Determining if user's inputted value is an integer or a separate command below:
            try {
                //Parsing user input to integer below:
                int input = Integer.parseInt(inputString);
                //Calling method to add new number to back of queue below:
                queueCommands.enqueue(input);
            //Determining that user's input was not an integer below:
            } catch (NumberFormatException e) {
                //Determining what command the user would like to execute below:
                if (inputString.equals("dequeue")) {
                    //Calling method to remove existing member from front of queue below:
                    queueCommands.dequeue();
                } else if (inputString.equals("display")) {
                    //Calling method to display queue below:
                    queueCommands.display();
                } else {
                    //Alerting user that their command was not recognized below:
                    System.out.println("COMMAND NOT UNDERSTOOD.");
                }
            }
            //Prompting user for input below:
            System.out.println("ENTER A NUMBER FOR THE QUEUE, 'deque', 'display', OR TYPE 'exit' TO END");
            //Receiving user input below:
            inputString = reader.nextLine();
        }
    }
}