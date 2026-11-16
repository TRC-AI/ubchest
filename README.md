# Always Open Chests

In vanilla Minecraft a chest refuses to open when a solid block sits directly on top of it, or
when a cat is sitting on its lid. Always Open Chests removes those restrictions, so you can build
compact, hidden or tightly packed storage without leaving air above every chest.

It works on normal and trapped chests, single and double. Ender chests, barrels and shulker boxes
are not affected, because vanilla never blocked them.

## Copper golems

Copper golems check the same rule when they sort items into chests. By default they follow your
settings, so they can reach every chest you can open. If you prefer, they can keep vanilla's rules
instead and skip chests with a block or a sitting cat on top.

## Settings

In the TRC settings screen (press **U**, or the TRC button in the main menu) under
**Unblocked Chests**, or with `/trc`. The setting names are available in English, German and
Pirate Speak.

| Setting                          | Id                       | Default  | Effect                                                                               |
|----------------------------------|--------------------------|----------|--------------------------------------------------------------------------------------|
| Open chests through solid blocks | `ignore_block_above`     | off      | A solid block on top no longer stops a chest from opening                            |
| Open chests under sitting cats   | `ignore_sitting_cats`    | on       | A sitting cat no longer stops a chest from opening                                   |
| Apply to copper golems           | `apply_to_copper_golems` | on       | The two settings above also apply to copper golems. Off: golems keep vanilla's rules |

With the first two settings off, chests behave exactly like vanilla. All settings are server
settings and take effect immediately, without reloading the world.

Example: `/trc ubchest ignore_block_above true`

## Requirements

- [Fabric API](https://modrinth.com/mod/fabric-api)
- [TRC Core & Libs](https://modrinth.com/mod/trc-core) 1.2 or newer
- Java 25

There is one file per Minecraft version. Install the mod on the server, or in your game for
singleplayer. Players joining a server do not need it.

## License

MIT, see [LICENSE](LICENSE).