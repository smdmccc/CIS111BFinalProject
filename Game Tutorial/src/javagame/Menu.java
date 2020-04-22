package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image playNow;
	Image exitGame;
	
	public Menu(int state) {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		playNow = new Image("res/start.png");
		exitGame = new Image("res/exit.png");
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		//* Gets input of mouse from computer
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//* When user clicks between the coordinates of the Start button,
		//* they will be taken into State1(Play.java)
		//* start = 167/69 , exit = 168/70
		if((posX>75 && posX<242)&&(posY>220 && posY<285)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
			
			//* Creates an exit button
			if((posX>75 && posX<242) && (posY>150 && posY<210)) {
				if(Mouse.isButtonDown(0)) {
					System.exit(0);
				}
			}		
		
	}
		
		//* if(input.isKeyDown(Input.KEY_UP)) 		{	butterflyY -= 1;	}
		//if(input.isKeyDown(Input.KEY_DOWN)) 	{	butterflyY += 1;	}
		//if(input.isKeyDown(Input.KEY_LEFT)) 	{	butterflyX -= 1;	}
		//f(input.isKeyDown(Input.KEY_RIGHT)) 	{	butterflyX += 1;	}

	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Welcome to the Game", 75, 50);
		playNow.draw(75,75);
		exitGame.draw(75,150);
	}
	

	@Override
	public int getID() {
		return 0;
	}

}
