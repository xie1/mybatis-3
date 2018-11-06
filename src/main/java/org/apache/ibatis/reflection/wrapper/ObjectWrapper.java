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
package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 *
 * 获取/设置对象中指定的属性值
 * @author Clinton Begin
 */
public interface ObjectWrapper {

//  如果ObjectWrapper中封装的是普通的bean对象，则调用相应属性的相应getter方法
//  如果封装的是集合类，则获取指定key或下标对应的value值
  Object get(PropertyTokenizer prop);

  void set(PropertyTokenizer prop, Object value);

//  查找属性表达式指定的属性，第二参数表示是否忽略属性表达式中的下画线
  String findProperty(String name, boolean useCamelCaseMapping);

  String[] getGetterNames();

//  查找可读属性名称集合
  String[] getSetterNames();

  Class<?> getSetterType(String name);

  Class<?> getGetterType(String name);

  boolean hasSetter(String name);

  boolean hasGetter(String name);

//  为属性表达式指定的属性创建相应的MetaObject对象
  MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);
  
  boolean isCollection();
  
  void add(Object element);
  
  <E> void addAll(List<E> element);

}
