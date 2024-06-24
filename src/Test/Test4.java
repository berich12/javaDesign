package Test;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import personType.*;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;






public class Test4 extends Application {
    public static final int deleteButtonHeight = 24;
    Button delete1 = new Button("删除");
    Button delete2 = new Button("删除");
    Button delete3 = new Button("删除");
    Button delete4 = new Button("删除");
    Button delete5 = new Button("删除");
    Button delete6 = new Button("删除");
    Button delete7 = new Button("删除");
    Button delete8 = new Button("删除");
    Button delete9 = new Button("删除");
    Button delete10 = new Button("删除");
    Button delete11 = new Button("删除");
    Button delete12 = new Button("删除");
    Button delete13 = new Button("删除");
    Button delete14 = new Button("删除");
    Button delete15 = new Button("删除");

    Button search1=new Button("Student");
    Button search2=new Button("Faculty");
    Button search3=new Button("Staff");
    Button search4=new Button("Postgraduate");
    Button modify1 = new Button("修改");
    Button modify2 = new Button("修改");
    Button modify3 = new Button("修改");
    Button modify4 = new Button("修改");
    Button modify5 = new Button("修改");
    Button modify6 = new Button("修改");
    Button modify7 = new Button("修改");
    Button modify8 = new Button("修改");
    Button modify9 = new Button("修改");
    Button modify10 = new Button("修改");
    Button modify11 = new Button("修改");
    Button modify12 = new Button("修改");
    Button modify13 = new Button("修改");
    Button modify14 = new Button("修改");
    Button modify15 = new Button("修改");

    Button confirmButton=new Button("确定修改");

    TextField nameField = new TextField();
    TextField addressField = new TextField();
    TextField phoneNumberField = new TextField();
    TextField emailAddressField = new TextField();
    TextField tutorField = new TextField();
    TextField searchField = new TextField();
    TextField titleField = new TextField();
    TextField workTimeField = new TextField();
    TextField rankField = new TextField();
    TextField salaryField = new TextField();
    TextField officeField = new TextField();

    int modifyChoice;




    public static void main(String[] args) {
        //personType.Student personType.Faculty staff
        //MyDate(year,month,day)
        launch(args);

    }

    //获取随机人物列表
    public static ArrayList<Person> gerPersonList() {
        Random rand = new Random();
        int capacity = 30 + rand.nextInt(500);


        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            //1 personType.Student
            //2 personType.Faculty
            //3 personType.Staff
            //4 personType.Postgraduate
            int type = 1 + rand.nextInt(5);
            switch (type) {
                case 1: {
                    //personType.Student
                    persons.add(new Student("Student" + getName(), getAddress(), getPhoneNumber(), getEmailAddress()));
                    break;
                }
                case 2: {
                    //personType.Faculty
                    persons.add(new Faculty("Faculty" + getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getOffice(), getSalary(), getMyData(), getWorkTime(), getRank()));
                    break;
                }
                case 3: {
                    //personType.Staff
                    persons.add(new Staff("Staff" + getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getOffice(), getSalary(), getMyData(), getTitle()));
                    break;
                }
                case 4: {
                    //personType.Postgraduate
                    persons.add(new Postgraduate("Postgraduate" + getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getResearchField(), getTutor()));
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
        String year = 2000 + rand.nextInt(25) + "";
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
        return "SONGWEILONG" + new Random().nextInt(100);
    }

    //生成随机地址
    public static String getAddress() {
        return "EARTH" + new Random().nextInt(100);
    }

    //生成随机电话
    public static String getPhoneNumber() {
        return "" + new Random().nextInt(100000);
    }

    //生成随机邮箱
    public static String getEmailAddress() {
        return  new Random().nextInt(100)+"@qq.com" ;
    }

    //升成随机办公室
    public static String getOffice() {
        return "Mars" + new Random().nextInt(100);
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
        ArrayList<Person> persons = gerPersonList();
        ObservableList<Person> list = FXCollections.observableArrayList();
        list.addAll(persons);
//        for (personType.Person person : list) {
//            System.out.println(person);
//        }

        //person
        TableView<Person> tableView = new TableView<>(list);
        TableColumn<Person, String> tc_name = new TableColumn<>("姓名");
        tableView.getColumns().add(tc_name);

        TableColumn<Person, String> tc_address = new TableColumn<>("地址");
        tableView.getColumns().add(tc_address);

        TableColumn<Person, String> tc_phoneNumber = new TableColumn<>("电话");
        tableView.getColumns().add(tc_phoneNumber);

        TableColumn<Person, String> tc_emailAddress = new TableColumn<>("邮箱");
        tableView.getColumns().add(tc_emailAddress);

        //personType.Postgraduate
        TableColumn<Person, String> tc_tutor = new TableColumn<>("导师");
        tableView.getColumns().add(tc_tutor);

        TableColumn<Person, String> tc_searchField = new TableColumn<>("研究方向");
        tableView.getColumns().add(tc_searchField);

        //personType.Staff
        TableColumn<Person, String> tc_title = new TableColumn<>("职称");
        tableView.getColumns().add(tc_title);

        //personType.Faculty
        TableColumn<Person, String> tc_workTime = new TableColumn<>("工作时间");
        tableView.getColumns().add(tc_workTime);

        TableColumn<Person, String> tc_rank = new TableColumn<>("等级");
        tableView.getColumns().add(tc_rank);

        //employee
        TableColumn<Person, String> tc_salary = new TableColumn<>("薪资");
        tableView.getColumns().add(tc_salary);

        TableColumn<Person, String> tc_office = new TableColumn<>("办公室");
        tableView.getColumns().add(tc_office);

        TableColumn<Person, String> tc_data = new TableColumn<>("入职日期");
        tableView.getColumns().add(tc_data);


        //person
        tc_name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        tc_address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        tc_phoneNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        tc_emailAddress.setCellValueFactory(new PropertyValueFactory<Person, String>("emailAddress"));
        //personType.Postgraduate
        tc_tutor.setCellValueFactory(new PropertyValueFactory<Person, String>("tutor"));
        tc_searchField.setCellValueFactory(new PropertyValueFactory<Person, String>("searchField"));
        //personType.Staff
        tc_title.setCellValueFactory(new PropertyValueFactory<Person, String>("title"));
        //personType.Faculty
        tc_workTime.setCellValueFactory(new PropertyValueFactory<Person, String>("workTime"));
        tc_rank.setCellValueFactory(new PropertyValueFactory<Person, String>("rank"));
        //employee
        tc_salary.setCellValueFactory(new PropertyValueFactory<Person, String>("salary"));
        tc_office.setCellValueFactory(new PropertyValueFactory<Person, String>("office"));
        tc_data.setCellValueFactory(new PropertyValueFactory<Person, String>("data"));


        AnchorPane ap = new AnchorPane();

        ap.getChildren().addAll(tableView);

        //添加按钮
        Button bu_add = new Button("添加人物");
        bu_add.setStyle("-fx-background-color: PINK");
        bu_add.setLayoutX(400);
        bu_add.setLayoutY(450);
        bu_add.setOnAction(event -> {
            setSearchButtonVisual(false);
            setDeleteButtonVisual(false);
            setTextFieldNotVisible();
            list.add(gerPersonList().get(0));
            System.out.println("添加成功");
            tableView.refresh();


        });

        ap.getChildren().add(bu_add);


        //删除按钮
        Button bu_delete = new Button("删除人物");
        bu_delete.setStyle("-fx-background-color: PINK");
        bu_delete.setLayoutX(500);
        bu_delete.setLayoutY(450);

        setDelete_bu(list, tableView, ap, 975, 22 + 0 * deleteButtonHeight, 0, delete1);
        setDelete_bu(list, tableView, ap, 975, 22 + 1 * deleteButtonHeight, 1, delete2);
        setDelete_bu(list, tableView, ap, 975, 22 + 2 * deleteButtonHeight, 2, delete3);
        setDelete_bu(list, tableView, ap, 975, 22 + 3 * deleteButtonHeight, 3, delete4);
        setDelete_bu(list, tableView, ap, 975, 22 + 4 * deleteButtonHeight, 4, delete5);
        setDelete_bu(list, tableView, ap, 975, 22 + 5 * deleteButtonHeight, 5, delete6);
        setDelete_bu(list, tableView, ap, 975, 22 + 6 * deleteButtonHeight, 6, delete7);
        setDelete_bu(list, tableView, ap, 975, 22 + 7 * deleteButtonHeight, 7, delete8);
        setDelete_bu(list, tableView, ap, 975, 22 + 8 * deleteButtonHeight, 8, delete9);
        setDelete_bu(list, tableView, ap, 975, 22 + 9 * deleteButtonHeight, 9, delete10);
        setDelete_bu(list, tableView, ap, 975, 22 + 10 * deleteButtonHeight, 10, delete11);
        setDelete_bu(list, tableView, ap, 975, 22 + 11 * deleteButtonHeight, 11, delete12);
        setDelete_bu(list, tableView, ap, 975, 22 + 12 * deleteButtonHeight, 12, delete13);
        setDelete_bu(list, tableView, ap, 975, 22 + 13 * deleteButtonHeight, 13, delete14);
        setDelete_bu(list, tableView, ap, 975, 22 + 14 * deleteButtonHeight, 14, delete15);

        setDeleteButtonVisual(false);
        bu_delete.setOnAction(event -> {
            setSearchButtonVisual(false);
            setDeleteButtonVisual(true);
            setModifyButtonVisual(false);
            setTextFieldNotVisible();

        });
        ap.getChildren().add(bu_delete);

        //退出按钮
        Button bu_exit = new Button("退出");
        bu_exit.setStyle("-fx-background-color: LIGHTBLUE");
        bu_exit.setLayoutX(800);
        bu_exit.setLayoutY(450);
        bu_exit.setOnAction(event -> {
            System.exit(0);
        });
        ap.getChildren().add(bu_exit);

        //修改按钮
        Button bu_modify = new Button("修改信息");
        bu_modify.setStyle("-fx-background-color: PINK");

        confirmButton.setLayoutX(1040);
        confirmButton.setLayoutY(22+17*deleteButtonHeight);

        confirmButton.setOnAction(event -> {
            Person temp = list.get(modifyChoice);
            //姓名
            nameField.setVisible(true);
            temp.setName(nameField.getText());
            //地址
            addressField.setVisible(true);
            temp.setAddress(addressField.getText());
            //电话
            phoneNumberField.setVisible(true);
            temp.setPhoneNumber(phoneNumberField.getText());
            //邮箱
            emailAddressField.setVisible(true);
            temp.setEmailAddress(emailAddressField.getText());
            if (temp instanceof Postgraduate) {
                //导师
                tutorField.setVisible(true);
                ((Postgraduate) temp).setTutor(tutorField.getText());
                //研究方向
                searchField.setVisible(true);
                ((Postgraduate) temp).setSearchField(searchField.getText());
            }
            if (temp instanceof Employee) {
                //办公室
                officeField.setVisible(true);
                ((Employee) temp).setOffice(officeField.getText());
                //工资
                salaryField.setVisible(true);
                ((Employee) temp).setSalary(salaryField.getText());
            }
            if (temp instanceof Staff) {
                //职称
                titleField.setVisible(true);
                ((Staff) temp).setTitle(titleField.getText());
            }
            if (temp instanceof Faculty) {
                //上班时间
                workTimeField.setVisible(true);
                ((Faculty) temp).setWorkTime(workTimeField.getText());
                //等级
                rankField.setVisible(true);
                ((Faculty) temp).setRank(rankField.getText());
            }
            System.out.println("修改成功");
            list.set(modifyChoice, temp);
        });

        confirmButton.setVisible(false);
        ap.getChildren().add(confirmButton);

        bu_modify.setLayoutX(700);
        bu_modify.setLayoutY(450);

        modify1.setLayoutX(975);
        modify2.setLayoutX(975);
        modify3.setLayoutX(975);
        modify4.setLayoutX(975);
        modify5.setLayoutX(975);
        modify6.setLayoutX(975);
        modify7.setLayoutX(975);
        modify8.setLayoutX(975);
        modify9.setLayoutX(975);
        modify10.setLayoutX(975);
        modify11.setLayoutX(975);
        modify12.setLayoutX(975);
        modify13.setLayoutX(975);
        modify14.setLayoutX(975);
        modify15.setLayoutX(975);

        modify1.setLayoutY(22+0*deleteButtonHeight);
        modify2.setLayoutY(22+1*deleteButtonHeight);
        modify3.setLayoutY(22+2*deleteButtonHeight);
        modify4.setLayoutY(22+3*deleteButtonHeight);
        modify5.setLayoutY(22+4*deleteButtonHeight);
        modify6.setLayoutY(22+5*deleteButtonHeight);
        modify7.setLayoutY(22+6*deleteButtonHeight);
        modify8.setLayoutY(22+7*deleteButtonHeight);
        modify9.setLayoutY(22+8*deleteButtonHeight);
        modify10.setLayoutY(22+9*deleteButtonHeight);
        modify11.setLayoutY(22+10*deleteButtonHeight);
        modify12.setLayoutY(22+11*deleteButtonHeight);
        modify13.setLayoutY(22+12*deleteButtonHeight);
        modify14.setLayoutY(22+13*deleteButtonHeight);
        modify15.setLayoutY(22+14*deleteButtonHeight);




        //设置事件
        setPerModifyButtonEvent(list,modify1,0);
        setPerModifyButtonEvent(list,modify2,1);
        setPerModifyButtonEvent(list,modify3,2);
        setPerModifyButtonEvent(list,modify4,3);
        setPerModifyButtonEvent(list,modify5,4);
        setPerModifyButtonEvent(list,modify6,5);
        setPerModifyButtonEvent(list,modify7,6);
        setPerModifyButtonEvent(list,modify8,7);
        setPerModifyButtonEvent(list,modify9,8);
        setPerModifyButtonEvent(list,modify10,9);
        setPerModifyButtonEvent(list,modify11,10);
        setPerModifyButtonEvent(list,modify12,11);
        setPerModifyButtonEvent(list,modify13,12);
        setPerModifyButtonEvent(list,modify14,13);
        setPerModifyButtonEvent(list,modify15,14);


        ap.getChildren().add(modify1);
        ap.getChildren().add(modify2);
        ap.getChildren().add(modify3);
        ap.getChildren().add(modify4);
        ap.getChildren().add(modify5);
        ap.getChildren().add(modify6);
        ap.getChildren().add(modify7);
        ap.getChildren().add(modify8);
        ap.getChildren().add(modify9);
        ap.getChildren().add(modify10);
        ap.getChildren().add(modify11);
        ap.getChildren().add(modify12);
        ap.getChildren().add(modify13);
        ap.getChildren().add(modify14);
        ap.getChildren().add(modify15);



        setModifyButtonVisual(false);

        nameField.setLayoutX(1025);
        addressField.setLayoutX(1025);
        phoneNumberField.setLayoutX(1025);
        emailAddressField.setLayoutX(1025);
        tutorField.setLayoutX(1025);
        searchField.setLayoutX(1025);
        titleField.setLayoutX(1025);
        workTimeField.setLayoutX(1025);
        rankField.setLayoutX(1025);
        salaryField.setLayoutX(1025);
        officeField.setLayoutX(1025);


        nameField.setLayoutY(22+0*deleteButtonHeight);
        addressField.setLayoutY(22+1*deleteButtonHeight);
        phoneNumberField.setLayoutY(22+2*deleteButtonHeight);
        emailAddressField.setLayoutY(22+3*deleteButtonHeight);
        tutorField.setLayoutY(22+4*deleteButtonHeight);
        searchField.setLayoutY(22+5*deleteButtonHeight);
        titleField.setLayoutY(22+6*deleteButtonHeight);
        workTimeField.setLayoutY(22+7*deleteButtonHeight);
        rankField.setLayoutY(22+8*deleteButtonHeight);
        salaryField.setLayoutY(22+9*deleteButtonHeight);
        officeField.setLayoutY(22+10*deleteButtonHeight);

        nameField.setPromptText("请输入姓名");
        addressField.setPromptText("请输入地址");
        phoneNumberField.setPromptText("请输入电话");
        emailAddressField.setPromptText("请输入邮箱");
        tutorField.setPromptText("请输入导师姓名");
        searchField.setPromptText("请输入研究方向");
        titleField.setPromptText("请输入职称");
        workTimeField.setPromptText("请输入工作时间");
        rankField.setPromptText("请输入等级");
        salaryField.setPromptText("请输入薪资");
        officeField.setPromptText("请输入办公室");


        setTextFieldNotVisible();


        ap.getChildren().add(nameField);
        ap.getChildren().add(addressField);
        ap.getChildren().add(phoneNumberField);
        ap.getChildren().add(emailAddressField);
        ap.getChildren().add(tutorField);
        ap.getChildren().add(searchField);
        ap.getChildren().add(titleField);
        ap.getChildren().add(workTimeField);
        ap.getChildren().add(rankField);
        ap.getChildren().add(salaryField);
        ap.getChildren().add(officeField);


        bu_modify.setOnAction(event -> {
            setModifyButtonVisual(true);
            setDeleteButtonVisual(false);
            setSearchButtonVisual(false);
            tableView.refresh();
        });
        ap.getChildren().add(bu_modify);

        //查询按钮
        Button bu_search = new Button("查找人物");
        bu_search.setStyle("-fx-background-color: PINK");
        bu_search.setLayoutX(600);
        bu_search.setLayoutY(450);
        bu_search.setOnAction(event -> {
            setModifyButtonVisual(false);
            setDeleteButtonVisual(false);
            setTextFieldNotVisible();
            search1.setLayoutX(600);
            search2.setLayoutX(600);
            search3.setLayoutX(600);
            search4.setLayoutX(600);
            search1.setLayoutY(450+1*deleteButtonHeight);
            search2.setLayoutY(450+2*deleteButtonHeight);
            search3.setLayoutY(450+3*deleteButtonHeight);
            search4.setLayoutY(450+4*deleteButtonHeight);

            setSearchButtonVisual(true);
            search1.setOnAction(event1 ->{
                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i) instanceof Student)) {
                            list.remove(i);
                        }
                    }
                }
                tableView.refresh();
                System.out.println("查询成功");
            } );

            search2.setOnAction(event1 -> {
                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i) instanceof Faculty)) {
                            list.remove(i);
                        }
                    }
                }
                tableView.refresh();
            });

            search3.setOnAction(event1 -> {
                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i) instanceof Staff)) {
                            list.remove(i);
                        }
                    }
                }
                tableView.refresh();
            });

            search4.setOnAction(event1 -> {
                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i) instanceof Postgraduate)) {
                            list.remove(i);
                        }
                    }
                }
                tableView.refresh();
            });

            ap.getChildren().add(search1);
            ap.getChildren().add(search2);
            ap.getChildren().add(search3);
            ap.getChildren().add(search4);
            tableView.refresh();

        });
        ap.getChildren().add(bu_search);


        Scene scene = new Scene(ap);
        scene.setFill(Color.PINK);


        primaryStage.setScene(scene);
        primaryStage.setHeight(650);
        primaryStage.setWidth(1200);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();

    }

    private void setTextFieldNotVisible() {
        nameField.setVisible(false);
        addressField.setVisible(false);
        phoneNumberField.setVisible(false);
        emailAddressField.setVisible(false);
        tutorField.setVisible(false);
        searchField.setVisible(false);
        titleField.setVisible(false);
        workTimeField.setVisible(false);
        rankField.setVisible(false);
        salaryField.setVisible(false);
        officeField.setVisible(false);
        confirmButton.setVisible(false);
    }

    private void setPerModifyButtonEvent(ObservableList<Person> list,Button modify,int line) {
        modify.setOnAction(event -> {
            modifyChoice=line;
            confirmButton.setVisible(true);
            modifyEvent(list,line);
        });
    }

    private void setSearchButtonVisual(boolean value) {
        search1.setVisible(value);
        search2.setVisible(value);
        search3.setVisible(value);
        search4.setVisible(value);

    }

    private void setDeleteButtonVisual(boolean value) {
        delete1.setVisible(value);
        delete2.setVisible(value);
        delete3.setVisible(value);
        delete4.setVisible(value);
        delete5.setVisible(value);
        delete6.setVisible(value);
        delete7.setVisible(value);
        delete8.setVisible(value);
        delete9.setVisible(value);
        delete10.setVisible(value);
        delete11.setVisible(value);
        delete12.setVisible(value);
        delete13.setVisible(value);
        delete14.setVisible(value);
        delete15.setVisible(value);
    }

    private void setDelete_bu(ObservableList<Person> list, TableView<Person> tableView, AnchorPane ap, double x, double y, int index, Button delete) {
        delete.setLayoutX(x);
        delete.setLayoutY(y);
        delete.setOnAction(event1 -> {
            list.remove(index);
            tableView.refresh();
            System.out.println("成功删除");
        });
        ap.getChildren().add(delete);
    }

    private void setModifyButtonVisual(boolean value) {
        modify1.setVisible(value);
        modify2.setVisible(value);
        modify3.setVisible(value);
        modify4.setVisible(value);
        modify5.setVisible(value);
        modify6.setVisible(value);
        modify7.setVisible(value);
        modify8.setVisible(value);
        modify9.setVisible(value);
        modify10.setVisible(value);
        modify11.setVisible(value);
        modify12.setVisible(value);
        modify13.setVisible(value);
        modify14.setVisible(value);
        modify15.setVisible(value);
    }


    private void modifyEvent(ObservableList<Person> list,int line){
        Person temp = list.get(line);
        //姓名
        nameField.setVisible(true);
        nameField.setText(temp.getName());
        temp.setName(nameField.getText());
        //地址
        addressField.setVisible(true);
        addressField.setText(temp.getAddress());
        temp.setAddress(addressField.getText());
        //电话
        phoneNumberField.setVisible(true);
        phoneNumberField.setText(temp.getPhoneNumber());
        temp.setPhoneNumber(phoneNumberField.getText());
        //邮箱
        emailAddressField.setVisible(true);
        emailAddressField.setText(temp.getEmailAddress());
        temp.setEmailAddress(emailAddressField.getText());
        if (temp instanceof Postgraduate) {
            //导师
            tutorField.setVisible(true);
            tutorField.setText(((Postgraduate) temp).getTutor());
            ((Postgraduate) temp).setTutor(tutorField.getText());
            //研究方向
            searchField.setVisible(true);
            searchField.setText(((Postgraduate) temp).getName());
            ((Postgraduate) temp).setSearchField(searchField.getText());
        }
        if (temp instanceof Employee) {
            //办公室
            officeField.setVisible(true);
            officeField.setText(((Employee) temp).getOffice());
            ((Employee) temp).setOffice(officeField.getText());
            //工资
            salaryField.setVisible(true);
            salaryField.setText(((Employee) temp).getSalary());
            ((Employee) temp).setSalary(salaryField.getText());
        }
        if (temp instanceof Staff) {
            //职称
            titleField.setVisible(true);
            titleField.setText(((Staff) temp).getTitle());
            ((Staff) temp).setTitle(titleField.getText());
        }
        if (temp instanceof Faculty) {
            //上班时间
            workTimeField.setVisible(true);
            workTimeField.setText(((Faculty) temp).getWorkTime());
            ((Faculty) temp).setWorkTime(workTimeField.getText());
            //等级
            rankField.setVisible(true);
            rankField.setText(((Faculty) temp).getRank());
            ((Faculty) temp).setRank(rankField.getText());
        }
        System.out.println("修改成功");
        list.set(line, temp);
    }

}