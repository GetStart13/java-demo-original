package 继承;

public class Child extends Parent {
    public String child;
    public String parent;

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public String getParent() {
        return parent;
    }

    @Override
    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public void priority() {
        System.out.println("child");
        incidental();
    }

    protected void incidental() {
        System.out.println("附带发生的");
    }
}
