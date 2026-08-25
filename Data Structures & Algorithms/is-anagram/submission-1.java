class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> CountS = new HashMap<>();
        HashMap<Character, Integer> CountT = new HashMap<>();

        if(s.length() != t.length()) return false;

        for (int i = 0; i<s.length(); i++){
            CountS.put(s.charAt(i), CountS.getOrDefault(s.charAt(i), 0) + 1);
            CountT.put(t.charAt(i), CountT.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (char key : CountS.keySet()){
            if(!CountS.get(key).equals(CountT.getOrDefault(key, 0))) return false;
        }

        return true;
    }
}
