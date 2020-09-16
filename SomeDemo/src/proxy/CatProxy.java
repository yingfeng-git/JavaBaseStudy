package proxy;

public class CatProxy implements Animal {
    Animal a;
    CatProxy(Animal a){
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("CatProxy start run...");
        a.run();
        System.out.println("CatProxy end run...");
    }
}
