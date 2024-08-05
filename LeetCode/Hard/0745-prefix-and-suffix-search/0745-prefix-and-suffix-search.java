import java.util.HashMap;
import java.util.Map;

class WordFilter {
    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int length = word.length();
            for (int prefixLength = 1; prefixLength <= length; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= length; suffixLength++) {
                    String key = word.substring(0, prefixLength) + "#" + word.substring(length - suffixLength);
                    map.put(key, index);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String key = pref + "#" + suff;
        return map.getOrDefault(key, -1);
    }
}