# 概述
- 函数是第一等公民(柯里化与高阶函数)
- 纯面向对象的语言
- basic.LeakageInspectionCompletion
# 数据类型(类型推断)
- Traversable
    - Iterable
        - Seq
            - List
            - Vector
        - Set
        - Map
- Array
    - 数组是一种特殊的collection
- Seq
    - Seq是列表，适合存有序重复数据，进行快速插入/删除元素等场景
    - Set是集合，适合存无序非重复数据，进行快速查找海量元素的等场景
- List
    - 不可变
- Vector
- Matrix
- ClassTag
    - stores the erased class of a given type T
- asInstanceOf[T](将对象类型强制转换为T类型)
    - classOf(获取类型T的Class对象)
    - isInstanceOf[T](判断对象是否为T类型的实例)
    - 我们把classOf[T]看成Java里的T.class, obj.isInstanceOf[T]看成 obj instanceof T, obj.asInstanceOf[T]看成(T)obj就对了
- val
    - var 修饰的对象引用可以改变，val 修饰的则不可改变，但对象的状态却是可以改变的
# 函数
- 柯里化----柯里化的函数被应用于多个参数列表----多个小括号括起来的函数参数列表的函数就是柯里化函数,curry化最大的意义在于把多个参数的函数等价转化成多个单参数函数的级联
    - ()()
    - 高阶函数----带其他函数做参数的函数(接受一个或多个函数作为输入或者输出一个函数)
    - 强调将计算过程分解成可复用的函数
    - 多个参数转化为单参数函数的级联，达到了动态确定参数的目的
    - 某些参数不确定时，可以先保留一个存根
    - 建造者模式(building)，把一个大的东西的构造过程，切成一个个的小模块来逐步构造
# 常规语法
- 伴生对象
    - 在scala中，类名可以和对象名为同一个名字，该对象称为该类的伴生对象，类和伴生对象可以相互访问他们的私有属性，但是他们必须在同一个源文件内。
- trait
    - Scala Trait(特征)----与接口不同的是，它还可以定义属性和方法的实现
- sealed
    - 可以修饰类和特质（特质）。密封类提供了一种约束：不能在类定义的文件之外定义任何新的子类
- override
    - 子类中的方法要覆盖父类中的方法，必须写override
    - 子类中的属性val要覆盖父类中的属性，必须写override
    - 父类中的变量不可以覆盖
# 特殊用法
- 任何对象都能调用的->机制被称为隐式转化(implicit conversion)
    - Scala在面对编译出现类型错误时，提供了一个由编译器自我修复的机制，编译器试图去寻找
      一个隐式implicit的转换方法，转换出正确的类型，完成编译。这就是implicit 的意义
    - 隐式参数(implicit parameters)
        - 列表中可以添加隐式implicit关键字进行标记， 标记为implicit的参数在调用中可以省略
    - 隐式转换(implicit conversion)
        - 标记规则：只会去寻找带有implicit标记的方法
        - 作用域范围规则,只会在当前表达式的作用范围之内查找，而且只会查找单一标识符的函数，上述代码中
        - 不能有歧义原则：在相同优先级的位置只能有一个隐式的转型方法
        - 只应用转型方法一次原则
- :: 两个冒号运算符----表示普通元素与list的连接操作
    - ++ 该方法用于连接两个集合，list1++list2
    - :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素
- =>  把左边的东西改成右边的东西；可以看做创建函数实例的语法糖
- 写成private[x],读作"这个成员除了对[…]中的类或[…]中的包中的类及它们的伴生对像可见外，对其它所有类都是private
- .:: _(某个元素的替代) ++=(用于向数组中追加内容，++=右侧可以是任何集合)
- 传入可变长度参数列表
    - 参数的类型之后放一个星号
- asScala/asJava将Java和Scala的集合互相转换
    - 先import scala.collection.JavaConverters._
# 数学概念
- L0范数是指向量中非零元素的个数/L1(L1范数是指向量中各个元素的绝对值之和)/L2(L2范数是指向量各元素的平方和然后开方)
- variance(每个样本值与全体样本值的平均数之差的平方值的平均数/用来度量随机变量和其数学期望（即均值）之间的偏离程度)
- 向量是由n个实数组成的一个n行1列（n*1）或一个1行n列（1*n）的有序数组
    - 向量的点乘(就是对这两个向量对应位一一相乘之后求和的操作，点乘的结果是一个标量)
        - 几何意义是可以用来表征或计算两个向量之间的夹角(a·b>0    方向基本相同，夹角在0°到90°之间/a·b=0    正交，相互垂直 /a·b<0    方向基本相反，夹角在90°到180°之间 )
    - 两个向量的叉乘，又叫向量积、外积、叉积，叉乘的运算结果是一个向量而不是一个标量
        - 可以通过两个向量的叉乘，生成第三个垂直于a，b的法向量，从而构建X、Y、Z坐标系
    - https://blog.csdn.net/dcrmg/article/details/52416832 向量点乘（内积）和叉乘（外积、向量积）概念及几何意义解读    
- 矩阵(一个m * n的矩阵是一个由 m行（row） n列（column）元素排列成的矩形阵列)
    - 矩阵相乘(结果矩阵第m行与第n列交叉位置的那个值，等于第一个矩阵第m行与第二个矩阵第n列，对应位置的每个值的乘积之和)
        - 矩阵的本质就是线性方程式，两者是一一对应关系
    - http://www.ruanyifeng.com/blog/2015/09/matrix-multiplication.html 理解矩阵乘法