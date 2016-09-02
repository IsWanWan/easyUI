package com.my.service;

import com.my.domain.Admin;

import java.util.List;
import java.util.Map;

/**
 * Created by wanwan on 16/8/26.
 */
public interface AdminService {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);



    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);



    /***
     *  listPage
     */
    List<Admin> listPage(Map map);

    int totalPage(Map map);
}
