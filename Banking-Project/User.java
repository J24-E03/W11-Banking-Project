public class User {

    private String firstName;
    private String userName ;
    private String password;

    private double initialDepositAmount;
    private double  withdrawLimit;
    private double balance;
    private double depositLimit= 10000;

    public User(String firstName, String userName, String password, double initialDepositAmount, double withdrawLimit,double balance) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.initialDepositAmount = initialDepositAmount;
        this.withdrawLimit = withdrawLimit;
        this.balance=balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getInitialDepositAmount() {
        return initialDepositAmount;
    }

    public void setInitialDepositAmount(double initialDepositAmount) {
        this.initialDepositAmount = initialDepositAmount;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(double depositLimit) {
        this.depositLimit = depositLimit;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", initialDepositAmount=" + initialDepositAmount +
                ", withdrawLimit=" + withdrawLimit +
                ", balance=" + balance +
                ", depositLimit=" + depositLimit +
                '}';
    }
}
