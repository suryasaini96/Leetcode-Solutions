class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows==0) return new ArrayList<List<Integer>>();

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>(){{add(1);}});
        if (numRows==1) return list;

        for (int i=1; i<numRows; i++){
            List<Integer> al = new ArrayList<Integer>();
            for (int j=0; j<=i; j++){
                int num = getNum(list.get(i-1),j) + getNum(list.get(i-1),j-1);
                al.add(num);
            }
            list.add(al);
        }
        return list;
    }
    
    private static int getNum(List<Integer> list, int pos){
        if (pos < 0 || pos >= list.size()) return 0;
        return list.get(pos); 
    }
}