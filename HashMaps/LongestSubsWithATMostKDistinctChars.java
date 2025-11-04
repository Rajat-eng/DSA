import java.util.HashMap;

public class LongestSubsWithAtMostKDistinctChars {

    public static int longestSubstring(String s, int k) {
        int left = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if distinct chars exceed k
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update max window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Longest substring length with at most " + k + " distinct chars: " 
                           + longestSubstring(s, k));
    }
}
