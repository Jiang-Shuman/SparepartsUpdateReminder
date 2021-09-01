package com.nexteer;


import java.util.Base64;
import java.io.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientUtil {

	public static String httpClientUtil() throws Exception {
		
		String url = "http://192.168.0.198/eamic/ws/rest/v1/spareParts";
		String encoding = Base64.getEncoder().encodeToString(("00001:ETAKZwWRvVfQm8Zp").getBytes());
		System.out.println("备件更新信息：");
		System.out.println(GetData.jsonStr() + "\n");
		String result = HttpClientUtil.doPut(url, encoding, GetData.jsonStr());
		return result;
    }
	
	public static String doPut(String url, String encoding, String jsonStr) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();
        httpPut.setConfig(requestConfig);
        httpPut.setHeader("Authorization", "Basic "+encoding);
        httpPut.setHeader("Content-Type","application/json");
        httpPut.setHeader("DataEncoding", "UTF-8");

        
        CloseableHttpResponse httpResponse = null;
        try {
        	String  str ="{\"data\":"+jsonStr+"}";
        	StringEntity entitys = new StringEntity(str,"utf-8");
     
        	entitys.setContentEncoding("utf-8");
        	entitys.setContentType("application/json");
            httpPut.setEntity(entitys);
            httpResponse = httpClient.execute(httpPut);
            HttpEntity entity = httpResponse.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println("备件更新结果：");
            System.out.println(result + "\n");
            return result;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}