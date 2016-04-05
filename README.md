# Discord4J Module tutorial
Module Example for Discord4J Java API

First you start by creating a new maven or gradle project and adding the [Discord4J](http://austinv11.github.io/Discord4J/) depency.

You start with creating a new class and implementing IModule
```Java
public class SimpleCommand implements IModule{
}
```

It gives an error, you will need to add some functions to the class.
```Java
    public void disable() {
		
	}
	public boolean enable(IDiscordClient dclient) {
		return false;
	}
	public String getAuthor() {
		return null;
	}
	public String getMinimumDiscord4JVersion() {
		return null;
	}
	public String getName() {
		return null;
	}
	public String getVersion() {
		return null;
	}
```

When starting the bot it will load the module once installed and the functions will return null which results in Nullpointer exceptions.
So be sure to replace the ```null``` with strings. You can see how I did it in the [SimpleCommand.java](https://github.com/Martacus/Simplecommands/blob/master/src/main/java/module/spartacusbot/simplecommand/SimpleCommand.java).

Now we can work with the IDiscordClient that has been passed with the enable() method. Making a public and static IDiscordClient will be usefull when using more classes in one module.
Anything you would do in the main function of your original bot would go in the enable method. Here is an example of adding a Event Listener:

```Java	
    public static IDiscordClient client;
    
    public boolean enable(IDiscordClient dclient) {
		client = dclient;
		EventDispatcher dispatcher = client.getDispatcher();
		dispatcher.registerListener(new MessageHandler());
		return true;
	}
```

Just like that! There you have it, your very own module!

#Installing the module
Once you finished the code it is time to install the module to the bot you are using. Be aware this bot needs to be made with the Discord4J API or it will most certainly break.

To do that you need the project in a jar format. Go to the root directory of your project and run ```mvn clean package```. You will then find the jar file in the target folder. Copy the jar file and go to the directory of your bot. You should see the module folder there. Paste the jar file in there and all should be good!
