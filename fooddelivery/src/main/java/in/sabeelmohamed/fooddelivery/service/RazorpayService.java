package in.sabeelmohamed.fooddelivery.service;

import com.razorpay.RazorpayException;
import in.sabeelmohamed.fooddelivery.io.RazorpayOrderResponse;

public interface RazorpayService {

    RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;
}
