package pockers;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private String id;
	private List<Card> cards;
	
	public void player(){
		
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	//¹¹ÔìÆ÷
	public  Player(String name,String Id){
		this.name = name;
		id = Id;
		this.cards = new ArrayList<Card>();
	}
	

	
	public void setCards(List<Card>cards){
		this.cards = cards;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public String getId(){
		return id;
	}
	
	public void setId(String Id){
		id = Id;
	}
	
}
