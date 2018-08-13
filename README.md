# ambowssm
安博实训第二个项目（ssm框架项目）
1.entit,dao,mapper统一使用工具类根据数据库自动生成。
2.如果dao中没有需要的方法，需要手写。
3.service统一处理业务逻辑。
4.controller中不可存在任何的业务逻辑。
5.controller中只可以有页面处理、传值、跳转等。
6.jsp中如果需要使用el表达式（${变量名}），需要在jsp加入：<%@page isELIgnored="false" %>
7.jsp中避免出现<%%>小脚本
