class TimeMap {
    
    // TreeMap Solution 
    
    // key, timestamp, value
//     private Map<String, TreeMap<Integer, String>> map;
    
//     public TimeMap() {
//         map = new HashMap<>();    
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if (!map.containsKey(key)) {
//             map.put(key, new TreeMap<Integer, String>());
//         }
//         map.get(key).put(timestamp, value);
//     }
    
//     public String get(String key, int timestamp) {
//         TreeMap<Integer, String> treeMap = map.get(key);
//         if (treeMap == null) { // No mapping for the key
//             return "";
//         }
//         Integer floorKey = treeMap.floorKey(timestamp);
//         if (floorKey == null) { // No timestamp lower than given timestamp exists for given key
//             return "";
//         }
//         return treeMap.get(floorKey);
//     }
    
    // Binary Search Solution
    
    private Map<String, List<Data>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        return binarySearch(map.get(key), timestamp);
    }
    
    private String binarySearch(List<Data> list, int timestamp) {
         // Apply binary search on List<Data>
        int low = 0, high = list.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (list.get(mid).time <= timestamp) {
                // Make sure the highest time is returned from the time less than timestamp
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index != -1 ? list.get(index).value : "";
    }
    
}


class Data {
    Integer time;
    String value;
    
    Data(Integer time, String value) {
        this.time = time;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */