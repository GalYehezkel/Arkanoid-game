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

**Sprite**: interface of Sprite.

**Classes that implements Sprite interface:**

**Block**:

**Paddle**:

**Ball**:

**ScoreIndicator**:




![arkanoid](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/arkanoid.png)

### geometry

![geometry](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/geometry.png)

### levels

![levelsDiagram](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/levelsDiagram.png)

### listeners

![listeners](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/listeners.png)

### akanoidstats

![akanoidstats](https://raw.githubusercontent.com/GalYehezkel/Arkanoid-game/master/images/akanoidstats.png)

