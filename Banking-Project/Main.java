import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static User currentUser = null;

    public static void main(String[] args) {

        firstPage();
    }

    public static void firstPage() {
        System.out.println("1.Sign Up \n2.Log in \n3.Exit");
        int choiceFirstPage = scanner.nextInt();
        scanner.nextLine();
        if ( choiceFirstPage == 3 ) {
            System.out.println("Have a nice Day!");
        } else if ( choiceFirstPage == 2 ) {
            logInFlow();
        } else if ( choiceFirstPage == 1 ) {
            singUpFlow();
        } else {
            firstPage();
        }
    }

    public static void singUpFlow() {

        System.out.println("You are in sign up Flow!!!");

        System.out.println("Enter your firstname: ");
        String firstName = scanner.nextLine();

        boolean isUserNameOK = false;
        String userNameAfterCheck = null;
        while (!isUserNameOK) {
            System.out.println("Enter your username(it should be in lowercase form): ");
            String userName = scanner.nextLine();
            if ( userName.equals(userName.toLowerCase()) ) {
                for (User user : users) {
                    if ( user.getUserName().equals(userName) ) {
                        System.out.println("Your username is not unique!");
                    } else {
                        isUserNameOK = true;
                        userNameAfterCheck = userName;
                    }
                }
            } else {
                System.out.println("Your username is not in lowercase form !");
            }
        }

        boolean isPasswordOk = false;
        String passwordAfterCheck = null;
        while (!isPasswordOk) {
            System.out.println("Enter your password(at least 6 character): ");
            String password = scanner.nextLine();
            if ( password.length() >= 6 ) {

                isPasswordOk = true;
                passwordAfterCheck = password;
            } else {
                System.out.println("Your username is not in lowercase form !");
            }
        }

        System.out.println("Enter your Initial Deposit Amount : ");
        double InitialDepositAmount = scanner.nextDouble();

        System.out.println("Enter your withdraw limit : ");
        double withdrawLimit = scanner.nextDouble();

        User user = new User(firstName, userNameAfterCheck, passwordAfterCheck, InitialDepositAmount, withdrawLimit, InitialDepositAmount);
        users.add(user);
        System.out.println(user);
        System.out.println("Your account has been created!");
        scanner.nextLine();
        logInFlow();
    }

    public static void logInFlow() {
        System.out.println("You are in log in Flow!!!");

        System.out.println("Enter your username : ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password : ");
        String password = scanner.nextLine();

        for (User user : users) {

            if ( user.getUserName().equals(userName) && user.getPassword().equals(password) ) {
                currentUser = user;
            }
        }
        if ( currentUser != null ) {
            System.out.println("you have successfully logged in!");
            loggedInUserMenu();
        } else {
            System.out.println("Your username or pssword is incorrect!");
            logInFlow();
        }
    }

    public static void loggedInUserMenu() {
        System.out.println("1.Show Balance \n2.Deposit \n3.Withdraw \n4.Reset Password \n5.Logout");
        int choiceUserMenu = scanner.nextInt();
        scanner.nextLine();
        if ( choiceUserMenu == 5 ) {
            System.out.println("Have a nice Day!");
        } else if ( choiceUserMenu == 4 ) {
            resetPassword();
        } else if ( choiceUserMenu == 3 ) {
            withdraw();
        } else if ( choiceUserMenu == 2 ) {
            deposit();
        } else if ( choiceUserMenu == 1 ) {
            System.out.println("Your current balance is : " + currentUser.getBalance() + "€.");
            loggedInUserMenu();
        }
    }

    public static void deposit() {

        System.out.println("How much do you want to deposit in your account:");
        double depositAmount = scanner.nextDouble();
        if ( depositAmount > currentUser.getDepositLimit() ) {
            currentUser.setBalance(currentUser.getBalance() + depositAmount);
            System.out.println("Your deposit was successful!");
            loggedInUserMenu();
        } else {
            System.out.println("Your deposit doesn't pass the deposit limit");
            loggedInUserMenu();
        }
    }

    public static void withdraw() {

        System.out.println("How much do you want to withdraw from your account:");
        double withdrawAmount = scanner.nextDouble();
        if ( withdrawAmount < currentUser.getWithdrawLimit() ) {
            currentUser.setBalance(currentUser.getBalance() - withdrawAmount);
            System.out.println("Your withdraw was successful!");
            loggedInUserMenu();
        } else {
            System.out.println("Your withdraw request is higher than the withdraw limit");
            loggedInUserMenu();
        }
    }

    public static void resetPassword() {


        System.out.println("Enter your old password : ");
        String oldPassword = scanner.nextLine();
        if ( oldPassword.equals(currentUser.getPassword()) ) {

            boolean isPasswordOk = false;
            String passwordAfterCheck = null;
            while (!isPasswordOk) {
                System.out.println("Enter your new password(at least 6 character): ");
                String password = scanner.nextLine();
                if ( password.length() >= 6 ) {

                    isPasswordOk = true;
                    passwordAfterCheck = password;
                } else {
                    System.out.println("Your username is not in lowercase form !");
                }
            }
            currentUser.setPassword(passwordAfterCheck);
        } else {
            System.out.println("Your given password is wrong!");

            resetPassword();
        }
    }
}