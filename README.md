# About

A simple Minecraft Java Spigot plugin that converts a real-world coordinate location to a Minecraft block position.

Download the plugin (SpigotMC): https://www.spigotmc.org/resources/coordstoblock.138676/

Video explanation and example walkthrough: https://www.youtube.com/watch?v=3ZXC56hAl9k


## You need:
1. The real-world coordinate boundaries (in latitude and longitude decimal degree format) of the area that you're trying to convert
2. The Minecraft world's boundary positions (top-left and bottom-right block positions)
3. A target position in real-world coordinates to convert



# Usage

This plugin only has one command: "**ctb**".
Any player (OP or not) can use this command. You can also use this command through the server console.

Syntax: /ctb [1] [2] [3]

[1] Real-world coordinate boundaries (LAT/LONG): *<west_LONG> <south_LAT> <east_LONG> <north_LAT>*

[2] Minecraft world's boundary positions (X/Z): *<top-left_X> <top-left_Z> <bottom-right_X> <bottom-right_Z>*

[3] Target pos in real-world coords to convert (LAT/LONG): *<target_LAT> <target_LONG>*


## Example usage:

Command input:
**/ctb -74.0 45.4 -73.4 45.7 0 0 8900 5400 45.470358 -73.538817**

Output:
CONVERTED BLOCK POSITION (X, Z): **6841, 4134**

<a href="https://www.youtube.com/watch?v=tQuyhljoy0I">
  <img width="1357" height="675" alt="2026-11-11_19 31 58" src="https://github.com/user-attachments/assets/fd40e2b6-c1e4-4613-a4ec-d45ed316ca52" />
</a>
