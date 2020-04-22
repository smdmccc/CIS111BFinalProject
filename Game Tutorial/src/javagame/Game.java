package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "Tutorial Full";
	public static final int menu = 0;
	public static final int play = 1;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}
	
	public void initSatesList(GameContainer container) throws SlickException{
		this.getState(menu).init(container, this);
		this.getState(play).init(container, this);
		this.enterState(menu);
		
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
				appgc = new AppGameContainer(new Game(gamename));
				appgc.setDisplayMode(640, 360, false);
				appgc.start();
		}catch(SlickException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}
}
