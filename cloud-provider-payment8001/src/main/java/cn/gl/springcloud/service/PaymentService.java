package cn.gl.springcloud.service;

import cn.gl.springcloud.model.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author gl
 */

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
