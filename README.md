# git/github test
This repository is here to learn and test the connection between a local git repository and my online github repository.

There is a similar project at home. This one is from work. (worktest)

2021-09-24 08:15

## Installation
### Install curl 
```
sudo apt install curl
```

### Install GitHub CLI for authentication management
```
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-key C99B11DEB97541F0
sudo apt-add-repository https://cli.github.com/packages
sudo apt update
sudo apt install gh
```

### Connect GitHub CLI to online GitHub
```
gh auth login
```
When prompted for your preferred protocol, select `HTTPS`.  
When asked if you would like to authenticate to Git with your GitHub credentials, enter `Y`.

## Add Remote Repository
```
echo "# [repository name]" >> READMEmd
git init
git add README.md   (or git add .)
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/n7tms/[repository name].git
git push -u origin main
```

## Update Files
```
git add .    (or a specific file to add or update)
git commit -m "[description]"
git push -u origin main
```


