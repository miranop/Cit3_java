package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	
	
	//ゲーム回数
	int games;
	
	//コンストラクタ
	public PokerModel() {
		deckcards = new ArrayList<>();
		handcards = new ArrayList<>();
		
	}
	
	//一連のゲームを開始する
	public void reset() {
		games = 0;
		chips = 500;
	}
	
	//数字毎に手札を集計した配列
	int count[];
	//次のゲームのためにカードを配りなおす
	public void nextgame() {
		//52枚の山札を作る
		deckcards.clear();
		for(int i = 0;i<=51;i++) {
			deckcards.add(i);
		}
		Collections.shuffle(deckcards);
		//山札の頭5枚を回収して手札にする
		handcards.clear();
		for(int i = 0;i<5;i++) {
			int n = deckcards.remove(0);
			handcards.add(n);
		}
		
		

		
		//残りの山札の枚数とカード番号をコンソールに表示
		System.out.printf("%d", deckcards.size());
		for(int n: deckcards) {
			System.out.printf("%d", n);
		}
		System.out.println();
		
		//JSPに送る情報を更新する
		message = "交換するカードをチェックしてください";
		buttonlabel = "交換";
		games++;
	}
	
	//indexで指定された位置のカードを、山札から補充したカードを置き替える
	public void change(List<String>index) {
		System.out.print("before: ");
		for(int c: handcards) {
			System.out.print(c);
			System.out.print(" ");
		}
		System.out.println();
		
		System.out.println("index="+index);
		List<Integer> num = new ArrayList<>();
		for(String s :index) {
			num.add(Integer.parseInt(s));
		}
		System.out.println("num="+num);
		for(int i = 0;i<num.size();i++) {
			int n = num.get(i);
			int c = deckcards.remove(0); // 山札の先頭を取り除き、
			handcards.set(n, c);
		}
		System.out.print("change: ");
		for(int c: handcards) {
			System.out.print(c);
			System.out.print(" ");
		}
		System.out.println();
		
		evaluate();
		buttonlabel = "次のゲーム";
		
	}
	//役の判定を実装する
	public void evaluate() {
		CountNumber();
		int point = 0;
		if(straight()==true && flash() == true) {
			message="ストレートフラッシュ";
			point += 1000;
		}else if(four()==true) {
			message="フォーカード";
			point += 700;
		}else if(three()==true&&one()==true) {
			message="フルハウス";
			point += 500;
		}else if(flash()==true) {
			message="フラッシュ";
			point += 300;
		}else if(straight()==true) {
			message="ストレート";
			point += 200;
		}else if(three()==true) {
			message="スリーカード";
			point += 100;
		}else if(two()==true) {
			message="ツーペア";
			point += 50;
		}else if(one()==true) {
			message = "ワンペア";
			point += 20;
		}else {
			message = "ノーハンド";
			point -= 100;
		}
		chips += point;
		message += ": " + chips;
		
		System.out.print("evaluate: ");
		for(int c: handcards) {
			System.out.print(c);
			System.out.print(" ");
		}
		System.out.println();
		
		if(chips == 0) {
			message += "ゲームオーバー";	
		}
	}
	
	//JSPから呼び出されるメソッド
	public int getGames() {
		return games;
	}
	
	//課題2の追加
	//現在のチップ数
	int chips;
	
	//山札
	List<Integer> deckcards;
	
	//手札
	List<Integer> handcards;
	
	//送信ボタンに表示する文字列
	String buttonlabel;
	
	//プレイヤーへのメッセージ
	
	String message;
	
	//現在のチップ数を返す
	
	public int getChips() {
		return chips;
	}
	
	//5枚の手札のうち、i番目のカード番号を返す
	public int getHandcardAt(int i) {
		return handcards.get(i);
	}
	
	//送信ボタンのラベルを返す
	public String getButtonLabel() {
		return buttonlabel;
	}
	
	//プレイヤーへのメッセージを返す
	public String getMessage() {
		return message;
	}
	
	//カードをセットする
	public void setHandcards(int a, int b, int c, int d, int e) {
		handcards.set(0, a);
		handcards.set(1, b);
		handcards.set(2, c);
		handcards.set(3, d);
		handcards.set(4, e);
	}
	//ワンペアの際の処理
	boolean one() {
		for(int i = 0;i<=12;i++) {
			if(count[i]==2) {
				return true;
			}
		}
		return false;
	}
	//ツーペアの際の処理
	boolean  two() {
		int t = 0;
		for(int i = 0;i<=12;i++) {
			if(count[i]==2) {
				t++;
			}
			if(t==2) {
				return true;
			}
		}return false;
	}
	//スリーカードの際の処理
	boolean  three() {
		for(int i = 0;i<=12;i++) {
			if(count[i]==3) {
				return true;
			}
		}return false;
	}
	//フォーカードの処理
	boolean  four() {
		for(int i = 0;i<=12;i++) {
			if(count[i]==4) {
				return true;
			}
		}return false;
	}
		
	
	//ストレートの判定
	public Boolean straight() {
	    ArrayList<Integer> sorthandcards = new ArrayList<>();
	    for(int s :handcards) {
	        sorthandcards.add(s);
	    }
	    Collections.sort(sorthandcards);
	    System.out.print("ソート後のカード");
	    System.out.print(sorthandcards);
	    for(int i = 0;i<=2;i++) {
	    	int num = sorthandcards.get(i+1)%13 - sorthandcards.get(i)%13;
	        if(num != 1) {
	            return false;
	        }
	        
	    }
	    // Aが最初または最後のカードである場合のストレートを確認する
	    return (sorthandcards.get(4)%13 - sorthandcards.get(3)%13) == 1 ||
	           (sorthandcards.get(3)%13 == 12 && sorthandcards.get(4)%13 == 0) ||
	           (sorthandcards.get(0)%13 == 0 && sorthandcards.get(4)%13 == 12);
	}
	

	//フラッシュの判定
	public Boolean flash() {
		for(int i = 0;i<=3;i++) {
			if(handcards.get(i)/13 != handcards.get(i+1)/13) {
				return false;
			}
		}
		return true;
	}
	
	void CountNumber() {
		count = new int[13];
		for(int c: handcards) {
			int x = c % 13;
			count[x]++;
		}
		for(int c: count) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	

}
