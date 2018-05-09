package prototype.simple;

public class SImpleCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep =new Sheep();
        sheep.age=3;
        sheep.name="母羊";
        sheep.sheep=new Sheep();
        Sheep duoli = (Sheep) sheep.clone();
        System.out.println(sheep.hashCode());
        System.out.println(duoli.hashCode());
        sheep.sheep.name="test";
        System.out.println(sheep.sheep);
        System.out.println(duoli.sheep);
        System.out.println(sheep.sheep==duoli.sheep);
        System.out.println(sheep==duoli);

    }
}
