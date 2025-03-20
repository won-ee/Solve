import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (isJavaStyle(str)) {
            System.out.println(convertJavaToCpp(str));
        } else if (isCppStyle(str)) {
            System.out.println(convertCppToJava(str));
        } else {
            System.out.println("Error!");
        }
    }

    // Java 스타일 확인 함수
    private static boolean isJavaStyle(String s) {
        if (s.contains("_")) return false;  // Java 변수명에 _가 있으면 안 됨
        if (s.isEmpty() || Character.isUpperCase(s.charAt(0))) return false; // 첫 문자가 대문자면 안 됨
        return true;
    }

    // C++ 스타일 확인 함수
    private static boolean isCppStyle(String s) {
        if (s.isEmpty() || s.startsWith("_") || s.endsWith("_")) return false; // 첫/마지막이 _이면 안 됨
        if (s.contains("__")) return false;  // 연속된 _는 안 됨

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) return false; // C++ 변수명은 대문자가 포함되면 안 됨
        }
        return true;
    }

    // Java 스타일 → C++ 스타일 변환 함수
    private static String convertJavaToCpp(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append("_").append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // C++ 스타일 → Java 스타일 변환 함수
    private static String convertCppToJava(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = false;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                toUpper = true;
            } else {
                sb.append(toUpper ? Character.toUpperCase(c) : c);
                toUpper = false;
            }
        }
        return sb.toString();
    }
}
