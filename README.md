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

![geometry](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/geometry.png)

### levels

![levelsDiagram](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/levelsDiagram.png)

### listeners

![listeners](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/listeners.png)

### akanoidstats

![akanoidstats](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/akanoidstats.png)

