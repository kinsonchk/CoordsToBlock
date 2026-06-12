package me.ksmc.minecraftSpigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CTBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length != 10) {
                p.sendMessage(ChatColor.RED + "Error: Incorrect command usage.\n");
                return false;
            }

            // Initiate variables
            // Real-world coordinate boundaries (LAT/LONG)
            float westLong = 0;
            float southLat = 0;
            float eastLong = 0;
            float northLat = 0;

            // Minecraft world's boundary positions (X/Z)
            float topLeftX = 0;
            float topLeftZ = 0;
            float bottomRightX = 0;
            float bottomRightZ = 0;

            // Target pos in real-world coords to convert (LAT/LONG)
            float targetLat = 0;
            float targetLong = 0;

            // Scales for calculation
            float ewScale = 0;
            float nsScale = 0;

            // Final result
            float resultX = 0;
            float resultZ = 0;

            try {
                westLong = Float.parseFloat(args[0]);
                southLat = Float.parseFloat(args[1]);
                eastLong = Float.parseFloat(args[2]);
                northLat = Float.parseFloat(args[3]);

                topLeftX = Float.parseFloat(args[4]);
                topLeftZ = Float.parseFloat(args[5]);
                bottomRightX = Float.parseFloat(args[6]);
                bottomRightZ = Float.parseFloat(args[7]);

                targetLat = Float.parseFloat(args[8]);
                targetLong = Float.parseFloat(args[9]);
            } catch (NumberFormatException e) {
                p.sendMessage(ChatColor.RED + "Error: Only valid numbers are allowed as arguments.");
                return false;
            }

            if (eastLong == westLong || northLat == southLat) {
                p.sendMessage(ChatColor.RED + "Error: Coordinate boundaries cannot be identical.");
                return false;
            }

            ewScale = (bottomRightX - topLeftX) / (eastLong - westLong);
            nsScale = (bottomRightZ - topLeftZ) / (northLat - southLat);

            resultX = ewScale * (targetLong - westLong) + topLeftX;
            resultZ = nsScale * (northLat - targetLat) + topLeftZ;

            p.sendMessage(ChatColor.GREEN + "CONVERTED BLOCK POSITION (X, Z): " +
                    ChatColor.ITALIC + Math.round(resultX) + ", " + Math.round(resultZ));

        } else {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
        }

        return true;
    }
}
