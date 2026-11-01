class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isOpen(c)){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    if(isSame(stack.peek(), c)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isOpen(char c){
        if(c=='(' || c=='{' || c=='['){
            return true;
        }
        return false;
    }

    public boolean isClosed(char c){
        if(c==')' || c=='}' || c==']'){
            return true;
        }
        return false;
    }

    public boolean isSame(char first, char second){
        if(first == '(' && second == ')'){
            return true;
        }
        else if(first == '{' && second == '}'){
            return true;
        }
        else if(first == '[' && second == ']'){
            return true;
        }
        return false;
    }
}
