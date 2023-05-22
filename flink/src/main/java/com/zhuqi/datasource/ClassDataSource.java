/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zhuqi.datasource;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author zhuqi at 2021/11/8
 */
public class ClassDataSource {

    public static void main(String[] args) throws Exception {

        // 每个 Flink 应用都需要有执行环境，在该示例中为 env。流式应用需要用到 StreamExecutionEnvironment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Person> flintstones = env.fromElements(
                new Person("zhuqi", 33),
                new Person("qinxue", 30),
                new Person("ruirui", 6)
        );

        // DataStream API 将你的应用构建为一个 job graph，并附加到 StreamExecutionEnvironment 。
        // 当调用 env.execute() 时此 graph 就被打包并发送到 JobManager 上，后者对作业并行处理并将其子任务分发给 Task Manager 来执行。
        // 每个作业的并行子任务将在 task slot 中执行。
        SingleOutputStreamOperator<Person> adults = flintstones.filter(new FilterFunction<Person>() {
            @Override
            public boolean filter(Person value) throws Exception {
                return value.age >= 18;
            }
        });
        

        // sink 打印其结果到 task manager 的日志中（如果运行在 IDE 中时，将追加到你的 IDE 控制台）。它会对流中的每个元素都调用 toString() 方法。
        adults.print();

        env.execute("zhuqi_test_flink");


    }


    public static class Person {
        public String name;
        public Integer age;

        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
