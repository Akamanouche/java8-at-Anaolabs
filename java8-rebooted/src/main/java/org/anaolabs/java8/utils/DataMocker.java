package org.anaolabs.java8.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic data mocker only for test purposes
 * 
 */
public class DataMocker {

    ReadWriteFile dataLoader;

    /**
     * Get a generic list of objects based on data provided in a JSON file
     * 
     * @param mockDataPath the path of JSON data
     * @return a list of object
     */
    @SuppressWarnings({"unchecked"})
    public List<Object> getMockDataAsObjectList(String mockDataPath, Class<?> clazz) throws IOException {

        // Get mock data as string
        String mockDataAsStr = dataLoader.readSmallFileOneShot(mockDataPath);

        // Get mock data as object list
        ObjectMapper jacksonMapper = new ObjectMapper();
        jacksonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return jacksonMapper.readValue(mockDataAsStr, jacksonMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
    }

}
