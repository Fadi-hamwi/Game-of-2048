# The Game
This is a single player computer game written by Gabriele Cirulli, and based on an earlier game "1024" by Veewo Studio 
(see this link [on-line version of 2048](http://gabrielecirulli.github.io/2048).

The game itself is quite simple. It’s played on a 
 grid of squares, each of which can either be empty or contain a tile bearing an integer–a power of 2 greater than or equal to 2. Before the first move, the application adds a tile containing either 2 or 4 to a random square on the initially empty board. The choice of 2 or 4 is random, with a 75% chance of choosing 2 and a 25% chance of choosing 4.

The player then chooses a direction via their arrow keys to tilt the board: north, south, east, or west. 
All tiles slide in that direction until there is no empty space left in the direction of motion (there might not be any to start with).
A tile can possibly merge with another tile which earns the player points.

The below GIF is an example to see what the result of a few moves looks like.

![](https://fa22.datastructur.es/materials/proj/proj0/img/example-2048.gif)

# Important Note 
This project is from CS61B Data Structures and Algorithms Course to see The full description of the project go to this [link](https://fa22.datastructur.es/materials/proj/proj0/).

I implemented the `model.java` and `TiltColumn.java`.
