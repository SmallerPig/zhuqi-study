package zhuqistudyspring.bean;

/**
 * @author zhuqi at 2020/8/9
 */
public class Person {

    private String user;

    private String password;

    public Person(){
        System.out.println("Person.Person");
    }

    public Person(String name, int age){
        System.out.println("Person.Person");
        System.out.println("name = " + name + ", age = " + age);
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
