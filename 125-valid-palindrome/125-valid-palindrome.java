class Solution {
    static boolean isAlphaNum(char c)
    {
        if( (48<=c && c<=57) || (65<=c && c<=90) || (97<=c && c<=122)) 
            return true;
        else
            return false;
    }
    
    static char lowerCase(char c)
    {
        if(65<=c && c<=90)
            return (char)(c+32);
        else 
            return c;
    }
    
    public static boolean isPalindrome(String s) 
    {
       int start=0,end=s.length()-1;
        
        while(start<end)
        {
            while(start<end && !isAlphaNum(s.charAt(start))) start++;
            while(start<end && !isAlphaNum(s.charAt(end))) end--;
           
            if(lowerCase(s.charAt(start))!=lowerCase(s.charAt(end)))  
                return false; 
            
            start++;
            end--;
        }
        
        return true;
        
    }
}