# Hello-World-

Fluent/Modern **JavaFX GUI demo** that exercises the whole pipeline you care about:

> local `git push` → **GitHub Actions** auto-build → download the runnable jar.

A "**Hello World**" accent button pops a modern, gradient-themed dialog. Look and feel
comes from a single stylesheet (`style.css`); the entrance and dialog fades use
JavaFX `FadeTransition` (JavaFX CSS has no web keyframes — see style.css top comment).

## Project layout

```
pom.xml                       Maven build (shaded fat jar, main class = Launcher)
src/main/java/.../Launcher.java   plain entry point (java -jar works)
src/main/java/.../App.java        JavaFX Application (window + modern dialog)
src/main/resources/.../style.css  gradient / shadow / hover theme
.github/workflows/build.yml       GitHub Actions: mvn package + upload artifact
.gitignore                        excludes target/, IDE files
```

## Local run (after installing a JDK 21)

```bash
mvn -q javafx:run
```

Or build a runnable jar and launch it:

```bash
mvn -q clean package
java -jar target/hello-world-1.0.0.jar
```

The shaded jar embeds the JavaFX modules, so a plain `java -jar` works on any JDK 21+.

## What GitHub Actions does (triggered by push)

Every push / pull-request to `main` runs:

1. `actions/setup-java@v4` → Temurin **JDK 21**
2. `mvn -B clean package` → compiles and shades the jar
3. uploads `target/hello-world-1.0.0.jar` as an **artifact**

Watch it live: repo → **Actions** tab → run → **Artifacts**.

> You never re-authenticate for Actions: they use the repository's own `GITHUB_TOKEN`,
> **not** your GCM credentials. The one-time browser grant you did was only so *git push*
> works on this machine.

---
*Boilerplate demo. Change `com.fesio4` and the artifact name when you start real projects.*
