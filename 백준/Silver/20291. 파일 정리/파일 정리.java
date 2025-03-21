import java.io.*;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    static class Item {
        int count;
        String name;
        Item(String name){
            this.name = name;
            count=1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Item> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String[] arr = br.readLine().split("\\.");
            String key = arr[1];
            if(map.get(key)==null){
                map.put(key, new Item(key));
            }else {
                map.get(key).count += 1;
            }
        }
        
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key).count);
        }
    }
}