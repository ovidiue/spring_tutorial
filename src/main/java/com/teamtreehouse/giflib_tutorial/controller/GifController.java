package com.teamtreehouse.giflib_tutorial.controller;

import com.teamtreehouse.giflib_tutorial.data.GifRepository;
import com.teamtreehouse.giflib_tutorial.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ovidiu on 01-Mar-18.
 */

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap) {
        List<Gif> all_favs = gifRepository.getAllFavorites();
        modelMap.put("gifs", all_favs);
        return "favorites";
    }

    @RequestMapping("/search")
    public String searchedGifs(@RequestParam("q") String searchTerm, ModelMap modelMap) {
        List<Gif> searchResults = gifRepository.searchByName(searchTerm);
        modelMap.put("gifs", searchResults);
        return "home";
    }
}
