package com.eagle.controller;

import com.eagle.dao.AdmaterialMapper;
import com.eagle.dao.SbtestMapper;
import com.eagle.dto.ReturnMessage;
import com.eagle.model.Admaterial;
import com.eagle.model.Sbtest;
import com.eagle.utils.AppVersUtil;
import com.eagle.utils.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/6.
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    @Resource
    private AdmaterialMapper admaterialMapper;
    @Resource
    private SbtestMapper sbtest;

    private static Logger logger = LogManager.getLogger();
    //跟新副屏图片
    @RequestMapping(value = "/imageadlist")
    @ResponseBody
    public ReturnMessage imageadlist(HttpServletRequest request) {
        ReturnMessage message = new ReturnMessage();
        String appVer = AppVersUtil.getHeader(request,"appver");
        double appVerson;
            if (appVer.equals("")){
                message.setFail_code("1002");
                message.setFail_msg("没有版本号!");
                return message;
            }else{
                appVerson =  Double.parseDouble(appVer);
            }
        Long shopID =  Long.parseLong(request.getParameter("ShopID"));
            List<Admaterial> admaterialList = admaterialMapper.selectByShopID(shopID);
            List<Map> admaterialMap =  new ArrayList<Map>();
            Map<String,String> map = new HashMap<String, String>();
        for (Admaterial admaterial:admaterialList) {
            if (appVerson >= 1.9){
                String  materialurl= admaterial.getMaterialurl();
                map.put("AdType",""+admaterial.getAdtype());
                map.put("MaterialUrl",""+getShowUrl(materialurl,request));
                admaterialMap.add(map);
            }else{
                String  materialurl= admaterial.getMaterialurl();
                map.put("MaterialUrl",""+getShowUrl(materialurl,request));
                admaterialMap.add(map);
            }
        }
        message.setStatus("ok");
        String admaterialJsonList  =  JsonUtils.toJson(admaterialMap);
        message.setCookmethod(admaterialJsonList);
        return message;
    }

    @RequestMapping(value = "/tt",produces = "application/xml" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Sbtest> tt(HttpServletRequest request){
        //Long shopID=Long.parseLong(request.getParameter("ShopID"));
        //Long s=Long.parseLong("10004");
        //System.out.println(request.getParameter("name"));
        //List<Admaterial> admaterialList = admaterialMapper.selectByShopID(s);
        //Admaterial a=admaterialMapper.selectByPrimaryKey(new Long(32));
        Integer i=1;
        Sbtest sb=sbtest.selectByPrimaryKey(i);//查询


        Sbtest lzq0=new Sbtest();
        lzq0.setAge(2);
        lzq0.setUsername("lzq");
        List<Sbtest> sb2=  sbtest.selectByShopID(lzq0);
        List<Sbtest> sb3=sbtest.selectByS(2,"lzq");

        Sbtest lzq=new Sbtest();
        lzq.setUsername("lzq2");
        lzq.setAddress("nanj");
        lzq.setPrice(new BigDecimal(1.1));
        lzq.setAge(2);
        //lzq.setId(2);
        //sbtest.insert(lzq);//增加
        Sbtest lzq2=new Sbtest();
        lzq2.setId(6);
        lzq2.setUsername("helllo");
        int j=sbtest.updateByPrimaryKeySelective(lzq2); //更新
        System.out.println(j);
        int m=sbtest.deleteByPrimaryKey(6);//删除
        System.out.println(m);

        return sb3;
    }
    //图片展示URL(虚拟路劲转绝对路径)
    public String getShowUrl(String url,HttpServletRequest request){
        if(StringUtils.isNotBlank(url)){
            return "http://" + "localhost" + ":" + request.getServerPort() + request.getContextPath() + "/" + url;
        }else{
            return "";
        }
    }
}
