# Arkanoid-game
## Introduction
In this project, I created an Arkanoid game.

The game contains four levels with different difficulty.

![levels](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/levels.png)

## UML

### arkanoid
**Animation** - An Animation interface. Has two functions- doOneFrame that put the changes in the drawsurface and and shouldStop that indicates to stop the animation.

**Classes that implements animation interface:**

**GameLose**: A pause screen that pauses the game until space is pressed.

**GameLevel**: A game level that contains a sprite collection, environment, GUI, colors array and sleeper.
runs a game that displays blocks pedals and balls. 

**GameWin**: A pause screen that pauses the game until space is pressed.

**CountDownAnimation**:  The CountdownAnimation will display the given gameScreen,
for numOfSeconds seconds, and on top of them it will show
a countdown from countFrom back to 1, where each number will
appear on the screen for (numOfSeconds / countFrom) seconds, before
it is replaced with the next one.

**KeyPressStoppableAnimation**: A key press stoppable for animation, holds an animation that is keyPressStoppable.

**PauseScreen**:  A pause screen that pauses the game until space is pressed.

**Sprite**: interface of Sprite. An object that can be drawen on a DrawSurface.

**Classes that implements Sprite interface:**

**Block**: A block that contains a rectangle and a color, implements Collidable, Sprite, HitNotifier.

**Paddle**: A paddle that contains a rectangle, color and keyboard sensor.

**Ball**: A ball that contains his location and radius and functions of set to his fields and move his location.

**ScoreIndicator**: a score indicator that displays the score.

**Collidable**: A collidable interface. An object that other objects can collide it.

**Classes that implements Collidable interface:**

**Block**

**Paddle**

**SpriteCollection**: A Sprite Collection that contains a list of sprites.

**GameEnvironment**: game environment that contains a collidable list and finds collisions with them and the balls.

**AnimationRunner**: An animation runner.

**CollisionInfo**: collision info that contains collision point and collision object.

**GameFlow**: A game flow that runs the levels.

**Velocity**: A velocity that contains dx and dy.


![arkanoid](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/arkanoid.png)

### geometry

**Epsilon**: An epsilon constant for doubles.

**Height**: A Height for the GUI.

**Line**: Represents a line that contains two points one start and one end.

**Point**: Represents a point that contains x and y.

**Rectangle**: A Rectangle that contains upperLeft Point, width and height.

**Width**: A Width for the GUI.


![geometry](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/geometry.png)

### levels

LevelInformation: An interface of level information.

**Classes that implements LevelInformation interface:**

**LevelOne**:  Level one.

**LevelTwo**:  Level two.

**LevelThree**:  Level three.

**LevelFour**:  Level four.

**BackGroundOne**: A sprites backGround.

**BackGroundTwo**: A sprites backGround.

**BackGroundThree**: A sprites backGround.

**BackGroundFour**: A sprites backGround.


![levelsDiagram](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/levelsDiagram.png)

### listeners

**HitNotifier**: interface of Hit Notifier.

**Classes that implements HitNotifier interface:**

**Block**.

**HitListener**: interface of Hit Listener.

**Classes that implements HitListener interface:**

**BlockRemover**: a BlockRemover is in charge of removing blocks from the game, as well as keeping count of the number of blocks that remain.

**BallRemover**: a BallRemover is in charge of removing balls from the game, as well as keeping count of the number of balls that remain.

**ScoreTrackingListener**: a score tracking listener that updates the score after each hit by increasing 5 points.


![listeners](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/listeners.png)

### akanoidstats

**Counter**:  a counter.

![akanoidstats](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/akanoidstats.png)

**Ass6Game**: run a game with levels that contains balls, blocks and paddle.


## Design Patterns

**Observer-Observable**: in the game the Block is the observable and BlockRemover, BallRemover and ScoreTrackingListener are that observers.

**Polymorphism**: There are interfaces and diffrent types for each interface.
