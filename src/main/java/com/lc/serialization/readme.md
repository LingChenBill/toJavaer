#### 序列化及反序列化相关知识
```text
1. 在Java中,只要一个类实现了java.io.Serializable接口,那么它就可以被序列化.
2. 通过ObjectOutputStream和ObjectInputStream对对象进行序列化及反序列化.
3. 虚拟机是否允许反序列化,不仅取决于类路径和功能代码是否一致.
   一个非常重要的一点是两个类的序列化ID是否一致.
   private static final long serialVersionUID = 1L;
4. 序列化并不保存静态变量.
5. 要想将父类对象也序列化,就需要让父类也实现Serializable接口.
6. Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，
   可以阻止该变量被序列化到文件中，在被反序列化后，transient 变量的值被设为初始值，
   如 int 型的是 0，对象型的是 null。
7. 服务器端给客户端发送序列化对象数据，对象中有一些数据是敏感的,比如密码字符串等  
   希望对该密码字段在序列化时，进行加密，而客户端如果拥有解密的密钥，
   只有在客户端进行反序列化时，才可以对密码进行读取，这样可以一定程度保证序列化对象的数据安全。

总结:
1、如果一个类想被序列化，需要实现Serializable接口。否则将抛出NotSerializableException异常，
   这是因为，在序列化操作过程中会对类型进行检查，
   要求被序列化的类必须属于Enum、Array和Serializable类型其中的任何一种。
2、在变量声明前加上transient关键字，可以阻止该变量被序列化到文件中。
3、在类中增加writeObject和readObject方法可以实现自定义序列化策略。
```