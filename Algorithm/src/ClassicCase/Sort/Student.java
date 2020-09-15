package ClassicCase.Sort;

public class Student {
    public int id;
    public int age;
    public int height;
    Student(int id, int age, int height){
        this.id = id;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "id:\"" + id +
                "\", age:\"" + age +
                "\", height:\"" + height +
                "\"}";
    }
}
