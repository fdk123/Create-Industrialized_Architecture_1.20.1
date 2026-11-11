# Create: Industrialized Architecture for Minecraft 1.20.1

Forge port of the 1.21.1 NeoForge source in this repository. The mod keeps the `i_architecture` ID and the original block, item, and texture names.

## Build

Use Java 17 and run:

```sh
./gradlew build
```

The release JAR is written to `build/libs/i_architecture-1.20.1-0.1.1.jar`.

This project targets Forge 47.3.0, Create 6.0.8, Ponder 1.0.91, Flywheel 1.0.5, and Registrate MC1.20-1.3.3. The versioned Create development artifact is `6.0.8-289`. Generated 1.20.1 blockstates, models, tags, loot tables, recipes, and advancements are included in `src/generated/resources`.

## Verification

`compileJava`, `runData`, and `build` pass with Create 6.0.8. The datagen run loads Create and generates 255 recipe JSON files and 164 blockstate JSON files. A full in-game client check has not been performed.
