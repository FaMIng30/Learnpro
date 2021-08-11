package bean;

public class User {

    private String username;
    private String passwords;
    private int userid;
    private String logopath;
    public User (){

    }

    @Override
    public String toString (){
        return "User{" +
//                "logopath='" + logopath + '\'' +
                ", username='" + username + '\'' +
                ", passwords='" + passwords + '\'' +
//                ", userid=" + userid +
                '}';
    }

    public User (String username, String passwords){
        this.username = username;
        this.passwords = passwords;
    }

    public String getLogopath (){
        return logopath;
    }

    public void setLogopath (String logopath){
        this.logopath = logopath;
    }

    public int getUserid (){
        return userid;
    }

    public void setUserid (int userid){
        this.userid = userid;
    }




    public String getPasswords (){
        return passwords;
    }

    public void setPasswords (String passwords){
        this.passwords = passwords;
    }
}
