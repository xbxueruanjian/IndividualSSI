##Spring+SpringMVC+Mybatis+Shiro搭建的框架
####1、本地缓存（项目启动时加载，后续添加Redis）
####2、Model进行特殊化处理
>继承BaseModel，数据存放对应Model的Map中。通过缓存以及Model的特殊化处理，减少大量View类，并同时提升查询效率。
####3、自定义异常处理机制，统一处理业务逻辑异常，并区分开JAVA运行时异常。
>自定义业务逻辑异常继承IException，同时需要抛出业务逻辑异常的地方使用 Thrower.throwException(IException,....)抛出相应异常。
####4、控制层的入参、出参进行处理，统一处理请求。
####5、登录采用Shiro进行控制。（前台所有页面善未移进Github，后续处理）
