#include<stdio.h>
#include<string.h>
using namespace std;

void change(){
    char a[20];
    int len;
    char e;
    scanf("%s",a);
    len=strlen(a);
    for(int i=0;i<len/2;i++){
        e=a[i];
        a[i]=a[len-1-i];
        a[len-1-i]=e;
    }
    printf("%s",a);
}

int main(){
    change();
    return 0;
}
