package hello.client.clientcore;

import java.util.HashMap;
import java.util.Map;

public class ThreadMap {
	private static Map<String , Object> ThreadMap = new HashMap<String , Object> ();
	
	public static Object getThreadMap(String id){

		return ThreadMap.get(id);
	}
	public static void addThreadMap(String id, Object ClientTest){
		ThreadMap.put(id,ClientTest);
	}
}
