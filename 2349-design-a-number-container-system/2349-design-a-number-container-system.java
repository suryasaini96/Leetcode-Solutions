class NumberContainers {
    
    HashMap<Integer, Integer> indexToNumber;
    HashMap<Integer, TreeSet<Integer>> numberIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<Integer, Integer>();
        numberIndices = new HashMap<Integer, TreeSet<Integer>>();
    }
    
    public void change(int index, int number) {
        if (!indexToNumber.containsKey(index)) { // If number doesn't exist at that index
            addNumberToIndex(index, number);
        } else { // If there is already a number at that place
            int existingNumber = indexToNumber.get(index);
            TreeSet<Integer> existingNumberIndices = numberIndices.get(existingNumber);
            existingNumberIndices.remove(index);
            if (!existingNumberIndices.isEmpty())
                numberIndices.put(existingNumber, existingNumberIndices);
            else
                numberIndices.remove(existingNumber);
            addNumberToIndex(index, number);
        }
    }
    
    public int find(int number) {
        if (numberIndices.containsKey(number)) {
            TreeSet<Integer> indices = numberIndices.get(number);
            if (!indices.isEmpty())
                return indices.first();
            return -1;
        }
        return -1;
    }
    
    public void addNumberToIndex(int index, int number) {
        indexToNumber.put(index, number);
        if (numberIndices.containsKey(number)) {
            TreeSet<Integer> indices = numberIndices.get(number);
            indices.add(index);
            numberIndices.put(number, indices);
        } else {
            TreeSet<Integer> indices = new TreeSet<>();
            indices.add(index);
            numberIndices.put(number, indices);
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */