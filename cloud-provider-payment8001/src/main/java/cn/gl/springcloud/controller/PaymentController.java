package cn.gl.springcloud.controller;

import cn.gl.springcloud.model.CommonResult;
import cn.gl.springcloud.model.Payment;
import cn.gl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gl
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果:" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功", result);
        } else {
            return new CommonResult<>(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询数据:" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询数据成功", payment);
        } else {
            return new CommonResult<>(444, "查询数据失败,id:" + id, null);
        }
    }
}
