public class AliPayService implements PayService {

    @Override
    public void pay(double money){
        System.out.println("支付宝支付"+ money + "元");
    }
}
