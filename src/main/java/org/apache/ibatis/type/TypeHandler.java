/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 类型转换（Java类型转换成JDBC类型，再从结果集中JDBC类型转换成Java类型）
 * @author Clinton Begin
 */
public interface TypeHandler<T> {

//  在通过PreparedStatement为SQL绑定参数时，会将数据由JDBC类型转换成Java类型
  void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;


//  从ResultSet中获取数据时会调用此方法，会将Java类型转换为JDBC类型
  T getResult(ResultSet rs, String columnName) throws SQLException;

  T getResult(ResultSet rs, int columnIndex) throws SQLException;

  T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}
