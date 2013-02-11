hello friends!

Febuary 10, 2013 - 20:00
-Added the GameObject class, an abstract class that all objects in the game will inherit from, such as the player and the asteroids
	-It inherits from polygon.
-Added the GameWindow class, which contains the game loop as well as the code that initiates the creation of a window. 
-Added the player class: it has some variables which represent all of its points
	-You can call the move function and it moves the object x pixels in the sideways direction and y pixels in the down direction
	-You can call the pointAtMouse function, with your window as your input, make the player polygon point at the mouse. The reason you need to input your window is so that you get the mouse location relative to 0,0 of the canvas. 
		-This function doesn't work properly because bottom right point for some reason doesn't go to the right location. 