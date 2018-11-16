package cn.e3mall.controller;

import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private TbItemService tbItemService;

    //{ItemId}是一个模版映射，可以从url中取出数据
    @RequestMapping("/item/{ItemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long ItemId){

        TbItem tbItem = tbItemService.getItemById(ItemId);
        return tbItem;
    }

    //注解ResponseBody表示返回json数据
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){

        //调用服务查询商品列表
        EasyUIDataGridResult result = tbItemService.getItemList(page, rows);

        return result;
    }
}
