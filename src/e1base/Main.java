package e1base;

import e1base.ctrl.Ctrl;
import e1base.ihm.Ihm;
import e1base.wrk.Wrk;

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
 * Cette classe implémente le main() de l'application où le contrôleur,
 * l'ihm et le workeur son créés, mis en relation puis démarrés.
 *
 * @author <a href="mailto:mario.ramalho@edufr.ch">Mario Ramalho</a>
 * @version 1.0
 * @since 22.04.2024
 */
public class Main {

    /**
     * Notre implémentation du main() de l'application.
     *
     * @param args les paramètres sur la ligne de commande
     */
    public static void main( String[] args ) {
        Ihm ihm = new Ihm();
        Ctrl ctrl = new Ctrl();
        Wrk wrk = new Wrk();
        ctrl.setRefWrk( wrk );
        ctrl.setRefIhm( ihm );
        ihm.setRefCtrl( ctrl );
        ctrl.start();
    }
}
