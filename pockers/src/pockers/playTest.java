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
		String[] sh = {"��Ƭ","����","����","÷��"};
		Card cars = new Card();
		for(int i = 0;i < 4;i++){
			 cars.setColor(sh[i]);
			for(int j = 2;j < 15;j++){
				if(j==11){
					 cars.setId("J");
				cardList.add(new Card(sh[i],"J"));
				System.out.println("����˿��ƣ�"+cars.getColor()+cars.getId());
				continue;
				}
				if(j==12){
					 cars.setId("Q");
				cardList.add(new Card(sh[i],"Q"));
				System.out.println("����˿��ƣ�"+cars.getColor()+cars.getId());
				continue;
				}
				if(j==13){
					 cars.setId("K");
				cardList.add(new Card(sh[i],"K"));
				System.out.println("����˿��ƣ�"+cars.getColor()+cars.getId());
				continue;
				}
				if(j==14){
					 cars.setId("A");
				cardList.add(new Card(sh[i],"A"));
				System.out.println("����˿��ƣ�"+cars.getColor()+cars.getId());
				continue;
			}
			cars.setId(j+"");
			System.out.println("����˿��ƣ�"+cars.getColor()+cars.getId());
			cardList.add(new Card(sh[i],j+""));
		}
		}
		System.out.println("���ƴ����ɹ���");
		for(Card card:cardList){
			System.out.println("������ƣ�"+card.getColor()+"    "+card.getId());
		}
		
	}
	
	public void fapai(){
		System.out.println("���������1��������");
		String name1 = console.next();
		Player player1 = new Player("1",name1);
		System.out.println("���"+name1+"������Ϸ");
		System.out.println("���������2��������");
		String name2 = console.next();
		Player player2 = new Player("2",name2);
		System.out.println("���"+name2+"������Ϸ");
		
		//���Ҽ����е�Ԫ��
		Collections.shuffle(cardList);
		
		System.out.println(cardList.get(0).getColor()+cardList.get(0).getId());//������Ҽ��ϵĵ�һ��Ԫ��
		
		player1.getCards().add(cardList.get(0));
		player2.getCards().add(cardList.get(1));
		player1.getCards().add(cardList.get(2));
		player2.getCards().add(cardList.get(3));
		//����λ���������ƽ�������
		Collections.sort(player1.getCards());
		Collections.sort(player2.getCards());
		
		for(Card card:player1.getCards())
			System.out.println("���1����Ϊ��"+card.getColor()+card.getId());
		System.out.println("������Ϊ"+player1.getCards().get(1).getColor()+player1.getCards().get(1).getId());
		
		for(Card card:player2.getCards())
			System.out.println("���2����Ϊ��"+card.getColor()+card.getId());
		System.out.println("������Ϊ"+player2.getCards().get(1).getColor()+player2.getCards().get(1).getId());
		//����comparable����
		List<Card> newList = new ArrayList<Card>();
		newList.addAll(player1.getCards());
		newList.addAll(player2.getCards());
		
		if(newList.get(3).equals(player1.getCards()))
		System.out.println("��ң�"+player1.getName()+"��ʤ!!����Ϊ"+newList.get(0).getColor()+newList.get(0).getId());
		else
			System.out.println("��ң�"+player1.getName()+"��ʤ!!����Ϊ"+newList.get(0).getColor()+newList.get(0).getId());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playTest st = new playTest();
		st.creat();
		st.fapai();
	}

}
