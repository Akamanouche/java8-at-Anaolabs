package org.anaolabs.java8.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A generic serializer/deserializer
 * 
 * REMEMBER THAT
 * 	serializer : 	JAVA ==> JSON
 * 	deserializer :	JSON ==> JAVA
 */
public class JacksonSerializer {

    ReadWriteFile dataLoader = new ReadWriteFile();

    /**
     * Get a generic list of objects based on data provided in a JSON file
     * 
     * @param mockDataPath the path of JSON data
     * @return a list of object
     */
    @SuppressWarnings({"unchecked"})
    public List<Object> deserialize(String mockDataPath, Class<?> clazz) throws IOException {

        // Get mock data as string
        String mockDataAsStr = dataLoader.readSmallFileAsStr(mockDataPath);

        // Get mock data as object list
        ObjectMapper jacksonMapper = new ObjectMapper();
        jacksonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return jacksonMapper.readValue(mockDataAsStr, jacksonMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
    }

}
