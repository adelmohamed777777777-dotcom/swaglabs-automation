package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class DataDriven {

    private static final String JSON_PATH = "testData/testData.json";
    private static JsonNode root;


    public static JsonNode jsonReader() {
        if (root == null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                root = mapper.readTree(new File(JSON_PATH));
            } catch (IOException e) {
                throw new RuntimeException("Failed to read " + JSON_PATH + ": " + e.getMessage(), e);
            }
        }
        return root;
    }
}
