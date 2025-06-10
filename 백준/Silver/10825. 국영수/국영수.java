import java.io.*;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int korea;
        int english;
        int math;

        Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korea != o.korea) return o.korea - this.korea;
            if (this.english != o.english) return this.english - o.english;
            if (this.math != o.math) return o.math - this.math;
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> lst = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String[] strArr = br.readLine().split(" ");
            Student student = new Student(strArr[0],Integer.parseInt(strArr[1]),Integer.parseInt(strArr[2]),Integer.parseInt(strArr[3]));
            lst.add(student);
        }
        Collections.sort(lst);
        for (int i=0; i<n; i++){
            Student student = lst.get(i);
            System.out.println(student.name);
        }
    }
}
