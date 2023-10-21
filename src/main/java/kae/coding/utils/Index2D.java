package kae.coding.utils;

public record Index2D(int r, int c) {
    public static int flatten(int r, int c, int width) {
        return r * width + c;
    }
}
