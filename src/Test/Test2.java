
package Test;

import personType.*;

import java.util.Random;


public class Test2 {
    public static final String FILENAME="person.txt";
    public static void main(String[] args) {
        //personType.Student personType.Faculty staff
        //MyDate(year,month,day)
        Random rand = new Random();
        int capacity = rand.nextInt(500);
        Person[] persons = new Person[capacity];
        for (int i = 0; i < capacity; i++) {
            //1 personType.Student
            //2 personType.Faculty
            //3 personType.Staff
            //4 personType.Postgraduate
            int type = 1+rand.nextInt(4);
            switch (type) {
                case 1: {
                    //personType.Student
                    persons[i]=new Student(getName(),getAddress(),getPhoneNumber(),getEmailAddress());
                    break;
                }
                case 2: {
                    //personType.Faculty
                    persons[i]=new Faculty(getName(),getAddress(),getPhoneNumber(),getEmailAddress(),getOffice(),getSalary(),getMyData(),getWorkTime(),getRank());
                    break;
                }
                case 3: {
                    //personType.Staff
                    persons[i]=new Staff(getName(),getAddress(),getPhoneNumber(),getEmailAddress(),getOffice(),getSalary(),getMyData(),getTitle());
                    break;
                }
                case 4: {
                    //personType.Postgraduate
                    persons[i]=new Postgraduate(getName(),getAddress(),getPhoneNumber(),getEmailAddress(),getResearchField(),getTutor());
                }
            }
        }
        //打印
        printMessages(persons);
        //将对象信息输出至person.txt
        for(Person person: persons){
            person.fileWrite(FILENAME);
        }
        System.out.println(capacity);
    }

    public static void printMessages(Person[] persons) {
        for(Person person: persons){
            System.out.println(person);
        }
    }


    //生成随机日期
    public static MyData getMyData() {
        Random rand = new Random();
        //生成随机年份
        String year = 2000+rand.nextInt(25) + "";
        int m = rand.nextInt(13);
        String month = m + "";
        String day = "";
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            //一个月有31天
            day = rand.nextInt(32) + "";
        } else {
            //一个月有30天
            day = rand.nextInt(31) + "";
        }
        return new MyData(year, month, day);
    }

    //生成随机名字
    public static String getName() {
        return "name" + new Random().nextInt(100);
    }

    //生成随机地址
    public static String getAddress() {
        return "address" + new Random().nextInt(100);
    }

    //生成随机电话
    public static String getPhoneNumber() {
        return "phoneNumber" + new Random().nextInt(100);
    }

    //生成随机邮箱
    public static String getEmailAddress() {
        return "emailAddress" + new Random().nextInt(100);
    }

    //升成随机办公室
    public static String getOffice() {
        return "office" + new Random().nextInt(100);
    }

    //生成随机薪资
    public static String getSalary() {
        return "salary" + new Random().nextInt(100);
    }

    //生成随机办公时间
    public static String getWorkTime() {
        return "time" + new Random().nextInt(100);
    }

    //生成随机等级
    public static String getRank() {
        return "rank" + new Random().nextInt(100);
    }

    //生成随机职称
    public static String getTitle() {
        return "title" + new Random().nextInt(100);
    }

    //生成随机研究方向
    public static String getResearchField() {
        return "research" + new Random().nextInt(100);
    }

    //生成随机导师姓名
    public static String getTutor() {
        return "tutor" + new Random().nextInt(100);
    }

}
