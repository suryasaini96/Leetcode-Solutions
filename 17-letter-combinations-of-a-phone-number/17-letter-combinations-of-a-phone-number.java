class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        List<String> result = new ArrayList();
        
        if(digits.length()==0) return new ArrayList();
        
        HashMap<String, String> map = new HashMap<String, String>();
    
        map.put("2", "abc"); map.put("3", "def"); map.put("4", "ghi"); map.put("5", "jkl");
        map.put("6", "mno"); map.put("7", "pqrs"); map.put("8", "tuv"); map.put("9", "wxyz");
        
        Deque<String> deque = new ArrayDeque();
        
        deque.add("");
        
        for(int i=0; i<digits.length(); i++) { //234
            String d = digits.substring(i, i+1); 
            String fromMap = map.get(d); //"abc"
            
            int n = deque.size();
            
            for(int j=0; j<n; j++){
                String pull = deque.pollFirst();   // []   a b c
                for(int k=0; k<fromMap.length(); k++){
                    String temp = pull.concat(fromMap.charAt(k) + ""); 
                    deque.add(temp);                        
                }
            } 
        }
        
        while(!deque.isEmpty()){
            result.add(deque.poll());
        }
        
        
        return result;
        
        
        
        
        
        
    }
}