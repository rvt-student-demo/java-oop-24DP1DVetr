package rvt;
import java.util.ArrayList;
import java.util.List;

interface IA {}
interface IB {}
interface IC {}


class A implements IA {}
class B extends A implements IB {}
class C extends B implements IC {
    private List<E> eList;

    public C() {
        this.eList = new ArrayList<>(); 
    }

    public void addE(E e) {
        this.eList.add(e);
    }
}

class D {
    private IA iaObject;

    public D(IA iaObject) {
        this.iaObject = iaObject;
    }
}

class E {
    private List<C> cList;

    public E() {
        this.cList = new ArrayList<>();
    }

    public void addC(C c) {
        this.cList.add(c);
    }
}


public class BiggerClassDiagram {
    public static void main(String[] args) {
            
    }
}