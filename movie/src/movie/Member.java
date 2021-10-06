package movie;

import java.io.Serializable;

public class Member implements Serializable {
     private String name ;
     private int first;
     private int second;
	public String getName() {
		return name;
	}
	public Member(String name, int first, int second) {
		super();
		this.name = name;
		this.first = first;
		this.second = second;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", first=" + first + ", second=" + second + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}
