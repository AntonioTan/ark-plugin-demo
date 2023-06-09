package com.stori.toydemo.controller;
import com.alipay.sofa.demo.hessian3.Hessian3Service;
import com.alipay.sofa.demo.hessian4.Hessian4Service;
import com.alipay.sofa.demo.pojo.SamplePoJo;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.stori.toyservice.ToyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
@RestController
public class ToyDemoController {
    @SofaReference(uniqueId = "annotationImpl")
    private ToyService toyService;

    @RequestMapping("/hello-hessian3")
    public String hessian3() throws IOException {
        SamplePoJo samplePoJo = new SamplePoJo("Hello, hessian3.");
        Hessian3Service hessian3Service = new Hessian3Service();
        byte[] bytes = hessian3Service.serialize(samplePoJo);
        Object pojo = hessian3Service.deserialize(bytes);
        return pojo.toString();
    }

    @RequestMapping("/hello-hessian4")
    public String hessian4() throws IOException {
        SamplePoJo samplePoJo = new SamplePoJo("Hello, hessian4.");
        Hessian4Service hessian4Service = new Hessian4Service();
        byte[] bytes = hessian4Service.serialize(samplePoJo);
        Object pojo = hessian4Service.deserialize(bytes);
        return pojo.toString();
    }

    @RequestMapping("/toy-service")
    public String toyService() throws IOException{
        return toyService.sayHi();
    }
}
