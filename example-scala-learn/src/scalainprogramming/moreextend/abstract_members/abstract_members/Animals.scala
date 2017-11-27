package scalainprogramming.moreextend.abstract_members.abstract_members

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

object Animals {

  class Food

  abstract class Animal {
    // 上界
    // 抽象类型 极好
    type SuitableFood <: Food

    def eat(food: SuitableFood)
  }

  class Grass extends Food

  class Cow extends Animal {
    // 路径依赖类型----类型依赖于路径
    // 类型的拥有者为对象
    type SuitableFood = Grass

    override def eat(food: Grass) {
      println(food.getClass)
    }
  }

  def main(args: Array[String]) {
    val cow = new Cow
    cow.eat(new Grass)
  }

}