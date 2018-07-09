package com.zhenghao.service;

import com.zhenghao.domain.Spitter;
import com.zhenghao.domain.Spittle;

import java.io.Serializable;
import java.util.List;

// 注意：用rmi接口不需要序列号，用hessian接口需要序列化
public class SpitterServiceImpl implements SpitterService,Serializable {

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        System.out.println("getRecentSpittles");
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        System.out.println("saveSpittle");
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        System.out.println("saveSpitter");
    }

    @Override
    public void startFollowing(Spitter follower, Spitter followee) {
        System.out.println("startFollowing");
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        System.out.println("getSpittlesForSpitter");
        return null;
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        System.out.println("getSpittlesForSpitter");
        return null;
    }

    @Override
    public Spittle getSpittleById(long id) {
        System.out.println("getSpittleById");
        return null;
    }

    @Override
    public void deleteSpittle(long id) {
        System.out.println("deleteSpittle");

    }

    @Override
    public List<Spitter> getAllSpitters() {
        System.out.println("getAllSpitters");
        return null;
    }
}
