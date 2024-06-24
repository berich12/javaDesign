package personType;

import java.io.*;

public abstract class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person() {
    }

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 设置
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "personType.Person{name = " + name + ", address = " + address + ", phoneNumber = " + phoneNumber + ", emailAddress = " + emailAddress + "}";
    }

    public boolean fileWrite(String fileName) {
        String content=fileRead(fileName)+toString();
        File writeName = new File(fileName);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
            out.write(content);
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public  String fileRead(String pathName) {
        File fileName = new File(pathName);
        String line = "";
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(reader);

            String tempLine="";
            while (tempLine != null) {
                tempLine = br.readLine();
                if (tempLine != null) {
                    line += tempLine;
                    line += "\n";
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
}


