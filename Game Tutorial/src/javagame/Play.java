package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = {200,200};
	float playerPositionX = 0;
	float playerPositionY = 0;
	// Centers the player on the screen based on the dimensions we created in Game.Java
	float shiftX = playerPositionX + 320;
	float shiftY = playerPositionY + 160;
	
	
	public Play(int state) {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		worldMap = new Image("res/world.png");
		Image[] walkUp = {new Image("res/back.png"), new Image("res/back.png")};
		Image[] walkDown = {new Image("res/front.png"), new Image("res/front.png")};
		Image[] walkLeft = {new Image("res/right.png"), new Image("res/right.png")};
		Image[] walkRight = {new Image("res/left.png"), new Image("res/left.png")};

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		player = movingDown;

	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)) {
			player = movingUp;
			playerPositionY += delta * .1f;
		}
			
		if(input.isKeyDown(Input.KEY_DOWN)) {
			player = movingDown;
			playerPositionY -= delta * .1f;
		}
			
		if(input.isKeyDown(Input.KEY_LEFT)) {
			player = movingLeft;
			playerPositionX += delta * .1f;
		}		
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			player = movingRight;
			playerPositionX -= delta * .1f;
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(playerPositionX, playerPositionY);
		player.draw(shiftX, shiftY);
		g.drawString("Player's X: " + playerPositionX + "\nPlayer's Y: " + playerPositionY, 460, 20);
		
		if(quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 100);
			g.drawString("Quit Game (Q)", 250, 100);
			if(quit==false) {
				g.clear();
			}


		}
		
	}
	

	@Override
	public int getID() {
		return 1;
	}

}
