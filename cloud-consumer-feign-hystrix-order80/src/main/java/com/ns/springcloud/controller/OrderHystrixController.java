package com.ns.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ns.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-02-26 14:45
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局配置
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}") //端口号
    private String serverPort;


    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id)+" ===端口号为：-->"+serverPort;
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")  //get用着玩意  @PathVariable("id")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //这个线程的超时时间是3s 三秒后报错启用兜底方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")  //2秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id)+" ===端口号为：-->"+serverPort;
        log.info("*******result:"+result);
        return result;
    }


    //兜底方法 上面出问题找到这个方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    //global fallback 需要一个全局的服务降级

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
