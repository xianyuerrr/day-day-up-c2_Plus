#include <stdio.h>
#include <math.h>
int main() {
    double x0,x1;
    int a;
    scanf("%d",&a);
    x0=a/2;
    x1=(x0+a/x0)/2;
    while(fabs(x0-x1)>=1e-5) {
        x0=x1;
        x1=(x0+a/x0)/2;
    }
    printf("%.3lf",x1);
}