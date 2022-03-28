class Solution {
    public String convert(String s, int numRows) {
        
        ArrayList<Character> list[] = new ArrayList[numRows];
        
        
        /*
        
        PAYPALISHIRING
        
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
        
        
        */
        if (numRows == 0 || numRows == 1) return s;

        boolean direction = true;    
        int up = numRows-2; // select row where we want to insert when direction is upwards
        int down = 0, i = 0;
        
        for(int j=0; j<numRows; j++){
            list[j] = new ArrayList<Character>();
        }
     
        while(i<s.length()){
            
            if(direction){
                list[down++].add(s.charAt(i));                
                if(down==numRows) { direction = false; down = 0;  } // downward direction completed
            }
            
            else {
                list[up--].add(s.charAt(i));
                if (up==0) {direction = true; up = numRows-2; }  // upwards direction completed -- diagonal elements done
                if (up==-1) {direction = true; down=1; up = numRows-2; } // special case when numRows = 2 
 
            }
            
            i++;
        }
        
        
        StringBuilder ret = new StringBuilder();
        
        for (List arr : list) {
        	for (int k=0; k<arr.size(); k++) {
        		ret.append(arr.get(k));
        	}
        }
        
        return ret.toString();
        
        
        
    }
}