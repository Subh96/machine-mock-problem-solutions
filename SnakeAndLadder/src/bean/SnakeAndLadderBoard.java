package bean;

import java.util.List;
import java.util.Queue;

public class SnakeAndLadderBoard {
	private List<Snake> Lsnake;
	private List<Ladder> Lladder;
	private Queue<Players> Lplayer;
	private int size;
	public List<Snake> getLsnake() {
		return Lsnake;
	}
	public void setLsnake(List<Snake> lsnake) {
		Lsnake = lsnake;
	}
	public List<Ladder> getLladder() {
		return Lladder;
	}
	public void setLladder(List<Ladder> lladder) {
		Lladder = lladder;
	}
	public Queue<Players> getLplayer() {
		return Lplayer;
	}
	public void setLplayer(Queue<Players> lPlayyer) {
		Lplayer = lPlayyer;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
