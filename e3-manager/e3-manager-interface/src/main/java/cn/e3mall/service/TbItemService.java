package cn.e3mall.service;

import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.utills.E3Result;

public interface TbItemService {

    TbItem getItemById(long ItemId);

    //获取商品列表
    EasyUIDataGridResult getItemList(int page,int rows);
    //添加商品
    E3Result addItem(TbItem tbItem,String desc);
}
