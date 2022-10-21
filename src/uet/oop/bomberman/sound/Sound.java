package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Sound {
    public Sound() {
    }

    public final String Just_Died_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_death.wav";
    public final String Bomb_Explosion_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_explosion.wav";
    public final String Level_Complete_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\level_complete.wav";
    public final String Put_Bombs_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_bomb.wav";
    public final String Title_Screen_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\title_screen.wav";
    public final String Coin_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_score.wav";

    public void play(String filePath, int loop, double volume ) {
        try {
            String path = new File(filePath).toURI().toString();
            MediaPlayer player = new MediaPlayer(new Media(path));
            player.setVolume((double) volume);
            player.setCycleCount(loop);
            player.seek(Duration.ZERO);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPutBomb() {
        this.play(Put_Bombs_SoundFX, 1, 1);
    }
    public void playJustDied() {
        this.play(Just_Died_SoundFX, 1, 1);
    }
    public void playBombExplosion() {
        this.play(Bomb_Explosion_SoundFX, 1, 1);
    }
    public void playLevelComplete() {
        this.play(Level_Complete_SoundFX, 1, 1);
    }
    public void playTitleScreen() {
        this.play(Title_Screen_SoundFX, 1, 1);
    }
    public void playCoin() {
        this.play(Coin_SoundFX, 1, 1);
    }
}
