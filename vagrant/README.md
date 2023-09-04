# URLs, IPs, & Credentials

Provision the VM.
```
vagrant up
```


Tomcat
* http://192.168.56.10:8080/
* http://192.168.56.10:8080/manager/html
   * `admin/admin`


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
vagrant provision --start-at-task {task}
```


## Useful Development Commands
### Firewalld

List open ports
```
sudo firewall-cmd --list-ports
```