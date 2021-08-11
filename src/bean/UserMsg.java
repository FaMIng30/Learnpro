package bean;

public class UserMsg {
    private int usermsgid;
    private String gender;
    private  String tellphone;
    private  String truename;

    public  UserMsg(){

    }

    public UserMsg (int usermsgid, String gender, String tellphone, String truename){
        this.usermsgid = usermsgid;
        this.gender = gender;
        this.tellphone = tellphone;
        this.truename = truename;
    }

    @Override
    public String toString (){
        return "UserMsg{" +
                "usermsgid=" + usermsgid +
                ", gender='" + gender + '\'' +
                ", tellphone='" + tellphone + '\'' +
                ", truename='" + truename + '\'' +
                '}';
    }

    public int getUsermsgid (){
        return usermsgid;
    }

    public void setUsermsgid (int usermsgid){
        this.usermsgid = usermsgid;
    }

    public String getGender (){
        return gender;
    }

    public void setGender (String gender){
        this.gender = gender;
    }

    public String getTellphone (){
        return tellphone;
    }

    public void setTellphone (String tellphone){
        this.tellphone = tellphone;
    }

    public String getTruename (){
        return truename;
    }

    public void setTruename (String truename){
        this.truename = truename;
    }
}
