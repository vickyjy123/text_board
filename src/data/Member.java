package data;

import java.time.LocalDateTime;

public class Member {

    private int id;

    private  String loginId;
    private String password;
    private String name;

    private LocalDateTime regDate = LocalDateTime.now();
    private  LocalDateTime updateDate = LocalDateTime.now();

    public Member(int id, String loginId, String password, String name){
        this.id =id;
        this.loginId=loginId;
        this.password=password;
        this.name=name;
    }






    //Getter

    public int getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }





    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
