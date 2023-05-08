package 继承;

public class Parent implements Root {

    public String parent;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void priority() {
        System.out.println("parent");
    }

}
