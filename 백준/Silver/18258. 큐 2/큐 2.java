import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static class Node{
        public Node next;
        public int num;
        Node(int num){
            this.num = num;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Node front = null;
        Node back = null;
        int size = 0;
        for (int i=0; i<n; i++){
            String[] arr = br.readLine().split(" ");
            String command = arr[0];

            if (command.equals("push")){
                int num = Integer.parseInt(arr[1]);
                Node node = new Node(num);
                if (front ==null){
                    front=back=node;
                }else {
                    back.next = node;
                    back = node;
                }
                size++;
            } else if (command.equals("pop")) {
                if (front==null){
                    sb.append(-1).append("\n");
                }else {
                    sb.append(front.num).append("\n");
                    if (front.next == null){
                        front = null;
                        back = null;
                    }else {
                        front = front.next;
                    }
                   size--;
                }
            } else if (command.equals("front")) {
                if (front==null){
                    sb.append(-1).append("\n");
                }else {
                    sb.append(front.num).append("\n");
                }
            } else if (command.equals("back")) {
                if (back==null){
                    sb.append(-1).append("\n");
                }else {
                    sb.append(back.num).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(size).append("\n");
            } else if (command.equals("empty")) {
                if (size==0){
                    sb.append(1).append("\n");
                }else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
