import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static class Pokemon{
        public String name;
        public int key;
        Pokemon(String name, int key){
            this.name = name;
            this.key = key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Pokemon> intDogam = new HashMap<>();
        HashMap<String,Pokemon> strDogam = new HashMap<>();


        for (int i=1; i<=n; i++){
            String name = br.readLine();
            Pokemon pokemon = new Pokemon(name,i);
            intDogam.put(i,pokemon);
            strDogam.put(name,pokemon);
        }

        String findPokemon;
        for (int i=0; i<m; i++){
            findPokemon = br.readLine();
            if (Character.isUpperCase(findPokemon.charAt(0))) {
                sb.append(strDogam.get(findPokemon).key).append("\n");
            } else {
                sb.append(intDogam.get(Integer.parseInt(findPokemon)).name).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
