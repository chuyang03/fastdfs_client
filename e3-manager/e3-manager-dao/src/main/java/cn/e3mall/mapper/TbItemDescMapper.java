package cn.e3mall.mapper;

import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemDescMapper {
    int countByExample(TbItemDescExample example);

    int deleteByExample(TbItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);

    List<TbItemDesc> selectByExample(TbItemDescExample example);

    TbItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    int updateByPrimaryKeySelective(TbItemDesc record);

    int updateByPrimaryKey(TbItemDesc record);
}