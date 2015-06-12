md系列算法中，用得较多的是md5算法。
虽然jdk中实现了md5算法，但加密的结果是一个byte数组，得到的结果不便于保存。
bounce castle实现的md5算法，除了可以得到byte数组外，还提供了将byte数组转化为16进制字符的方法
common codec 提供了一个工具类：DigestUtils，该类实现了md系列算法，提供的方法既能返回byte数组，
也能返回16进制字符串，使用起来非常方便。

