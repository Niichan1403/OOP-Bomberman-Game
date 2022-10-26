package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Sound {
    public static boolean turnSound = true;
    public Sound() {
    }

    public static final String Just_Died_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_death.wav";
    public static final String Put_Bombs_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_bomb.wav";
    public static final String Bomb_Explosion_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_explosion.wav";
    public static final String Title_Screen_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\title_screen.wav";
    public static final String Coin_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_score.wav";
    public static final String Next_Level_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\next_level.wav";
    public static final String Running1_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\running_1.wav";
    public static final String Item_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\nes_item.wav";
    public static final String Background_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\background.wav";
    public static final String Win_Title_SoundFX = System.getProperty("user.dir") + "\\res\\sound\\win_title.wav";

    public static MediaPlayer justDiedPlayer = new MediaPlayer(new Media(new File(Just_Died_SoundFX).toURI().toString()));
    public static MediaPlayer putBombPlayer = new MediaPlayer(new Media(new File(Put_Bombs_SoundFX).toURI().toString()));
    public static MediaPlayer bombExplosionPlayer = new MediaPlayer(new Media(new File(Bomb_Explosion_SoundFX).toURI().toString()));
    public static MediaPlayer titleScreenPlayer = new MediaPlayer(new Media(new File(Title_Screen_SoundFX).toURI().toString()));
    public static MediaPlayer coinPlayer = new MediaPlayer(new Media(new File(Coin_SoundFX).toURI().toString()));
    public static MediaPlayer nextLevelPlayer = new MediaPlayer(new Media(new File(Next_Level_SoundFX).toURI().toString()));
    public static MediaPlayer running1Player = new MediaPlayer(new Media(new File(Running1_SoundFX).toURI().toString()));
    public static MediaPlayer itemPlayer = new MediaPlayer(new Media(new File(Item_SoundFX).toURI().toString()));
    public static MediaPlayer backgroundPlayer = new MediaPlayer(new Media(new File(Background_SoundFX).toURI().toString()));
    public static MediaPlayer winTitlePlayer = new MediaPlayer(new Media(new File(Win_Title_SoundFX).toURI().toString()));

    public void play(int loop, double volume, MediaPlayer player) {
        player.setVolume(volume);
        player.setCycleCount(loop);
        player.seek(Duration.ZERO);
        player.play();
    }

    public void stop(MediaPlayer player) {
        player.stop();
    }

    public void playJustDied() {
        if(turnSound) {
            this.play(1, 1, justDiedPlayer);
        }
    }
    public void playPutBomb() {
        if(turnSound){
            this.play(1, 1, putBombPlayer);
        }
    }

    public void playBombExplosion() {
        if(turnSound) {
            this.play(1, 1, bombExplosionPlayer);
        };
    }
    public void playNextLevel() {
        if(turnSound) {
            this.play(1, 0.5, nextLevelPlayer);
        }
    }
    public void playTitleScreen() {
        if(turnSound) {
            this.play(1, 0.2, titleScreenPlayer);
        }
    }
    public void playCoin() {
       if(turnSound) {
           this.play(1, 1, coinPlayer);
       }
    }
    public void playItem() {
       if(turnSound) {
           this.play(1, 0.5, itemPlayer);
       }
    }
    public void playRunning1() {
       if(turnSound) {
           this.play(1, 0.08, running1Player);
       }
    }
    public void playBackground() {
       if(turnSound) {
           this.play(1, 0.55, backgroundPlayer);
       }
    }
    public void playWinTitle() {
        if(turnSound) {
            this.play(1, 0.55, winTitlePlayer);
        }
    }

    public void stopBackground() {
        this.stop(backgroundPlayer);
    }

    public void stopTitleScreen() {
        this.stop(titleScreenPlayer);
    }
}
