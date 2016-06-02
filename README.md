#练习Mybatis
###Mybatis.xml
Mapper接口和对应的xml应该在同一个包下，不然``<mappers><package name="com.henry.mapper"/></mappers>``没用。
###Mapper.xml
``<mapper namespace="com.henry.mapper.StudentMapper"></mapper>``这里的namespace对应接口的位置。

