package com.cms.controller.app.goods;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.controller.base.BaseController;
import com.cms.service.erp.goods.GoodsManager;
import com.cms.service.erp.spbrand.SpbrandManager;
import com.cms.service.erp.sptype.SptypeManager;
import com.cms.service.erp.spunit.SpunitManager;
import com.cms.service.information.pictures.PicturesManager;
import com.cms.util.PageData;


/**@author gzj
  * 商品信息-接口类 
  * 相关参数协议：
  * 00	请求失败
  * 01	请求成功
  * 02	返回空值
  * 03	请求协议参数不完整    
  * 04  用户名或密码错误
  * 05  KEY验证失败
 */
@Controller
@RequestMapping(value="/appGoods")
public class AppGoodsController extends BaseController {
    
	@Resource(name="goodsService")
	private GoodsManager goodsService;
	@Resource(name="picturesService")
	private PicturesManager picturesService;
	@Resource(name="spbrandService")
	private SpbrandManager spbrandService;
	@Resource(name="sptypeService")
	private SptypeManager sptypeService;
	@Resource(name="spunitService")
	private SpunitManager spunitService;
	
	 /**商品详情页面
	 * @param
	 * @throws Exception
	 * http://127.0.0.1:8080/CommonManageSystem/appGoods/goods.do?GOODS_ID=284e2238d7fc4bd481c6324fc4c160cf
	 */
	@RequestMapping(value="/goods")
	public ModelAndView goView()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	varList = picturesService.listAll(pd);	//列出Pictures列表
		pd = goodsService.findByIdToCha(pd);					//根据ID读取
		mv.setViewName("erp/goods/goods_app_view");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		return mv;
	}
	

	
}