package personType;



public class MyData {
    private String year;
    private String month;
    private String day;

    public MyData() {
    }

    public MyData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 获取
     *
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取
     *
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置
     *
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获取
     *
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * 设置
     *
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }

    public String toString() {
        return "personType.MyData{year = " + year + ", month = " + month + ", day = " + day + "}";
    }
}