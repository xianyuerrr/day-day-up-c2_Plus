
#     def __init__(self,a,b):
#         self.name=a
#         self.local=b
#     def speak(self):
#         print('my name is:', self.name, "my location is:", self.local)
# class son(fa):
#     def __init__(self,a,b,d):
#         fa.__init__(self,a,b)#调用父类的构造方法，否则子类speak()方法的变量会被提示无定义，因为调用的是父类的变量
#         #super(son,self).__init__(a,b) 与上一句等同
#         #super(son, self).speak()这一句只要在继承父类的构造函数下的方法内或者其它方法内都行，不能独立于方法
#         self.action=d
#     def speak(self):
#         super(son, self).speak()#调用父类的一般方法
#         print('my name is:', self.name, "my location is:", self.local,
#               'my location is:',self.action)
# ls=son('jk', 'bbn', 'io')
# ls.speak()
# super(son,ls).speak()#调用父类的一般方法