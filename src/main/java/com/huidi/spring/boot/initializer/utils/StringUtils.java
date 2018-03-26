package com.huidi.spring.boot.initializer.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils extends org.springframework.util.StringUtils {
    public static final String SPLIT = "&";

    /**
     * convert questions id list to string to store in database
     * for example
     * {a,b,c,d} .... a list to a&b&c&.....
     *
     * @param questions
     * @return
     */
    public static String list2String(List<String> questions) {
        StringBuilder result = new StringBuilder();

        for (String question : questions)
            result.append(question).append(SPLIT);
        return result.substring(0, result.length() - 1).toString();
    }

    /***
     * convert questions id string to list
     * @param questions
     * @return
     */
    public static List<String> string2List(String questions) {
        List<String> configList = new ArrayList<>();
        if (!StringUtils.isEmpty(questions)) {
            configList = Arrays.asList(questions.split(SPLIT));
        }
        return configList;
    }

    /**
     * 添加一个item
     *
     * @param ids
     * @param id
     * @return
     */
    public static String appendItem(String ids, String id) {
        if (ids == null ||
                StringUtils.isEmpty(id) ||
                ids.indexOf(id) != -1)
            return ids;
        if (ids.contains(id)) {
            return ids;
        }
        //ids为""
        if ("".equals(ids))
            ids = id;
        else if (ids.length() > 0) {
            ids = ids.concat(SPLIT + id);
        }
        return ids;
    }

    /**
     * 删除一个item
     *
     * @param ids
     * @param id
     * @return
     */
    public static String deleteItem(String ids, String id) {
        if (StringUtils.isEmpty(ids) ||
                StringUtils.isEmpty(id) ||
                ids.indexOf(id) == -1)
            return ids;
        int index = ids.indexOf(id);

        if (ids.length() == 1)
            ids = "";
        else if (id.equals(ids.charAt(0) + ""))
            ids = ids.replace(id + SPLIT, "");
        else if ((SPLIT + id).equals(SPLIT + ids.charAt(index)))
            ids = ids.replace(SPLIT + id, "");
        else
            ids = ids.replace(id, "");
        return ids;
    }

    /**
     * 生成items id列表
     *
     * @param ids
     * @return
     */
    public static String items(String... ids) {
        StringBuilder sb = new StringBuilder();
        for (String s : ids)
            sb.append(s).append(SPLIT);
        return sb.substring(0, sb.length() - 1).toString();
    }

    public static String items(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        for (String s : ids)
            sb.append(s).append(SPLIT);
        return sb.substring(0, sb.length() - 1).toString();
    }
}
