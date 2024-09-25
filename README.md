# Homework02_Program01
1. What Program01 does (backend)
 Program01 begins by setting up all GUI elements and finding thier IDs. The program then creates a new ArrayList called listOfColors, which will be used to help store values into the listView. The program then sets up an adapter for help in displaying the listView. The program then sets the max and the starting point of the Seekbars to 255, and gives the red, green, blue, and hex values their default values. The seekbars are then given listeners to display values as the seekbar changes. During each seekbar change, the hex value and background color are also being determined, the hex value needs each of the values of the colors and the background color depends on the hex value. During the changing of the background color, the luminance of the color is determined to see if the color needs to be changed to black or white. The program then sets up the button which will allow the user to save different colors. When the button is clicked, a colorToAdd variable is created to store values into the listOfColors, the values are then assigned to the correct variables, and the colorToAdd is given to the listOfColors to be added to the listView. After giving colorToAdd to the listOfColors, the adapter is notified of the new data, and then the GUI is reset to default values. 

2. How to Use Program 01
   Users can use the Seekbars to change the background of the screen as well as changing the red, green, blue, and hex values. Once a user is done finding a color, the user can save the color and make a new one. At anytime, the user can click on the items in the listView and display the values of the item.

 4. Issues/Non-completion
 a. I ran into two main issues while trying to record the demo
 - Microsoft Teams did not allow me to download the video file I recorded
 - Using stream.office.com allowed me to download the file, but the video became choppy after 30 seconds of runtime
 - I had to settle for the choppiness because using microsoft built-in video editing software, ClipChamp, made the choppiness much worse

 b. I was unable to get the background color to display in the listView
