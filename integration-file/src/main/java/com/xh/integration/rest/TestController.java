package com.xh.integration.rest;

import com.xh.integration.service.FileWriteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 9:32
 * @description
 */
@RestController
public class TestController {

    @Autowired
    private FileWriteGateway fileWriteGateway;

    @RequestMapping("/int/{filename}/{content}")
    public String testIntegration(@PathVariable("filename") String filename,
                                  @PathVariable("content") String content
    ) {
        fileWriteGateway.writeToFile(filename,content);
        return "success";
    }
}
