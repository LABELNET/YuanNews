#datacenter 使用方法

#新添加数据源实现流程
  * 1.实现LoadUtil类 继承 LoaderBase基类；
  * 2.实现ParseUtil类 继承 ParserBase基类；
  * 3.实现data类 继承 GetDataBase基类；
  * 4.ParseIndex类中，实现主页url解析方法；

  * 5.执行方法：三步即可
   ```
           //1.实现主页加载类
           HuxiuLoader huxiuLoader=new HuxiuLoader(IndexUrl);

           //2.实现线程池
           ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader);

           //3.执行开始操作
           threadPoolHttpClient.start();
   ```