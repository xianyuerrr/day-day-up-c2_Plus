def test(a):
    # 值传递，修改此值不影响作用范围外部的变量
    a = 2
a = 1
test(a)
print(a) # 返回 1