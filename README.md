springboot整合shardingsphere5.3.1 实现分表和读写分离
MySQL地址端口自行修改

sharding-all.yaml  分表+读写分离配置

sharding-readwrite.yaml  读写分离配置

sharding-tables-inline.yaml inline算法分表配置

sharding-tables-mod.yaml mod算法分表配置

分库配置暂未实现，可参考官方文档 https://shardingsphere.apache.org/document/5.3.1/en/user-manual/shardingsphere-jdbc/yaml-config/rules/sharding/
