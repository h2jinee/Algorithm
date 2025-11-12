class Solution {
    public String solution(String s) {
        StringBuilder str = new StringBuilder(s.toLowerCase());  
        
        String firstIndex = String.valueOf(str.charAt(0)).toUpperCase();
        str.replace(0, 1, firstIndex);
        
        boolean flag = true;

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (flag == true && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    str.replace(i, i+1, String.valueOf(str.charAt(i)).toUpperCase());
                } 
                
                flag = false;
            }
            
            if (str.charAt(i) == ' ') {
                flag = true;
            }
        }
        
        return str.toString();
    }
}