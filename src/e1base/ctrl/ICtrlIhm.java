package e1base.ctrl;

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
 * Cette interface renferme les fonctionnalités du contrôleur de l'application à
 * disposition de l'ihm.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public interface ICtrlIhm {

    /**
     * Cette méthode est appelée par l'ihm pour indiquer qu'elle est en train de
     * se fermer.
     */
    void ihmExiting();

    /**
     * Cette méthode est appelée par l'ihm pour que le fichier texte passé en
     * paramètres soit lu et enregistré dans la base de données.
     *
     * @param filepath le chemin complet du fichier texte qui doit être lu
     */
    void readTextBaseFile(String filepath);

    /**
     * Cette méthode est appelée par l'ihm pour que le fichier de correction
     * passé en paramètres soit lu et enregistré dans la base de données.
     *
     * @param filepath le chemin complet du fichier texte qui doit être lu
     */
    void readTexCorrectionFile(String filepath);
    
    /**
     * Cette méthode est appelée par l'ihm pour que la méthode 2 de votre
     * programme soit exécutée.
     *
     * @param param le paramètre sous forme de chaîne de caractère
     */
    void executeMethod2(String param);

}
