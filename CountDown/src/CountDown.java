import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 制作一个可以显示倒计时的界面，显示的倒计时格式是：HH：mm：ss
 * （该倒计时器主要是用在比如考试系统倒计时上面！）。
 * @author dukangcheng
 *
 */
public class CountDown{
private JLabel label;
    public static void main(String[]args){
    CountDown cn=new CountDown();
    
    }
    public CountDown(){
    countDown();
    }
    public void countDown(){
        //创建窗体对象倒计时的内容将显示在该窗体上面
    JFrame frame=new JFrame();
    frame.setSize(400,150);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //将倒计时字幕显示在正中间
    label=new JLabel("",JLabel.CENTER);
    frame.setLayout(new BorderLayout());
    frame.add(label,BorderLayout.CENTER);
    frame.setVisible(true);
    
        /* 
         * 设置倒计时的时间长度
         * 创建timer对象，再根据timer的schedule方法创键匿名内部类
         * 并实现线程
         */
    System.out.println("请输入需要设定的倒计时长：");
    Scanner input=new Scanner(System.in);
    //i可以设计成任意的大小，不是固定的
    int i=input.nextInt();
        final long end=System.currentTimeMillis()+i*1000*60;
    Timer timer=new Timer();
    timer.schedule(new TimerTask() {
//获取剩余的倒计时长
public void run() {
 long sub=end-System.currentTimeMillis();
 if(sub<0){
 return;
 }
 updateTimer(sub);
}

},0,1000);
    }
    //显示成HH：mm：ss样的格式，刷新剩余的时长
    public void updateTimer(long sub){
    int h=(int)(sub/1000/60/60);
    int m=(int)(sub/1000/60%60);
    int s=(int)(sub/1000%60);
    String str=h+":"+m+":"+s;
    //将String类型转换成Date类型的格式
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    Date date=new Date();
    Font font=new Font("Default", Font.PLAIN, 40);
    label.setFont(font);
    try{
    date=sdf.parse(str);
    }catch(Exception e){
    e.printStackTrace();
    }
    //将Date类型的数设置成想要显示的时间格式,并写入JLable中
    label.setText(sdf.format(date));
    System.out.println(sdf.format(date));
    }
}