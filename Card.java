public class Card{

    String suit;
    String value;
    int pointValue;

    public Card(String s, String v, int pV){
        this.suit = s;
        this.value = v;
        this.pointValue =pV;
    }

    public String getSuit(){
        return suit;
    }

    public String getValue(){
        return value;
    }

    public int getPointValue(){
        return pointValue;
    }

    public String toString(){
        return value + " of " + suit;
    }





}