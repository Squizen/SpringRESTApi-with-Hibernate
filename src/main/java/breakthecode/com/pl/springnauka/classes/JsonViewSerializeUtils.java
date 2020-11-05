package breakthecode.com.pl.springnauka.classes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonViewSerializeUtils {

	  public static String serializeObjectToString(Object object, Class<?> serializationView) throws JsonProcessingException{
	      ObjectMapper mapper = new ObjectMapper();
	      mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
	      String result = mapper.writerWithView(serializationView).writeValueAsString(object);
	      return result;
	  }

	  public static Object deserializeStringToObject(String jsonString, Class<?> view, Class<?> valueType) throws JsonProcessingException, IOException {
		  ObjectMapper mapper = new ObjectMapper();
		  Object object = mapper.readerWithView(view).forType(valueType).readValue(jsonString);
		  return object;
	  }
	}
