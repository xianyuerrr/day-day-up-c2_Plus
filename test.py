# class Parent:        # 定义父类
#    def myMethod(self):
#       print ('调用父类方法')
 
# class Child(Parent): # 定义子类
#    def myMethod(self):
#       print ('调用子类方法')
 
# c = Child()          # 子类实例
# c.myMethod()         # 子类调用重写方法
# super(Child,c).myMethod() #用子类对象调用父类已被覆盖的方法

# a = [[1,2], [3,4]]
# print(a)
# # *a 解包
# print(*a)
# # zip 换轴
# print(list(zip(a)))
# print(list(zip(*a)))

g1 = (x for x in range(10))
def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'

g2 = fib(8)
