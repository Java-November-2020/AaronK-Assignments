import java.util.HashMap;


public class firsthashmap {
    public static void challenge() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Deftones", "Rocket Skates");
        map.put("Thrice", "Black Honey");
        map.put("Bush", "The Kingdom");
        map.put("Tool", "Descending");

        String val = map.get("Deftones");
        System.out.println(map.get("Deftones"));

        for(String key : map.keySet()) {
            System.out.println(String.format("artist : %s, song : %s", key, map.get(key)));
        }
    }

}