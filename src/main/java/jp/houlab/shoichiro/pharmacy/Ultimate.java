package jp.houlab.shoichiro.pharmacy;

import jp.houlab.shoichiro.pharmacy.Scheduler.EnchantParticleScheduler;
import jp.houlab.shoichiro.pharmacy.Scheduler.GlassSoundScheduler;
import jp.houlab.shoichiro.pharmacy.Scheduler.RemainScheduler;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

public class Ultimate implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Team team = player.getServer().getScoreboardManager().getMainScoreboard().getPlayerTeam(player);
       if (team==null){
           return;
       }
        for (String playerName : team.getEntries()) {
            Player ally = player.getServer().getPlayer(playerName);

            if (event.getHand() == EquipmentSlot.HAND) {
                if (event.getAction().isRightClick()) {
                    if (event.getMaterial().equals(Material.DRAGON_BREATH)) {

                        new RemainScheduler(player).runTaskTimer(Pharmacy.getPlugin(),0,20);

                        Location location=player.getLocation();
                        location.getWorld().spawnParticle(Particle.END_ROD,location.getX(), location.getY()+0.5, location.getZ(),600,3,0,3,0);
                        location.getWorld().spawnParticle(Particle.DRAGON_BREATH,location.getX(), location.getY()+0.5, location.getZ(),600,3,0,3,0);
                        location.getWorld().spawnParticle(Particle.SPELL,location.getX(), location.getY()+1, location.getZ(),100,0,3,0,0);

                        location.getWorld().playSound(location, Sound.ENTITY_WITCH_CELEBRATE,1,0);
                        location.getWorld().playSound(location, Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT,1,1);
                        location.getWorld().playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT,1,0);

                        new EnchantParticleScheduler(location).runTaskLater(Pharmacy.getPlugin(),25);
                        new GlassSoundScheduler(location,ally).runTaskLater(Pharmacy.getPlugin(),25);

                        if (ally==null){
                            return;
                        }

                        Location location1=ally.getLocation();
                        location1.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,location1.getX(), location1.getY()+2, location1.getZ(),200,0.5,1,0.5,0.5);
                        location1.getWorld().spawnParticle(Particle.ASH,location1.getX(), location1.getY()+2, location1.getZ(),200,0.5,1,0.5,0);
                        location1.getWorld().spawnParticle(Particle.WHITE_ASH,location1.getX(), location1.getY()+2, location1.getZ(),200,0.5,1,0.5,0);
                    }
                }
            }
        }
    }
                @EventHandler
                public void onPlayerDeath(PlayerDeathEvent event1){

                    Player killer = event1.getPlayer().getKiller();
                    if (killer==null){
                        return;
                    }
                    if (killer.getPotionEffect(PotionEffectType.SPEED)==null){
                        return;
                    }

                    int count = killer.getPotionEffect(PotionEffectType.SPEED).getDuration();
                    int count1 = killer.getPotionEffect(PotionEffectType.JUMP).getDuration();
                    int count2 = killer.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getDuration();

                    if (count > 0 && count1>0 && count2>0) {

                        int b = count + 100;

                        killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, b, 1));
                        killer.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, b, 1));
                        killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, b, 0));

                        Location location=killer.getLocation();
                        location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,location.getX(), location.getY()+2, location.getZ(),200,0.5,1,0.5,0.5);
                        location.getWorld().spawnParticle(Particle.ASH,location.getX(), location.getY()+2, location.getZ(),200,0.5,1,0.5,0);
                        location.getWorld().spawnParticle(Particle.WHITE_ASH,location.getX(), location.getY()+2, location.getZ(),200,0.5,1,0.5,0);
                        location.getWorld().playSound(location, Sound.ENTITY_ALLAY_ITEM_GIVEN,1,1);
                    }
                }
            }