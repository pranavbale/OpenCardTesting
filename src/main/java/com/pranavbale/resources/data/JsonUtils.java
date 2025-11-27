package com.pranavbale.resources.data;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();

//    public static List<Map<String, String>> readJsonArray(String resourceName) throws Exception {
//        // Use package-relative lookup: "Users.json" (no leading slash)
//        try (InputStream is = JsonUtils.class.getResourceAsStream(resourceName)) {
//            if (is == null) {
//                // helpful error message showing what was attempted
//                String pkgPath = JsonUtils.class.getPackage().getName().replace('.', '/');
//            }
//            return mapper.readValue(is, new TypeReference<List<Map<String, String>>>() {});
//        }
//    }

    public static List<Map<String, String>> readJsonArray(String resourceName) throws Exception {
        try (InputStream is = JsonUtils.class.getResourceAsStream("/" + resourceName)) {
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + resourceName);
            }

            return mapper.readValue(is, new TypeReference<List<Map<String, String>>>() {});
        }
    }

    public static void main(String[] args) throws Exception {
        List<Map<String, String>> data =  readJsonArray("/Users.json");
        String name = data.getFirst().get("firstName");
        System.out.println(name);
    }
}
