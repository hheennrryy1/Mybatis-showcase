#练习Mybatis
###Mybatis.xml
Mapper接口和对应的xml应该在同一个包下，不然``<mappers><package name="com.henry.mapper"/></mappers>``没用。
###Mapper.xml
###namespace
``<mapper namespace="com.henry.mapper.StudentMapper"></mapper>``这里的namespace对应接口的位置。
###${}和#{}
执行SQL：Select * from emp where name = #{employeeName}  
参数：employeeName=>Smith  
解析后执行的SQL：Select * from emp where name = ?  
执行SQL：Select * from emp where name = ${employeeName}  
参数：employeeName传入值为:Smith  
解析后执行的SQL：Select * from emp where name =Smith  

如果类的属性名和数据库的字段名不一致，在sql语句中使用as.
###动态SQL

####if
	<select id="findActiveBlogWithTitleLike"
	     resultType="Blog">
	  SELECT * FROM BLOG 
	  WHERE state = ‘ACTIVE’ 
	  <if test="title != null">
	    AND title like #{title}
	  </if>
	</select>
###choose,when,otherwise
	<select id="findActiveBlogLike"
	     resultType="Blog">
	  SELECT * FROM BLOG WHERE state = ‘ACTIVE’
	  <choose>
	    <when test="title != null">
	      AND title like #{title}
	    </when>
	    <when test="author != null and author.name != null">
	      AND author_name like #{author.name}
	    </when>
	    <otherwise>
	      AND featured = 1
	    </otherwise>
	  </choose>
	</select>
####where
where 元素知道只有在一个以上的if条件有值的情况下才去插入“WHERE”子句。而且，若最后的内容是“AND”或“OR”开头的，where 元素也知道如何将他们去除。
###set
set 元素会动态前置 SET 关键字，同时也会消除无关的逗号，因为用了条件语句之后很可能就会在生成的赋值语句的后面留下这些逗号。

	<update id="updateAuthorIfNecessary">
	  update Author
	    <set>
	      <if test="username != null">username=#{username},</if>
	      <if test="password != null">password=#{password},</if>
	      <if test="email != null">email=#{email},</if>
	      <if test="bio != null">bio=#{bio}</if>
	    </set>
	  where id=#{id}
	</update>
###foreach
	public List<Student> queryStudent(List<Integer> list);
	
	 	<select id="queryStudent" resultMap="studentResult" parameterType="int">
			select id, name, birthday as brith 
			from student 
			where id in 
			<foreach collection="list" item="item" open="(" separator="," close=")">
				#{item}
			</foreach> 
		</select>
###bind
	<select id="selectStudentByName" resultMap="studentResult" parameterType="Student">
		<bind name="pattern" value="'%' + _parameter.getName() + '%'"/>
		select id, name, birthday as brith from student where name like #{pattern} 
	</select>
	
	public List<Student> selectStudentByName(Student student);
###一对多查询
两个表的id字段名不能都为id，不然多的一方结果集只有一条
###一级缓存
当 Session flush 或 close 之后，该Session中的所有 Cache 就将清空。
###二级缓存
在mapper.xml加入<cache/>，可自定义存储源，如 Ehcache。
