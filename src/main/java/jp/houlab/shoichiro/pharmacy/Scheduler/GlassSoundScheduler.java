package jp.houlab.shoichiro.pharmacy.Scheduler;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class GlassSoundScheduler extends BukkitRunnable {
    Location location;

    public GlassSoundScheduler(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        location.getWorld().playSound(location, Sound.BLOCK_GLASS_BREAK, 1, 1);
        location.getWorld().playSound(location, Sound.BLOCK_END_PORTAL_SPAWN, 1, 1);
    }
}
