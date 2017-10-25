package pockers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class playTest {
	private Scanner  console;
	public List<Card>cardList;
	public playTest(){
		this.cardList = new ArrayList<Card>();
		console = new Scanner(System.in);
	}
	
	public void creat(){
		String[] sh = {"方片","黑桃","红桃","梅花"};
		Card cars = new Card();
		for(int i = 0;i < 4;i++){
			 cars.setColor(sh[i]);
			for(int j = 2;j < 15;j++){
				if(j==11){
					 cars.setId("J");
				cardList.add(new Card(sh[i],"J"));
				System.out.println("添加了卡牌："+cars.getColor()+cars.getId());
				continue;
				}
				if(j==12){
					 cars.setId("Q");
				cardList.add(new Card(sh[i],"Q"));
				System.out.println("添加了卡牌："+cars.getColor()+cars.getId());
				continue;
				}
				if(j==13){
					 cars.setId("K");
				cardList.add(new Card(sh[i],"K"));
				System.out.println("添加了卡牌："+cars.getColor()+cars.getId());
				continue;
				}
				if(j==14){
					 cars.setId("A");
				cardList.add(new Card(sh[i],"A"));
				System.out.println("添加了卡牌："+cars.getColor()+cars.getId());
				continue;
			}
			cars.setId(j+"");
			System.out.println("添加了卡牌："+cars.getColor()+cars.getId());
			cardList.add(new Card(sh[i],j+""));
		}
		}
		System.out.println("卡牌创建成功：");
		for(Card card:cardList){
			System.out.println("输出卡牌："+card.getColor()+"    "+card.getId());
		}
		
	}
	
	public void fapai(){
		System.out.println("请输入玩家1的姓名：");
		String name1 = console.next();
		Player player1 = new Player("1",name1);
		System.out.println("玩家"+name1+"进入游戏");
		System.out.println("请输入玩家2的姓名：");
		String name2 = console.next();
		Player player2 = new Player("2",name2);
		System.out.println("玩家"+name2+"进入游戏");
		
		//打乱集合中的元素
		Collections.shuffle(cardList);
		
		System.out.println(cardList.get(0).getColor()+cardList.get(0).getId());//输出打乱集合的第一个元素
		
		player1.getCards().add(cardList.get(0));
		player2.getCards().add(cardList.get(1));
		player1.getCards().add(cardList.get(2));
		player2.getCards().add(cardList.get(3));
		//对两位玩家手里的牌进行排序
		Collections.sort(player1.getCards());
		Collections.sort(player2.getCards());
		
		for(Card card:player1.getCards())
			System.out.println("玩家1的牌为："+card.getColor()+card.getId());
		System.out.println("最大点数为"+player1.getCards().get(1).getColor()+player1.getCards().get(1).getId());
		
		for(Card card:player2.getCards())
			System.out.println("玩家2的牌为："+card.getColor()+card.getId());
		System.out.println("最大点数为"+player2.getCards().get(1).getColor()+player2.getCards().get(1).getId());
		//利用comparable排序
		List<Card> newList = new ArrayList<Card>();
		newList.addAll(player1.getCards());
		newList.addAll(player2.getCards());
		
		if(newList.get(3).equals(player1.getCards()))
		System.out.println("玩家："+player1.getName()+"获胜!!手牌为"+newList.get(0).getColor()+newList.get(0).getId());
		else
			System.out.println("玩家："+player1.getName()+"获胜!!手牌为"+newList.get(0).getColor()+newList.get(0).getId());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playTest st = new playTest();
		st.creat();
		st.fapai();
	}

}
