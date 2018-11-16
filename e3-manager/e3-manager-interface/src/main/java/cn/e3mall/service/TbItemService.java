package cn.e3mall.service;

import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;

public interface TbItemService {

    TbItem getItemById(long ItemId);

    EasyUIDataGridResult getItemList(int page,int rows);
}
