package org.example.fogbeam.xmpp;

import org.alicebot.ab.Bot;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;

public class MyNewMessageListener implements ChatMessageListener 
{

	private org.alicebot.ab.Chat chatSession;
	
	public MyNewMessageListener()
	{
		String botname="mybot";
		String path=".";
		Bot bot = new Bot(botname, path);
		
		
		chatSession = new org.alicebot.ab.Chat(bot);
	}
	
	
	@Override
	public void processMessage( Chat chat, Message msg ) 
	{
		
		if( msg == null )
		{
			return;
		}
		
		String msgBody = msg.getBody();
		
		System.out.println( "received incoming message: " + msgBody );
		
		try
		{
			if( msgBody != null && !msgBody.isEmpty())
			{				
				String response = chatSession.multisentenceRespond(msgBody);
				System.out.println("RESPONSE: " + response);
			
				// A little pause here, it's creepy if the bot responds too fast.
				Thread.sleep( 1250 );
				
				chat.sendMessage( response );				
			}
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		

	}
}