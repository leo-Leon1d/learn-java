import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(4);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        stack2.push(4);
        stack2.push(5);
        stack2.push(8);

        Stack<Integer> sixStack = new Stack<>();
        sixStack.push(9);
        sixStack.push(7);
        sixStack.push(1);
        sixStack.push(5);
        sixStack.push(3);
        sixStack.push(2);

        Stack<Integer> insaneStack = new Stack<>();
        insaneStack.push(8);
        insaneStack.push(8);
        insaneStack.push(8);
        insaneStack.push(8);
        insaneStack.push(4);
        insaneStack.push(4);
        insaneStack.push(4);
        insaneStack.push(2);
        insaneStack.push(2);

        Stack<Integer> decreasingStack = new Stack<>();
        decreasingStack.push(1);
        decreasingStack.push(2);
        decreasingStack.push(4);
        decreasingStack.push(9);

        // System.out.println(stackSum(stack));
        // System.out.println(uniqueStack(stack));
        // System.out.println(block(stack, 2));
        //System.out.println(pairSum(stack1, stack2));
        //System.out.println(minOfThree(sixStack));
        //System.out.println(isInsane(insaneStack));
        //System.out.println(isDecreasing(decreasingStack));
        //System.out.println(twoNums(stack,4));
        System.out.println(stackHalf(sixStack));

    }

    public static boolean isSimple(int num) {
        if (num < 2)
            return false;
        double s = Math.sqrt(num);
        for (int i = 2; i <= s; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static int stackSum(Stack<Integer> y) {
        int count = 0;
        int data1 = 0;
        int data2 = 0;
        while (y.size() > 1) {
            data1 = y.pop();
            data2 = y.peek();
            if (data1 + data2 > 10) {
                count++;
                System.out.printf("%d %d \n", data1, data2);
            }
        }
        return count;
    }

    public static boolean uniqueStack(Stack<Integer> y) {
        while (!y.isEmpty()) {
            int data = y.pop();
            int search = y.search(data);
            if (search != -1) {
                return false;
            }
        }
        return true;
    }

    // stack: 4443322241
    public static int block(Stack<Integer> s, int x) {
        int blockCount = 0;
        int data = 0;
        int count = 1;
        while (!s.isEmpty()) {
            data = s.pop();
            if (!s.isEmpty()) {
                while (data == s.peek()) {
                    count++;
                    s.pop();
                }
            }
            if (count == x) blockCount++;
            count = 1;
        }
        return blockCount;
    }

    // stack1: 654321   stack2: 635
    public static int pairSum(Stack<Integer> y1, Stack<Integer> y2) {
        int count = 0;
        int data1 = 0;
        int data2 = 0;
        while (y1.size() > 1) {
            data1 = y1.pop();
            data2 = y1.peek();
            if (y2.search(data1 + data2) != -1) {
                count++;
            }
        }
        return count;
    }

    // sixStack: 295173
    public static Stack<Integer> stackHalf(Stack<Integer> y) {
        if(y.size()%2==1) {
            System.out.println("Your stack is not even");
        }
        if(y.isEmpty()) {
            System.out.println("Your stack is empty");
        }
        Stack<Integer> copyStack2 = new Stack<>();
        Stack<Integer> copyStack1 = (Stack<Integer>)y.clone();
        Stack<Integer> copyStack3 = (Stack<Integer>)y.clone();
        int half = y.size()/2;
        int data = 0;
        int count = 0;
        while(!y.isEmpty()) {
            data=y.pop();
            while(!copyStack1.isEmpty()) {
                if(data>copyStack1.pop()) count++;
            }
            copyStack1 = (Stack<Integer>)copyStack3.clone();
                if (count >= half) {
                    copyStack2.push(data);
                }
            count = 0;
        }
        return copyStack2;
    }

    public static Stack<Integer> minOfThree(Stack<Integer> y) {
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        while (y.size() > 3) {
            data1 = y.pop();
            data2 = y.pop();
            data3 = y.pop();
            int smallest = data1;
            if (smallest > data2) smallest = data2;
            if (smallest > data3) smallest = data3;
            y.addElement(smallest);
        }
        return y;
    }

    //insaneStack: 224448888
    public static boolean isInsane(Stack<Integer> y) {
        if(y.isEmpty()) return true;
        int data = 0;
        int count1 = 1;
        int count2 = 1;
        int blocks = 0;
        int insaneBlocks = 0;
        while (y.size() > 1) {
            data = y.pop();
            while (y.peek() == data) {
                y.pop();
                count1++;
                if(y.isEmpty()) break;
            }
            if (count1 > count2) insaneBlocks++;
            count2 = count1;
            count1 = 1;
            blocks++;
        }
        return blocks == insaneBlocks;
    }

    //decreasingStack: 9421
    public static boolean isDecreasing(Stack<Integer> y) {
        int first = 0;
        int data = 0;
        int count = 0;
        int trueCount = 0;
        while(!y.isEmpty()) {
            first = y.pop();
            while(!y.isEmpty()) {
                data += y.pop();
            }
            if(first>data) trueCount++;
            count++;
        }
        return count==trueCount;
    }

    // stack: 4443322241
    public static boolean twoNums(Stack<Integer> s, int x) {
        int data = 0;
        int count = 1;
        while(!s.isEmpty()) {
            data = s.pop();
            if(data==x) count++;
        }
        return count>2;
    }
}



