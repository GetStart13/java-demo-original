package 多态;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        System.out.println(animal.name);
        animal = new Dog();
        animal.eat();
        Cat cat = new Cat();
        // 输出 cat
        System.out.println(cat.name);
        cat.eat();

        // 转父类
        Animal animalOfCat = cat;
        // 输出 animal
        System.out.println(animalOfCat.name);
        // 输出 cat，因为子类重写了方法，调用了 this
        System.out.println(animalOfCat.getName());
        // 输出 animal，因为子类未重写方法
        System.out.println(animalOfCat.getNameAnimal());
        Pig pig = new Pig();
        pig.eat();
    }
}
