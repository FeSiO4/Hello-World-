package com.fesio4.helloworld;

/**
 * Plain main-class entry point (no JavaFX modules on the classpath at startup),
 * so the shaded fat jar can be launched with a vanilla {@code java -jar}.
 */
public final class Launcher {
    public static void main(String[] args) {
        App.main(args);
    }
}
