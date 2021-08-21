public class test {
    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = i1;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i1==i2);
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
        i1 += 1;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i1==i2);
        // find address
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));

        // new Class3();
        // String a = new String("ab");
        // String b = new String("ab");
        // String aa = "ab";
        // String bb = "ab";
        // if (aa == bb)
        //     System.out.println("aa==bb");
        // if (a == b)
        //     System.out.println("a==b");
        // if (a.equals(b)) // true
        //     System.out.println("aEQb");
        // if (42 == 42.0) { // true
        //     System.out.println("true");
        // }
        // A a = new A(1);
        // A b = new A(1);
        // System.out.println(a == a);
        // System.out.println(a == b);
        // System.out.println(a.equals(b));        
    }
}

class A {
    int val;
    A(int val){
        this.val = val;
    }
    public boolean equals(A obj) {
        return (this.val == obj.val);
   }
}

class Class3 extends Class2 {
    public Class3() {
        System.out.println("D");
    }
}

class Class2 extends Class1 {
    public Class2() {
        this("B");
        System.out.println("C");
    }

    public Class2(String s) {
        System.out.println(s);
    }
}

class Class1 {
    public Class1() {
        System.out.println("A");
    }
}
