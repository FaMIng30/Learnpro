package DataStructre;

public class Users {
    @UserAnotation(value="name",len = 22,type="varchar")
    private String name;
    @UserAnotation(value="age",len = 4,type="int")
    private int age;
    @UserAnotation(value = "gender",type = "varchar",len=220)
    private String gender;

    public Users (){
    }

    public Users (String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public int getAge (){
        return age;
    }

    public void setAge (int age){
        this.age = age;
    }

    public String getGender (){
        return gender;
    }

    public void setGender (String gender){
        this.gender = gender;
    }
}
