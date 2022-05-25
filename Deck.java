import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    
    private ArrayList <Card> deck = new ArrayList <Card>();

    public Deck(){
        
        for(int i = 2; i <=10; i++){
            deck.add(new Card("Hearts",String.valueOf(i),i));
        }

        for(int i = 2; i <=10; i++){
            deck.add(new Card("Diamonds",String.valueOf(i),i));
        }

        for(int i = 2; i <=10; i++){
            deck.add(new Card("Spades",String.valueOf(i),i));
        }

        for(int i = 2; i <=10; i++){
            deck.add(new Card("Clubs",String.valueOf(i),i));
        }

        deck.add(new Card("Hearts","Jack",11));
        deck.add(new Card("Hearts","Queen",12));
        deck.add(new Card("Hearts","King",13));
        deck.add(new Card("Hearts","Ace",14));

        deck.add(new Card("Diamonds","Jack",11));
        deck.add(new Card("Diamonds","Queen",12));
        deck.add(new Card("Diamonds","King",13));
        deck.add(new Card("Diamonds","Ace",14));

        deck.add(new Card("Spades","Jack",11));
        deck.add(new Card("Spades","Queen",12));
        deck.add(new Card("Spades","King",13));
        deck.add(new Card("Spades","Ace",14));

        deck.add(new Card("Clubs","Jack",11));
        deck.add(new Card("Clubs","Queen",12));
        deck.add(new Card("Clubs","King",13));
        deck.add(new Card("Clubs","Ace",14));

    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public int getLength(){
        return deck.size();
    }

    public void shuffle(){
        Collections.shuffle(this.getDeck());
    }
    
    public void printCard(int i){
        System.out.println(deck.get(i));
    }

    public Card drawFromTop(){
        return deck.remove(0);
    }

}