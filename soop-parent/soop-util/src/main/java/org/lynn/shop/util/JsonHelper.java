package org.lynn.soop.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/8/15
 * Time         : 5:48 PM
 * Description  : json序列化，反序列化
 */
public class JsonHelper {
    private static final Logger log = LoggerFactory.getLogger(JsonHelper.class);

    private JsonHelper() {
        // utility method, private constructor.
    }

    public static String toGson(final Object value) {
        return new Gson().toJson(value);
    }

    public static String toJSON(final Object value) {

        return toGson(value);
    }

    public static String toJSONWithNull(final Object value) {
        Gson g = new GsonBuilder().serializeNulls().create();
        return g.toJson(value);

    }

    public static String toJSON1(final Object value) {

        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        String serializedValue = "";

        try {
            serializedValue = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Could not write out object of type " + value.getClass().getSimpleName(), e);
        }

        return serializedValue;
    }

    public static <T> T fromJSON(final String jsonString, final Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

        T toReturn = null;

        try {
            toReturn = objectMapper.readValue(jsonString, type);
        } catch (IOException e) {
            log.error("Could not read string for type " + type.getSimpleName(), e);
        }

        return toReturn;
    }

    public static <T> T fromJSON(final String jsonString, final TypeReference<T> typeReference) {

        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

        T toReturn = null;
        try {
            toReturn = objectMapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            log.error("Could not read string for type " + typeReference.getType(), e);
        }

        return toReturn;
    }
}
