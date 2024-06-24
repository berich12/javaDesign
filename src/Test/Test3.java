
package Test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import personType.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Test3 extends Application {
    public static final String FILENAME = "person.txt";

    public static void main(String[] args) {
        //personType.Student personType.Faculty staff
        //MyDate(year,month,day)
        launch(args);

    }

    //获取随机人物列表
    public static ArrayList<Person> gerPersonList() {
        Random rand = new Random();
        int capacity = 30+rand.nextInt(500);


        ArrayList<Person> persons= new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            //1 personType.Student
            //2 personType.Faculty
            //3 personType.Staff
            //4 personType.Postgraduate
            int type = 1+rand.nextInt( 5);
            switch (type) {
                case 1: {
                    //personType.Student
                    persons.add(new Student("Student"+getName(), getAddress(), getPhoneNumber(), getEmailAddress()));
                    break;
                }
                case 2: {
                    //personType.Faculty
                    persons.add(new Faculty("Faculty"+getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getOffice(), getSalary(), getMyData(), getWorkTime(), getRank()));
                    break;
                }
                case 3: {
                    //personType.Staff
                    persons.add(new Staff("Staff"+getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getOffice(), getSalary(), getMyData(), getTitle()));
                    break;
                }
                case 4: {
                    //personType.Postgraduate
                    persons.add(new Postgraduate("Postgraduate"+getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getResearchField(), getTutor()));
                }
            }
        }
        return persons;
    }

    public static void printMessages(ArrayList<Person> persons) {
        for (Person person : persons) {
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
        return "" + new Random().nextInt(100);
    }

    //生成随机地址
    public static String getAddress() {
        return "address" + new Random().nextInt(100);
    }

    //生成随机电话
    public static String getPhoneNumber() {
        return "" + new Random().nextInt(100000);
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Person> persons=gerPersonList();
        ObservableList<Person> list = FXCollections.observableArrayList();
        list.addAll(persons);
//        for (personType.Person person : list) {
//            System.out.println(person);
//        }

        //person
        TableView<Person> tableView=new TableView<>(list);
        TableColumn<Person,String> tc_name=new TableColumn<>("姓名");
        tableView.getColumns().add(tc_name);

        TableColumn<Person,String> tc_address=new TableColumn<>("地址");
        tableView.getColumns().add(tc_address);

        TableColumn<Person,String> tc_phoneNumber=new TableColumn<>("电话");
        tableView.getColumns().add(tc_phoneNumber);

        TableColumn<Person,String> tc_emailAddress=new TableColumn<>("邮箱");
        tableView.getColumns().add(tc_emailAddress);

        //personType.Postgraduate
        TableColumn<Person,String> tc_tutor=new TableColumn<>("导师");
        tableView.getColumns().add(tc_tutor);

        TableColumn<Person,String> tc_searchField=new TableColumn<>("研究方向");
        tableView.getColumns().add(tc_searchField);

        //personType.Staff
        TableColumn<Person,String> tc_title=new TableColumn<>("职称");
        tableView.getColumns().add(tc_title);

        //personType.Faculty
        TableColumn<Person,String> tc_workTime=new TableColumn<>("工作时间");
        tableView.getColumns().add(tc_workTime);

        TableColumn<Person,String> tc_rank=new TableColumn<>("等级");
        tableView.getColumns().add(tc_rank);

        //employee
        TableColumn<Person,String> tc_salary=new TableColumn<>("薪资");
        tableView.getColumns().add(tc_salary);

        TableColumn<Person,String> tc_office=new TableColumn<>("办公室");
        tableView.getColumns().add(tc_office);

        TableColumn<Person,String> tc_data=new TableColumn<>("入职日期");
        tableView.getColumns().add(tc_data);





        //person
        tc_name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        tc_address.setCellValueFactory(new PropertyValueFactory<Person,String>("address"));
        tc_phoneNumber.setCellValueFactory(new PropertyValueFactory<Person,String>("phoneNumber"));
        tc_emailAddress.setCellValueFactory(new PropertyValueFactory<Person,String>("emailAddress"));
        //personType.Postgraduate
        tc_tutor.setCellValueFactory(new PropertyValueFactory<Person,String>("tutor"));
        tc_searchField.setCellValueFactory(new PropertyValueFactory<Person,String>("searchField"));
        //personType.Staff
        tc_title.setCellValueFactory(new PropertyValueFactory<Person,String>("title"));
        //personType.Faculty
        tc_workTime.setCellValueFactory(new PropertyValueFactory<Person,String>("workTime"));
        tc_rank.setCellValueFactory(new PropertyValueFactory<Person,String>("rank"));
        //employee
        tc_salary.setCellValueFactory(new PropertyValueFactory<Person,String>("salary"));
        tc_office.setCellValueFactory(new PropertyValueFactory<Person,String>("office"));
        tc_data.setCellValueFactory(new PropertyValueFactory<Person,String>("data"));



        AnchorPane ap=new AnchorPane();

        ap.getChildren().addAll(tableView);

        //添加按钮
        Button bu_add=new Button("添加人物");
        bu_add.setLayoutX(400);
        bu_add.setLayoutY(450);
        bu_add.setOnAction(event->{
            list.add(gerPersonList().get(0));
            tableView.refresh();
            System.out.println("添加成功");
        });
        ap.getChildren().add(bu_add);

        //删除按钮
        Button bu_delete=new Button("删除人物");
        bu_delete.setLayoutX(500);
        bu_delete.setLayoutY(450);
        bu_delete.setOnAction(event->{
            System.out.println("请输入要删除第几行的人物");
            int line=new Scanner(System.in).nextInt()-1;
            list.remove(line);
            tableView.refresh();
            System.out.println("成功删除");
        });
        ap.getChildren().add(bu_delete);

        //退出按钮
        Button bu_exit=new Button("退出");
        bu_exit.setLayoutX(800);
        bu_exit.setLayoutY(450);
        bu_exit.setOnAction(event->{
            System.exit(0);
        });
        ap.getChildren().add(bu_exit);

        //修改按钮
        Button bu_modify=new Button("修改信息");
        bu_modify.setLayoutX(700);
        bu_modify.setLayoutY(450);
        bu_modify.setOnAction(event->{
            System.out.println("请输入你要修改的行数");
            Scanner sc=new Scanner(System.in);
            int line=new Scanner(System.in).nextInt()-1;
            Person temp=list.get(line);
            System.out.println("您要修改的对象是");
            System.out.println(temp);
            System.out.println("请输入修改后的姓名");
            temp.setName(sc.nextLine());
            System.out.println("请输入修改后的地址");
            temp.setAddress(sc.nextLine());
            System.out.println("请输入修改后的电话");
            temp.setPhoneNumber(sc.nextLine());
            System.out.println("请输入修改后的邮箱");
            temp.setEmailAddress(sc.nextLine());
            if (temp instanceof Postgraduate){
                System.out.println("请输入修改后的导师姓名");
                ((Postgraduate) temp).setTutor(sc.nextLine());
                System.out.println("请输入修改后的研究方向");
                ((Postgraduate) temp).setSearchField(sc.nextLine());
            }
            if(temp instanceof Employee){
                System.out.println("请输入修改后的办公室");
                ((Employee)temp).setOffice(sc.nextLine());
                System.out.println("请输入修改后的薪资");
                ((Employee)temp).setSalary(sc.nextLine());
            }

            if (temp instanceof Staff) {
                System.out.println("请输入修改后的职称");
                ((Staff) temp).setTitle(sc.nextLine());
            }
            if (temp instanceof Faculty){
                System.out.println("请输入修改后的上班时间");
                ((Faculty) temp).setWorkTime(sc.nextLine());
                System.out.println("请输入修改后的等级");
                ((Faculty) temp).setRank(sc.nextLine());
            }
            System.out.println("修改成功");
            list.set(line,temp);
            tableView.refresh();
        });
        ap.getChildren().add(bu_modify);

        //查询按钮
        Button bu_search=new Button("查找人物");
        bu_search.setLayoutX(600);
        bu_search.setLayoutY(450);
        bu_search.setOnAction(event->{
            System.out.println("请输入你要查询的类型:");
            System.out.println("1.personType.Student");
            System.out.println("2.personType.Faculty");
            System.out.println("3.personType.Staff");
            System.out.println("4.personType.Postgraduate");
            int choice=new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:{
                    //personType.Student
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!(list.get(i) instanceof Student)){
                                list.remove(i);
                            }
                        }
                    }

                    tableView.refresh();
                    System.out.println("查询成功");
                    break;
                }
                case 2:{
                    //personType.Faculty
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!(list.get(i) instanceof Faculty)){
                                list.remove(i);
                            }
                        }
                    }
                    tableView.refresh();
                    System.out.println("查询成功");
                    break;

                }
                case 3:{
                    //personType.Staff
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!(list.get(i) instanceof Staff)){
                                list.remove(i);
                            }
                        }
                    }
                    tableView.refresh();
                    System.out.println("查询成功");
                    break;
                }
                case 4:{
                    //personType.Postgraduate
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!(list.get(i) instanceof Postgraduate)){
                                list.remove(i);
                            }
                        }
                    }
                    tableView.refresh();
                    System.out.println("查询成功");
                    break;
                }
            }

        });
        ap.getChildren().add(bu_search);





        Scene scene=new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();

    }
}
