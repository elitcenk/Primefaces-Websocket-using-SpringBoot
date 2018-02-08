package tr.com.elitcenk.primefaces.service;

import org.primefaces.push.EventBus;
import org.primefaces.push.RemoteEndpoint;
import org.primefaces.push.annotation.OnClose;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.OnOpen;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.elitcenk.primefaces.model.Message;
import tr.com.elitcenk.primefaces.model.MessageDecoder;
import tr.com.elitcenk.primefaces.model.MessageEncoder;

/**
 * Created by calp on 6.02.2018.
 */
@PushEndpoint ("/{room}/{user}")
public class ChatResource{

	@Autowired
	private ChatUsers chatUsers;

	public ChatResource() {
		System.out.println("Yaratıldı.  !!!!!!!!!!!!!!!!!!!!!");
	}

	private final Logger logger = LoggerFactory.getLogger(ChatResource.class);

	@PathParam ("room")
	private String room;

	@PathParam ("user")
	private String username;

	@OnOpen
	public void onOpen(RemoteEndpoint r, EventBus eventBus) {
		logger.info("OnOpen {}", r);

		eventBus.publish(room + "/*", new Message(String.format("%s has entered the room '%s'", username, room), true));
	}

	@OnClose
	public void onClose(RemoteEndpoint r, EventBus eventBus) {
		chatUsers.remove(username);

		eventBus.publish(room + "/*", new Message(String.format("%s has left the room", username), true));
	}

	@OnMessage (decoders = {MessageDecoder.class}, encoders = {MessageEncoder.class})
	public Message onMessage(Message message) {
		return message;
	}

}
