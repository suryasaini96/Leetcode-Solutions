class WordDictionary {
    
    class Node {
        Node[] links = new Node[26];
        boolean flag = false;
        
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
        
        Node get(char ch) {
            return links[ch - 'a'];
        }
        
        void setEnd() {
            flag = true;
        }
        
        boolean isEnd() {
            return flag;
        }
    }
    
    private Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            } 
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }
    
    private boolean searchInNode(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Node link : node.links) {
                    if (link != null && searchInNode(word.substring(i+1), link))
                        return true;
                }
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }
        }
        return node.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */