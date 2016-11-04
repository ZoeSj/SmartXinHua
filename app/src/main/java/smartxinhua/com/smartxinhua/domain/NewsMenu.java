package smartxinhua.com.smartxinhua.domain;

import java.util.ArrayList;

/**
 * 分类信息的对象封装,照着json写
 *使用Gson解析是对象书写技巧
 * 遇到大括号就是一个对象,遇到中括号就是一个集合ArrayList
 * 所有字段的名称要和json返回字段的名称高度一致
 * Created by Zoe on 2016/11/4.
 */
public class NewsMenu {
    public int retcode;

    public ArrayList<Integer> extend;

    public ArrayList<NewsMenuData> data;
    //侧边栏菜单的对象
    public class NewsMenuData
    {
        public int id;
        public String title;
        public int type;
        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData{" +
                    "title='" + title + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
    //标签的对象
    public class NewsTabData{
        public int id;
        public String title;
        public int type;
        public String url;

        @Override
        public String toString() {
            return "NewsTabData{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsMenu{" +
                "data=" + data +
                '}';
    }
}
