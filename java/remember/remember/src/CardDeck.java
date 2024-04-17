import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    List<Integer> cards;

    public CardDeck(){
        cards = new ArrayList<>();
        for(int i = 0;i<52;i++){
            cards.add(i);
        }
    }

    public void print(){
        for(int i = 0;i<cards.size();i++){
            int c = cards.get(i);
            System.out.println(c);
        }
        System.out.println();
    }

    //カードデッキの残り枚数を返す
    public int getSize(){
        return cards.size();
    }

    public int getCodeAt(int x){
        return cards.get(x);
    }

    private static String code2label(int code){
        String[] suit = {"S","H","D","C"};
        String[] num = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
        return suit[code/12]+num[code%12];
        
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int takeCard(){
        int card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        System.out.println("deck @3="+deck.getCodeAt(3));
        System.out.println("deck size="+deck.getSize());
        System.out.println("0->"+code2label(0));
        System.out.println("9->"+code2label(9));
        deck.takeCard();
        deck.takeCard();
        deck.takeCard();
        deck.shuffle();
        deck.print();
    }
}
