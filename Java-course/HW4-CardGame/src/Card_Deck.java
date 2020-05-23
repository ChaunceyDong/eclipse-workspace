import java.util.Scanner;

public class Card_Deck {

	public static void main(String[] args) {
		CardDeck cd = new CardDeck();
		Card c1 = cd.drawRand();
		System.out.println("The card drawn by the computer is");
		System.out.println(c1.getSuit() + " of suit \n" + c1.getValue() + " of value");
		System.out.println("Please give me a number from 0 to 51 and I will give you a card.");
		Scanner scan = new Scanner(System.in);
		int b = scan.nextInt();
		Card c2 = cd.drawManually(b);
		System.out.println("The card drawn by you is");
		System.out.println(c2.getSuit() + " of suit \n" + c2.getValue() + " of value");
		scan.close();
		if (cd.Pk(c2, c1) == true)
			System.out.println("Congratulations! You win!");
		else
			System.out.println("Sorry, you lose.");
	}

}

class CardDeck {
	private Card[] cards;// 此时card没有值，null，所以之后要new

	public CardDeck() {
		cards = new Card[52];
		int k = 0;
		for (int a = 0; a < 4; ++a)
			for (int b = 1; b < 14; ++b)
				cards[k++] = new Card(a, b);
		shuffle();
	}

	private void shuffle() {
		for (int i = 0; i < cards.length; ++i) {
			int replacement = (int) (Math.random() * 52);
			swap(i, replacement);
		}
	}

	private void swap(int i, int j) {
		Card tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}

	public Card drawRand() {
		return cards[(int) (Math.random() * 52)];
	}

	public Card drawManually(int i) {// 抽第i张牌，返回该牌的花色和数字
		return cards[i];
	}

	public boolean Pk(Card i, Card j) {
		if (i.getValue() > j.getValue())
			return true;
		if (i.getValue() == j.getValue())
			if (i.getSuit() > j.getSuit())
				return true;
		return false;
	}
}

class Card {
	private int suit;// 0,1,2,3
	private int value;// 1,2,3,4...10,11,12,13

	public Card(int s, int v) {
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