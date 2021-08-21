public class test {
    public static void main(String[] args) {
        // Java 基本类型的包装类的大部分都实现了常量池技术
        // 使用 new 创建的一定在堆中
        // 使用 valueOf()方法（装箱） 创建的在常量池中，所以下面的 i1 和 i2 是同一个对象
        // 传入小于128的值时，返回的是内置的缓存值，节省空间和效率。
        Integer i1 = 1;
        Integer i2 = 1;
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
