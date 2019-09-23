package main;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import bean.Ladder;
import bean.Players;
import bean.Snake;
import bean.SnakeAndLadderBoard;
import service.GameStarter;

public class GameMain {
	public static void main(String a[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		s.nextLine();
		List<Snake> lsnake=new ArrayList<>();
		for(int i=0;i<n;i++) {
			String str=s.nextLine();
			Snake snake=new Snake();
			snake.setHead(Integer.parseInt(str.split(" ")[0]));
			snake.setTail(Integer.parseInt(str.split(" ")[1]));
			lsnake.add(snake);
		}
		int n1=s.nextInt();
		s.nextLine();
		List<Ladder> list=new ArrayList<>();
		for(int i=0;i<n1;i++) {
			String str=s.nextLine();
			Ladder ladder=new Ladder();
			ladder.setStart(Integer.parseInt(str.split(" ")[0]));
			ladder.setEnd(Integer.parseInt(str.split(" ")[1]));
			list.add(ladder);
		}
		int n2=s.nextInt();
		s.nextLine();
		Queue<Players>lPlayyer=new LinkedList<>();
		for(int i=0;i<n2;i++) {
			String str=s.nextLine();
			Players p=new Players();
			p.setName(str);
			lPlayyer.add(p);			
		}
		SnakeAndLadderBoard snakeAndLadderBoard=new SnakeAndLadderBoard();
		snakeAndLadderBoard.setLsnake(lsnake);
		snakeAndLadderBoard.setLladder(list);
		snakeAndLadderBoard.setLplayer(lPlayyer);
		snakeAndLadderBoard.setSize(100);
		GameStarter gameStarter=new GameStarter(snakeAndLadderBoard);
		gameStarter.runningGame();
	}
}
