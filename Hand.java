import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand{

    ArrayList <Card> hand = new ArrayList<Card>();


    public Hand(Deck d, int n){
        for(int i = 0; i < n; i++){
            hand.add(d.getDeck().remove(0));
        }
    }

    //test case to make you own hand
    public Hand(){
        hand.add(new Card("Hearts","Queen",12));
        hand.add(new Card("Diamonds","King",13));
        hand.add(new Card("Hearts","9",9));
        hand.add(new Card("Hearts","10",10));
        hand.add(new Card("Clubs","10",10));
    }

    public ArrayList<Card> getHand(){
        return hand;
    }
    
    public void showHand(){
        for(Card c: hand){
            System.out.println(c);
        }
    }

    public void discard(int i,Deck d){
        //Card removed is 1 less than i. This accounts for 0 index
        hand.set(i-1,draw(d));
    }

    public Card draw(Deck d){
       return d.getDeck().remove(0);
    }
    
}