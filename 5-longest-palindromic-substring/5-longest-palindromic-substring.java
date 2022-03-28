class Solution {
    
    int resultStart;
    int resultLength;
    
    public String longestPalindrome(String s) {
     
        int strLength = s.length();
        
        if(strLength<2){
            return s;
        }
        
        
        for(int start=0; start < strLength -1; start++){
            expandRange(s, start, start); 
            expandRange(s, start, start + 1);
        }
        
             
        return s.substring(resultStart, resultStart + resultLength); 
    }
    
    public void expandRange(String s, int beg, int end){
            while (beg>=0 && end<s.length() && (s.charAt(beg) == s.charAt(end))){
                beg--;
                end++;
            }
            
            if(end-beg-1>resultLength){
                resultLength = end-beg-1;
                resultStart = beg + 1;                           
            }
            
            
        }
    
    
    
}