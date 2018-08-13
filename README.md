# ambowssm
# 安博实训第二个项目（ssm框架项目）
# 1.entit,dao,mapper统一使用工具类根据数据库自动生成。
# 2.如果dao中没有需要的方法，需要手写。
# 3.service统一处理业务逻辑。
# 4.controller中不可存在任何的业务逻辑。
# 5.controller中只可以有页面处理、传值、跳转等。
# 6.jsp中如果需要使用el表达式（${变量名}），需要在jsp加入：<%@page isELIgnored="false" %>
# 7.jsp中避免出现<%%>小脚本
# 8.controller中
    控制角色使用 @RequiresRoles("admin") 加在方法体之上
    控制权限使用 @RequiresPermissions("user:new") 加在方法体之上
    前提是在创建用户（user）时，需要同时在角色表和权限表中加入相对应的权限和角色
# 9.jsp中
    控制角色 <shiro:hasRole name="admin"></shiro:hasRole> 标签中内容只有包含admin角色的用户才可访问
    控制权限 <shiro:hasPermission name="user:new"></shiro:hasPermission> 标签中内容只有拥有user：new权限的角色的用户才可以访问
    ps：<shiro:lacksRole name="admin"/>意为除去拥有admin角色的用户 <shiro:hasAnyRoles> 意为拥有列表中任意角色的用户均可访问，实则shrio标签
        与<c:if>标签相类似，但更加安全可靠，方便快捷。
    使用前提 需在页面开头导入标签库<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    
    