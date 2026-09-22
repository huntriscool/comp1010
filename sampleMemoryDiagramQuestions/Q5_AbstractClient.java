class A {
    public int p;

    public A(int p) {
        this.p = p;
    }
}

class B {
    public int q;

    public B(int q) {
        this.q = q;
    }
}

class C {
    public A a;
    public B b;

    public C(A a, B b) {
        this.a = a;
        this.b = b;
    }
}

public class AbstractClient {
    public static void main(String[] args) {
        A a1 = new A(5);
        B b1 = new B(10);
        C c1 = new C(a1, b1);

        a1.p++;
        b1.q--; 
    }
}
