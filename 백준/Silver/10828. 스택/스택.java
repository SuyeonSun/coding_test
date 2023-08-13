import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        Stack<Integer> stack = new Stack<>();

        // int num = Integer.parseInt(sc.nextLine());
        int num = Integer.parseInt(bf.readLine());

        for (int i = 0; i < num; i++) {
            String input = bf.readLine();

            if (input.contains("push")) {
                stack.push(Integer.parseInt(input.split(" ")[1]));
            } else if (input.contains("pop")) {
                if (stack.isEmpty()) System.out.println(-1); 
                else {
                    System.out.println(stack.peek());                    
                    stack.pop();
                }
            } else if (input.contains("size")) {
                System.out.println(stack.size());
            } else if (input.contains("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek()); 
            }

        }
    }
}