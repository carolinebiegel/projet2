package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Genres;
import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.security.Utilisateur;
import com.example.projetgroupe.service.ArticleService;
import com.example.projetgroupe.service.MembresService;
import com.example.projetgroupe.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticlesController {



    @Autowired
    private ArticleService articleService;

    @Autowired
    private MembresService membresService;

    @GetMapping("/")
    private String getArticles (Model model, String keyword) {
        List<Articles> listProducts = articleService.findArticleByKeyword(keyword);
        model.addAttribute("listeArticles", listProducts);
        model.addAttribute("keyword", keyword);
        return "affichageListeArticles";
    }





    @GetMapping("/admin/vendre")
    private String getArticleVendre(Model model) {
        model.addAttribute("article", new Articles());
        model.addAttribute("listeGenres", Genres.values());

        majModeleAvecListes(model);
        return "venteArticle";
    }

    // Ajout de la lecture de la photo
    @PostMapping("/admin/vendre")
    private String postArticle(@AuthenticationPrincipal Utilisateur utilisateurConnecte, @Valid Articles article, BindingResult br, Model model,@RequestParam("image") MultipartFile multipartFile) {


        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            majModeleAvecListes(model);
            return "venteArticle";
        }

        // creer le participant via participantService
        try {
            String uploadDir = "src/main/resources/static/images/" ;

            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            article.setPhotos(fileName);



            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

            article.setMembres(utilisateurConnecte.getMembre());
            articleService.addArticle(article);



        }
        // si jamais ca se passe mal
        catch (Exception e) {
            model.addAttribute("article", new Articles());
            majModeleAvecListes(model);
            return "venteArticle";
        }
        return "redirect:/";
    }



    /**
     * Pour ne pas se r??peter, je refactorise mes ajouts de listes au mod??le dans une m??thode ?? part
     */
    private void majModeleAvecListes(Model model) {
        model.addAttribute("listeArticles", articleService.listeArticles());
        model.addAttribute("listeMembres", membresService.listeMembres());
    }

    private void addMembreAuModele(Model model, String membreId) {
        model.addAttribute("membre", membresService.getMembresById(membreId));
    }


}
