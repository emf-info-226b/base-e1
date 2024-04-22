package e1base.ctrl;

import e1base.ihm.IIhmCtrl;
import e1base.wrk.IWrkCtrl;
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
 * Cette classe renferme l'implémentation du contrôleur de l'application.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public class Ctrl implements ICtrlIhm {

    /**
     * La référence au worker principal de l'application.
     */
    private IWrkCtrl refWrk;
    /**
     * La référence à l'ihm de l'application.
     */
    private IIhmCtrl refIhm;

    /**
     * La méthode permettant de faire démarrer l'application. Il sera nécessaire
     * de désérialisé du fichier pour l'insérer dans la base de données.
     */
    public void start() {
        getRefIhm().display();

    }

    /**
     * Cette méthode est appelée par l'ihm pour indiquer qu'elle est en train de
     * se fermer. Il sera nécessaire de sérialisé le contenu de la base de
     * données pour sérialisé le fichier.
     */
    public void ihmExiting() {
    }

    /**
     * Cette méthode est appelée par l'ihm pour que le fichier texte passé en
     * paramètres soit lu et enregistré dans la base de données.
     *
     * @param filepath le chemin complet du fichier texte qui doit être lu
     */
    public void readTextBaseFile(String filepath) {

    }

    /**
     * Cette méthode est appelée par l'ihm pour que le fichier de correction
     * passé en paramètres soit lu et enregistré dans la base de données.
     *
     * @param filepath le chemin complet du fichier texte qui doit être lu
     */
    public void readTexCorrectionFile(String filepath) {

    }

    /**
     * Cette méthode est appelée par l'ihm pour que la méthode 2 de votre
     * programme soit exécutée.
     *
     * @param param le paramètre sous forme de chaîne de caractère
     */
    public void executeMethod2(String param) {
        
    }

    /**
     * Getter de la référence au worker principal de l'application.
     *
     * @return la référence au worker principal de l'application
     */
    public IWrkCtrl getRefWrk() {
        return refWrk;
    }

    /**
     * Setter de la référence au worker principal de l'application.
     *
     * @param refWrk la nouvelle référence au worker principal de l'application
     */
    public void setRefWrk(IWrkCtrl refWrk) {
        this.refWrk = refWrk;
    }

    /**
     * Getter de la référence à l'ihm de l'application.
     *
     * @return la référence à l'ihm de l'application.
     */
    public IIhmCtrl getRefIhm() {
        return refIhm;
    }

    /**
     * Setter de la référence à l'ihm de l'application.
     *
     * @param refWrk la nouvelle référence à l'ihm de l'application
     */
    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

}
