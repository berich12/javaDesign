package personType;

public abstract class Employee extends Person {
    private String office;
    private String salary;
    private MyData data;

    public Employee() {
    }

    public Employee(String name, String address, String phoneNumber, String emailAddress,String office, String salary, MyData data) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.data = data;
    }

    /**
     * 获取
     * @return office
     */
    public String getOffice() {
        return office;
    }

    /**
     * 设置
     * @param office
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * 获取
     * @return salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * 获取
     * @return data
     */
    public MyData getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(MyData data) {
        this.data = data;
    }

    public String toString() {
        return "personType.Employee{office = " + office + ", salary = " + salary + ", data = " + data + "}";
    }
}
