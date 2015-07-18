javac--java编译命令

1.填充符号表：com.sun.tools.javac.comp.Enter
2.标注检查： com.tools.javac.comp.Attr
		    com.sun.tools.javac.comp.Check
3.数据及控制流分析：com.sun.tools.javac.comp.Flow
4.解语法糖(泛型、变长参数、自动装箱/拆箱)：com.sun.tools.javac.comp.TransTypes
										 com.sun.tools.javac.comp.Lower
5.字节码生成：com.sun.tools.javac.jvm.Gen
6.字节码输出到磁盘：com.sun.tools.javac.jvm.ClassWriter
										