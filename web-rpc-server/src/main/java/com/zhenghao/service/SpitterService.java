package com.zhenghao.service;



import com.zhenghao.domain.Spitter;
import com.zhenghao.domain.Spittle;

import java.util.List;

public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    void saveSpittle(Spittle spittle);
    void saveSpitter(Spitter spitter);
    void startFollowing(Spitter follower, Spitter followee);
    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spittle getSpittleById(long id);
    void deleteSpittle(long id);
    List<Spitter> getAllSpitters();
}
