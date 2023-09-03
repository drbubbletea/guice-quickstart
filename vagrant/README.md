These

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

Reload Vagrant after modifying provisioning files.
```
vagrant reload --provision
```

Stopping and removing the VM.
```
vagrant destroy -f
```

Destroy and provision VM.
```
vagrant destroy -f && vagrant up
```


Start provision at specific task
```
provision --start-at-task {task}
```