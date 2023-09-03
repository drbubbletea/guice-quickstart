# Examples

## Creating New Examples

Run the following

```
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DgroupId=net.timeboxing -Dversion=1.0-SNAPSHOT
```

# Get Started
The following was testing on AlmaLinux 9.2

## Tools
VirtualBox - 7.0.10
Vagrant - 2.3.7

## Get Started

Start & provision the VM.
```
cd examples
vagrant up
```

Stopping and removing the VM.
```
vagrant destroy -f
```