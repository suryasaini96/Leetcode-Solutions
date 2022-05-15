class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String folder: folders) {
            if (folder.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (folder.equals(".") || folder.isEmpty())
                continue;
            else
                stack.push(folder);
        }
        
        StringBuilder answer = new StringBuilder("/");
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            String word = itr.next();
            answer.append(word + "/");
        }
        if (answer.length() > 1)
            answer.deleteCharAt(answer.length()-1);
        
        return answer.toString();
    }
}