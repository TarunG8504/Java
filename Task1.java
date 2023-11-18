import java.util.Random;
import java.util.Scanner;
class Compare
{
    static int point=0;
    public int comp(int num2,int i)
    {
        if(num2==0)
        {
            System.out.println("Your guess is correct");
            point+=10/Math.pow(2,i);
        }
        else if(num2>0&&num2<=1)
        {
            System.out.println("Your almost there.Just a little high than expected");
            point+=5/Math.pow(2,i);
        }
        else if(num2<0&&num2>=-1)
        {
            System.out.println("Your almost there.Just a litle low than expected");
            point+=5/Math.pow(2,i);
        }
        else if(num2>1&&num2<=2)
        {
            System.out.println("Your guess is more high than expected");
            point+=2/Math.pow(2,i);
        }
        else if(num2<-1&&num2>-2)
        {
            System.out.println("Your guess is more low than expected");
            return point+=2/Math.pow(2,i);
        }
        else if(num2>2)
        System.out.println("Your guess is too high than expected");
        else 
        System.out.println("Your guess is too low than expected");
        if(point<0)
        point=0;
        return point;
    }
}
public class Task1 
{
    static int num2=1;
    public static void main(String[] args) 
    {
        Random random=new Random();
        Scanner sc= new Scanner(System.in);
        Scanner s=new Scanner(System.in);
        int rand=random.nextInt(11);
        for(int i=0;;i++)
        {
            System.out.println("Say 'yes' if you would like to proceed");
            System.out.println("Say 'no' if otherwise");
            String str=sc.nextLine();
            if(str.equals("yes"))
            {
                System.out.println("ATTEMPT:"+(i+1));
                System.out.println("Guess a number between 1 to 10:");
                int num1=s.nextInt();
                num2=num1-rand;
                Compare c = new Compare();
                c.comp(num2,i);
                System.out.println("TOTAL SCORE:"+Compare.point);
                System.out.println("---------------------------------------------");
            }
            else if(str.equals("no"))
            {
                System.out.println("TOTAL SCORE:"+Compare.point);
                System.out.println("---------------------------------------------");
                break;
            }
            else
            {
                i--;
                System.out.println("Invalid Response");
                System.out.println("---------------------------------------------");
            }
            if(num2==0)
            break;

        }
        sc.close();
        s.close();
    }
}