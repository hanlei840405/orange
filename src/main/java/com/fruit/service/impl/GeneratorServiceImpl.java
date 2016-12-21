package com.fruit.service.impl;

import com.fruit.service.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by hanlei6 on 2016/12/20.
 */
@Slf4j
@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Value("${zk.url}")
    private String url;

    public Long getId(String entity) {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString(url).retryPolicy(retryPolicy).connectionTimeoutMs(30000).build();
        curatorFramework.start();
        try {
            String path = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/edu/" + entity);
//            DistributedAtomicLong distributedAtomicLong = new DistributedAtomicLong(curatorFramework, path, new RetryOneTime(1));
            return Long.parseLong(path.replace("/edu/" + entity, ""));
        } catch (Exception e) {
            log.error("连接zookeeper失败，无法获取主键");
            return -1L;
        }
    }
}
