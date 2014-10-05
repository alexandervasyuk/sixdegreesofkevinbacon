Six Degrees of Kevin Bacon
==========================

I was posed with this problem at one of my interviews: 
We're looking for a command line script that takes the input of an actor or actress and outputs the path to Kevin Bacon. For example, if I pass it "Johnny Depp", it should output something like: Johnny Depp -(Once Upon a Time in Mexico)-> Mickey Rourke -(Diner)-> Kevin Bacon . With this comes a tarball of films.


To run my solution:
-------------------
To compile please use: javac -cp json-simple.jar:. Solution.java
To run: java -cp json-simple.jar:. Solution