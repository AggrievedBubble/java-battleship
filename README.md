# BattleShip

This is a simple **BattleShip** game created in ~~JavaScript~~ **Java** for a college project that allows you to play against ~~another player~~ a computer.

(note: would have liked to develop in javascript but college systems don't allow the use of npm or yarn)

---

## How the game works

**Battleship** is a game played by two players in which each player has a grid on which they can place 5 **ships** of varying lengths:

- 5 spaces - Carrier
- 4 spaces - Battleship
- 3 spaces - Submarine
- 3 spaces - Cruiser
- 2 spaces - Destroyer

The ships can **not** be placed next to each other or at diagonals, and **must** all be placed on the board.

Players can **not** see each others grids and take turns firing shots at each other by calling out grid references, the other player then reveals whether the shot hit or missed.

If a player hits a shot they get another go.

![gameplay flowchart](./Images/gameplay_flowchart.png "Gameplay flowchart")

---

The board state is to be saved in a 2d array that can be created with this function:

```java
static boolean[][] createGrid() {
	boolean[][] grid = new boolean[8][8];
	for (int x = 0; x < grid.length; x++) {
		for (int y = 0; y< grid.length; y++) {
			grid[x][y] = false;
		}
	}
	return grid;
}
```

The above function would create and return the structure to be filled with ship segments that can be present or not.

Another useful function is this one which randomly places ships and ensures they don't overlap:

```java
	static boolean[][] placeShipsRandom(boolean[][] grid) {
		boolean invalid_grid = false;
		do {//repeats until a valid grid is generated where all ships are placed, none overlap, touch or extend past the side
			if (invalid_grid) grid = generateGrid();
			invalid_grid = false;
			//placing 5 long ship
			//decides whether to place vertical or horizontal
			if ((int)Math.round(Math.random()) == 0) {
				//code for vertical placement
				int startx = (int)Math.floor(Math.random()*8);
				int starty = (int)Math.floor(Math.random()*3);
				grid[starty][startx] = true;
				grid[starty+1][startx] = true;
				grid[starty+2][startx] = true;
				grid[starty+3][startx] = true;
				grid[starty+4][startx] = true;
					
			} else {
				//code for horizontal placement
				int startx = (int)Math.floor(Math.random()*3);
				int starty = (int)Math.floor(Math.random()*8);
				grid[starty][startx] = true;
				grid[starty][startx+1] = true;
				grid[starty][startx+2] = true;
				grid[starty][startx+3] = true;
				grid[starty][startx+4] = true;
			}
			//placing 4 long ship
			//decides whether to place vertical or horizontal
			if ((int)Math.round(Math.random()) == 0) {
				//code for vertical
				int startx = (int)Math.floor(Math.random()*8);
				int starty = (int)Math.floor(Math.random()*4);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty+1][startx]) invalid_grid = true;
				if (grid[starty+2][startx]) invalid_grid = true;
				if (grid[starty+3][startx]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty+1][startx] = true;
				grid[starty+2][startx] = true;
				grid[starty+3][startx] = true;
				
			} else {
				//code for horizontal
				int startx = (int)Math.floor(Math.random()*4);
				int starty = (int)Math.floor(Math.random()*8);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty][startx+1]) invalid_grid = true;
				if (grid[starty][startx+2]) invalid_grid = true;
				if (grid[starty][startx+3]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty][startx+1] = true;
				grid[starty][startx+2] = true;
				grid[starty][startx+3] = true;
			}
			//placing 3 long ship a
			//decides vertical or horizontal
			if ((int)Math.round(Math.random()) == 0) {
				//code for vertical
				int startx = (int)Math.floor(Math.random()*8);
				int starty = (int)Math.floor(Math.random()*5);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty+1][startx]) invalid_grid = true;
				if (grid[starty+2][startx]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty+1][startx] = true;
				grid[starty+2][startx] = true;

			} else {
				//code for horizontal
				int startx = (int)Math.floor(Math.random()*5);
				int starty = (int)Math.floor(Math.random()*8);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty][startx+1]) invalid_grid = true;
				if (grid[starty][startx+2]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty][startx+1] = true;
				grid[starty][startx+2] = true;

			}
			//placing 3 long ship b
			//decides vertical or horizontal
			if ((int)Math.round(Math.random()) == 0) {
				//code for vertical
				int startx = (int)Math.floor(Math.random()*8);
				int starty = (int)Math.floor(Math.random()*5);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty+1][startx]) invalid_grid = true;
				if (grid[starty+2][startx]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty+1][startx] = true;
				grid[starty+2][startx] = true;

			} else {
				//code for horizontal
				int startx = (int)Math.floor(Math.random()*5);
				int starty = (int)Math.floor(Math.random()*8);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty][startx+1]) invalid_grid = true;
				if (grid[starty][startx+2]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty][startx+1] = true;
				grid[starty][startx+2] = true;

			}
			//placing 2 long ship
			//decides vertical or horizontal
			if ((int)Math.round(Math.random()) == 0) {
				//code for vertical
				int startx = (int)Math.floor(Math.random()*8);
				int starty = (int)Math.floor(Math.random()*6);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty+1][startx]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty+1][startx] = true;

			} else {
				//code for horizontal
				int startx = (int)Math.floor(Math.random()*6);
				int starty = (int)Math.floor(Math.random()*8);
				if (grid[starty][startx]) invalid_grid = true;
				if (grid[starty][startx+1]) invalid_grid = true;
				grid[starty][startx] = true;
				grid[starty][startx+1] = true;

			}
			
		} while (invalid_grid);
		
		return grid;
	}
```

One downfall of this function is that it **only** checks for overlapping ships and not contacting ships. this can lead to some strange but interesting generation. it would be fairly easy to alter this to check for contact with other ships but this is still better than having preset locations for the enemy ships that can be memorised over time and helps to improve the replayability of the game.

```java
static void logGrid(boolean[][] grid) {
	System.out.println("----------------");
	for (int x = 0; x < grid.length; x++) {
		System.out.print("|");
		for (int y = 0; y < grid.length; y++) {
			System.out.print(grid[x][y] + "|");
		}
		System.out.print("\n----------------\n");
	}
}
```

The above function is be a useful debugging function to quickly log the board state when programming.

---

I plan to store the board as a 2d array that contains panels which the user can interact with, suich as the background color of the panel changes color as shown:

## Example enemy grid

![Example enemy grid](./Images/example_enemy_grid.png "Enemy Grid")

## Example friendly grid

![Example friendly grid](./Images/example_friendly_grid.png "Friendly Grid")

The above images are a rough depiction of how the ships will be displayed to the user, using a color key to represent different states:

- **light grey** - not hit yet
- **dark grey** - shot missed
- **orange** - hit but not sunk
- **red** - sunk ship
- **blue** - friendly ship

(note: on the friendly grid hit ships are displayed as red as it looks nicer and the player can determine whether a ship has been sunk by looking at the board.)