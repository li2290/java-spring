package com.eagle.controller;


import com.eagle.dto.ReturnMessage;
import com.eagle.model.Admaterial;
import com.eagle.model.Sbtest;
import com.eagle.trade.wx.common.XMLParser;
import com.eagle.utils.DateTimeUtil;
import com.eagle.utils.json.JsonUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.sql.DriverManager.println;

/**
 * Created by Xiekang on 2017/4/27.
 */
public class test {




    public static void main(String[] args) throws IOException {


        //发送 GET 请求
        //String s=Httptest.sendGet("http://localhost:8080/ad/tt2", "key=123&v=456");
        //System.out.println(s);

        //发送 POST 请求
        //String sr=Httptest.sendPost("http://localhost:8080/ad/tt2", "key=123&v=456");
        String sr=Httptest.sendPost("http://localhost:8080/ad/tt2", "{\n" +
                "\"name\":\"lzq\",\n" +
                "\"age\":\"18\"\n" +
                "}");
        System.out.println(sr);

        /*
        生产json数据的操作
        ReturnMessage message = new ReturnMessage();
        List<Sbtest> admaterialList = new ArrayList<>();
        for(int i=0;i<3;i++){
            Sbtest temp=new Sbtest();
            temp.setUsername("lzq");
            temp.setAge(2);
            temp.setId(i);
            temp.setPrice(BigDecimal.valueOf(1.2));
            temp.setAddress("武汉");
            admaterialList.add(temp);
        }
        System.out.println(JsonUtils.toJson(admaterialList));
        List<Map> admaterialMap =  new ArrayList<Map>();
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg","sucesss");
        map.put("status","01");
        map.put("date",JsonUtils.toJson(admaterialList));
        System.out.println(JsonUtils.toJson(map));*/







       /* Map resultMap = new HashMap();
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>\n" +
                "\t<name>liao</name>\n" +
                "\t<age>18</age>\n" +
                "\t<school>w3c school</school>\n" +
                "  </body>\n" +
                "</note>";


        try {
            Map<String, Object> map = XMLParser.getMapFromXML(s);
            System.out.println(map.get("name"));
            System.exit(0);
            if (map.get("status") != null && map.get("result_code") != null) {
                if (map.get("status").toString().equals("0") && map.get("result_code").toString().equals("0")) {
                    resultMap.put("trade_state", map.get("trade_state").toString());
                    if ("success".equals(map.get("trade_state").toString())) {
                        resultMap.put("total_fee", map.get("total_fee").toString());
                        resultMap.put("trade_state", map.get("trade_state").toString());
                    }
                }
            }
            if (resultMap != null && resultMap.get("trade_state") != null) {
                if ("SUCCESS".equalsIgnoreCase(resultMap.get("trade_state").toString())) {

                } else if ("USERPAYING".equalsIgnoreCase(resultMap.get("trade_state").toString())) {

                } else {

                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,31);
        date = calendar.getTime();
        System.out.print("时间:"+ DateTimeUtil.getyyyymmddhhmmssStr(date));

        */

       /*
       解析获取json字符串
       String s = "{\"error_code\":0,\"reason\":\"SUCCESSED!\",\"result\":{\"totalCount\":\"1251\",\"page\":\"1\",\"num\":\"20\",\"data\":[{\"symbol\":\"sh600000\",\"name\":\"浦发银行\",\"trade\":\"15.000\",\"pricechange\":\"-0.020\",\"changepercent\":\"-0.133\",\"buy\":\"14.990\",\"sell\":\"15.000\",\"settlement\":\"15.020\",\"open\":\"15.020\",\"high\":\"15.060\",\"low\":\"14.930\",\"volume\":278625,\"amount\":417686613,\"code\":\"600000\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600004\",\"name\":\"白云机场\",\"trade\":\"16.940\",\"pricechange\":\"0.000\",\"changepercent\":\"0.000\",\"buy\":\"16.940\",\"sell\":\"16.950\",\"settlement\":\"16.940\",\"open\":\"16.920\",\"high\":\"16.990\",\"low\":\"16.660\",\"volume\":173871,\"amount\":293150037,\"code\":\"600004\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600006\",\"name\":\"东风汽车\",\"trade\":\"5.780\",\"pricechange\":\"-0.030\",\"changepercent\":\"-0.516\",\"buy\":\"5.780\",\"sell\":\"5.790\",\"settlement\":\"5.810\",\"open\":\"5.750\",\"high\":\"5.830\",\"low\":\"5.750\",\"volume\":73194,\"amount\":42344578,\"code\":\"600006\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600007\",\"name\":\"中国国贸\",\"trade\":\"20.610\",\"pricechange\":\"-0.050\",\"changepercent\":\"-0.242\",\"buy\":\"20.610\",\"sell\":\"20.620\",\"settlement\":\"20.660\",\"open\":\"20.600\",\"high\":\"20.990\",\"low\":\"20.400\",\"volume\":9990,\"amount\":20676170,\"code\":\"600007\",\"ticktime\":\"14:54:53\"},{\"symbol\":\"sh600008\",\"name\":\"首创股份\",\"trade\":\"7.770\",\"pricechange\":\"0.010\",\"changepercent\":\"0.129\",\"buy\":\"7.770\",\"sell\":\"7.780\",\"settlement\":\"7.760\",\"open\":\"7.610\",\"high\":\"7.900\",\"low\":\"7.410\",\"volume\":3255906,\"amount\":2493141296,\"code\":\"600008\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600009\",\"name\":\"上海机场\",\"trade\":\"39.660\",\"pricechange\":\"0.340\",\"changepercent\":\"0.865\",\"buy\":\"39.620\",\"sell\":\"39.660\",\"settlement\":\"39.320\",\"open\":\"39.700\",\"high\":\"39.870\",\"low\":\"38.800\",\"volume\":49265,\"amount\":192949674,\"code\":\"600009\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600010\",\"name\":\"包钢股份\",\"trade\":\"2.910\",\"pricechange\":\"-0.020\",\"changepercent\":\"-0.683\",\"buy\":\"2.910\",\"sell\":\"2.920\",\"settlement\":\"2.930\",\"open\":\"2.940\",\"high\":\"2.960\",\"low\":\"2.900\",\"volume\":513882,\"amount\":151073595,\"code\":\"600010\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600011\",\"name\":\"华能国际\",\"trade\":\"7.750\",\"pricechange\":\"-0.040\",\"changepercent\":\"-0.513\",\"buy\":\"7.740\",\"sell\":\"7.750\",\"settlement\":\"7.790\",\"open\":\"7.760\",\"high\":\"8.000\",\"low\":\"7.700\",\"volume\":157926,\"amount\":124238199,\"code\":\"600011\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600012\",\"name\":\"皖通高速\",\"trade\":\"12.510\",\"pricechange\":\"-0.370\",\"changepercent\":\"-2.873\",\"buy\":\"12.510\",\"sell\":\"12.580\",\"settlement\":\"12.880\",\"open\":\"12.980\",\"high\":\"12.980\",\"low\":\"12.400\",\"volume\":34929,\"amount\":44135851,\"code\":\"600012\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600015\",\"name\":\"华夏银行\",\"trade\":\"10.210\",\"pricechange\":\"-0.030\",\"changepercent\":\"-0.293\",\"buy\":\"10.200\",\"sell\":\"10.210\",\"settlement\":\"10.240\",\"open\":\"10.230\",\"high\":\"10.320\",\"low\":\"10.180\",\"volume\":232393,\"amount\":238335861,\"code\":\"600015\",\"ticktime\":\"14:54:53\"},{\"symbol\":\"sh600016\",\"name\":\"民生银行\",\"trade\":\"7.740\",\"pricechange\":\"-0.070\",\"changepercent\":\"-0.896\",\"buy\":\"7.740\",\"sell\":\"7.750\",\"settlement\":\"7.810\",\"open\":\"7.820\",\"high\":\"7.820\",\"low\":\"7.730\",\"volume\":746830,\"amount\":580534392,\"code\":\"600016\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600017\",\"name\":\"日照港\",\"trade\":\"4.180\",\"pricechange\":\"-0.090\",\"changepercent\":\"-2.108\",\"buy\":\"4.180\",\"sell\":\"4.190\",\"settlement\":\"4.270\",\"open\":\"4.250\",\"high\":\"4.280\",\"low\":\"4.160\",\"volume\":291619,\"amount\":122784515,\"code\":\"600017\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600018\",\"name\":\"上港集团\",\"trade\":\"6.090\",\"pricechange\":\"0.000\",\"changepercent\":\"0.000\",\"buy\":\"6.080\",\"sell\":\"6.090\",\"settlement\":\"6.090\",\"open\":\"6.030\",\"high\":\"6.090\",\"low\":\"5.980\",\"volume\":167551,\"amount\":101326685,\"code\":\"600018\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600019\",\"name\":\"宝钢股份\",\"trade\":\"6.150\",\"pricechange\":\"0.160\",\"changepercent\":\"2.671\",\"buy\":\"6.140\",\"sell\":\"6.150\",\"settlement\":\"5.990\",\"open\":\"6.020\",\"high\":\"6.180\",\"low\":\"6.020\",\"volume\":929027,\"amount\":570703387,\"code\":\"600019\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600020\",\"name\":\"中原高速\",\"trade\":\"4.710\",\"pricechange\":\"-0.100\",\"changepercent\":\"-2.079\",\"buy\":\"4.710\",\"sell\":\"4.720\",\"settlement\":\"4.810\",\"open\":\"4.790\",\"high\":\"4.820\",\"low\":\"4.710\",\"volume\":112697,\"amount\":53665353,\"code\":\"600020\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600021\",\"name\":\"上海电力\",\"trade\":\"12.810\",\"pricechange\":\"-0.060\",\"changepercent\":\"-0.466\",\"buy\":\"12.810\",\"sell\":\"12.820\",\"settlement\":\"12.870\",\"open\":\"12.760\",\"high\":\"12.880\",\"low\":\"12.600\",\"volume\":71923,\"amount\":91556309,\"code\":\"600021\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600022\",\"name\":\"山东钢铁\",\"trade\":\"2.560\",\"pricechange\":\"-0.040\",\"changepercent\":\"-1.538\",\"buy\":\"2.550\",\"sell\":\"2.560\",\"settlement\":\"2.600\",\"open\":\"2.600\",\"high\":\"2.650\",\"low\":\"2.550\",\"volume\":690936,\"amount\":180314393,\"code\":\"600022\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600023\",\"name\":\"浙能电力\",\"trade\":\"5.550\",\"pricechange\":\"0.000\",\"changepercent\":\"0.000\",\"buy\":\"5.530\",\"sell\":\"5.540\",\"settlement\":\"5.550\",\"open\":\"5.540\",\"high\":\"5.550\",\"low\":\"5.420\",\"volume\":212029,\"amount\":116568689,\"code\":\"600023\",\"ticktime\":\"14:54:56\"},{\"symbol\":\"sh600026\",\"name\":\"中远海能\",\"trade\":\"6.150\",\"pricechange\":\"-0.090\",\"changepercent\":\"-1.442\",\"buy\":\"6.150\",\"sell\":\"6.160\",\"settlement\":\"6.240\",\"open\":\"6.260\",\"high\":\"6.270\",\"low\":\"6.130\",\"volume\":97029,\"amount\":60231219,\"code\":\"600026\",\"ticktime\":\"14:54:53\"},{\"symbol\":\"sh600027\",\"name\":\"华电国际\",\"trade\":\"4.760\",\"pricechange\":\"-0.080\",\"changepercent\":\"-1.653\",\"buy\":\"4.760\",\"sell\":\"4.770\",\"settlement\":\"4.840\",\"open\":\"4.820\",\"high\":\"4.820\",\"low\":\"4.700\",\"volume\":265137,\"amount\":125813620,\"code\":\"600027\",\"ticktime\":\"14:54:56\"}]}}";
       try {
            JSONObject jsonObject = new JSONObject(s);
            String result1 =jsonObject.getString("error_code");
            System.out.println(result1);

            //return;
            //JSONObject result= new JSONObject(result1);
            JSONObject result = jsonObject.getJSONObject("result");
            System.out.println(result.getString("totalCount"));
           System.exit(0);
            Iterator keys = jsonObject.keys();


            JSONArray jsonArray = result.getJSONArray("data");
            for (int position = 0; position < jsonArray.length(); position++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(position);

                String symbol = jsonObject1.getString("symbol");
                String trade = jsonObject1.getString("trade");
                String pricechange = jsonObject1.getString("pricechange");
                String changepercent = jsonObject1.getString("changepercent");
                String Name = jsonObject1.getString("name");
                System.out.println(symbol);
                System.out.println(trade);
                System.out.println(pricechange);
                System.out.println(changepercent);
                System.out.println(Name);
            }

            System.out.print(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


    }
}
