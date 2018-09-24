1. Spring 中 Bean的Scope有哪些？它们分别代表什么含义？
	- singleton:单例模式，在整个容器中只存在一个Bean实例
	- prototype：可以有任意多个实例在一个容器里
	- request：每一次网络请求都会新建一个新的bean实例出来。比如get，post等，每次请求就会生成一个新的bean实例
	- session：每次网络回话会新建一个。会话是指一定时间内用户和网站之间的一组整合操作。
	- global session：Scopes a single bean definition to the lifecycle of a global HTTP Session.
2. Spring 中 的AOP的通知有几种类型，对每种Advice写至少一个Test Case来验证它们的工作机制。
	- around:代表在join point 执行时自行定义执行前，执行中以及执行后需要的操作，如果需要join point方法执行需要显式的调用proceed方法（只有around需要）
	- before：在join point方法执行前执行的方法
	- after returning：只有当join point方法正常执行之后会调用的方法
	- after throwing：只有当join point方法抛出异常后执行的方法
	- after finally：不管是join point正常执行还是抛异常都会执行的方法