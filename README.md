hAutoCommand is a lightweight Spigot plugin that runs a configurable list of commands as the console at a repeating interval.

Set the interval in seconds, add the commands you want to run, and hAutoCommand will execute each command on the schedule.

Features
Runs configured commands as the console
Uses one repeating interval for the command list
Interval is configurable in seconds
Supports multiple commands


Config.yml:
```
enabled: true

# Time to second
time: 30

prefix: '&8[&chAutoCommand&8] '

commands:
    - 'say Hello World!'
    - 'tellraw @a {"text":"Hellow World!!","color":"gold"}'
```

## Permissions
**hautocommand.admin** - Allows reloading the config - Default: OP


