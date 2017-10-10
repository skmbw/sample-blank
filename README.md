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
spring配置文件位于src/main/resources/spring目录下：
* 主配置文件是application-context.xml。
* application-mybatis.xml是mybatis的配置
* application-spring-mvc.xml是Spring MVC的配置文件
* application-h2db.xml是用于演示的基于h2 database数据库的配置
* application-mysql.xml是用于生产环境的配置

## 其他配置
在src/main/resources目录下还有其他的配置文件
* config.properties是项目属性配置文件
* h2db.sql and h2db-user.sql是h2数据库的测试sql脚本，mysql.sql是mysql数据库的测试脚本
* log4j2.xml是日志配置文件，是基于log4j2的
* mybatis-config.xml是mybatis的配置文件，配置mybatis的一些特性

## 基础代码说明
在包com.cetiti.base下是一些基础的代码：
* bean包中的JsonBean.java用于和前端进行json的交互
* dao包中的BaseDao.java是mybatis的一些增删改查的基础方法，要配合mapper.xml文件一起使用，具体的模块的dao直接继承它即可。
这个类是一个泛型类，第一个泛型参数是该DAO对象的model类（数据库表对应的model），第二个是这个model（表）的主键。
* service包中的BaseService.java是基于BaseDao.java的通用service方法的封装，业务service只要继承它就能获得基本CRUD方法。
这个类也是一个泛型类，泛型参数的意义和BaseDao是一样的。
* exception包中有两个异常，ServiceException用于回滚抛出的异常（基于AOP的事务配置使用到），BasicException是一般的异常。

## Demo样例代码说明
user包是一个样例代码，包含controller，dao，model，service四个子包。

## 切换环境
如果要切换到mysql环境，只需要将application-context.xml文件中mysql的注释去掉，h2db的配置注释掉即可。当然也可将pom.xml中h2的驱动
去掉也是OK的。
`	<!--<import resource="application-mysql.xml" />-->
	<import resource="application-h2db.xml" />
`