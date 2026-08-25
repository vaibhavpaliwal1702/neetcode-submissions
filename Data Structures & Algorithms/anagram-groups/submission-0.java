class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> GroupAnagram = new HashMap<>();
        List<List<String>> Res = new ArrayList<>();
        for (String str : strs) {
            char inpString[] = str.toCharArray();
            Arrays.sort(inpString);
            String key = new String(inpString);
            if (GroupAnagram.containsKey(key)) {
                GroupAnagram.get(key).add(str);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                GroupAnagram.put(key, newList);
            }
        }
        GroupAnagram.forEach((key, value) -> Res.add(value));

        return Res;
    }
}
