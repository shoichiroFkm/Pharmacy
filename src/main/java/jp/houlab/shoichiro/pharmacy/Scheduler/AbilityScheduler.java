package jp.houlab.shoichiro.pharmacy.Scheduler;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class AbilityScheduler extends BukkitRunnable {
    Location location;

    public AbilityScheduler(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        location.getWorld().spawnParticle(Particle.SPIT,location.getX(), location.getY(), location.getZ(),50,0,2,0,0.3);
        location.getWorld().playSound(location, Sound.ENTITY_ITEM_PICKUP,1,1);
    }
}

