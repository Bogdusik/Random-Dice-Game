# Rolling Dice GUI

This project is a simple Java-based graphical user interface (GUI) that simulates rolling two dice.
It uses Swing components to display images of dice and a banner and it includes a button to trigger the dice roll animation.

## Features
- Displays two dice images on the GUI.
- Rolls the dice with a 3-second animation, showing random dice faces.
- Uses Swing components to manage the layout and interactions.

## Project Structure
- `src/`: Contains the Java source code for the application.
  - `App.java`: The main entry point for the application. It launches the `RollingDiceGui` frame.
  - `ImgService.java`: A utility class for loading and updating images from the resources folder.
  - `RollingDiceGui.java`: The main GUI class that contains the dice rolling logic and layout.
- `resources/`: A folder containing images for the dice faces and a banner.
  - `dice1.png` to `dice6.png`: Images of the dice faces, representing values 1 to 6.
  - `banner.png`: A banner image that is displayed at the top of the window.

## Requirements
- Java 8 or later.

## Running the Application
1. Ensure that you have the required images in the `resources` folder.
2. Compile and run the project.
   - You can run the project from the command line using the following:
     ```bash
     javac -d . src/*.java
     java App
     ```

## How it Works
1. The GUI is initialized with two dice images and a "Roll" button.
2. When the user clicks the "Roll" button, the dice roll animation starts.
3. The dice images update every 60 milliseconds for 3 seconds, showing random dice faces.
4. After the 3-second roll, the "Roll" button becomes active again, allowing the user to roll the dice again.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- The dice images are sourced from the `resources` folder.
