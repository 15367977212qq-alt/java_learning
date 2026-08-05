public class Main_1 {


    public static void main(String[] args) {
        Animal ani1 = new Dog("旺财");
        Animal ani2 = new Cat("果粒橙");
        ani1.sound();
        ani2.sound();
        PayService servie;

        servie = new AliPayService();
        servie.pay(100);

        servie = new WeChatService();

        servie.pay(200);

    }
}
