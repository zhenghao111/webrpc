package rmi.service;

import org.springframework.stereotype.Service;
import rmi.domain.Spitter;
import rmi.domain.Spittle;
import java.util.List;

public class SpitterServiceImpl implements SpitterService {

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
