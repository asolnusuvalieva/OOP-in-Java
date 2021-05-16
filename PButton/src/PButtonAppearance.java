import processing.core.PImage;

public class PButtonAppearance {
    private int backgroundColor = 0xfff51d7e; // Dark
    private int backgroundColorHover = 0xffff5ea6; // Light
    private int backgroundColorActive = 0xffab004d; // Very Dark

    private PImage backgroundImage = null;
    private PImage backgroundImageHover = null;
    private PImage backgroundImageActive = null;

    private PImage icon = null;
    private PImage iconHover = null;
    private PImage iconActive = null;

    int getBackgroundColor() {
        return backgroundColor;
    }

    void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    int getBackgroundColorHover() {
        return backgroundColorHover;
    }

    void setBackgroundColorHover(int backgroundColorHover) {
        this.backgroundColorHover = backgroundColorHover;
    }

    int getBackgroundColorActive() {
        return backgroundColorActive;
    }

    void setBackgroundColorActive(int backgroundColorActive) {
        this.backgroundColorActive = backgroundColorActive;
    }

    PImage getBackgroundImage() {
        return backgroundImage;
    }

    void setBackgroundImage(PImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    PImage getBackgroundImageHover() {
        return backgroundImageHover;
    }

    void setBackgroundImageHover(PImage backgroundImageHover) {
        this.backgroundImageHover = backgroundImageHover;
    }

    PImage getBackgroundImageActive() {
        return backgroundImageActive;
    }

    void setBackgroundImageActive(PImage backgroundImageActive) {
        this.backgroundImageActive = backgroundImageActive;
    }

    PImage getIcon() {
        return icon;
    }

    void setIcon(PImage icon) {
        this.icon = icon;
    }

    PImage getIconHover() {
        return iconHover;
    }

    void setIconHover(PImage iconHover) {
        this.iconHover = iconHover;
    }

    PImage getIconActive() {
        return iconActive;
    }

    void setIconActive(PImage iconActive) {
        this.iconActive = iconActive;
    }
}

