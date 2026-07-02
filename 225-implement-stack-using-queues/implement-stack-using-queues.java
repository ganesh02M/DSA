import java.util.LinkedList;
import java.util.Queue;
class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

    // public MyStack() {
       
    // }
    
    public void push(int x) {
        q2.add(x);

        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp =q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
       return q1.remove(); 
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 // USING array  
//  class Stack {

//     int[] arr;
//     int top;
//     int size;

//     Stack(int size) {
//         this.size = size;
//         arr = new int[size];
//         top = -1;
//     }

//     // Push
//     void push(int x) {

//         if (top == size - 1) {
//             System.out.println("Stack Overflow");
//             return;
//         }

//         top++;
//         arr[top] = x;
//     }

//     // Pop
//     int pop() {

//         if (top == -1) {
//             System.out.println("Stack Underflow");
//             return -1;
//         }

//         int val = arr[top];
//         top--;

//         return val;
//     }

//     // Peek
//     int peek() {

//         if (top == -1)
//             return -1;

//         return arr[top];
//     }

//     // Empty
//     boolean isEmpty() {
//         return top == -1;
//     }
// }