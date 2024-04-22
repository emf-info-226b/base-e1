package e1base.wrk.flux;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
 * Cette classe renferme les fonctionnalités permettant d'écrire et de lire du texte dans des fichiers à l'aide des flux
 * de type texte.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public class WrkTextFile {

    /**
     * Cette constante spécifie l'encodage à utiliser lors de l'écriture et la lecture du fichier texte. Il est très
     * important de toujours spécifier afin d'éviter de dépendre de la valeur par défaut qui est justement dépendante de
     * la plateforme, voir même la version de Java.
     */
    public final static Charset TEXT_FILE_CHARSET = StandardCharsets.UTF_8;

    /**
     * Lit et retourne l'ensemble des lignes présentes dans un fichier texte. En cas de problème(s) rencontré aucune
     * ligne ne sera retournée (null) de manière à ce qu'on puisse s'en rendre compte.
     *
     * @param filepath le chemin complet du fichier texte à lire
     *
     * @return l'ensemble des lignes du fichier texte, ou null en cas de problème(s) rencontré(s)
     */
        public ArrayList<String> readTextFile( String filepath ) {

            return null;
        }

}
