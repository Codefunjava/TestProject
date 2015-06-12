SHA算法也是一种摘要算法，与md系列算法不同，SHA摘要长度较md系列算法长，
如：md5算法摘要长度为128位，而SSH1摘要长度为160，较md算法更为安全。

jdk自带的sha算法不多，bounce castle与common codec很好地扩充了sha系列算法

bounce castle 扩充了sha224算法，该算法返回的摘要长度为224位
common codec  提供的工具类DigestUtils中，实现了sha的多种版本实现。


