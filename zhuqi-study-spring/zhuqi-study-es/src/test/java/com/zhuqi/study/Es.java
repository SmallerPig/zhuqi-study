package com.zhuqi.study;

import com.zhuqi.study.es.BootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuqi at 2020/12/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class Es {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 测试:index
     */
    @Test
    public void test(){

        Student student = new Student();
        student.setId(10003L);
        student.setAge(33);
        student.setName("zhuqi---ddd");

        IndexQuery build = new IndexQueryBuilder().withObject(student).build();
//        elasticsearchRestTemplate.index()
        elasticsearchRestTemplate.index(build, IndexCoordinates.of("student"));


        Student student1 = elasticsearchRestTemplate.get("10003", Student.class, IndexCoordinates.of("student"));
        System.out.println("student = " + student);
        System.out.println("student1 = " + student1);
        Assert.assertEquals(student.getAge(), student1.getAge());
    }
}
