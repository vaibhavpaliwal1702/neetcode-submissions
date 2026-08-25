class Solution {
    public boolean isPalindrome(String s) {
        char[] str1 = new char[s.length()];
        int temp = 0;
        for(int i = 0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                str1[temp] = Character.toLowerCase(s.charAt(i));
                temp++;
            }
        }

        int i = 0;
        int j = temp-1;
        while(j>=i){
            if(str1[j] != str1[i]){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
