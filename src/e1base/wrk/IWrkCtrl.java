package e1base.wrk;

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
 * Cette interface renferme les fonctionnalités du worker à disposition
 * du contrôleur de l'application.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public interface IWrkCtrl {



    /**
     * Cette méthode permet de lire toutes les lignes de texte contenues dans le fichier spécifié en paramètres.
     *
     * @param filepath le chemin complet du fichier texte à utiliser
     * @return null pour tout problème rencontré, respectivement l'ensemble des lignes lues si tout s'est bien passé
     */
    ArrayList<String> readTextFile( String filepath );
}
