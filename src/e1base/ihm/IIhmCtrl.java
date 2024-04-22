package e1base.ihm;

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
 * Cette interface renferme les fonctionnalités de l'ihm à disposition du
 * contrôleur de l'application.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public interface IIhmCtrl {

    /**
     * Cette méthode permet de rendre l'ihm visible à l'écran.
     */
    void display();

    /**
     * Cette méthode permet d'afficher un message d'information à l'utilisateur.
     *
     * @param message le message à afficher
     */
    void showInformationMessage(String message);

    /**
     * Cette méthode permet d'afficher un message d'erreur à l'utilisateur.
     *
     * @param message le message à afficher
     */
    void showErrorMessage(String message);

    /**
     * Cette méthode permet de poser une question à l'utilisateur à laquelle il
     * devra répondre par oui ou par non.
     *
     * @param message la question à afficher
     * @return true si l'utilisateur presse le bouton "oui", sinon false
     */
    boolean askYesNoQuestion(String yesNoQuestion);

    /**
     * Cette méthode permet de demander la saisie d'une chaîne de caractères à
     * l'utilisateur.
     *
     * @param message la question
     * @return la chaîne que l'utilisateur a entrée, null s'il annule
     * l'opération
     */
    String askTextString(String message);

    /**
     * Cette méthode remplace le contenu de notre zone d'édition multiligne de
     * texte (notre JTextArea) par les lignes passées en paramètre.
     *
     * @param lignes les lignes à afficher
     */
    void setTextContent(ArrayList<String> lignes);

    /**
     * Cette méthode affiche le résultat de la méthode 2 dans l'IHM
     *
     * @param result le résultat à afficher
     */
    void setResultMethod2(String result);

}
