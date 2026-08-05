public class WeChatService implements PayService {

    @Override
    public void pay(double money){
        System.out.println("微信支付"+ money + "元");
    };
}
