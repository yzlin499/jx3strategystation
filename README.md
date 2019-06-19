# jx3ss

后台：管理员修改资料，管理员审核帖子 [rickieee](https://github.com/rickieee/jx3strategystation)

社区：社区展示，交易社区面板展示，公告社区面板，副本社区面板 [hiukie](https://github.com/hiukie/jx3strategystation)

资料：门派心法奇穴技能 [ay2008lnt](https://github.com/ay2008lnt/jx3strategystation)

用户页：登录注册修改密码，用户个人主页 [totoger](https://github.com/totoger/jx3strategystation)

功能页：环境配置，帖子发布，帖子显示，帖子回复等 [yzlin499](https://github.com/yzlin499/jx3strategystation)

该项目数据库配置文件为 \src\main\resources\config.properties ，并且识别当前的git user.name来配置数据库

或者修改 spring.profiles.active 为prod，来启动其他的数据库配置方案

当数据库没有配置的时候，sqlite会在默认位置创建数据库，hibernate会创建默认表，项目可以启动但是没有任何游戏数据

该项目为零配置项目，主要spring配置为：
top.yzlin.jx3strategystation.WebProjectConfigInitializer;
top.yzlin.jx3strategystation.config.MainConfig;

没有web.xml的情况下，低版本tomcat可能无法启动