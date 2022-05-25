import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Welcome
        System.out.println("Welcome to 5-Card Draw!\nPress 0 to Draw Your Hand.");
        int flag = sc.nextInt();
        
        //Forces the user to draw
        while(flag != 0){
            System.out.println("Please Press 0.");
            flag = sc.nextInt();
        }

        //Do-while to replay game 
        do{
            
            //Creates Deck
            Deck test = new Deck();
            
            //Shuffles Deck
            test.shuffle();
            test.shuffle();
            
            //Creates and Outputs User's Hand
            System.out.println("Your Hand: \n");
            Hand hand1 = new Hand(test,5);
            hand1.showHand();
            
            System.out.println();

            //Prompts User to Discard if desired
            System.out.print("How many cards would you like to discard? Please enter a number 0 through 4.");
            int disNum = sc.nextInt();
            
            //Checks for Valid input
            while (disNum < 0 || disNum > 4){
                System.out.println("Invalid response. Please enter a number 0 through 4.");
                disNum = sc.nextInt();
            }
            
            System.out.println();
            
            //Prompts for specific cards to discard by using card position. When a card is removed, a new one from the same deck is drawn and placed in hand.
            System.out.println("Please enter which card you would like to discard, one at a time. Use the cards position. 1 - 5");
            for(int i = 0; i < disNum; i++){
                System.out.print("Card Number: ");
                int cardNum = sc. nextInt();
                hand1.discard(cardNum,test);
            }
            
            System.out.println();
            
            //Displays final hand
            System.out.println("Your New Hand: \n");
            hand1.showHand();

            //If else chain that classifies hand and determines if user won.
            if(isRoyalFlush(hand1)){
               System.out.println("You Have a Royal Flush!"); 
            }
            else if(isStraightFlush(hand1)){
                System.out.println("You Have a Straight Flush!");
            }
            else if(isFourOfKind(hand1)){
                System.out.println("You Have a Four of a Kind!");
            }
            else if(isFullHouse(hand1)){
                System.out.println("You Have a Full House!");
            }
            else if(isFlush(hand1)){
                System.out.println("You Have a Flush!");
            }
            else if(isStraight(hand1)){
                System.out.println("You Have a Straight!");
            }
            else if(isThreeOfKind(hand1)){
                System.out.println("You Have a Three of a Kind!");
            }
            else if(isTwoPair(hand1)){
                System.out.println("You Have Two Pairs!");
            }
            else if(isPair(hand1)){
                System.out.println("You Have a Pair!");
            }
            else{
                System.out.println("Sorry, Please play again.");
            }
            
            System.out.println();
            
            //Prompt the user if they would like to play again
            System.out.println("Would you like to play again? Press 0 to draw again. 1 to quit");
            flag = sc.nextInt();
            
            System.out.println();

        }while(flag ==0);     
    }
    
    //   ***Beginning of procedures to check for winning hands***
    
    /*
      Royal Flush Procdure has two parts:
      1. Determines if the cards are a straight based on sum of 5 consecutive integers formula
         5*(smallest number) + 10. This is using the values of the cards with J = 11, Q =12, K = 13, A = 14
      2. Checks for same suit by examining the first suit of card with the rest of the hand.     
    */
    public static boolean isRoyalFlush(Hand h){
       
        final int royalFlushValue = 60;
        int sum = 0;
        
        for(int i =0;i < h.getHand().size();i++){
           sum =sum + h.getHand().get(i).getPointValue();
        }
        String checkSuit = h.getHand().get(0).getSuit();
        
        int flag = 1;
        for(int i =1;i < h.getHand().size();i++){
           if( h.getHand().get(i).getSuit().equals(checkSuit)){
               flag++;
           }
        }
        
        if(sum == royalFlushValue && flag == 5){
            return true;
        }
        else{
            return false;
        }
    }
    
    /*
    This will also return true for Royal Flush. This procedure uses the same algo. as the royal flush. 
    The only difference is computing the sum of the values of the cards is compared to the 5 cons. integer formula. 
    Utilizes for-each loop
    */ 
    public static boolean isStraightFlush(Hand h){
        int sum = 0;
        int smallest = 15;

        for(Card c: h.getHand()){
            sum = sum + c.getPointValue();
        }
        
        for(Card c: h.getHand()){
            if(c.getPointValue() < smallest){
                smallest = c.getPointValue();
            }
        }
        
        String checkSuit = h.getHand().get(0).getSuit();
        int flag = 0;
        
        for(Card c: h.getHand()){
            if(c.getSuit().equals(checkSuit)){
                flag++;
            }
        }
        
        if((5*smallest+10)== sum && flag == 5){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isFourOfKind(Hand h){
        
        int maxValue = 0;
        int maxCount = 0;
        
        
        for(int i = 0; i < h.getHand().size(); i++){
            int count = 0;
            for(int j = 0; j < h.getHand().size(); j++){
                if(h.getHand().get(i).getPointValue() == h.getHand().get(j).getPointValue()){
                    count++;
                }
            }
            //Stores the mode and the point value for the card.
            if(maxCount < count){
                maxCount = count;
                maxValue = h.getHand().get(i).getPointValue();
            }
        }

        if(maxCount == 4){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isFullHouse(Hand h){
        
        int flag3Kind = 0;
        int flagPair = 0;
        
        for(int i = 0; i < h.getHand().size(); i++){
            int count = 0;
            for(int j = 0; j < h.getHand().size(); j++){
                if(h.getHand().get(i).getPointValue() == h.getHand().get(j).getPointValue()){
                    count++;
                }
            }

            if(count == 3){
                flag3Kind = 1;
            }

            if(count == 2){
                flagPair = 1;
            }
        }

        if(flag3Kind == 1 && flagPair == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isFlush(Hand h){
        
        String checkSuit = h.getHand().get(0).getSuit();
        int flag = 0;
        
        for(Card c: h.getHand()){
            if(c.getSuit().equals(checkSuit)){
                flag++;
            }
        }

        if(flag == 5){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isStraight(Hand h){
        
        int sum = 0;
        int smallest = 15;

        for(Card c: h.getHand()){
            sum = sum + c.getPointValue();
        }
        
        for(Card c: h.getHand()){
            if(c.getPointValue() < smallest){
                smallest = c.getPointValue();
            }
        }

        if((5*smallest+10)== sum){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isThreeOfKind(Hand h){
       
        int maxValue = 0;
        int maxCount = 0;
        
        
        for(int i = 0; i < h.getHand().size(); i++){
            int count = 0;
            for(int j = 0; j < h.getHand().size(); j++){
                if(h.getHand().get(i).getPointValue() == h.getHand().get(j).getPointValue()){
                    count++;
                }
            }
            //Stores the mode and the point value for the card.
            if(maxCount < count){
                maxCount = count;
                maxValue = h.getHand().get(i).getPointValue();
            }
        }
        
        if(maxCount == 3){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isTwoPair(Hand h){

        //Though this procedure records the value of the pairs, it doesn't implent the values. It returns true once is finds the second pair.
        int firstPair = 0;
        int secondPair = 0;
        int maxCount = 0;
        
        
        for(int i = 0; i < h.getHand().size(); i++){
            int count = 0;
            for(int j = 0; j < h.getHand().size(); j++){
                if(h.getHand().get(i).getPointValue() == h.getHand().get(j).getPointValue()){
                    count++;
                }
            }
            //Stores the mode and the point value for the card.
            //The first IF will capture the first pair. Note that this algo. will count 3, 4, and 5 of a kinds.
            if(maxCount == 0 && count == 2 ){
                maxCount = count;
                firstPair = h.getHand().get(i).getPointValue();
                
            }
            if(count == 2 && firstPair != h.getHand().get(i).getPointValue() ){
                secondPair = h.getHand().get(i).getPointValue();
                return true;
            }


        }
        return false;
    }

    public static boolean isPair(Hand h){
        
        for(int i = 0; i < h.getHand().size(); i++){
            
            for(int j = 0; j < h.getHand().size(); j++){
                
                //Notice the i != j 
                //We do not want to count the same card as pair.
                if(h.getHand().get(i).getPointValue() == h.getHand().get(j).getPointValue() && i != j){
                    return true;
                }
            }
        }
        return false;
    }
}
