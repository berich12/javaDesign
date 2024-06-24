package personType;

public class Postgraduate extends Student {
    private String searchField;
    private String tutor;

    public Postgraduate() {
    }

    public Postgraduate(String name,String address,String phoneNumber,String emailAddress,String searchField, String tutor) {
        super(name,address,phoneNumber,emailAddress);
        this.searchField = searchField;
        this.tutor = tutor;
    }

    /**
     * 获取
     * @return searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * 设置
     * @param searchField
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * 获取
     * @return tutor
     */
    public String getTutor() {
        return tutor;
    }

    /**
     * 设置
     * @param tutor
     */
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String toString() {
        return "class:personType.Postgraduate,name:"+this.getName();
    }
}
