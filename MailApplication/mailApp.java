package PracticeOOP.MailApplication;

public class mailApp {
    private String firstName;
    private String lastName;
    private String company;
    private String department;
    private String mailId;
    private String password;
    private int mailBoxCapacity;
    private String alternateEmailId;
    private String changePassword;

    public mailApp(String firstName, String lastName, String company,String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.company= company;
        this.mailId = generateEmailId(firstName,lastName,company,department);
        this.password = generatePassword(8);
    }

    private String generateEmailId(String firstName, String lastName, String company, String department) {
        return firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+company+".com";
    }

    private String generatePassword(int size){
        String charUpper = "abcdefghijklmnopqrstuvwxyz";
        String charLower = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "1234567890";
        String splChar = "!@#$&_.~%|";
        String[] passwordSet = new String[]{charLower, charUpper, num, splChar};

        StringBuilder sb = new StringBuilder();
        String password;

        for (int i = 0; i < size; i++) {
            int set = (int) (passwordSet.length * Math.random()); // Randomly select a set (0 to 3)
            int chars = (int) (passwordSet[set].length() * Math.random()); // Randomly select a character from the set
            char pass = passwordSet[set].charAt(chars); // Access the character
            sb.append(pass);
        }
        password = sb.toString();
        return  password;
    }

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }
    public void setAlternateEmailId(String alternateEmailId) {
        this.alternateEmailId = alternateEmailId;
    }
    public void setChangePassword(String changePassword) {
        this.changePassword = changePassword;
    }
    public String getMailId() {
        return mailId;
    }
    public String getPassword() {
        return password;
    }
}
