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
 * ����һ��������ʾ����ʱ�Ľ��棬��ʾ�ĵ���ʱ��ʽ�ǣ�HH��mm��ss
 * ���õ���ʱ����Ҫ�����ڱ��翼��ϵͳ����ʱ���棡����
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
        //����������󵹼�ʱ�����ݽ���ʾ�ڸô�������
    JFrame frame=new JFrame();
    frame.setSize(400,150);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //������ʱ��Ļ��ʾ�����м�
    label=new JLabel("",JLabel.CENTER);
    frame.setLayout(new BorderLayout());
    frame.add(label,BorderLayout.CENTER);
    frame.setVisible(true);
    
        /* 
         * ���õ���ʱ��ʱ�䳤��
         * ����timer�����ٸ���timer��schedule�������������ڲ���
         * ��ʵ���߳�
         */
    System.out.println("��������Ҫ�趨�ĵ���ʱ����");
    Scanner input=new Scanner(System.in);
    //i������Ƴ�����Ĵ�С�����ǹ̶���
    int i=input.nextInt();
        final long end=System.currentTimeMillis()+i*1000*60;
    Timer timer=new Timer();
    timer.schedule(new TimerTask() {
//��ȡʣ��ĵ���ʱ��
public void run() {
 long sub=end-System.currentTimeMillis();
 if(sub<0){
 return;
 }
 updateTimer(sub);
}

},0,1000);
    }
    //��ʾ��HH��mm��ss���ĸ�ʽ��ˢ��ʣ���ʱ��
    public void updateTimer(long sub){
    int h=(int)(sub/1000/60/60);
    int m=(int)(sub/1000/60%60);
    int s=(int)(sub/1000%60);
    String str=h+":"+m+":"+s;
    //��String����ת����Date���͵ĸ�ʽ
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    Date date=new Date();
    Font font=new Font("Default", Font.PLAIN, 40);
    label.setFont(font);
    try{
    date=sdf.parse(str);
    }catch(Exception e){
    e.printStackTrace();
    }
    //��Date���͵������ó���Ҫ��ʾ��ʱ���ʽ,��д��JLable��
    label.setText(sdf.format(date));
    System.out.println(sdf.format(date));
    }
}