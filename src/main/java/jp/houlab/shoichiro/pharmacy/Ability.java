package jp.houlab.shoichiro.pharmacy;

import jp.houlab.shoichiro.pharmacy.Scheduler.AbilityScheduler;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;

public class Ability implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        Set<String> tagPlayer = player.getScoreboardTags();
        if (tagPlayer.contains("pharmacy")) {
            if (event.getHand() == EquipmentSlot.HAND) {
                if (event.getAction().isRightClick()) {
                    if (event.getMaterial().equals(Material.BLAZE_POWDER)&& player.getCooldown(event.getMaterial()) == 0) {

                        Location location = player.getLocation();
                        location.getWorld().spawnParticle(Particle.FALLING_SPORE_BLOSSOM, location.getX() + 1, location.getY() + 2, location.getZ() + 1, 80, 0.2, 1, 0.2, 0);
                        location.getWorld().spawnParticle(Particle.FALLING_NECTAR, location.getX() + 1, location.getY() + 2, location.getZ() - 1, 80, 0.2, 1, 0.2, 0);
                        location.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR, location.getX() - 1, location.getY() + 2, location.getZ() + 1, 80, 0.2, 1, 0.2, 0);
                        location.getWorld().spawnParticle(Particle.FALLING_HONEY, location.getX() - 1, location.getY() + 2, location.getZ() - 1, 80, 0.2, 1, 0.2, 0);
                        location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, location.getX(), location.getY() + 2, location.getZ(), 200, 0, 1, 0, 0.5);
                        location.getWorld().playSound(location, Sound.ENTITY_WITCH_AMBIENT, 1, 0);
                        location.getWorld().playSound(location, Sound.BLOCK_SAND_BREAK, 1, 0);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 25, 5, true));

                        ItemStack potion = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) potion.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 1800, 1), true);
                        meta.setColor(Color.fromRGB(0x33EBFF));
                        meta.displayName(Component.text("翡俊閃風の薬"));
                        potion.setItemMeta(meta);

                        ItemStack potion1 = new ItemStack(Material.POTION);
                        PotionMeta meta1 = (PotionMeta) potion1.getItemMeta();
                        meta1.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 1800, 1), true);
                        meta1.setColor(Color.fromRGB(0xFDFF84));
                        meta1.displayName(Component.text("跳上活黄の薬"));
                        potion1.setItemMeta(meta1);

                        ItemStack potion2 = new ItemStack(Material.POTION);
                        PotionMeta meta2 = (PotionMeta) potion2.getItemMeta();
                        meta2.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600, 0), true);
                        meta2.setColor(Color.fromRGB(0xFFC700));
                        meta2.displayName(Component.text("衝攻気陽の薬"));
                        potion2.setItemMeta(meta2);

                        new AbilityScheduler(location, player, potion, potion1, potion2).runTaskLater(Pharmacy.getPlugin(), 20L);
                    }
                }
            }
        }
    }
}