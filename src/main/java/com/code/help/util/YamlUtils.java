package com.code.help.util;

//import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

public class YamlUtils {
    public static Object parse(String filename, String ymlkey) {
//        try {
//            Yaml yaml = new Yaml();
//            URL url = YamlUtils.class.getClassLoader().getResource(filename);
//            if (url != null) {
//                //也可以将值转换为Map
//                Map map = (Map) yaml.load(new FileInputStream(url.getFile()));
//                return map.get(ymlkey);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public static Object dump(String filename, String ymlkey) {
        try {
//            Yaml yaml = new Yaml();
//            URL url = YamlUtils.class.getClassLoader().getResource(filename);
//            if (url != null) {
//                //也可以将值转换为Map
//                Map map = (Map) yaml.load(new FileInputStream(url.getFile()));
//                return map.get(ymlkey);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
