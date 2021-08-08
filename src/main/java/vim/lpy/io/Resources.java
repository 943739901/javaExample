package vim.lpy.io;

import java.io.InputStream;

/**
 * @author lipengyu
 * 获取资源类
 */
public class Resources {

    /**
     * 根据文件路径获取流
     *
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}