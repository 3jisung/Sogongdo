package common;

public enum Bool {
    TRUE(true, "Y"),
    FALSE(false, "N");

    public final boolean bool;
    public final String yn;

    Bool(boolean bool, String yn){
        this.bool = bool;
        this.yn = yn;
    }

    public static Bool get(boolean obj){
        if(Bool.TRUE.bool == obj)
            return Bool.TRUE;
        else
            return Bool.FALSE;
    }
    public static Bool get(String obj){
        if(Bool.TRUE.yn.equals(obj))
            return Bool.TRUE;
        else
            return Bool.FALSE;
    }
}
