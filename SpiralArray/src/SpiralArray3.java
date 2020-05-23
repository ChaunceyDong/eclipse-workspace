import java.util.Scanner;

public class SpiralArray3 {
    public static void main(String[] args) {
    		SpiralArray3 game = new SpiralArray3();
        game.start();
    }

    
    
    Scanner input = new Scanner(System.in);
     
    /**
     * 游戏的具体实现在play()方法中
     */
    public void play(){
        System.out.println("游戏正在运行");
    }
     
    
    /**
     * 开始游戏的方法
     */
    public void start(){
        String answer;
        //循环实现游戏的重新开始
        do{
            play();  //调用play()方法开始玩游戏
            System.out.println("继续游戏(y/n)?");
            answer = input.next();
        }while(!answer.equals("n")); //当用户输入n时退出游戏
        System.out.println("游戏结束");
    }
}