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
                p.sendMessage("Incorrect command usage.\n");
                return false;
            }

            float blockX = 0;
            float blockZ = 0;

            try {
                float minX = Float.parseFloat(args[0]);
                float minY = Float.parseFloat(args[1]);
                float maxX = Float.parseFloat(args[2]);
                float maxY = Float.parseFloat(args[3]);

                float leftBlock = Float.parseFloat(args[4]);
                float topBlock = Float.parseFloat(args[5]);
                float rightBlock = Float.parseFloat(args[6]);
                float bottomBlock = Float.parseFloat(args[7]);

                float posY = Float.parseFloat(args[8]);
                float posX = Float.parseFloat(args[9]);


                blockX = posY;
                blockZ = posX;

            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "Only numbers are allowed.");
            }

            p.sendMessage("DESIRED BLOCK POSITION (x, z): " + blockX + blockZ );

        } else {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
        }

        return true;
    }
}
