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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

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

    @RequestMapping(value = "/tt2",produces = "application/xml" ,method = RequestMethod.POST)
    @ResponseBody
    public List<Sbtest> tt2(HttpServletRequest request) throws IOException {
        //Long shopID=Long.parseLong(request.getParameter("ShopID"));
        //Long s=Long.parseLong("10004");
        //System.out.println(request.getParameter("name"));
        //List<Admaterial> admaterialList = admaterialMapper.selectByShopID(s);
        //Admaterial a=admaterialMapper.selectByPrimaryKey(new Long(32));

        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String paramName = (String)headerNames.nextElement();

            String paramValue = request.getHeader(paramName);
            System.out.println(paramName+":"+paramValue );
        }

        BufferedReader reader = request.getReader();
        String input = null;
        String requestBody = "";
        while((input = reader.readLine()) != null){
            requestBody = requestBody + input ;
        }

        System.out.println(requestBody);
        System.out.println("dfsfsdfsdfsdf");

        /*Map map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    System.out.println("参数：" + paramName + "=" + paramValue);
                    map.put(paramName, paramValue);
                }
            }else{
                System.out.println(StringUtils.join(paramValues,","));//有复选框的时候表单name=check php为name=check[]这点不一样
            }
        }*/
        List<Sbtest> sb3=sbtest.selectByS(2,"lzq");
        return sb3;
    }

    @RequestMapping(value = "/tt3" ,method = RequestMethod.GET)
    public String tt3(HttpServletRequest request) throws IOException {
        request.setAttribute("test","hallo");
        return "upload";
    }

    @RequestMapping(value = "/dott3",produces = "application/xml" ,method = RequestMethod.POST)
    @ResponseBody
    public void dott3(@RequestParam("file") CommonsMultipartFile cm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("filename:---->"+cm.getOriginalFilename());
        if(!cm.isEmpty()){
            FileOutputStream os =new FileOutputStream("./lia.jpg");
            FileInputStream in= (FileInputStream) cm.getInputStream();
            int b=0;
            while ((b=in.read())!=-1){
                os.write(b);
            }
            os.flush();
            os.close();
            in.close();

            response.setCharacterEncoding("utf-8");
            response.getWriter().write("菜鸟教程：http://www.runoob.com");
        }
    }


    @RequestMapping(value = "/dott32",produces = "application/xml" ,method = RequestMethod.POST)
    @ResponseBody
    public void dott32(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommonsMultipartResolver cr=new CommonsMultipartResolver(request.getSession().getServletContext());
        if(cr.isMultipart(request)){
            MultipartHttpServletRequest mr=(MultipartHttpServletRequest)request;
            Iterator<String> iter=mr.getFileNames();
            while (iter.hasNext()){
                MultipartFile file=mr.getFile((String) iter.next());
                System.out.println(request.getSession().getServletContext().getRealPath("/"));//一般不存在tomacat目录要不然重启一次服务器图片就消失了
                System.out.println("dsfsdfsdfdsfsdf");
                String fileName=request.getSession().getServletContext().getRealPath("/")+"/upload/"+file.getOriginalFilename();
                File localfile=new File(fileName);
                file.transferTo(localfile);//这里存文件
            }
        }
         response.setCharacterEncoding("utf-8");
         response.getWriter().write("菜鸟教程：http://www.runoob.com");

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
