package personType;

public class Student extends Person {
    private final static String grade1="freshman";
    private final static String grade2="sophomore";
    private final static String grade3="junior";
    private final static String grade4="senior";
    public Student(){}
    public Student(String name,String address,String phoneNumber,String emailAddress){
        super(name,address,phoneNumber,emailAddress);
    }

    public String toString() {
        return "class:personType.Student,name:" + this.getName();
    }
}
