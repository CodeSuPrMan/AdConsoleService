package com.vcgo.Common.Globle;

import com.vcgo.Entity.TreeEntity;
import com.vcgo.Entity.VcSysPoweritem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 33469 on 2017/2/1.
 */

/***
 * 通用工具类
 */
public class Utils {
    /**
     * 填充树模型
     * @param treeList 原始列表数据
     * @param <T> 继承自树实体的类型
     * @return 填充完毕的树模型
     */
        public static <T extends TreeEntity> List<T> fillTreeEntity(List<T> treeList){
            List<T> resultTree=new LinkedList<T>();
            for (T e:treeList
                 ) {
                if(e.getParentid().equals(0)){
                    resultTree.add(fillChilds(e,treeList));
                }
            }
            return  resultTree;
        }
        private static <T extends TreeEntity> T fillChilds(T m, List<T> listall){
            List<T> VCP=null;
            for (T v:listall) {
                if(v.getParentid().equals(m.getId())){
                    VCP=VCP==null?new LinkedList<T>():VCP;
                    VCP.add(fillChilds(v,listall));
                }
            }
            if(VCP!=null){
                m.setChildren(VCP);
            }
            return  m;
        }


}
