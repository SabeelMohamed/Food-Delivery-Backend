package in.sabeelmohamed.fooddelivery.controller;

import com.razorpay.RazorpayException;
import in.sabeelmohamed.fooddelivery.io.OrderResponse;
import in.sabeelmohamed.fooddelivery.io.PaymentRequest;
import in.sabeelmohamed.fooddelivery.io.PaymentVerificationRequest;
import in.sabeelmohamed.fooddelivery.io.RazorpayOrderResponse;
import in.sabeelmohamed.fooddelivery.service.OrderService;
import in.sabeelmohamed.fooddelivery.service.RazorpayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final RazorpayService razorpayService;
    private final OrderService orderService;

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse createRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException {
        return razorpayService.createOrder(request.getAmount(), request.getCurrency());
    }

    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request) {
        return orderService.verifyPayment(request);
    }
}
