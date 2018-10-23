package models;

public class User {


    private String username, email;

    //Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public User(){

    }

    public User(String username, String email) {
        this.username = this.getUsername();
        this.email = this.getEmail();
    }
}
