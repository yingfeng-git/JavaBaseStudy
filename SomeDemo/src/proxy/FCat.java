package proxy;

public class FCat implements Animal {

    @Override
    public void run() {
        System.out.println("大花猫在跑。。。");
    }

    public static void main(String[] args) {
        //FCat是我的类，现在我要给我的类加个代理
        Animal fCat = new FCat();

        // 下面是代理的方法，把我的类丢进去，然后执行代理类，实现静态代理
//        CatProxy catProxy = new CatProxy(fCat);
//        catProxy.run();

        CatEndProxy catEndProxy = new CatEndProxy(fCat);
        catEndProxy.run();
    }
}
