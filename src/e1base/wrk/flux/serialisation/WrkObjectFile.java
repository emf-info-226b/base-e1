package e1base.wrk.flux.serialisation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 * Cette classe renferme les fonctionnalités permettant de
 * sérialiser/désérialiser des objets de toute nature.
 * <p>
 * Le code utilise les exceptions de manière optimale afin de garantir le
 * fonctionnement demandé.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public class WrkObjectFile {


    /**
     * Cette fonction sérialise l'objet passé en paramètre dans un fichier.
     *
     * @param filepath le chemin complet du fichier à utiliser
     * @param obj      l'objet a sérialiser
     *
     * @return l'objet a-t-il été correctement sérialisé ?
     */
    public boolean serialiseObjet( String filepath, Object obj ) {

      return false;
    }

    /**
     * Cette fonction desérialise un objet précédemment sérialisé dans un
     * fichier.
     *
     * @param filepath le chemin complet du fichier à utiliser
     *
     * @return l'objet s'il a été correctement désérialisé, sinon null
     */
    public Object deserialiseObjet( String filepath ) {
        
        return null;
    }
}
