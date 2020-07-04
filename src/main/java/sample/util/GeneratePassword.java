package sample.util;

public class GeneratePassword {

  public static void addNewUser(String userName, String password) {
    String hashedPass = EncodeUtil.passwordEncode(password, userName);
    System.out.println(hashedPass);
  }

  public static void main(String[] args) {
    addNewUser("cmsk1","abcdefg1");
    addNewUser("cmsk2","abcdefg2");
    addNewUser("cmsk3","abcdefg3");
    addNewUser("cmsk4","abcdefg4");
    addNewUser("cmsk5","abcdefg5");
    addNewUser("cmsk6","abcdefg6");
    addNewUser("cmsk7","abcdefg7");
    addNewUser("cmsk8","abcdefg8");
    addNewUser("cmsk9","abcdefg9");
    addNewUser("cmsk10","abcdefg10");

  }
  
}
