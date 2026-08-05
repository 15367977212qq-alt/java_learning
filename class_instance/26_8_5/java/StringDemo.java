public class StringDemo {

    public static void main(String[] args) {
        String txt1 = "Java";
        String txt2 = "Java";
        String txt3 = new String("Java");

        // true：两个字符串字面量通常引用常量池中的同一个对象
        System.out.println(txt1 == txt2);

        // false：txt3 是显式创建的新对象
        System.out.println(txt1 == txt3);

        // true：String 重写了 equals，比较字符串内容
        System.out.println(txt1.equals(txt3));

        StringBuilder builder = new StringBuilder();
        builder.append("用户ID：1001");
        builder.append("，用户名：Tom");
        builder.append("，状态：ACTIVE");

        System.out.println(builder);
    }
}