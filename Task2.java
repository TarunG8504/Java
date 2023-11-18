import java.util.Scanner;
class Grade
{
    public void grad(double avg1)
    {
        if(avg1>90&&avg1<=100)
        System.out.println("Grade A");
        else if(avg1>80&&avg1<=90)
        System.out.println("Grade B");
        else if(avg1>70&&avg1<=80)
        System.out.println("Grade C");
        else if(avg1>60&&avg1<=70)
        System.out.println("Grade D");
        else if(avg1>50&&avg1<=60)
        System.out.println("Grade E");
        else
        System.out.println("Fail");
    }
}
public class Task2
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n=sc.nextInt();
        double phy[]=new double[n];
        double chem[]=new double[n];
        double math[]=new double[n];
        String name[]= new String[n];
        double total[]=new double[n];
        double avg[]=new double[n];
        int i;
        for(i=0;i<n;i++)
        {
            System.out.println("Enter student "+ (i+1) +" name:");
            name[i]=sc.next();
            System.out.println("Enter the marks obtained in Physics:");
            phy[i]=sc.nextInt();
            if(phy[i]<0||phy[i]>100)
            {
                System.out.println("You have entered invalid marks");
                i--;
                continue;
            }
            System.out.println("Enter the marks obtained in Chemistry:");
            chem[i]=sc.nextInt();
            if(chem[i]<0||chem[i]>100)
            {
                System.out.println("You have entered invalid marks");
                i--;
                continue;
            }
            System.out.println("Enter the marks obtained in Mathematics:");
            math[i]=sc.nextInt();
            if(math[i]<0||math[i]>100)
            {
                System.out.println("You have entered invalid marks");
                i--;
                continue;
            }
            total[i]=phy[i]+chem[i]+math[i];
            avg[i]=total[i]/3;
            System.out.println("---------------------------------------------------------");
            if(i==n)
            sc.close();
        }
        for(i=0;i<n;i++)
        {
            System.out.println("Student Name:"+name[i]);
            System.out.println("Total Marks:"+total[i]);
            System.out.println("Average Percentage:"+String.format("%.2f",avg[i]));
            Grade g= new Grade();
            double avg1=avg[i];
            g.grad(avg1);
            System.out.println("---------------------------------------------------------");
        }
    }
}
