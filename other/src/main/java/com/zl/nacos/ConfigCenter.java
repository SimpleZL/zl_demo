package com.zl.nacos;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-14
 */
@Slf4j
public class ConfigCenter {
    public static void main(String[] args) {

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "supply");

}}
