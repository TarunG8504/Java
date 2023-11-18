import java.util.Scanner;
class Account
{
    private static double bl=0;
    public double balance()
    {
        return bl;
    }
    public void deposit(double dep)
    {
        bl+=dep;
        System.out.println("Deposit successful");
    }
    public void withdraw(double with)
    {   
        if(bl>=with)
        {
            bl-=with;
            System.out.println("Withdraw successful");
        }
        else
        {
            System.out.println("Withdraw unsuccessful due to insufficient balance");
        }   
    }
}
public class Task3
{
    public static void main(String[] args) 
    {  
        Scanner sc= new Scanner(System.in);
        for(;;)
        {
            System.out.println("If you would like to check your balance, please type '1'");
            System.out.println("If you would like to deposit to your account, please type '2'");
            System.out.println("If you would like to withdraw from your account, please type '3'");
            System.out.println("If you would like to exit, please type '4'"); 
            int a=sc.nextInt();  
            if(a==1)
            {
                Account b = new Account();
                System.out.println("Balance:"+b.balance());
            }
            else if(a==2)
            {
                System.out.println("How much would you like to deposit?");
                double dep=sc.nextDouble();
                Account b = new Account();
                b.deposit(dep);
            }
            else if(a==3)
            {
                System.out.println("How much would you like to withdraw?");
                double with=sc.nextDouble();
                Account b = new Account();
                b.withdraw(with);
            }
            else if(a==4)
            {
                System.out.println("Thank you");
                sc.close();
                System.exit(0);
            }
            else
                System.out.println("Invalid Command");
            System.out.println("---------------------------------------------------------------------");
        }  
    }
}
