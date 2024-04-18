package jp.houlab.shoichiro.pharmacy.Scheduler;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class RemainScheduler extends BukkitRunnable {
    int time;
    Player player;

    public RemainScheduler(Player player) {
        this.player = player;
        this.time = 30;
    }

    @Override
    public void run() {

        if (player==null){
            return;
        }
        if (player.getPotionEffect(PotionEffectType.SPEED)==null){
            return;
        }

        int count = player.getPotionEffect(PotionEffectType.SPEED).getDuration();
        int count1 = player.getPotionEffect(PotionEffectType.JUMP).getDuration();
        int count2 = player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getDuration();

        time = count / 20;
        time--;

        if (time < 0) {
            player.clearTitle();
            cancel();
            return;
        }

        if (count > 0 && count1 > 0 && count2 > 0) {
            Title title = Title.title(Component.text(""), Component.text( "ULT残り"+time + "秒"));
            player.showTitle(title);
        }
    }
}