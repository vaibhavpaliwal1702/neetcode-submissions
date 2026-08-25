class Solution {
    public String encode(List<String> strs) {
        String res = "";
        for (String str : strs) {
            res += str.length() + "#" + str;
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> Res = new ArrayList<>();
        char[] myArray = str.toCharArray();
        String str1 = "";
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != '#') {
                str1 += myArray[i];
            }
            else{
                int n = Integer.parseInt(str1);
                String str2 = "";
                for(int j = i+1; j<i+1+n;j++){
                    str2 += myArray[j];
                }
                Res.add(str2);
                str1 = "";
                i = i+n;
            }
        }

        return Res;
    }
}
