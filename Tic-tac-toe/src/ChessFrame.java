import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
//import com.borland.jbcl.layout.*;

public class ChessFrame extends JFrame{
	
	///��Ϸ�������
	private Container contentPane;
	private JPanel upPanel;
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	private JPanel downPanel;
	private JComboBox level;          //��Ϸ����
	private JComboBox size;          //���̴�С
	private JRadioButton cb1;         //��ѡ��ť���������
	private JRadioButton cb2;         //��ѡ��ť����������
	private JButton b4;               //��ʼ
	private JButton b5;               //����
	private JButton b6;               //�˳���ť
	private JButton b[][];          //���̰�ť
	private JLabel b1;                //��ӭ��
	private JLabel b11;  
	private JLabel b12;  
	private JLabel b2;                 //���״��
	private JLabel b3;                  //��ֽ��
	private JLabel b31; 
	private JLabel b32; 
	
	/////�������
	private int startturn;       //�������һ����1������ң�2�������
	private int  a[][];          //������Ϣ��0���������ӣ�1��������µ����ӣ�2��������µ�����
	private int result;      //��ֽ����1�������Ӯ��2�������Ӯ��3����ƽ��
	private int c_size;      //���̴�С������Ϸ����3��3��4���ģ�5��5��������
	private int c_level;      //��Ϸ���𣬵ͼ����м����߼��ֱ��Ӧ0��1��2
	private int x;          //��ҳ�����������λ�õ��к�
	private int y;           //��������������ڵ��к�
	
	public ChessFrame(){
		 
		
		super("�������˻���ս");
		//���ý����ʼ������
		frameInitnew();
		
		//�˳�����
		
		WindowListener w=new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				ChessFrame.this.dispose();
				System.exit(0);
				}
			
		};
		
		this.addWindowListener(w);
		
		//������Ӧ��굥�����¼�
		
		ActionListener ch=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==level){     //����
					c_level=level.getSelectedIndex();
					
				}
				else if(e.getSource()==size){   //�������̴�С���ز��ְ�ť
					
			
					c_size=size.getSelectedIndex()+3;
		            if(c_size==3){
		            	b[0][3].setVisible(false);
    					b[1][3].setVisible(false);
    					b[2][3].setVisible(false);
    					b[3][3].setVisible(false);
    	  				b[3][0].setVisible(false);
    					b[3][1].setVisible(false);
    					b[3][2].setVisible(false);
    					b[0][4].setVisible(false);
    					b[1][4].setVisible(false);
    					b[2][4].setVisible(false);
    					b[3][4].setVisible(false);
    					b[4][4].setVisible(false);
    					b[4][0].setVisible(false);
    					b[4][1].setVisible(false);
    					b[4][2].setVisible(false);
    					b[4][3].setVisible(false);
		            }
		            else if(c_size==4){
		            	b[0][3].setVisible(true);
    					b[1][3].setVisible(true);
    					b[2][3].setVisible(true);
    					b[3][3].setVisible(true);
    					b[3][0].setVisible(true);
    					b[3][1].setVisible(true);
    					b[3][2].setVisible(true);
    					b[0][4].setVisible(false);
    					b[1][4].setVisible(false);
    					b[2][4].setVisible(false);
    					b[3][4].setVisible(false);
    					b[4][4].setVisible(false);
    					b[4][0].setVisible(false);
    					b[4][1].setVisible(false);
    					b[4][2].setVisible(false);
    					b[4][3].setVisible(false);
		            }
					else{
						b[0][3].setVisible(true);
    					b[1][3].setVisible(true);
    					b[2][3].setVisible(true);
    					b[3][3].setVisible(true);
    					b[3][0].setVisible(true);
    					b[3][1].setVisible(true);
    					b[3][2].setVisible(true);
						b[0][4].setVisible(true);
   				 		b[1][4].setVisible(true);
    					b[2][4].setVisible(true);
    					b[3][4].setVisible(true);
    					b[4][4].setVisible(true);
    					b[4][0].setVisible(true);
    					b[4][1].setVisible(true);
    					b[4][2].setVisible(true);
    					b[4][3].setVisible(true);
					}
			
				}
				else if(e.getSource()==cb1){        //���Ƶ�ѡ��ť
					cb1.setSelected(true);
					cb2.setSelected(false);
					cb1.updateUI();
					cb2.updateUI();
					startturn=1;
				}
				else if(e.getSource()==cb2){
					cb1.setSelected(false);
					cb2.setSelected(true);
					cb1.updateUI();
					cb2.updateUI();
					startturn=2;
				}
				else if(e.getSource()==b4){         //��ʼ��ť
					//�����ڲ���������ʼ������
				    beginChess();
    				
				}
				else if(e.getSource()==b5){         //������ť
					endChess();
				}
				else if(e.getSource()==b6){       //exit
					System.exit(0);
				}
				else{
					 for(int ii=0;ii<c_size;ii++){
					 	for(int jj=0;jj<c_size;jj++){
					 		if(e.getSource()==b[ii][jj]){
					 		
					 			x=ii; y=jj;
					 		
					 			playchess();
					 		}
					 
					 }
					}
				}//end else
				
			}//end actionPerformed
		};//end actionlistener
		
		
		//�����а�ť���������
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				b[i][j].addActionListener(ch);
			}
		}
		level.addActionListener(ch);
		size.addActionListener(ch);
		cb1.addActionListener(ch);
		cb2.addActionListener(ch);
		b4.addActionListener(ch);
		b5.addActionListener(ch);
		b6.addActionListener(ch);
		
		this.setVisible(true);
		
    }//end Chessframe
    
    
    
    ///�����ʼ������
    private void frameInitnew(){
    	
    	
		contentPane=this.getContentPane();
		//����Ĵ�С��λ��
		this.setSize(500,500);
		this.setResizable(false);
		Dimension frameSize=this.getSize();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
    	
    	
    	
    	//���������滮�ֳ�������򣬶���������
		//��Ϊ����
		//��Ϊ��ӭ��
		//��Ϊ�հ���
		//��Ϊ���ť�����״��
		//��Ϊ��Ϸ���
		
		//��ʼ״̬Ϊ3��3���̣�����Ϊ�ͼ�����������
		
		c_size=3; 
		startturn=2;
		c_level=0;
		
		
		chessboardFormed();              //�γ�����
		
	    //�����ǹ̶��ģ����Բ��赥���γɺ���
		
		//��������ӭ��
		b1=new JLabel("    ��ӭ�������������磡����",JLabel.CENTER);
		b1.setFont(new java.awt.Font("Times",Font.PLAIN, 25));
		b1.setForeground(Color.darkGray);
		b11=new JLabel("             ",JLabel.CENTER);
		b12=new JLabel("             ",JLabel.CENTER);
		upPanel=new JPanel();
		upPanel.setLayout(new GridLayout(3,1));
		upPanel.setPreferredSize(new Dimension(500, 80));
		upPanel.add(b11);
		upPanel.add(b1);
		upPanel.add(b12);
		contentPane.add(upPanel,BorderLayout.NORTH);
		
		//��������ֽ������ʼ״̬Ϊ��
		b3=new JLabel(" *************************  ",JLabel.CENTER);
		b31=new JLabel("             ",JLabel.CENTER);
		b32=new JLabel("             ",JLabel.CENTER);
		b3.setFont(new java.awt.Font("Times",Font.PLAIN, 25));
		b3.setForeground(Color.darkGray);
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(500, 60));
		downPanel.setLayout(new GridLayout(3,1));
		downPanel.add(b31);
		downPanel.add(b3);
		downPanel.add(b32);
		contentPane.add(downPanel,BorderLayout.SOUTH);
		
		
		///������������Ϸ����ѡ�����̴�Сѡ�����ַ�ѡ���Լ���ʼ�������˳���ť
		rightPanel=new JPanel();
		rightPanel.setPreferredSize(new Dimension(100, 360));
		rightPanel.setLayout(new GridLayout(8,1,0,15));
		b2=new JLabel("                    ",JLabel.CENTER);
		b2.setFont(new java.awt.Font("Dialog", 0, 15));
		b4=new JButton("��ʼ");
		b4.setFont(new java.awt.Font("Dialog", 0, 20));
		b4.setBorder(BorderFactory.createRaisedBevelBorder());
		b5=new JButton("����");
		b5.setFont(new java.awt.Font("Dialog", 0, 20));
		b5.setBorder(BorderFactory.createRaisedBevelBorder());
		b6=new JButton("�˳�");
		b6.setFont(new java.awt.Font("Dialog", 0, 20));
		b6.setBorder(BorderFactory.createRaisedBevelBorder());
		b5.setEnabled(false);
		cb1=new JRadioButton("�������");
		cb2=new JRadioButton("��������");
		//cb1.setMinimumSize(new Dimension(91, 25));
        cb1.setPreferredSize(new Dimension(30, 15));
    	cb1.setSelected(false);
	    //cb2.setMinimumSize(new Dimension(91, 25));
        cb2.setPreferredSize(new Dimension(30, 15));
        cb2.setSelected(true);
        cb1.setFont(new java.awt.Font("Dialog", 0, 15));
        cb2.setFont(new java.awt.Font("Dialog", 0, 15));
        level=new JComboBox();
        level.addItem("����");
        level.addItem("�м�");
        level.addItem("�߼�");
		size=new JComboBox();
		size.addItem("3��3����");
		size.addItem("4��4����");
		size.addItem("5��5����");
		rightPanel.add(size);
		rightPanel.add(level);
		rightPanel.add(cb1);
		rightPanel.add(cb2);
		rightPanel.add(b2);
		rightPanel.add(b4);
		rightPanel.add(b5);
		rightPanel.add(b6);
		contentPane.add(rightPanel,BorderLayout.EAST);		
		
    }//end  frameInitnew
    
    private void chessboardFormed()     //�γ�����
    {
    	int i,j;
    	
		leftPanel=new JPanel();
		leftPanel.setPreferredSize(new Dimension(300, 300));
		
		
    	b=new JButton[5][5];
    	leftPanel.setLayout(new GridLayout(5,5,10,10));
    	for(i=0;i<5;i++){
    		for(j=0;j<5;j++){
    			b[i][j]=new JButton();
    			b[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
    			b[i][j].setPreferredSize(new Dimension(30, 30));
    			b[i][j].setBackground(Color.white);
    			b[i][j].setEnabled(false);
    			leftPanel.add(b[i][j]);
    		}
    	}
    	if(c_size==3){
    		b[0][3].setVisible(false);
    		b[1][3].setVisible(false);
    		b[2][3].setVisible(false);
    		b[3][3].setVisible(false);
    		b[3][0].setVisible(false);
    		b[3][1].setVisible(false);
    		b[3][2].setVisible(false);
    		b[0][4].setVisible(false);
    		b[1][4].setVisible(false);
    		b[2][4].setVisible(false);
    		b[3][4].setVisible(false);
    		b[4][4].setVisible(false);
    		b[4][0].setVisible(false);
    		b[4][1].setVisible(false);
    		b[4][2].setVisible(false);
    		b[4][3].setVisible(false);
    		
    	}
    	else if(c_size==4){
    		b[0][4].setVisible(false);
    		b[1][4].setVisible(false);
    		b[2][4].setVisible(false);
    		b[3][4].setVisible(false);
    		b[4][4].setVisible(false);
    		b[4][0].setVisible(false);
    		b[4][1].setVisible(false);
    		b[4][2].setVisible(false);
    		b[4][3].setVisible(false);
    	}
    	else{
    	}
    	leftPanel.setLocation(200,200);
    	contentPane.add(leftPanel,BorderLayout.WEST);
    	
    	
    }//end chessboardFormed()
    
    
    private void beginChess(){
    	int i,j,k;
    	k=c_size/2;
    	a=new int[c_size][c_size];
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			b[i][j].setBackground(Color.white);
    			
    			a[i][j]=0;
    		}
    	}
    	
    	if(startturn==2){   //�������֣�ѡ���м��λ����Ϊ��һ��
    		a[k][k]=2;
    		b[k][k].setEnabled(false);
    		b[k][k].setBackground(Color.blue);
    	}
    	else                //������֣����ʼ��Ϊ������
    	     b[k][k].setEnabled(true);
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(i!=k||j!=k){
    				b[i][j].setEnabled(true);
    			}
    			
    		}
    	}
    	
    	
    	cb1.setEnabled(false);
    	cb2.setEnabled(false);
    	size.setEnabled(false);
    	level.setEnabled(false);
    	b2.setText("���˼����...");
    	b3.setText("           ");
    	b4.setEnabled(false);
    	b5.setEnabled(true);
    	  	
    }///end beginChess
    
    private void endChess(){   //��ֹ��ǰ��Ϸ������Ϊ�����̲��Ҳ�����
    	int i,j;
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			b[i][j].setEnabled(false);
				b[i][j].setBackground(Color.white);
    		}
    	}
    	
    	cb1.setEnabled(true);
    	cb2.setEnabled(true);
    	size.setEnabled(true);
    	level.setEnabled(true);
    	b4.setEnabled(true);
		b5.setEnabled(false);
		b2.setText("           ");
    }//end endChess
    
    private void playchess(){
    	int i,j,k,k1,k2;
    	k=0;
    	for(i=0;i<c_size;i++){
			for(j=0;j<c_size;j++){
				b[i][j].setEnabled(false);
			}//endfor
		}
		b[x][y].setBackground(Color.red);
		a[x][y]=1;
		b2.setText("����˼����...");
		if(isWinornot()){      //�ж��Ƿ��Ѿ��ֳ�ʤ��
			b4.setEnabled(true);
	 		b5.setEnabled(false);
			//����result��ֵ�ж���ֵĽ��
			b2.setText("��Ϸ����");
			switch(result){
				case 1: b3.setText("��ϲ������Ӯ��");break;
				case 2: b3.setText("�汿��������");break;
				case 3: b3.setText("������ƽ��");break;
			}
			cb1.setEnabled(true);
			cb2.setEnabled(true);
			level.setEnabled(true);
			size.setEnabled(true);
		}//endif
		else{       //���Ը��ݼ���ѡ����һ������
			switch(c_level){
				case 0:   k=choosenext0();break;
				case 1:   k=choosenext1();break;
				case 2:	  k=choosenext2();break;									
			}
			k1=k/10;k2=k%10;   //������кź��к�
			b[k1][k2].setBackground(Color.blue);
			a[k1][k2]=2;
			
			if(isWinornot()){
				b4.setEnabled(true);
	 			b5.setEnabled(false);
			    //����result��ֵ�ж���ֵĽ��
				b2.setText("��Ϸ����");
				switch(result){
					case 1: b3.setText("��ϲ������Ӯ��");break;
					case 2: b3.setText("�汿��������");break;
					case 3: b3.setText("������ƽ��");break;
				}
				cb1.setEnabled(true);
  				cb2.setEnabled(true);
				level.setEnabled(true);
				size.setEnabled(true);
			}
			else{   //���������û�����
				 	for(i=0;i<c_size;i++){
					for(j=0;j<c_size;j++){
						if(a[i][j]==0){
							b[i][j].setEnabled(true);
				}}}
				b2.setText("���˼����...");
			}
			
		}//endelse
		
    }
    
    private boolean isWinornot(){
    	int i,j,k;
    	boolean fa;
    	//���Ƿ���ͬһ����������һ���ߵ�
    	for(i=0;i<c_size;i++){
    		k=a[i][0];
    		fa=true;
    		if(k!=0){
    			for(j=1;j<c_size;j++){
    			  if(a[i][j]!=k)
    				fa=false;
    			}
    		   if(fa)  //��һ���������ں���������һ������
    		   {
    			   if(k==1) result=1;    //�ж�����һ��������
    			   else result=2;
    			   return true;
    		   }
    		}
    		
    	}//endfor
    	
    	//��ͬһ������û������һ���ߵ�
    	for(j=0;j<c_size;j++){
    		k=a[0][j];
    		fa=true;
    		if(k!=0){
    			for(i=1;i<c_size;i++){
    			   if(a[i][j]!=k)
    				  fa=false;
    			}
    		    if(fa)  //��һ���������ں���������һ������
    		    {
    				if(k==1) result=1;
    				else result=2;
    				return true;
    			}
    		}    		
    	}
    	
    	//��б�Խ�����û������һ���ߵ�
    	k=a[0][0];
    	fa=true;
    	if(k!=0){
    	   	for(i=1;i<c_size;i++){
    			if(a[i][i]!=k)  fa=false;
    	 	}
    	 	if(fa){
    			if(k==1)  result=1;
    			else result=2;
    			return true;
    		}
    	}
    	
    	j=c_size-1;
    	k=a[0][j];
    	fa=true;
    	if(k!=0){
    		for(i=1,j--;i<c_size;i++,j--){
    			if(a[i][j]!=k) fa=false;
    		}
    		if(fa){
    		if(k==1)  result=1;
    		else result=2;
    		return true;
    	    }
    	}
    	
    	
    	//����������Ĳ��ң�û��һ����ʤ��������Ƿ�����������
    	//���������룬�򷵻�false����Ϸ����
    	//�����ܼ����������ӣ�����Ϸ������˫�����ƽ��
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0)  return false ; 
    		}
    	}
    	
    	result=3;
    	return true;
    }
    
    
    //�����淨������ѡ����һ���������ǰ����ϵ��´�����ѡ���һ���յ����
    private int choosenext0(){
    	int i,j,c=0;
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0){
    				c=10*i+j;
    				return c;
    			}
    			   
    		}
    	}
    	return 0;
    }
    
    //�ð�����-�����㷨����ǰ������
    
    private int choosenext1(){
    	// max_i��������߷����ڵ��кţ�max_j��������߷����ڵ��к�
		//hΪ����״̬�µļ�ֵ��������
        int i,j,max_i,max_j,h;
        int p,q;
        int minus,plus;
        minus=200;
        max_i=0;
        max_j=0;
        for(i=0;i<c_size;i++){          //ѡ���һ���յ����
        	for(j=0;j<c_size;j++){
        		if(a[i][j]==0){
        			max_i=i;
        			max_j=j;
        			a[i][j]=2;
        			
        			if(isWinornot())   //�����һ�����Ե��µ���Ӯ����ô�ͷ�����һ��
        			{
        				if(result==2){
        					a[i][j]=0;
        					return 10*max_i+max_j;
        				}
        				
        			}
        			i=c_size;      ////Ϊ������ѭ��
        			j=c_size;
        		}
        	}
        } /////�ҵ���һ��
        
        
        ///�ӵ�һ����֧���ҳ���ֵ������С��
        
        for(i=0;i<c_size;i++){          //��̽�����еķ�֧�ֱ������ǵ���������
        	for(j=0;j<c_size;j++){
        		//��ǰ��ֵļ�ֵ��������
        		if(a[i][j]==0){
        			a[i][j]=1;
        			h=evaluate();
        			if(h<minus){
        				minus=h;
        			}
        			a[i][j]=0;
        		}//һ����Ч��֧
        		
        	}
        }
        
        plus=minus;
        a[max_i][max_j]=0;
        i=max_i;
        //�ٲ��������ķ�֧
		//��Ϊ��һ���ҵ�������������жϣ���ʣ������ֳ�������
		//��max_i�е�max_j�����֮���
		//��max_i��֮������
        for(j=max_j+1;j<c_size;j++){  
        	if(a[i][j]==0){
        			minus=200;
        			a[i][j]=2;
        			if(isWinornot()){
        				if(result==2){
        					a[i][j]=0;
        					return 10*i+j;
        				}
        			}
        			for(p=0;p<c_size;p++){
        				for(q=0;q<c_size;q++){
        					if(a[p][q]==0){
        						a[p][q]=1;
        						h=evaluate();
        						a[p][q]=0;
        						if(h<=plus){   //��֦��ʣ���ӽڵ��������ж�
        							minus=h;
        							q=c_size;
        							p=c_size;   //��������ѭ��
        						}
        						else{
        							if(h<minus)  minus=h;
        							
        						}
        						
        					}
        				}
        			}//����ڵ�
        			if(minus>plus&&minus!=200){   ////plusֵ���ӣ����õ��߷�
        				plus=minus;
        				max_i=i;
        				max_j=j;
        			}
        			a[i][j]=0;
        		}//endif
        }
        for(i++;i<c_size;i++){
        	for(j=0;j<c_size;j++){
        		if(a[i][j]==0){
        			minus=200;
        			a[i][j]=2;
        			if(isWinornot()){
        				if(result==2){
        					a[i][j]=0;
        					return 10*i+j;
        				}
        			}
        			for(p=0;p<c_size;p++){
        				for(q=0;q<c_size;q++){
        					if(a[p][q]==0){
        						a[p][q]=1;
        						h=evaluate();
        						a[p][q]=0;
        						if(h<=plus){        //��֦
        							minus=h;
        							q=c_size;
        							p=c_size;   //��������ѭ��
        						}
        						else{
        							if(h<minus)  minus=h;
        							
        						}
        						
        					}
        				}
        			}//����ڵ�
        			if(minus>plus&&minus!=200){
        				plus=minus;
        				max_i=i;
        				max_j=j;
        			}
        			a[i][j]=0;
        		}//endi
        	}//endfor
        }//endfor
        return 10*max_i+max_j;
         
    }
    
    private int choosenext2(){
    	
    	//�Ľ�choosenext1()�㷨
    	//������ǰ�������㷨����ǰ���Ĳ�������˼������ǰ�������Ĳ��
    	int i,j;
    	int p,q;
    	int max_i,max_j;
    	int plus,minus,h_temp;
    	minus=200;
    	max_i=0;
    	max_j=0;
    	
    	
    	//��������һ�����ӱ��ܳ��ߵı��򷵻ظ�λ�õ���Ϣ
    	
    	
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0){
    				a[i][j]=2;
    				max_i=i;
    				max_j=j;
    				if(isWinornot()){
    					if(result==2){
    						a[i][j]=0;
    						return 10*i+j;
    					}
    				}
    				i=c_size;
    				j=c_size;
    							
    			}
    		}
    	}
    	
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0){
    				a[i][j]=1;
    				
    				//�����Լ�����֧�����øĽ�������ǰ�������㷨�õ���ֵ��������
    				if(isWinornot()){  ////������Ѿ���������ֱ�ӵ��ü�ֵ��������
    					h_temp=evaluate();
    				}
    				else h_temp=newchoosenext1();
    				    				
    				if(h_temp<minus)   minus=h_temp;   //����С�ķ�֧
    				a[i][j]=0;    				
    			}
    		}
    	}
    	
    	plus=minus;
    	a[max_i][max_j]=0;
    	i=max_i;
    	//ͬ���ֳ������ֲ���������֧
    	for(j=max_j+1;j<c_size;j++){
    		if(a[i][j]==0){    
    			 	a[i][j]=2;
    			 	minus=200;
    			 	if(isWinornot()){
    			 		if(result==2){
    			 			a[i][j]=0;
    			 			return 10*i+j;
    			 		}
    			 	}
    			 	for(p=0;p<c_size;p++){
    			 		for(q=0;q<c_size;q++){
    			 			if(a[p][q]==0){
    			 				a[p][q]=1;
    			 				if(isWinornot()){
    								h_temp=evaluate();      //ֱ�Ӽ����ֵ��������
    							}
    							else
    								h_temp=newchoosenext1();
    			 				a[p][q]=0;
    			 				if(h_temp<=plus){
    			 					p=c_size;
    			 					q=c_size;	
    			 					minus=h_temp;
    			 				}
    			 				else{
    			 					if(h_temp<minus)  minus=h_temp;  
    			 				}
    			 		 	}
    			 		}
    			 	}
    			 	if(minus>plus&&minus!=200) {
    			 		plus=minus;
    			 		max_i=i;        ///���ŵ�λ��
    			 		max_j=j;
    			 	}
    			 	a[i][j]=0;
    			 }//endif
    	}
    	
    	for(i++;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    		if(a[i][j]==0){    
    			 	a[i][j]=2;
    			 	minus=200;
    			 	if(isWinornot()){
    			 		if(result==2){
    			 			a[i][j]=0;
    			 			return 10*i+j;
    			 		}
    			 	}
    			 	for(p=0;p<c_size;p++){
    			 		for(q=0;q<c_size;q++){
    			 			if(a[p][q]==0){
    			 				a[p][q]=1;
    			 				if(isWinornot()){
    								h_temp=evaluate();      //ֱ�Ӽ����ֵ��������
    							}
    							else
    								h_temp=newchoosenext1();
    			 				a[p][q]=0;
    			 				if(h_temp<=plus){
    			 					p=c_size;
    			 					q=c_size;	
    			 					minus=h_temp;
    			 				}
    			 				else{
    			 					if(h_temp<minus)  minus=h_temp;  
    			 				}
    			 		 	}
    			 		}
    			 	}
    			 	if(minus>plus&&minus!=200) {
    			 		plus=minus;
    			 		max_i=i;
    			 		max_j=j;
    			 	}
    			 	a[i][j]=0;
    			 }//endif    			 
    		}//endfor
    	}//endfor
    	return 10*max_i+max_j;
    }
    
    
    //�Ľ�choosenext1()�㷨����������ѡ���µ���ֵļ�ֵ���ƺ���ֵ
    private int newchoosenext1(){
    	int i,j,max_i,max_j,h;
        int p,q;
        int minus,plus;
        minus=200;
        max_i=0;
        max_j=0;
        for(i=0;i<c_size;i++){
        	for(j=0;j<c_size;j++){
        		if(a[i][j]==0){
        			max_i=i;
        			max_j=j;
        			a[i][j]=2;
        			
        			if(isWinornot())
        			{
        				a[i][j]=0;
        				h=evaluate();
        				return h;   // //����Ѿ����������ص�ǰ��ֵļ�ֵ����ֵ
        				
        			}
        			i=c_size;      ////Ϊ������ѭ��
        			j=c_size;
        		}
        	}
        } /////�ҵ���һ��
        
        
        ///�ӵ�һ����֧���ҳ���С��
        
        for(i=0;i<c_size;i++){          //��̽�����еķ�֧�ֱ������ǵ���������
        	for(j=0;j<c_size;j++){
        		//��ǰ��ֵļ�ֵ��������
        		if(a[i][j]==0){
        			a[i][j]=1;
        			h=evaluate();
        			if(h<minus){
        				minus=h;
        			}
        			a[i][j]=0;
        		}//һ����Ч��֧
        		
        	}
        }
        
        plus=minus;
        a[max_i][max_j]=0;
        i=max_i;
        for(j=max_j+1;j<c_size;j++){
        	if(a[i][j]==0){
        			minus=200;
        			a[i][j]=2;
        			if(isWinornot()){
        				if(result==2){
        					a[i][j]=0;
        					return 10*i+j;
        				}
        			}
        			for(p=0;p<c_size;p++){
        				for(q=0;q<c_size;q++){
        					if(a[p][q]==0){
        						a[p][q]=1;
        						h=evaluate();
        						a[p][q]=0;
        						if(h<=plus){
        							minus=h;
        							q=c_size;
        							p=c_size;   //��������ѭ��
        						}
        						else{
        							if(h<minus)  minus=h;
        							
        						}
        						
        					}
        				}
        			}//����ڵ�
        			if(minus>plus&&minus!=200){
        				plus=minus;
        				max_i=i;
        				max_j=j;
        			}
        			a[i][j]=0;
        		}//endif
        }
        for(i++;i<c_size;i++){
        	for(j=0;j<c_size;j++){
        		if(a[i][j]==0){
        			minus=200;
        			a[i][j]=2;
        			if(isWinornot()){
        				if(result==2){
        					a[i][j]=0;
        					return 10*i+j;
        				}
        			}
        			for(p=0;p<c_size;p++){
        				for(q=0;q<c_size;q++){
        					if(a[p][q]==0){
        						a[p][q]=1;
        						h=evaluate();
        						a[p][q]=0;
        						if(h<=plus){
        							minus=h;
        							q=c_size;
        							p=c_size;   //��������ѭ��
        						}
        						else{
        							if(h<minus)  minus=h;
        							
        						}
        						
        					}
        				}
        			}//����ڵ�
        			if(minus>plus&&minus!=200){
        				plus=minus;
        				max_i=i;
        				max_j=j;
        			}
        			a[i][j]=0;
        		}//endi
        	}//endfor
        }//endfor
        return plus;  ////��choosenext1�Ĳ�֮ͬ�����ڷ���ֵ�Ĳ�ͬ
    }
    
    
// ��ֵ��������
// ���壺����ֶ��κ�һ�������ǻ�ʤ�ģ���h�������еĿո���ϵ��Ե�����֮�����ӳ�һ�ߵ�����
// ��ȥ���пո������ҵ�����֮�����ӳ�һ�ߵ�����
//�����״��Ϊ���Ի�ʤ�����ֵ����ֵΪ����󣬱���������Ϊ100����
//�����״��Ϊ��һ�ʤ�����ֵ����ֵΪ����С������������Ϊ-100����
//������������ע�Ͷ����������һ�ߵ�˵���������̴�СΪ4��4��5��5��Ϊ�ĵ��һ�߻�����һ��
 private int evaluate(){
    	int i,j;
    	int h2,h1;
    	int h;
    	int a_temp[][]=new int[c_size][c_size];   //��ʱ����洢�����Ϣ
    	boolean tp;
    	h2=0;    //���еĿո���ϵ��Ե�����֮�����ӳ�һ�ߵ�����
    	h1=0;    //���пո������ҵ�����֮�����ӳ�һ�ߵ�����
    	
    	if(isWinornot()){
    		if(result==2)  return 100;
    		else if(result==1)  return -100;
    		else{
    		}
    	}
    	//���ȼ������пո���ϵ��Ե�����֮���������ӳ�һ�ߵĸ���
    	//��ʣ�����񶼰��ϵ��Ե����ӣ�����a������ֵΪ0������Ϊ2
    	
    	for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0)
    				a_temp[i][j]=2;
    			else
    			    a_temp[i][j]=a[i][j];
    		}
    	}
    	
    	
    	//������������ӳ�һ�ߵĸ���
    	for(i=0;i<c_size;i++){
    		
    		if(a_temp[i][0]==2){
    			tp=true;
    			for(j=1;j<c_size;j++){
    				if(a_temp[i][j]!=2)
    				{  
    					tp=false;
    					break;
    				}    
    			}
    			if(tp){
    				h2++;
    			}
    		}
    	}
    	
    	///�������������ӳ�һ�ߵĸ���
    	for(j=0;j<c_size;j++){
    		if(a_temp[0][j]==2){
    			tp=true;
    			for(i=1;i<c_size;i++){
    				if(a_temp[i][j]!=2){
    					tp=false;
    					break;
    				}
    			}
    			if(tp){
    				h2++;
    			}
    		}
    	}
    	
    	//��������б�Խ����Ƿ��һ����
    	if(a_temp[0][0]==2){
    		tp=true;
    		for(i=1;i<c_size;i++){
    			if(a_temp[i][i]!=2){
    				tp=false;
    				break;
    			}
    		}
    		if(tp)
    			h2++;
    	}
    	
    	if(a_temp[0][c_size-1]==2){
    		tp=true;
    		for(i=1,j=c_size-2;i<c_size;i++,j--){
    			if(a_temp[i][j]!=2){
    				tp=false;
    				break;
    			}
    		}
    		if(tp)
    			h2++;
    	}
 		
 		
 		//////�������пո񶼰���������������ӳ�һ�ߵĸ���
 		//��ʣ������Ϊ��ҵ����ӣ�����a������ֵΪ0������Ϊ1
 		
 		for(i=0;i<c_size;i++){
    		for(j=0;j<c_size;j++){
    			if(a[i][j]==0)
    				a_temp[i][j]=1;
    			else
    			    a_temp[i][j]=a[i][j];
    		}
    	}
    	
    	
    	//������������ӳ�һ�ߵĸ���
    	for(i=0;i<c_size;i++){
    		
    		if(a_temp[i][0]==1){
    			tp=true;
    			for(j=1;j<c_size;j++){
    				if(a_temp[i][j]!=1)
    				{  
    					tp=false;
    					break;
    				}    
    			}
    			if(tp){
    				h1++;
    			}
    		}
    	}
    	
    	///�������������ӳ�һ�ߵĸ���
    	for(j=0;j<c_size;j++){
    		if(a_temp[0][j]==1){
    			tp=true;
    			for(i=1;i<c_size;i++){
    				if(a_temp[i][j]!=1){
    					tp=false;
    					break;
    				}
    			}
    			if(tp){
    				h1++;
    			}
    		}
    	}
    	
    	
    	//�ж�б�Խ����Ƿ������ӳ�һ��
    	if(a_temp[0][0]==1){
    		tp=true;
    		for(i=1;i<c_size;i++){
    			if(a_temp[i][i]!=1){
    				tp=false;
    				break;
    			}
    		}
    		if(tp)
    			h1++;
    	}
    	
    	if(a_temp[0][c_size-1]==1){
    		tp=true;
    		for(i=1,j=c_size-2;i<c_size;i++,j--){
    			if(a_temp[i][j]!=1){
    				tp=false;
    				break;
    			}
    		}
    		if(tp)
    			h1++;
    	}
 		
 		
 		
 		h=h2-h1;
 		return h;   	
    	
    }
}