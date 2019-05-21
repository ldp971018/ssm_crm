package com.ldp.ssm.dao;

import com.ldp.ssm.bean.Visit;
import com.ldp.ssm.bean.VisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitMapper {
    int countByExample(VisitExample example);

    int deleteByExample(VisitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Visit record);

    int insertSelective(Visit record);

    List<Visit> selectByExample(VisitExample example);

    Visit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByExample(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}