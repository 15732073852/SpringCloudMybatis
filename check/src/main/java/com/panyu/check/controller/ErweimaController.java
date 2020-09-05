package com.panyu.check.controller;

import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ErweimaController {
    @GetMapping(value = "qrcode")
    public void qrcode(HttpServletResponse response) throws Exception {
        Map<EncodeHintType, Object> hints = Maps.newHashMap();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //封装二维码参数
        JSONObject codeParams = new JSONObject();
        codeParams.put("世界","神奇");
        codeParams.put("宇宙","科幻");
        codeParams.put("自然","无线");
        String content = codeParams.toJSONString();  //二维码内容
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
        response.reset();//HttpServletResponse
        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
    }

}
