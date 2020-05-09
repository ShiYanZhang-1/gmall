package top.shiyana.gmall.gateway.test;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.gateway.test
 * @ClassName: T1
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 14:15
 * @Version: 1.0
 */
public class T1 {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());

        for (int i = 0; i <10000 ; i++) {
            new Thread(()->{
                System.out.println("He1llo World!1!!");
                System.out.println(Thread.currentThread().getName());
            },""+i).start();

        }
    }
}
