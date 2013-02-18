hello friends!

February 17 2013 - 7:2
-Spelled February correctly!
-Forced GameObjects to have a color variable. The default is Color.WHITE. 
-Added all sorts of serialVersionUIDS! 
-Changed the move class to one without x's and y's. 
-GameWindow.java
	-Changed the version to 0.0.3!
	-Changed movement so that it works better, through booleans and logic.
		-It's not vectored, though. 
	-Added some spaces
	-Added the getFPS class, which returns an integer approximation of the frames per
	second (Which is really the # of game loops per second).
	-Instead of storing the objects that need to be drawn in a linked list of game
	objects,they are now stored in a GameObjectHolder 
-GameObjectHolder.java
	-This stores different types of gameObjects(really just lasers and asteroids)
		-This is so that the # lasers can be limited more easily
	-It comes with all sorts of handy classes for manipulating the objects!
-Asteroid.java
	-It has a generateAsteroid() class that lets you generate an asteroid
	-Other than that, it's not done yet.
-Laser.java
	-It's a laser beam!
	-It'll move every time you call move() in the angle that you specify at its 
	creation
-Player.java
	-Using doubles to store stuff to make things more accurate!


Febuary 10, 2013 - 22:18
-Made the player class form it's triangle properly
-Added a pause feature where the game stops running the when the mouse is outside the window
-Changed the cursor to a crosshair from the normal thingy
-Made the player's shoot() method print out "pew" when it is called
-Changed the shape of the player so that it's a 11x5 isosceles triangle rather than a 10x5 one. 



February 10, 2013 - 20:00
-Added the GameObject class, an abstract class that all objects in the game will inherit from, such as the player and the asteroids
	-It inherits from polygon.
-Added the GameWindow class, which contains the game loop as well as the code that initiates the creation of a window. 
-Added the player class: it has some variables which represent all of its points
	-You can call the move function and it moves the object x pixels in the sideways
	direction and y pixels in the down direction
	-You can call the pointAtMouse function, with your window as your input, make the
	player polygon point at the mouse. The reason you need to input your window is so
	that you get the mouse location relative to 0,0 of the canvas. 
		-This function doesn't work properly because bottom right point for some
		reason doesn't go to the right location. 