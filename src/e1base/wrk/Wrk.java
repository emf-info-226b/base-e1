package e1base.wrk;

import e1base.wrk.flux.WrkTextFile;
import e1base.wrk.flux.serialisation.WrkObjectFile;
import java.io.File;
import java.util.ArrayList;

//
// ######################################################################
// #                        _       _        ____  ____   __            #
// #        /\/\   ___   __| |_   _| | ___  |___ \|___ \ / /_           #
// #       /    \ / _ \ / _` | | | | |/ _ \   __) | __) | '_ \          #
// #      / /\/\ \ (_) | (_| | |_| | |  __/  / __/ / __/| (_) |         #
// #      \/    \/\___/ \__,_|\__,_|_|\___| |_____|_____|\___/  RAM     #
// #                        __                                          #
// #                       |_   |    /  \  \_/                          #
// #                       |    |__  \__/  / \                          #
// #                                                                    #
// ######################################################################
// # Projet de base pour l'évaluation E1 pour le module 226b.           #
// # Il contient une interface de base soignée permettant de démarrer.  #
// ######################################################################
// # Ecrit par # Mario Ramalho      # VERSION # 1.0 # DATE # 02.05.2024 #
// ######################################################################
//
/**
 * Cette classe renferme le worker principal de l'application. Elle délègue
 * quasiment toutes les opérations sur les fichiers à ses workers spécialisés
 * sur les flux texte, flux binaires et sérialisation.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public class Wrk implements IWrkCtrl {

    /**
     * Worker spécialisé sur les fichiers texte.
     */
    private WrkTextFile wrkTextFile;
    /**
     * Worker spécialisé sur la sérialisation.
     */
    private WrkObjectFile wrkObjectFile;
    
    /**
     * Votre base de données de votre objet
     */
    private ArrayList<?> baseDonnees;

    /**
     * Le constructeur de notre worker principal.
     */
    public Wrk() {
        wrkTextFile = new WrkTextFile();
        wrkObjectFile = new WrkObjectFile();
    }

    /**
     * Cette méthode permet de lire toutes les lignes de texte contenues dans le
     * fichier spécifié en paramètres.
     *
     * @param filepath le chemin complet du fichier texte à utiliser
     * @return null pour tout problème rencontré, respectivement l'ensemble des
     * lignes lues si tout s'est bien passé
     */
    public ArrayList<String> readTextFile(String filepath) {
        return getWrkTextFile().readTextFile(filepath);
    }

    /**
     * Getter de notre worker spécialisé sur les fichiers texte.
     *
     * @return notre worker spécialisé sur les fichiers texte
     */
    public WrkTextFile getWrkTextFile() {
        return wrkTextFile;
    }

    /**
     * Getter de notre worker spécialisé sur la sérialisation.
     *
     * @return notre worker spécialisé sur la sérialisation
     */
    public WrkObjectFile getWrkObjectFile() {
        return wrkObjectFile;
    }

}
