# 热加载替换助手
# 请谨慎使用该功能, 以避免不必要的风险.

@(标签)[热替换|定位问题|快速上线]

**热加载助手**是一款专为开发人员开发的工具，通过安装热加载助手提供的Chrome插件，快速对项目中的个别Class类进行热替换，协助开发人员快速定位问题、解决问题、上线新版本，带来前所未有的开发体验。

**热加载助手**整个工具分为2部分：
1.  Server端：即宿主JVM项目，包含功能有：上传新版本Class、查询上一次热加载信息
2.  Chrome端：热加载替换助手Chrome插件，开发人员通过该插件进行热替换和查询
 
 -------------------



## 热加载助手-产生原因

> 在日常开发中，开发环境比较复杂，很多项目本地无法启动 需要 集中部署到QA环境，这会导致开发调试起来非常不方便，QA环境使用的用户很多所以远端又不能进行远端断点调试(会阻塞其他人的操作)。 经常的，测试同学会发现一些问题，开发人员想定位问题，需要观察出现问题时的变量信息只能 新添加一些Log信息 然后重新通过jekins的pipeline的定义进行构建、kill运行实例、重启，而这3个动作浪费了 开发、测试的大量时间。 
 
> 为了节省大家的时间，提高工作效率，热加载助手作为1个辅助工具，开发人员对有疑惑的代码部分添加日志信息后， 快速在远程服务实例进行热替换，从而省去了 [构建项目]、[等待关闭超时]、[项目重启(耗时与服务实例个数成正比)] 这3大动作消耗的时间。


### Example使用说明

1. 找到在`src\chrome_springboot_reload`文件夹，然后安装为一个Chrome插件，点击图标，进行相关内容设置，具体参数看示例。
2. 在启动类上添加`@EnableOnlineReload`注解, 在项目的application.properties添加
   ```
   spring.profiles.active=dev
   management.endpoints.web.exposure.include=*
   ```
3. 启动Example项目 , 启动成功后访问：http://localhost:8080/debug-test
3. 修改debugx.reloader.service.impl.HelloServiceImpl 的实现
4. 使用IDE导出`HelloServiceImpl `这个类，导出的文件格式为jar文件。参考：[导出](https://blog.csdn.net/tsj11514oo/article/details/52078924)
5. 点击Chrome 热加载助手插件，选择你导出的jar文件，点击上传
6. 注意看上传下面的区域，看到 成功的文字提示后，你可以再请求一次 http://localhost:8080/debug-test 
7. 是不是很简单



### 代码很简单，有问题多看代码