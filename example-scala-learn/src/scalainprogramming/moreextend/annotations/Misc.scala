package scalainprogramming.moreextend.annotations

/*
 * Copyright (C) 2007-2008 Artima, Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Example code from:
 *
 * Programming in Scala (First Edition, Version 6)
 * by Martin Odersky, Lex Spoon, Bill Venners
 *
 * http://booksites.artima.com/programming_in_scala
 */
// 注解是添加到程序源代码的结构化信息
// @注解类(参数列表)
// 标准注解----@deprecated、@volatile、@transient、@serializable、@SerialVersionUID、@unchecked
object Misc {
  @deprecated def bigMistake() = //...
    "bigMistake"

  @deprecated class QuickAndDirty {
    //...
  }

  class Q {}

  def unchecked(e: Any) {
    (e: @unchecked) match {
      case "foo" => println("foo")
    }
  }

  def main(args: Array[String]) {
    bigMistake()
  }
}