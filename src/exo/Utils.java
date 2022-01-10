package exo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	
	public String toString(Object classObject) {
		List<Field> fields = Arrays.asList(classObject.getClass().getDeclaredFields());
		Map<String, String> map = new HashMap<String, String>();
		
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(classObject).toString());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "La classe de cette instance est " + classObject.getClass().getSimpleName() + "." + " Ses attributs sont => " + map.toString();
	}
}
