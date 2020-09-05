package com.panyu.member.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.panyu.client.base.MemberBaseResponse;
import com.panyu.member.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class AlipayController {

    @PostMapping("/alipay")
    @ResponseBody
    public MemberBaseResponse<User> alipay() {

        String URL = "https://openapi.alipay.com/gateway.do";
        String APP_ID = "2021001182679461";
        String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCDNN1/Ort9Pj2KGmqj+Zy1/29yzOHtsarFz4dljTNj3GOfWtO8hWKquGrBWjcIOrI/FXZuCbtiOObBQ9nnxGF+EAq+Fbc1DHivtAwkSh57TX5w7oUv/SBRZsCkAx56HzSEG5DW+OdFiNjLER1HKe8G9M4GPiaAVMoJOwGcgc3fFiVNqWJzTKcDFx3GNBPWhstzlFcjN+Ss2XW/YxuI6aC5xCvGY7cvIRS7Y+/Y7AibwPBIVBFLt1fiEVSdNlximw4Rv/BLHmZG7PKR/NRz4ejwPypTY3irg3j2CWgsV1AKNU6XTqnii069oqINf8ejXoaLYwZ0f67OhOG933CjNLdHAgMBAAECggEAHUR+oDHevspSeer4nMlCbsqi9q3DO/1kxalMX5fGveDcjCB7mNL8Nm7ayXSxT/Gf7zh/aX5cQUXGG5hiFDQXN0Km0s4PRxMYHMGB79pkwEaCDPj31sOVIPNVx4A2nTE2yr1Hatys4jLrgSi5KjWtbxTOnE/i0L+ZLcPu0RWXccqwqoGL/hCoy2GOmL3m4PDRw++3LdCH7yubeYs61HxayimO/0sGLrhWcZeQt60ekDbtqqfFJzcY8xbLZJpHmf4cy+iK0TNKjprz+CKrLkrcR4CN0TYYGZphWbKf24WDP7CIvDNn0corl14lYfzrI597TjLe6KUrb9QWB8kAoentkQKBgQDcvz2CeLOPvLS0RpHXPjb8jrjeO6fvNYSmAzvVYjkwAoDASJsbo26gyk6McuM4Y2YlebUB2/Y7JIC5l9c/jthv+P6YeR5wvn4CU7KcPNqGWrUweK12JFjU9MwwVo9VAe/nDHc1xy4n9Rp/cEagLOVdlE80VRqdDiVRAjB/kof+6QKBgQCYKPTOSBehlGjJYtYPS6tc/HjLDxu44bivfmVLBjhBHFVZTK5d+tnH4BjnFJvnyOK33fQm3fwNjgaW3SLMsKMiumXHywdEAOu3DKI+gJOE722ejb/qePlPyna3TGW110udFFtMBQ3wxMD/0QjNg7N5dBI1NgAvNKzdCGaGQ6QGrwKBgQCh/aEIxsSWPVeqV4McniZBzgZx5vtEulRec08MNulahuuur1lLvfIoAm4D+ScvMRo7dAXVmHIoUpA4IeouVQgVm3ZRs8gX2mKkGIGgz7NZFuWR7Wz1npSlqgLRkiPasPI47lfo2gLQBbjtPhpF3sxukLBS6gT+revKd73ZUFGGSQKBgQCRMUOoMxKZlEwJHs6z+bijGicJXHlPidP5Ydq2JFE5kBfBBnK8Ksn099nLZtb97aqpWJnJHLmPFZ8kBg9W0pZYZRUJ+KoOMfK60MtgaMBbcTxgt1ISIy2C/ecaMUQ8qBv2353ehFQxEw43DPghYzK3ChL1w3mZkeIBaCqso4648QKBgQCknlyTrUGgm4HEveNlyF0ZRJY2HCkQzMds0tctknCbviMBJApBUwlqNI5zUiQ8YlEQeKDaxEo6zmYhrTD8xj6Rzth+YBkgojWLCUJv/mUgmimh3KVncWir6fZrVReYNtViXo+UIUVfSMHYv5XDF6aNV7X3896puGEofcmJ8aKPIA==";
        String FORMAT = "json";
        String CHARSET = "UTF-8";
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAioRh93IeASWufFvNSdMA1GNuvB+N6ASk1/Q4fPFeGKLdX51rrHoeYev/ZIRV3rItDxTaxqNuoIsPz88jLGDDnQEIOG2mRxM8YZ9DyhsnRcvYEXlr+UoRGSagxdcD9uZIUT0aTG8mGpebxS7OKMo9KuRinKy2MNBfciMaWSx4QuHy3NCW9Psx29ft3/FcPldZAJWxXVi51OlBgj14HIiN5kUZJn3RY4x4iHKBQelBzZx+04YtjIwGNPaDHwoelKkwefQG/SGjmfZMZuQStw62/DKq3N9doeLjv2OwnoET6RLM4RollZDu/11UbN0Bkc3ZQVvvViCWHqbJBDHroiHf+QIDAQAB";
        String SIGN_TYPE = "RSA2";

        String outtradeno = "11111";

        AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo(outtradeno);
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        //request.setNotifyUrl("192.168.1.3:8090/notifyAli");
        request.setNotifyUrl("192.168.1.3:8093/check/test");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;

    }

    @PostMapping("/notifyAli")
    @ResponseBody
    public MemberBaseResponse<User> notifyAli(HttpServletRequest request) throws  Exception {
        System.out.println("-------------------------------------------------------------");
        String charset = "UTF-8";
        String alipaypublicKey= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAioRh93IeASWufFvNSdMA1GNuvB+N6ASk1/Q4fPFeGKLdX51rrHoeYev/ZIRV3rItDxTaxqNuoIsPz88jLGDDnQEIOG2mRxM8YZ9DyhsnRcvYEXlr+UoRGSagxdcD9uZIUT0aTG8mGpebxS7OKMo9KuRinKy2MNBfciMaWSx4QuHy3NCW9Psx29ft3/FcPldZAJWxXVi51OlBgj14HIiN5kUZJn3RY4x4iHKBQelBzZx+04YtjIwGNPaDHwoelKkwefQG/SGjmfZMZuQStw62/DKq3N9doeLjv2OwnoET6RLM4RollZDu/11UbN0Bkc3ZQVvvViCWHqbJBDHroiHf+QIDAQAB";

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, alipaypublicKey, charset, "RSA2");

        return null;

    }

}
