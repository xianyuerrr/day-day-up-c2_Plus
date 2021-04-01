//#include <iostream>
//#include <hash_map>
//#include <iomanip>
////#include "./CPlusPlusPrimerPlus-master/Chapter 4/instr1.cpp"
//using namespace std;
//// 使用新式C++风格，include头文件不需以 .h 结尾
//// 可以使用std命名空间中定义的名称，std::cout -> cout
//
//int main() {
//    int num(0), letter(0), blank(0), els(0);
//    char ans;
//    while ((ans = getchar()) != '\n') {
//        if ('0' <= ans && ans <= '9') {
//            num += 1;
//        }else if (('a' <= ans && ans <= 'z') ||
//                            ('A' <= ans && ans <= 'Z')) {
//            letter += 1;
//        }else if (ans == ' ' || ans =='\t') {
//            blank += 1;
//        }else {
//            els += 1;
//        }
//    }
//    cout << letter << endl;
//    cout << blank << endl;
//    cout << num << endl;
//    cout << els << endl;
//}
////int main() {
////    char xianyue[] = "xianyue";
////    cout << xianyue << endl;
////    cout << xianyue[-1] << endl;
//////    cout << typeof("xianyue");
////    cout << sizeof(xianyue) / sizeof(char) << endl;
////}
////int main() {
////    /* 多行注释 */
////    // 单行注释 (其实是C注释)
////    /*
////     * 声明
////     * 赋值
////     * 消息
////     * 函数调用
////     * 函数原型
////     * 返回语句
////     */
////    std::cout << "Hello, World!" << std::endl;
////    return 0;
////}
#include <iostream>
#include <iomanip>
using namespace std;
int main() {
    int n = 30;
    double res = 0, ans = 1;
    for (int idx = 1; idx <= n; idx++) {
        ans *= idx;
        res += ans;
    }
    cout.precision(3) ;
    cout << res << endl;
    return 0;
}