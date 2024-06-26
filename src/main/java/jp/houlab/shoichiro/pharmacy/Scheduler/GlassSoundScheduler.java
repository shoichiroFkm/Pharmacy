package jp.houlab.shoichiro.pharmacy.Scheduler;

import jp.houlab.shoichiro.pharmacy.Pharmacy;
import org.bukkit.Location;
import org.bukkit.Particle;
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
        if (player == null) {
            return;
        }
        if (location == null) {
            return;
        }
        location.getWorld().playSound(location, Sound.BLOCK_GLASS_BREAK, 1, 1);
        location.getWorld().playSound(location, Sound.BLOCK_END_PORTAL_SPAWN, 0.3f, 1);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0));

        player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, player.getX(), player.getY() + 2, player.getZ(), 200, 0.5, 1, 0.5, 0.5);
        player.getWorld().spawnParticle(Particle.ASH, player.getX(), player.getY() + 2, player.getZ(), 200, 0.5, 1, 0.5, 0);
        player.getWorld().spawnParticle(Particle.WHITE_ASH, player.getX(), player.getY() + 2, player.getZ(), 200, 0.5, 1, 0.5, 0);

        new RemainScheduler(player).runTaskTimer(Pharmacy.getPlugin(), 0, 20);

    }
}
