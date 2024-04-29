# Guice Quick Start

## About

https://github.com/drbubbletea/guice-quickstart

[MIT Licensed](LICENSE)

## Libraries

### [lib-adapter](./lib-adapter)

### [lib-foundation](./lib-foundation)

### [lib-rest](./lib-rest)

### [lib-vaadin](./lib-vaadin)

# Development

Prepare for deploy.
```
# remove snapshot suffix
mvn versions:set -DremoveSnapshot

# ensure build is successful
mvn clean package

# deploy
mvn clean deploy
```