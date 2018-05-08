package com.onion.pojo;

import java.util.List;

/**
 * Created by zhangqi on 2016/10/20.
 */

public class City {


    /**
     * code : 200
     * data : [{"id":1,"child":[{"id":2,"name":"北京市","pid":1,"pinyin":"beijingshi"}],"name":"北京"},{"id":102,"child":[{"id":103,"name":"石家庄","pid":102,"pinyin":"shijiazhuang"},{"id":128,"name":"唐山","pid":102,"pinyin":"tangshan"},{"id":144,"name":"秦皇岛","pid":102,"pinyin":"qinhuangdao"}],"name":"河北省"}]
     * info : 成功
     */

    private String code;
    private String info;
    private List<DataBean> data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * id : 1
         * child : [{"id":2,"name":"北京市","pid":1,"pinyin":"beijingshi"}]
         * name : 北京
         */

        private int id;
        private String name;
        private List<ChildBean> child;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public static class ChildBean {
            /**
             * id : 2
             * name : 北京市
             * pid : 1
             * pinyin : beijingshi
             */

            private int id;
            private String name;
            private int pid;
            private String pinyin;

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public int getPid() {
                return pid;
            }

            public String getPinyin() {
                return pinyin;
            }
        }
    }
}
