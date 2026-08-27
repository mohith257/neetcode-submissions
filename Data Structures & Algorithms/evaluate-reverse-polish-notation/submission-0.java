class Solution {
    public int evalRPN(String[] tokens) {
        int [] stack=new int[tokens.length];
        int top=-1;
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||  tokens[i].equals("/")){
                int second=stack[top--];
                int first=stack[top--];
                switch(tokens[i]){
                    case "+":{int result=first+second;
                            stack[++top]=result;
                            break;}
                    case "*":{int result=first*second;
                            stack[++top]=result;
                            break;}
                    case "-":{int result=first-second;
                            stack[++top]=result;
                            break;}
                    case "/":{int result=first/second;
                            stack[++top]=result;
                            break;}
                }
            } else {
                int val = Integer.parseInt(tokens[i]);
                stack[++top]=val;
            }
        }
        return stack[top];
    }
}
