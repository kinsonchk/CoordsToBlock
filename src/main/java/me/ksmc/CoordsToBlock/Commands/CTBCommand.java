package me.ksmc.CoordsToBlock.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CTBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length != 10) {
            sender.sendMessage(ChatColor.RED + "Error: Incorrect command usage.");
            return false;
        }

        // Initiate variables
        // Real-world coordinate boundaries (LAT/LONG)
        double westLong = 0;
        double southLat = 0;
        double eastLong = 0;
        double northLat = 0;

        // Minecraft world's boundary positions (X/Z)
        double topLeftX = 0;
        double topLeftZ = 0;
        double bottomRightX = 0;
        double bottomRightZ = 0;

        // Target pos in real-world coords to convert (LAT/LONG)
        double targetLat = 0;
        double targetLong = 0;

        // Scales for calculation
        double ewScale = 0;
        double nsScale = 0;

        // Final result
        double resultX = 0;
        double resultZ = 0;

        try {
            westLong = Double.parseDouble(args[0]);
            southLat = Double.parseDouble(args[1]);
            eastLong = Double.parseDouble(args[2]);
            northLat = Double.parseDouble(args[3]);

            topLeftX = Double.parseDouble(args[4]);
            topLeftZ = Double.parseDouble(args[5]);
            bottomRightX = Double.parseDouble(args[6]);
            bottomRightZ = Double.parseDouble(args[7]);

            targetLat = Double.parseDouble(args[8]);
            targetLong = Double.parseDouble(args[9]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Error: Only valid numbers are allowed as arguments.");
            return false;
        }

        if (eastLong == westLong || northLat == southLat) {
            sender.sendMessage(ChatColor.RED + "Error: Coordinate boundaries cannot be identical.");
            return false;
        }

        ewScale = (bottomRightX - topLeftX) / (eastLong - westLong);
        nsScale = (bottomRightZ - topLeftZ) / (northLat - southLat);

        resultX = ewScale * (targetLong - westLong) + topLeftX;
        resultZ = nsScale * (northLat - targetLat) + topLeftZ;

        sender.sendMessage(ChatColor.GREEN + "CONVERTED BLOCK POSITION (X, Z): " +
                ChatColor.UNDERLINE + Math.round(resultX) + ", " + Math.round(resultZ));

        return true;
    }
}
