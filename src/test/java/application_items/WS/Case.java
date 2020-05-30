package application_items.WS;

public class Case {
    public String user;
    public boolean strict;

    public Case(String user, boolean strict){
        this.user = user;
        this.strict = strict;
    }

    public Case(){}

    public String getUser(){
        return user;
    }

     public boolean getStrict() {
        return strict;
     }

     public void setUser(String user){
        this.user = user;
     }

     public void setStrict(boolean strict){
        this.strict = strict;
     }

     @Override
    public String toString(){
        return "User [username = " + user + ", strict = " + strict + "]";
     }
}
