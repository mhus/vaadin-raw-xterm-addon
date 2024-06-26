
#Development

## Resources
Git of xterm:

https://github.com/xtermjs/xterm.js

Current available versions:

https://registry.npmjs.org/xterm
https://registry.npmjs.org/xterm-addon-fit

Possible ESC Codes and Actions:

https://github.com/xtermjs/xterm.js/blob/master/src/common/InputHandler.ts

## Execute

Clean:
```bash
mvn clean vaadin:clean-frontend
```
Run withh new frontend:
```bash
mvn vaadin:build-frontend jetty:run
```
Run:
```bash
mvn jetty:run
```
