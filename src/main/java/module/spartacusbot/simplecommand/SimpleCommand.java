package module.spartacusbot.simplecommand;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.EventDispatcher;
import sx.blah.discord.modules.IModule;

public class SimpleCommand implements IModule{

	private String moduleName = "SimpleCommand";
	private String moduleVersion = "1.0";
	private String moduleMinimumVersion = "2.3.0";
	private String author = "Author";
	public static IDiscordClient client;
	
	public void disable() {
		
	}

	public boolean enable(IDiscordClient dclient) {
		client = dclient;
		EventDispatcher dispatcher = client.getDispatcher();
		dispatcher.registerListener(new MessageHandler());
		return true;
	}


	public String getAuthor() {
		return author;
	}

	public String getMinimumDiscord4JVersion() {
		return moduleMinimumVersion;
	}

	public String getName() {
		return moduleName;
	}

	public String getVersion() {
		return moduleVersion;
	}

}
