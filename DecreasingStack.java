package ex1;

import unit4.collectionsLib.Stack;

//---------------------------------------------------------------
// Decreasing-order checker
// Developer: עידן דרור
// Description: Returns true if the stack is sorted in decreasing
// order (top is largest), without modifying the original stack.
//---------------------------------------------------------------

public class DecreasingStack {

    // Returns true if the stack is in decreasing order
    public static boolean isDecreasing(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        boolean ok = true;

        if (s.isEmpty()) return true;

        int prev = s.pop();
        temp.push(prev);

        while (!s.isEmpty()) {
            int curr = s.pop();
            temp.push(curr);

            if (prev < curr) {
                ok = false;
            }

            prev = curr;
        }

        // Restore original stack
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return ok;
    }

    public static void printStack(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        System.out.print("[");
        boolean first = true;

        while (!s.isEmpty()) {
            int x = s.pop();
            temp.push(x);
            if (!first) System.out.print(", ");
            System.out.print(x);
            first = false;
        }
        System.out.println("]");

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(20);
        s.push(15);
        s.push(7);

        System.out.print("Stack: ");
        printStack(s);

        boolean result = isDecreasing(s);
        System.out.println("Is decreasing? " + result);

        System.out.print("Stack after check: ");
        printStack(s);
    }
}

/*
סיבוכיות זמן:
הפעולה עוברת על כל איברי המחסנית פעם אחת כדי לבדוק את הסדר
ופעם נוספת כדי לשחזר אותה 
לכן סיבוכיות הזמן היא 
O(n)

סיבוכיות מקום:
הפעולה משתמשת במחסנית עזר 
temp 
שיכולה להכיל עד 
n 
איברים
לכן סיבוכיות המקום היא 
O(n)

*/


