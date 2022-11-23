package com.example.batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public CafeRepository cafeRepository;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Cafe> reader(){
        return new FlatFileItemReaderBuilder<Cafe>()
                .name("reader")
                .resource(new ClassPathResource("coffee-list.csv"))
                .delimited()
                .names("nombre", "origen", "caracteristica")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>(){{
                    setTargetType(Cafe.class);
                }})
                .build();

        /*JdbcCursorItemReader<Cafe> reader = new JdbcCursorItemReader<>();
        reader.setSql("SELECT nombre as n, origen as o, caracteristica as c FROM cafe");
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);
        reader.setRowMapper(new CafeRowMapper());

        return reader;*/
    }

    @Bean
    public JdbcCursorItemReader<Cafe> readerDataBase(){
        JdbcCursorItemReader<Cafe> reader = new JdbcCursorItemReader<>();
        reader.setSql("SELECT nombre as n, origen as o, caracteristica as c FROM cafe");
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);
        reader.setRowMapper(new CafeRowMapper());

        return reader;
    }

    @Bean
    public Job importUserJob(Step step1){
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(new JobCompletionNotificationListener())
                .flow(step1)
                .next(step2())
                .end()
                .build();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<Cafe, Cafe> chunk(1)
                .reader(reader())
                .processor(new CafeItemProcessor())
                .writer(new CafeItemWriter(cafeRepository))
                .build();
    }

    @Bean
    public Step step2(){
        return stepBuilderFactory.get("step2")
                .<Cafe, Cafe> chunk(1)
                .reader(readerDataBase())
                .processor(new CafeItemProcessor2())
                .writer(new CafeItemWriter(cafeRepository))
                .build();
    }
}
