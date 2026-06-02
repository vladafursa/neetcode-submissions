class Solution {

    public String encode(List<String> strs) {
    StringBuilder encoded = new StringBuilder();
    for (String str : strs) {
        for (char c : str.toCharArray()) {
            if (c == '/') {
                encoded.append("//"); 
            } else {
                encoded.append(c);
            }
        }
        encoded.append("/:");
    }
    return encoded.toString();
}

public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    StringBuilder current = new StringBuilder();
    
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '/') {
            if (i + 1 < str.length() && str.charAt(i + 1) == '/') {
                current.append('/');
                i++;  
            } else if (i + 1 < str.length() && str.charAt(i + 1) == ':') {
                result.add(current.toString());
                current = new StringBuilder();
                i++; 
            }
        } else {
            current.append(str.charAt(i));
        }
    }
    
    return result;
}
}
