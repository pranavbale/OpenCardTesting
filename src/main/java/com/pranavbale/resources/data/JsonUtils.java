package com.pranavbale.resources.data;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();


    public static List<Map<String, String>> readJsonArray(String filename) throws Exception {
        Path path = Paths.get("src/main/java/com/pranavbale/resources/data/" + filename);
        String json = Files.readString(path);
        return mapper.readValue(json, new TypeReference<List<Map<String, String>>>() {});
    }

    public static void main(String[] args) throws Exception {
        List<Map<String, String>> data =  readJsonArray("Users.json");
        String name = data.get(0).get("email");
        System.out.println(name);
    }
}
