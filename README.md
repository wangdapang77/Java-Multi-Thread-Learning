# Java-Multi-Thread-Learning [![star this repo](http://githubbadges.com/star.svg?user=mynawang&repo=Java-Multi-Thread-Learning&style=flat&color=fff&background=1081C1)](https://github.com/mynawang/Java-Multi-Thread-Learning) [![fork this repo](http://githubbadges.com/fork.svg?user=mynawang&repo=Java-Multi-Thread-Learning&style=flat&color=fff&background=1081C1)](https://github.com/mynawang/Java-Multi-Thread-Learning/fork)


### 简介

关于Java多线程技术的学习中的例子汇总

```
com.sedion.mynawang
├── basic（多线程基础）
│   ├── DiscoverThread                              初识多线程
│   ├── PriorityThread                              线程优先级
│   ├── StatusThread                                线程状态
│   ├── DaemonThread                                守护线程
│   ├── SourceThread                                Thread线程源码阅读
│   ├── SuspendThread                               暂停线程（过期）
│   ├── InterruptedThread                           线程中断
│   ├── StopThread                                  停止线程（过期）
│   └── YieldThread                                 放弃当前线程CPU资源
├── advanced（多线程重要知识点）
│   ├── _synchrinozed（同步锁）
│   │   ├── pra1_safewithout                        方法内变量线程安全
│   │   ├── pra2_safewithsynchronized               加synchronized保证实例变量线程安全
│   │   ├── pra3_twoobjtwolock                      synchronized多个对象多个锁
│   │   ├── pra4_synchrinozedmethodlockobj          synchronized方法与锁对象
│   │   ├── pra5_dirtyread                          synchronized防止脏读
│   │   ├── pra6_lockin                             synchronized锁重入
│   │   ├── pra7_throwexceptionnolock               发生异常，锁自动释放
│   │   └── pra8_synnotextends                      同步不具有继承性
│   ├── _volatile（volatile关键字）
│   │   ├── pra1_dropdead                           死循环极及其解决方案
│   │   ├── pra2_atomicity                          volatile原子性问题
│   │   └── pra3_atomicinteger                      AtomicInteger原子类的安全与不安全
│   ├── _interthread_communication（线程间通信）
│   │   ├── pra1_nowaitnotify                       不使用等待通知使线程通信
│   │   ├── pra2_withwaitnotify                     正确使用等待通知使线程通信
│   │   ├── pra3_notifyall                          循序渐进唤醒所有等待线程
│   │   ├── pra4_waitwithinterrupt                  线程wait时调用interrupt报异常
│   │   ├── pra5_producerwithconsumer               生产者消费者
│   │   │   ├── procons_pra1_value                  生产者消费者一对多和多对多情况演示
│   ├── _threadlocal(ThreadLocal关键字)
│   │   ├── pra1_discoverthreadlocal                初识ThreadLocal
│   │   ├── pra2_checkthreadlocal                   验证线程变量的隔离性
│   │   ├── pra3_slovegetnull                       解决get()默认值为null的问题
│   │   └── pra4_inheritablethreadlocal             threadlocal子类inheritablethreadlocal可以让子线程取得父线程内的值
│   ├── _lock(lock实现同步效果)
│   │   ├── pra1_reentranlock                       lock同步
│   │   ├── pra2_withcondition                      Lock对象中使用ReentrantLock和Condition实现等待通知功能
│   │   ├── pra3_notifymore                         指定线程唤醒，和唤醒所有线程的方式的比较
│   ├── _threadpool(线程池)
│   │   ├── pra1_threadpool4ways                    四种Java线程池用法
│   │   ├── 
│   │   └── 
├── util（多线程工具）
│   ├── SleepUtils                                  休眠工具
```





### 技术交流

博客地址：[http://mynawang.com][1]

QQ群：专注的程序猿 282087535 [立即加入][2]


  [1]: http://mynawang.com
  [2]: http://shang.qq.com/wpa/qunwpa?idkey=632f7c11e0cb5dfc02231352205d9921c50e849a343e4010e4df1c25f59d2e90