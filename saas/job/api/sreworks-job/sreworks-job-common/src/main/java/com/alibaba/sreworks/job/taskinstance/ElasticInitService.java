package com.alibaba.sreworks.job.taskinstance;

import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ElasticInitService {

    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder) {
        return new RestHighLevelClient(restClientBuilder.setHttpClientConfigCallback(requestConfig ->
            requestConfig.setKeepAliveStrategy((response, context) -> TimeUnit.MINUTES.toMillis(3))));
    }

}
