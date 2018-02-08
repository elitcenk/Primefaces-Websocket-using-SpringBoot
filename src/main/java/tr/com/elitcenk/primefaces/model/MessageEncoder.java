package tr.com.elitcenk.primefaces.model;

/**
 * Created by calp on 6.02.2018.
 */
import org.primefaces.json.JSONObject;
import org.primefaces.push.Encoder;

import tr.com.elitcenk.primefaces.model.Message;

/**
 * A Simple {@link org.primefaces.push.Encoder} that decode a {@link Message} into a simple JSON object.
 */
public final class MessageEncoder implements Encoder<Message, String> {

	//@Override
	public String encode(Message message) {
		return new JSONObject(message).toString();
	}

}
