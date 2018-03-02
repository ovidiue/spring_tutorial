package com.teamtreehouse.giflib_tutorial.data;

import com.teamtreehouse.giflib_tutorial.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ovidiu on 01-Mar-18.
 */

@Component
public class GifRepository {
    public static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 1, LocalDate.of(2015, 2, 13), "Chris Ramacciotti", true),
            new Gif("ben-and-mike", 2, LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
            new Gif("book-dominos", 3, LocalDate.of(2015, 9, 15), "Craig Dennis", false),
            new Gif("compiler-bot", 3, LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 1, LocalDate.of(2015, 2, 13), "Grace Hopper", false),
            new Gif("infinite-andrew", 2, LocalDate.of(2015, 8, 23), "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }

        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> list = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id) {
                list.add(gif);
            }
        }

        return list;
    }

    public List<Gif> getAllFavorites() {
        List<Gif> favs = new ArrayList<>();
        for (Gif g : ALL_GIFS) {
            if (g.isFavorite()) {
                favs.add(g);
            }
        }

        return favs;
    }

    public List<Gif> searchByName(String searchTerm) {
        List<Gif> results = new ArrayList<>();
        for (Gif g : ALL_GIFS) {
            if (g.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(g);
            }
        }
        return results;
    }
}

