package com.eagle.dao;


import com.eagle.model.Admaterial;
import com.eagle.model.Sbtest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SbtestMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Sbtest record);

    int insertSelective(Sbtest record);

    Sbtest selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Sbtest record);

    int updateByPrimaryKey(Sbtest record);

    List<Sbtest> selectByShopID(Sbtest st);
    List<Sbtest> selectByS(Integer i,String m);


}