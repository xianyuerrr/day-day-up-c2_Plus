import java.util.Random;

class Solution {
    Random random = new Random();
    double radius;
    double x;
    double y;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }
    
    // 注意如果直接在 [0, 1) 范围内生成 r 以及 [0,2π) 范围内生成 θ，
    // 得到的随机点是不均匀的，可以通过任意一种可视化工具观察结果。
    public double[] randPoint() {
        return method2();
    }

    // 拒绝采样
    public double[] method2() {
        double delteX, delteY;
        while (true) {
            delteX = (random.nextDouble() * 2 - 1)  * radius;
            delteY = (random.nextDouble() * 2 - 1)  * radius;
            if (Math.pow(delteX, 2) + Math.pow(delteY, 2) <= Math.pow(radius, 2)) break;
        }
        return new double[] {x+delteX, y+delteY};
    }

    public double[] method1() {
        double angle = random.nextInt(360) / 180.0 * Math.PI;
        double len = random.nextDouble() * radius;
        double delteX = Math.sin(angle) * len;
        double delteY = Math.cos(angle) * len;
        return new double[] {x+delteX, y+delteY};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */