class Solution {
    public String interpret(String command) {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<command.length();i++){
            char c0 = command.charAt(i);
            if(c0=='G'){
                s.append("G");
            }else if(c0 == '(' && command.charAt(i+1) == ')'){
                s.append("o");
            }else if(c0 == '(' && command.charAt(i+1) == 'a'){
                s.append("al");
            }
        }
        return s.toString();
    }
}
