package com.cloudtp.learnrxjava.constant;

import java.io.Serializable;

/**
 * Created by cloudtp on 2016/8/24.
 */
public class Constant {
    public enum NewsType implements Serializable {

        ALL("all"),      //所有
        CREATING("creating"),          //新建
        TRANSFORM("transform"),     //变化
        FILTER("filter"),        //过滤
        COMBINING("combining");//结合

        String type;

        NewsType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
