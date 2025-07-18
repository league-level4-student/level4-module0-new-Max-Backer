package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Directions currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Directions.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {

		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */
		int headX = head.getLocation().x;
		int headY = head.getLocation().y;

		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */
		
		switch(currentDirection) {
		case UP:
			headY--;
			break;
		case DOWN:
			headY++;
			break;
		case RIGHT:
			headX++;
			break;
		case LEFT:
			headX--;
			break;
		
		}

		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
		

		for(int i = snake.size() - 1; i > 0; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		head.setLocation(new Location(headX, headY));
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */
		canMove = true;
		// Set the canMove member variable to true.

	}

	public void setDirection(Directions direction) {

		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */
		if(canMove && isNotOppositeDirection(direction)) {
			currentDirection = direction;
			canMove = false;
		}

	}

	private boolean isNotOppositeDirection(Directions direction) {
		
		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */
		Map<Directions, Directions> opposites = new HashMap<>();
		
		opposites.put(Directions.UP, Directions.DOWN);
		opposites.put(Directions.DOWN, Directions.UP);
		opposites.put(Directions.RIGHT, Directions.LEFT);
		opposites.put(Directions.LEFT, Directions.RIGHT);
		
		if(opposites.get(direction) == currentDirection) return false;

		return true;
	}

	public void resetLocation() {

		// Clear the snake.

		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
		snake.clear();
		Location loc = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);

		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */
		head = new SnakeSegment(loc, BODY_SIZE);
		

		// Add the head to the snake.
		snake.add(head);

	}

	public boolean isOutOfBounds() {

		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		if(head.getLocation().x > SnakeGame.WINDOW_WIDTH || head.getLocation().y > SnakeGame.WINDOW_HEIGHT || head.getLocation().y < 0 || head.getLocation().x < 0) { return true; }
		return false;
	}

	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
		
		for (int i = 1; i < snake.size(); i++) {
			if(snake.get(i).getLocation().equals(head.getLocation())) {

				return true;
			}
		}

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		for(SnakeSegment s: snake) {
			if(s.getLocation() == loc) return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
