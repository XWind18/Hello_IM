package hello.client.clientcore;

import java.util.HashMap;
import java.util.Map;

public class ChatMap {
	private static Map<String , Object> chatMap = new HashMap<String , Object> ();

	public static Object getChatMap(String id){

		return chatMap.get(id);
	}
	public static void addChatMap(String id, Object ClientTest){
		chatMap.put(id,ClientTest);
	}
}
