
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
class frame extends JFrame implements ItemListener
{
    Timer timer;
    String q[]={"Who is the father of Computer?","Who invented Java?","Who owns Java?","Who invented C?","In which year was Java invented?"};
    String opt[][]= {{"1.Dennis Ritchie","2.Guido van Rossum","3.James Gosling","4.Charles Babbage"},
                    {"1.James Gosling","2.Brendan Eich","3.Steve Jobs","4.Dennis Ritchie"},
                    {"1.Sun Microsystems","2.Oracle Corporation","3.Tesla","4.Amazon"},
                    {"1.Elon Musk","2.Dennis Ritchie","3.Alan Turing","4.John Backus"},
                    {"1.1990","2.2000","3.1995","4.1989"}};
    int ans[]={3,0,1,1,2};
    Container c;
    JLabel l1,l2,l3;
    JRadioButton r[]=new JRadioButton[4];
    JButton b;
    static int i=0;
    static int j=10;
    static int score=0;
    Font font= new Font("Times New Roman",Font.PLAIN,16);
    frame()
    {
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        r[0]=new JRadioButton();
        add(r[0]);
        r[1]=new JRadioButton();
        add(r[1]);
        r[2]=new JRadioButton();
        add(r[2]);
        r[3]=new JRadioButton();
        add(r[3]);
        b=new JButton("Proceed");
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        r[0].setFont(font);
        r[1].setFont(font);
        r[2].setFont(font);
        r[3].setFont(font);
        l1.setBounds(50,50,300,30);
        l2.setBounds(150,400,300,30);
        l3.setBounds(350,50,100,30);
        l1.setText(q[i]);
        r[0].setBounds(50,100,400,30);
        r[1].setBounds(50,150,400,30);
        r[2].setBounds(50,200,400,30);
        r[3].setBounds(50,250,400,30);
        b.setBounds(200,350,100,30);
        r[0].setText(opt[i][0]);
        r[1].setText(opt[i][1]);
        r[2].setText(opt[i][2]);
        r[3].setText(opt[i][3]);
        ButtonGroup bGroup=new ButtonGroup();
        bGroup.add(r[0]);
        bGroup.add(r[1]);
        bGroup.add(r[2]);
        bGroup.add(r[3]);
        timer=new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               l3.setText(j+"");
               j--;
               if(j==-1)
               {
                JOptionPane.showMessageDialog(c,"Time up");
                timer.stop();
                r[0].setEnabled(false);
                r[1].setEnabled(false);
                r[2].setEnabled(false);
                r[3].setEnabled(false);
               }
            }
        });
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(r[0]);
        c.add(r[1]);
        c.add(r[2]);
        c.add(r[3]);
        c.add(b);
        r[0].addItemListener(this);
        r[1].addItemListener(this);
        r[2].addItemListener(this);
        r[3].addItemListener(this);
        b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            bGroup.clearSelection();
            r[0].setEnabled(true);
            r[1].setEnabled(true);
            r[2].setEnabled(true);
            r[3].setEnabled(true);
            j=10;
            l2.setText(null);
            i++;
            if (i==5)
            {
                JOptionPane.showMessageDialog(c, "You have answered "+ score/2 +" out of 5 Questions correctly","Score",JOptionPane.PLAIN_MESSAGE);
                 System.exit(0);
            }
            else
            {
                l1.setText(q[i]);
                r[0].setText(opt[i][0]);
                r[1].setText(opt[i][1]);
                r[2].setText(opt[i][2]);
                r[3].setText(opt[i][3]);
                timer.start();
            }     
        }});
    }
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource()==r[ans[i]])
        {
            l2.setText("Your answer is Correct");
            score++;
        }
        else
        {
            l2.setText("Wrong. The answer is "+opt[i][ans[i]]);
        }
        timer.stop();
        r[0].setEnabled(false);
        r[1].setEnabled(false);
        r[2].setEnabled(false);
        r[3].setEnabled(false);
    }
    public void timer()
    {
        timer.start();
    }
}
public class QuizApp 
{
public static void main(String[] args) 
{
    frame f=new frame();
    f.setSize(500,500);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setTitle("Quiz");
    f.timer();
}
}

