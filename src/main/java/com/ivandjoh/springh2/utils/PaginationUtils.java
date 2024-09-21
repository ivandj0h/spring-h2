package com.ivandjoh.springh2.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PaginationUtils {

    // Helper method for pagination
    public static List<Map<String, Object>> paginate(Map<String, Object>[] data, int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, data.length);

        if (start > data.length) {
            return new ArrayList<>(); // Return empty list if page is out of range
        }

        return Arrays.asList(Arrays.copyOfRange(data, start, end));
    }
}