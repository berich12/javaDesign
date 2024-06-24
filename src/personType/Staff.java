package personType;

public class Staff extends Employee {
    private String title;

    public Staff() {
    }

    public Staff(String name, String address, String phoneNumber, String emailAddress, String office, String salary, MyData data, String title) {
        super(name,address,phoneNumber,emailAddress,office,salary,data);
        this.title = title;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "class:personType.Staff,name:"+this.getName();
    }
}
