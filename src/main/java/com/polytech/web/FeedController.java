package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeedController {

    private PublicationService publicationService;
    private FeedService feedService ;

    //Constructeur avec les deux services, on instancie
    public FeedController(PublicationService publicationService, FeedService feedService) {
        this.publicationService = publicationService;
        this.feedService = feedService;
    }

    //On cree les deux opérations post et feed en utilisant les deux services
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String post (String content) {
        publicationService.share(new Story(content));

        //Apres le post on veut être redirigé vers
        return "redirect:/feed" ;
    }

    //Ici : Display and Viex
    @RequestMapping(value="/feed", method = RequestMethod.GET)
    public String feed(Model model) {

        //Ce qu'on a fetch, on les mets dans une liste stories
        List<Story> stories = feedService.fetchAll();

        //On met dans model la liste stories
        model.addAttribute("stories", stories);


        //Pour afficher on ecrit return feed càd on utilise feed.html
        return "feed";
    }
}
