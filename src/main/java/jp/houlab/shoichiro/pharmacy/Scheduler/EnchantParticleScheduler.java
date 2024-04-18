package jp.houlab.shoichiro.pharmacy.Scheduler;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class EnchantParticleScheduler extends BukkitRunnable {
    Location location;

    public EnchantParticleScheduler(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,location.getX(), location.getY()+6, location.getZ(),1000,5,0,5,0.5);
        location.getWorld().spawnParticle(Particle.REVERSE_PORTAL,location.getX(), location.getY()+6, location.getZ(),600,5,0,5,0.5);
    }
}

