package cn.e3mall.service.impl;

import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.TbItemService;
import cn.e3mall.utills.E3Result;
import cn.e3mall.utills.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getItemById(long ItemId) {

        TbItem tbItem = tbItemMapper.selectByPrimaryKey(ItemId);
/**
        TbItemExample example = new TbItemExample();
        //设置查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(ItemId);

        //执行查询
        List<TbItem> list = tbItemMapper.selectByExample(example);

        if (list!=null&&list.size()>0){

            return list.get(0);
        }

        return null;
 */

        return tbItem;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {

        //设置分页信息
        PageHelper.startPage(page,rows);

        //设置查询条件
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);

        //显示分页结果
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);

        //创建返回结果对象
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);

        return result;
    }

    @Override
    public E3Result addItem(TbItem tbItem, String desc) {

        //生成商品id
        long id = IDUtils.genItemId();

        //补全商品表信息
        tbItem.setId(id);
        //1-正常，2-下架，3-删除
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        //插入商品表
        tbItemMapper.insert(tbItem);

        //创建商品描述表
        TbItemDesc itemDesc = new TbItemDesc();
        //补全商品描述表信息
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //插入商品表描述信息
        tbItemDescMapper.insert(itemDesc);

        return E3Result.ok();
    }


}
