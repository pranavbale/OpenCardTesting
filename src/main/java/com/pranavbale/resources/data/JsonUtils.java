package com.pranavbale.resources.data;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();

    public static Object[][] readJson(String filename) throws Exception {
        Path path = Paths.get("src/main/java/com/pranavbale/resources/data/" + filename);
        String json = Files.readString(path);

        JsonNode nodes =  mapper.readTree(json);

        Object[][] data = new Object[nodes.size()][1];

        int index = 0;
        for (JsonNode node : nodes) {
            data[index++][0] = node;   // each row contains a JsonNode object
        }

        return data;
    }
}
