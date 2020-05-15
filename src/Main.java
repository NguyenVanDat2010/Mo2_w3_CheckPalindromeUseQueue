import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";

        //Sử dụng ăn sẵn queue bằng 1 tron 2 cách ở dưới
//        PriorityQueue<String> myQueue=new PriorityQueue<>();
        ArrayBlockingQueue<String> myQueue = new ArrayBlockingQueue<>(str.length());
        Stack<String> myStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i)).toUpperCase();
            if (!temp.equals(" ")) {
                myQueue.add(temp);
                myStack.push(temp);
            }
        }
//        Collections.reverse(myStack);
//        System.out.println(Arrays.toString(new PriorityQueue[]{myQueue}));
        System.out.println(Arrays.toString(new ArrayBlockingQueue[]{myQueue}));
        System.out.println(Arrays.toString(new Stack[]{myStack}));

        int length = myStack.size();
//        System.out.println(myStack.pop());
//        System.out.println(myStack.peek());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
        boolean checkEqual = true;
        while (length - 1 >= 0) {
            String letterStack = myStack.pop();   //Xóa ptu đầu tiên
            String letterQueue = myQueue.poll();   //Xóa ptu đầu tiên
            if (!letterStack.equals(letterQueue)) {
                checkEqual = false;
                break;
            }
            length--;
        }
        if (checkEqual) {
            System.out.println("String \"" + str + "\" is Palindrome");
        } else {
            System.out.println("String \"" + str + "\" is not Palindrome");
        }
    }
}
