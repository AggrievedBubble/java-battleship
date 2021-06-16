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



---

The board state is to be saved in a 2d array that can be created with this function:
```java
static String[][] createGrid() {
	String[][] grid = new String[7][7];
	for (int x = 0; x < grid.length; x++) {
		for (int y = 0; y< grid.length; y++) {
			grid[x][y] = " ";
		}
	}		
	return grid;
}
```
The above function would create and return the structure to be filled with ship segments that can be alive or destroyed.

Another useful function is this one:
```java
static void logGrid(String[][] grid) {
	System.out.println("----------------");
	for (int x = 0; x < grid.length; x++) {
		System.out.print("|");
		for (int y = 0; y< grid.length; y++) {
			System.out.print(grid[x][y].state + "|");
		}
		System.out.print("\n----------------\n");
	}
}
```
The above function would be a useful template debugging function to quickly log the board state when programming.

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
