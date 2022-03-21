```text
元注解: page_307

(1).APT:
当开发者使用了 Annotation 修饰了类、方法、Field 等成员之后，
这些 Annotation 不会自己生效，必须由开发者提供相应的代码来提取并处理 Annotation 信息.
这些处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool).

(2).Spring 中的这几个注解有什么区别：
@Component 、@Repository、@Service、 @Controller?
1、@Component 指的是组件;
@Controller，@Repository 和@Service 注解都被@Component 修饰，
用于代码中区分表现层，持久层和业务层的组件，代码中组件不好归类时可以使用@Component 来标注.

2、当前版本只有区分的作用，未来版本可能会添加更丰富的功能.

```