import java.util.Scanner;

public class R4 {
	public static void main(String[] args) {
		System.out.println("The card drawn by the computer is");
		Cards cds = new Cards();
		System.out.println(cds.drawRandom().getValue());
		System.out.println(cds.drawManual(0).getValue());
		Scanner sc = new Scanner(System.in);
		int scint = sc.nextInt();
		
	}

}
class Cards{
	private Card[] card;
	
	public Cards() {
		card = new Card[52];
		int k=0;
		for (int a=0;a<4;++a)
			for(int b=0;b<13;++b)
				card[k++] = new Card(a,b);
		shuffle();
	}
	
	private void shuffle() {
		int replacement = (int)(Math.random()*52);
		for(int i=0;i<52;++i)
			swap(i,replacement);	
	}
	
	private void swap(int a,int b) {
		Card c = card[a];
		card[a] = card[b];
		card[b] = c;
	}
	
	public Card drawRandom() {
		return card[(int)(Math.random()*52)];
	}
	
	public Card drawManual(int i) {
		return card[i];
	}
}

class Card{
	private int suit;
	private int value;
	
	public Card(int s,int v) {
		suit = s;
		value = v;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
}