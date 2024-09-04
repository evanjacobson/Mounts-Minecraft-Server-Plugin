# Mounts
Horse mounts plugin for the Spigot/Paper Minecraft servers. Designed and written by Evan Jacobson.

## Building the jar file
`gradle build`

## Using a mount
Mounts can be set on any item.
The naming pattern of mount items is either "<user>'s Horse Mount" in gold, or "Unowned Horse Mount" in green.
More info on mount ownership in the /mount command explanation.

Attributes associated with a mount will be listed in red as meta text below the item name.

If you are in possession of a mount, you can right-click anywhere to spawn your mounted horse.
The horse will be tamed, saddled, and will have whatever effects the mount item listed out.
See permissions section for more details.


## Commands
### /mount [owner]
Sets the currently held item to a mount spawn egg.
If no item is held you will be given a horse spawn egg.
The user field is optional, enter any username to set the horse's owner as that horse.
If left blank, the mount will be unowned.
Users cannot ride each other's mount horses but anyone can ride an unowned mount horse.

### /mountedit \<attribute> \<value>
Only works while holding a mount item. Attributes can be tab completed and are self-explanatory.
The value can be set to any double (essentially decimal) value.
You can also specify "unset" for the value field to remove an attribute.

## Permissions
### mounts.admin
default: OP
use: /mount, /mountedit, ride any mount regardless of ownership

### mounts.spawn
default: OP
use: right-click a mount to spawn a mount horse. This permission is intended for normal users

### mounts.spawn.reuse
default: OP
use: do not lose your mount once you spawn the horse. This is mainly intended for use by staff during events.