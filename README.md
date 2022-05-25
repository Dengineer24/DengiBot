# DengiBot
A discord personal Assistance bot, that completes everyday tasks that I have to do in fast, simple, optimized way.
So far, has !shoe, which can scrape the available nike shoes upcoming, and !calendar which utilizes Google Calendar API, and will allow for easy editing and information on what tasks need to be done. Set up for bot is given below.

# To set up Discord Token in ENV 

### For Mac OS Monterey, in terminal (zsh) run:
```
touch ~/.zprofile 
```
then,
```
open ~/.zprofile  
```
edit the file making:
```
export DISC_Token="your Discord token" (No "" added in terminal) 
```
then, run:
```
source ~/.zprofile
```
This should make your env variable be in the zsh profile and work for Java.

### Mac OS errors 
if you run your program and get 
```Java
Exception in thread "main" java.lang.IllegalArgumentException: Token may not be null
```
Then, in the terminal shell where you are attempting to run your bot from run:
```
export DISC_Token="" (no "")
```
and then directly after, staying in the same shell, your bot should be up and running.

### For windows

Directly add DISC_Token directly as an env variable in control panel

# Google Calander Connection 

First in google calander create a new calander and find the calander ID for it, then follow the quickstart guide Java Google Calendar API.
```
add credentials.json to commands folder
```
then to input add your new Calander ID to 
```Java
Events events = service.events().list("add calander ID here"); (line 93)
```
