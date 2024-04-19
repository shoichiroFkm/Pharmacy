package jp.houlab.shoichiro.pharmacy.Scheduler;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class AbilityScheduler extends BukkitRunnable {
    Location location;
Player player;
ItemStack potion;
ItemStack potion1;
ItemStack potion2;
    public AbilityScheduler(Location location,Player player,ItemStack potion,ItemStack potion1,ItemStack potion2) {
        this.location = location;
        this.player=player;
        this.potion=potion;
        this.potion1=potion1;
        this.potion2=potion2;
    }

    @Override
    public void run() {
        location.getWorld().spawnParticle(Particle.SPIT,location.getX(), location.getY(), location.getZ(),80,0,2,0,0.3);
        location.getWorld().playSound(location, Sound.ENTITY_ITEM_PICKUP,1,1);

        Random random = new Random();
        int num = random.nextInt(3);

        switch (num) {
            case 0:
                player.getInventory().addItem(new ItemStack( potion));
                break;
            case 1:
                player.getInventory().addItem(new ItemStack(potion1));
                break;
            default:
                player.getInventory().addItem(new ItemStack(potion2));
                break;
        }
    }
}

