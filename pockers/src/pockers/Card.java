package pockers;

import java.util.Comparator;

public class Card  implements Comparable<Card>{
	private String color;
	private String id;

  	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}	
  	
  	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
  	
  	public Card(){
  		
  	}
	
	public Card(String color,String id){
		this.color = color;
		this.id = id;
	}
 
 
	public String getColor(){
		// TODO Auto-generated method stub
		return color;
	}


  	public String getId() {
	// TODO Auto-generated method stub
  		return id;
  }
  	public void setId(String id){
  		// TODO Auto-generated method stub
  		this.id = id;	
  	}


	//重写compareTo方法
 @Override
	public int compareTo(Card o2) {
		// TODO Auto-generated method stub
		String[] num = {"3","4","5","6","7","8","9","J","Q","K","A","2"};
		String[] color = {"黑桃","红桃","梅花","方片"};
		int n1=0, n2=0, n11=0 , n22=0;
		for(int i = 0; i < num.length; i++){
			if(this.getId().equals(num[i]))
				n1 = i;
			if(o2.getId().equals(num[i]))
				n2 = i;
		}
		for(int i = 0;i < num.length;i++){
			if(this.getColor().equals(color[i]))
				n11=i;
			if(o2.getColor().equals(color[i]))
				n22=i;
		}
		if(n1>n2)
			return 1;
		else if(n1<n2)
			return -1;
		else{
			if(n11>n22)
				return 1;
			else if(n11<n22)
				return -1;
			else
				return 0;
		}
		
 	}
 public Card getCards(){
	 return null;
 }

public void setColor(String color2) {
	// TODO Auto-generated method stub
	this.color = color2;
}




}



