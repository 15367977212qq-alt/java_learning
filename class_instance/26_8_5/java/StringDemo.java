public class StringDemo {
    public static void main(String[] args) {
        String txt1 = "Java";
        String txt2 = "Java";
        String txt3 = new String("Java");

        System.out.println(txt1 == txt2);//返回false，因为txt1跟txt2的指向地址相同
        System.out.println(txt1 == txt3);//返回false，因为txt1跟txt3的指向地址不同相同
        System.out.println(txt1.equals(txt3));//返回true，因为txt1跟txt3的变量内容相同

        StringBuilder txt4 = new StringBuilder(1024);
        txt4.append("用户ID：1001");
        txt4.append(",用户名：Tom,");
        txt4.append("状态：ACTIVE");
        System.out.println(txt4.toString());


    }
}
