package personType;

public class Faculty extends Employee {
    private String workTime;
    private String rank;

    public Faculty() {
    }

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, String salary, MyData data, String workTime, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, data);
        this.workTime = workTime;
        this.rank = rank;
    }

    /**
     * 获取
     * @return workTime
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * 设置
     * @param workTime
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * 获取
     * @return rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * 设置
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() {
        return "class:personType.Faculty,name:"+this.getName();
    }
}
