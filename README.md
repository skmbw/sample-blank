# sample-blank
展示Spring MVC Spring MyBatis的常见用法和广为接受的建议。

## 项目使用maven进行管理
这是一个web项目，目录结构是maven的标准结构。
* src/main/java 是java源代码
* src/main/resources 是资源文件和配置文件
* src/test/java 测试源代码
* src/test/resources 是测试资源文件和配置文件
* src/main/webapp 是web项目根目录

## Spring配置
spring配置文件位于src/main/resources/spring目录下：之所以将配置文件分开，一是大家更改各自的配置文件不会互相影响，另外配置独立，
容易找到对应的配置，简洁。
* 主配置文件是application-context.xml。
* application-mybatis.xml是mybatis的配置
* application-spring-mvc.xml是Spring MVC的配置文件
* application-h2db.xml是用于演示的基于h2 database数据库的配置
* application-mysql.xml是用于生产环境的配置

## 其他配置
在src/main/resources目录下还有其他的配置文件
* config.properties是项目属性配置文件
* h2db.sql and h2db-user.sql是h2数据库的测试sql脚本，mysql.sql是mysql数据库的测试脚本
* log4j2.xml是日志配置文件，是基于log4j2的，log4j2的日志性能是log4j的几倍，可以直接使用log4j2，或者slf4j
* mybatis-config.xml是mybatis的配置文件，配置mybatis的一些特性

## 基础代码说明
在包com.cetiti.base下是一些基础的代码：
* bean包中的JsonBean.java用于和前端进行json的交互
* dao包中的BaseDao.java是mybatis的一些增删改查的基础方法，要配合mapper.xml文件一起使用，具体模块的dao类直接继承它即可。
这个类是一个泛型类，第一个泛型参数是该DAO对象的model类（数据库表对应的model），第二个是这个model（表）的主键。
* service包中的BaseService.java是基于BaseDao.java的通用service方法的封装，业务service只要继承它就能获得基本CRUD方法。
这个类也是一个泛型类，泛型参数的意义和BaseDao是一样的。注意记得实现setBaseDao方法，注入对应的dao对象。
* exception包中有两个异常，ServiceException用于回滚抛出的异常（基于AOP的事务配置使用到），BasicException是一般的异常。

## Demo样例代码说明
user包是一个样例代码，包含controller，dao，model，service四个子包。这里dao和service都没有使用接口，因为对于小的项目，
使用接口没有什么优势，反而多写代码和多建两个接口类。直接使用类即可。
* 对于控制器，url映射的一般的约定就是，类级url就是类名去掉controller后缀，然后驼峰命名，方法级url就是方法名，如果是返回jsp，
那么jsp文件名就是方法名，返回是视图名就是 “类级url/方法级url”。jsp文件的目录结构也是“类级url/方法级url”（见user模块例子）
* 如果返回json数据，那么统一返回一个JsonBean对象，使用@ResponseBody注解，接收Json参数使用@RequestBody注解
* 控制器方法体，使用try-catch捕获异常，当然也可以配置SpringMVC的统一异常拦截器，这不冲突。

## 事务控制和回滚
对于事务控制，spring提供了多种方式：注解、aop、代码控制等。常用的就是aop吧，非常简洁省事。当然也可以使用注解。
* 对应的配置在数据库配置文件中（application-mysql.xml）
* 如果在service层要回滚事务，就抛出ServiceException，如果不需要回滚就抛出BasicException异常。
* 如果使用切面（aop）事务控制，那么包结构要满足切面的要求，不能是乱定义的包结构和包名。将配置文件。
* 如果使用注解事务配置，请参考UserService配置和application-mysql.xml底部的配置

## 切换环境
如果要切换到mysql环境，只需要将application-context.xml文件中mysql的注释去掉，h2db的配置注释掉即可。当然也可将pom.xml中h2的驱动
去掉也是OK的。
`	<!--<import resource="application-mysql.xml" />-->
	<import resource="application-h2db.xml" />
`
* 生产环境，记得删除掉application-h2db.xml和h2db.sql和h2db-user.sql，以及mysql.sql。当然不去掉也没什么影响，就是不够整洁。
* 生产环境，记得去掉demo的user模块代码，这个只是用来演示。同时避免暴露url（控制器中暴露的），影响安全。

## 关于Spring中注解的使用
Java EE中常用的依赖注入的注解，主要有三套：
* spring自己提供的一套，主要有 @Autowired @Qualifier @Service @Controller @Component @Repository等
* Java EE 5.0提供的一套（JSR250规范），主要是 @Resource @Resources，@PreDestroy @PostConstruct，后两者用于生命周期管理，前面俩用于资源注入
* 全新的Java EE 6.0提供的（JSR330规范），主要有 @Inject @Named @Qualifier @Scope @Singleton

先给结论，就是：
* 不推荐使用JSR250规范，首先它不全面，需要结合其他来使用，第二比较早的规范了。Spring早期为了兼容Java EE选择性的支持了它。
* 推荐使用Spring自己的（绑定Spring环境），或者JSR330。单是不要混合使用这两套。个人推荐JSR330（android也可以使用）。

简要介绍一下，首先说一下Spring这套：
* 对于声明组件（Spring Bean），@Service @Controller @Component @Repository这四个在本质上没有区别，之所以有这四个就是`见名知义`。
Spring对他们的处理方式是相同的。看到这些注解，明白它们分别是什么类型的组件。
* @Autowired是进行依赖注入（DI），规则是：默认autowired by type（按类型注入），可以通过@Qualifier显式指定 autowired by qualifier name（按名称注入）。

对于JSR330这套新规范，Spring处理它们的方式，和Spring处理自己的注解的方式相同
* @Inject用于DI，规则是：默认autowired by type（按类型注入），可以通过@Named显式指定 autowired by qualifier name（按名称注入），
这里是通过@Named限定按名称注入，和Spring本身的有区别。另外JSR330的@Qualifier是用来限定注解的，和Spring的不一样。
* @Named等价于@Service @Controller @Component @Repository的四个注解。这个就是用来声明Bean的。
* @Scope用来声明Bean的声明周期（用于标记注解），@Singleton声明是一个单例

最后说一下JSR250吧 @Resource：
* 默认是autowired by field name（可以通过@Resource(name="beanName")来指定bean的名字）
* 如果autowired by field name失败，会退化为autowired by type
* 可以通过@Qualifier（Spring的）显式指定 autowired by qualifier name和@Resource(name="beanName")类似。（没试验过两个同时指定的效果）
* 如果 autowired by qualifier name失败，会退化为 autowired by field name。但是这时候如果 autowired by field name失败，就不会再退化为autowired by type了