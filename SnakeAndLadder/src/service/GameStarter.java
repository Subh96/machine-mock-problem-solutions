package service;

import java.util.List;
import java.util.Queue;

import bean.Ladder;
import bean.Players;
import bean.Snake;
import bean.SnakeAndLadderBoard;

public class GameStarter {
	private SnakeAndLadderBoard sAndLadderBoard;
	private boolean isCompleted=false;
	private Queue<Players> lp;
	public GameStarter(SnakeAndLadderBoard sAndLadderBoard) {
		super();
		this.sAndLadderBoard = sAndLadderBoard;
		lp=(Queue<Players>) sAndLadderBoard.getLplayer();
	}

	public void runningGame(){
			while(!isCompleted) {
				Players p=lp.poll();
				int previousPosition=p.getPosition();
				int diceValue=DiceRoller.diceRoll();
				int count=0;
				int newPosition=0;
				if(diceValue==6) {
					newPosition=previousPosition+diceROLLCameSix();;
					newPosition=applyLadder(newPosition);
					newPosition=applySnake(newPosition);
					if(checkvalidInc(newPosition) && !isGameComplete(newPosition)) {
					p.setPosition(newPosition);}
					if(isGameComplete(newPosition)) {
						p.setPosition(newPosition);
						isCompleted=true;
					}
				}
				if(diceValue>=1 && diceValue<=5) {
					newPosition=previousPosition+diceValue;
					newPosition=applyLadder(newPosition);
					newPosition=applySnake(newPosition);
					if(checkvalidInc(newPosition) && !isGameComplete(newPosition)) {
					p.setPosition(newPosition);}
					if(isGameComplete(newPosition)) {
						p.setPosition(newPosition);
						isCompleted=true;
					}
				}
				System.out.println(p.getName()+" rolled a "+ diceValue+" and moved from "+previousPosition+" to "+newPosition);
				lp.add(p);
			}
			for(Players p:sAndLadderBoard.getLplayer()) {
				if(p.getPosition()==100) {
					System.out.println(p.getName()+" wins the game");
				}
			}
			
	}
	public int applyLadder(int newPosition) {
		for(Ladder l:sAndLadderBoard.getLladder()) {
			if(l.getStart()==newPosition) {
				newPosition=l.getEnd();	
			}
		}
		return newPosition;
	}
	public int applySnake(int newPosition) {
		for(Snake l:sAndLadderBoard.getLsnake()) {
			if(l.getHead()==newPosition) {
					newPosition=l.getTail();		
			}
		}
		return newPosition;
	}
	public int diceROLLCameSix() {
		int count=1,diceValue=6;
		int diceValue0=DiceRoller.diceRoll();
		if(diceValue0==6 && count==1) {
			diceValue=diceValue+diceValue0;
			count++;
			int diceValue1=DiceRoller.diceRoll();
			if(diceValue1==6 && count==2) {
				diceValue=0;
				count++;
			}
			else {
				diceValue+=diceValue1;
			}
		}
		else {
			diceValue=diceValue+diceValue0;
		}
		return diceValue;
	}
	public boolean checkvalidInc(int newPosition) {
		if(newPosition>100 && newPosition<0) {
			return false;
		}
		return true;
	}
	public boolean isGameComplete(int newPosition) {
		if(newPosition==100) {
			return true;
		}
		return false;
	}
}


