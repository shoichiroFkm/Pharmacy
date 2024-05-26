package jp.houlab.shoichiro.pharmacy.Scheduler;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class GlassSoundScheduler extends BukkitRunnable {
    Location location;
    Player player;
    public GlassSoundScheduler(Location location,Player player) {
        this.location = location;
        this.player=player;
    }

    @Override
    public void run() {
        location.getWorld().playSound(location, Sound.BLOCK_GLASS_BREAK, 1, 1);
        location.getWorld().playSound(location, Sound.BLOCK_END_PORTAL_SPAWN, 0.3f, 1);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0));
    }
}
