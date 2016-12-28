/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author gregory
 */
public class ImageSet {

    static final String WALLS_DIR = "walls/";
    static final String COIN_DIR = "coin/";
    static final String GHOST1_DIR = "ghost1/";
    static final String GHOST2_DIR = "ghost2/";
    static final String GHOST3_DIR = "ghost3/";
    static final String GHOST4_DIR = "ghost4/";
    static final String PACMAN_DIR = "pacman/";
    static final int ANIM_SIZE = 15;
    static final int GHOST_ANIM_SIZE = 2;

    public ImageSet(String path, int segSize) throws IOException {
        _segmentSize = segSize;
        _walls = new BufferedImage[6];

        _pacman_left = new BufferedImage[ANIM_SIZE];
        _pacman_right = new BufferedImage[ANIM_SIZE];
        _pacman_up = new BufferedImage[ANIM_SIZE];
        _pacman_down = new BufferedImage[ANIM_SIZE];

        for (int i = 1; i <= ANIM_SIZE; ++i) {
            _pacman_left[i - 1] = ImageIO.read(new File(path + PACMAN_DIR + "/left/" + i + ".bmp"));
            _pacman_right[i - 1] = ImageIO.read(new File(path + PACMAN_DIR + "/right/" + i + ".bmp"));
            _pacman_up[i - 1] = ImageIO.read(new File(path + PACMAN_DIR + "/up/" + i + ".bmp"));
            _pacman_down[i - 1] = ImageIO.read(new File(path + PACMAN_DIR + "/down/" + i + ".bmp"));
        }

        _coin = new BufferedImage[1];
        _coin[0] = ImageIO.read(new File(path + COIN_DIR + "coin.bmp"));

        _ghost1_left = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost1_right = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost1_up = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost1_down = new BufferedImage[GHOST_ANIM_SIZE];

        _ghost2_left = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost2_right = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost2_up = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost2_down = new BufferedImage[GHOST_ANIM_SIZE];

        _ghost3_left = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost3_right = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost3_up = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost3_down = new BufferedImage[GHOST_ANIM_SIZE];

        _ghost4_left = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost4_right = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost4_up = new BufferedImage[GHOST_ANIM_SIZE];
        _ghost4_down = new BufferedImage[GHOST_ANIM_SIZE];

        for (int i = 1; i <= GHOST_ANIM_SIZE; ++i) {
            _ghost1_left[i - 1] = ImageIO.read(new File(path + GHOST1_DIR + "/left/" + i + ".bmp"));
            _ghost1_right[i - 1] = ImageIO.read(new File(path + GHOST1_DIR + "/right/" + i + ".bmp"));
            _ghost1_up[i - 1] = ImageIO.read(new File(path + GHOST1_DIR + "/up/" + i + ".bmp"));
            _ghost1_down[i - 1] = ImageIO.read(new File(path + GHOST1_DIR + "/down/" + i + ".bmp"));

            _ghost2_left[i - 1] = ImageIO.read(new File(path + GHOST2_DIR + "/left/" + i + ".bmp"));
            _ghost2_right[i - 1] = ImageIO.read(new File(path + GHOST2_DIR + "/right/" + i + ".bmp"));
            _ghost2_up[i - 1] = ImageIO.read(new File(path + GHOST2_DIR + "/up/" + i + ".bmp"));
            _ghost2_down[i - 1] = ImageIO.read(new File(path + GHOST2_DIR + "/down/" + i + ".bmp"));

            _ghost3_left[i - 1] = ImageIO.read(new File(path + GHOST3_DIR + "/left/" + i + ".bmp"));
            _ghost3_right[i - 1] = ImageIO.read(new File(path + GHOST3_DIR + "/right/" + i + ".bmp"));
            _ghost3_up[i - 1] = ImageIO.read(new File(path + GHOST3_DIR + "/up/" + i + ".bmp"));
            _ghost3_down[i - 1] = ImageIO.read(new File(path + GHOST3_DIR + "/down/" + i + ".bmp"));

            _ghost4_left[i - 1] = ImageIO.read(new File(path + GHOST4_DIR + "/left/" + i + ".bmp"));
            _ghost4_right[i - 1] = ImageIO.read(new File(path + GHOST4_DIR + "/right/" + i + ".bmp"));
            _ghost4_up[i - 1] = ImageIO.read(new File(path + GHOST4_DIR + "/up/" + i + ".bmp"));
            _ghost4_down[i - 1] = ImageIO.read(new File(path + GHOST4_DIR + "/down/" + i + ".bmp"));
        }

        for (int i = 0; i < 6; i++) {
            _walls[i] = ImageIO.read(new File(String.format("%s%d.bmp", path + WALLS_DIR, i)));
        }
    }

    public BufferedImage[] getCoin() {
        return _coin;
    }

    public BufferedImage[] getPacman_left() {
        return _pacman_left;
    }

    public BufferedImage[] getPacman_right() {
        return _pacman_right;
    }

    public BufferedImage[] getPacman_up() {
        return _pacman_up;
    }

    public BufferedImage[] getPacman_down() {
        return _pacman_down;
    }

    public BufferedImage[] getGhost1_left() {
        return _ghost1_left;
    }

    public BufferedImage[] getGhost1_right() {
        return _ghost1_right;
    }

    public BufferedImage[] getGhost1_up() {
        return _ghost1_up;
    }

    public BufferedImage[] getGhost1_down() {
        return _ghost1_down;
    }

    public BufferedImage[] getGhost2_left() {
        return _ghost2_left;
    }

    public BufferedImage[] getGhost2_right() {
        return _ghost2_right;
    }

    public BufferedImage[] getGhost2_up() {
        return _ghost2_up;
    }

    public BufferedImage[] getGhost2_down() {
        return _ghost2_down;
    }

    public BufferedImage[] getGhost3_left() {
        return _ghost3_left;
    }

    public BufferedImage[] getGhost3_right() {
        return _ghost3_right;
    }

    public BufferedImage[] getGhost3_up() {
        return _ghost3_up;
    }

    public BufferedImage[] getGhost3_down() {
        return _ghost3_down;
    }

    public BufferedImage[] getGhost4_left() {
        return _ghost4_left;
    }

    public BufferedImage[] getGhost4_right() {
        return _ghost4_right;
    }

    public BufferedImage[] getGhost4_up() {
        return _ghost4_up;
    }

    public BufferedImage[] getGhost4_down() {
        return _ghost4_down;
    }

    public BufferedImage[] getWalls() {
        return _walls;
    }

    public int getSegmentSize() {
        return _segmentSize;
    }
    private BufferedImage[] _pacman_left;
    private BufferedImage[] _pacman_right;
    private BufferedImage[] _pacman_up;
    private BufferedImage[] _pacman_down;

    private BufferedImage[] _ghost1_left;
    private BufferedImage[] _ghost1_right;
    private BufferedImage[] _ghost1_up;
    private BufferedImage[] _ghost1_down;

    private BufferedImage[] _ghost2_left;
    private BufferedImage[] _ghost2_right;
    private BufferedImage[] _ghost2_up;
    private BufferedImage[] _ghost2_down;

    private BufferedImage[] _ghost3_left;
    private BufferedImage[] _ghost3_right;
    private BufferedImage[] _ghost3_up;
    private BufferedImage[] _ghost3_down;

    private BufferedImage[] _ghost4_left;
    private BufferedImage[] _ghost4_right;
    private BufferedImage[] _ghost4_up;
    private BufferedImage[] _ghost4_down;

    private BufferedImage[] _coin;
    private BufferedImage[] _walls;
    private int _segmentSize;

}
