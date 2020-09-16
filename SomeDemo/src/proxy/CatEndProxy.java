package proxy;

public class CatEndProxy implements Animal{
    Animal a;
    CatEndProxy(Animal a){
        this.a = a;
    }

    @Override
    public void run() {
        a.run();
        System.out.println("猫猫跑完了，要亲亲抱抱举高高！");
    }
}
