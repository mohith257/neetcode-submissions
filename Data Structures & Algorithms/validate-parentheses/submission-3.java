class Solution {
    public boolean isValid(String s) {
        int top =-1;
        if(s.length()<2){
            return false;
        }
        char [] stack=new char[s.length()];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='[' || c=='(' || c=='{'){
                top++;
                stack[top]=c;
            }else{
                switch (c){
                    case ']':if(top>-1 && stack[top]=='['){
                        top--;
                        break;
                    }else{
                        return false;
                    }
                    case ')':if(top>-1 && stack[top]=='('){
                        top--;
                        break;
                    }else{
                        return false;
                    }
                    case '}':if(top>-1 && stack[top]=='{'){
                        top--;
                        break;
                    }else{
                        return false;
                    }
                    default :return false;
                }
            }
        }
        if(top==-1){
            return true;
    }else{return false;}
    }
}
