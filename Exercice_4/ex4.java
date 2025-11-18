package Exercice_4;

public class ex4{
    static class Carte{
        a_valeur a_valeur;
        a_couleur a_couleur;

        public Carte(a_valeur valeur, a_couleur couleur){
            this.a_valeur = valeur;
            this.a_couleur = couleur;
        }

        public Carte(Carte carte){
            this.a_valeur = carte.a_valeur;
            this.a_couleur = carte.a_couleur;
        }   

        public void afficher(){
            System.out.println("Valeur : " + this.a_valeur + " Couleur : " + this.a_couleur);
        }

        public static void afficher(Carte carte){
            System.out.println("Valeur : " + carte.a_valeur + " Couleur : " + carte.a_couleur);
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (!(obj instanceof Carte)) return false;
            Carte carte = (Carte) obj;
            return this.a_valeur == carte.a_valeur && this.a_couleur == carte.a_couleur;
        }

        public void setType(a_couleur couleur){
            this.a_couleur = couleur;
        }

        public void setValeur(a_valeur valeur){
            this.a_valeur = valeur;
        }
    }
    
    enum a_couleur{
        PIQUE,
        TREFLE,
        COEUR,
        CARREAU;
    }

    enum a_valeur{
        ROI,
        DAME,
        VALET,
        AS,
        DEUX,
        TROIS,
        QUATRE,
        CINQ,
        SIX,
        SEPT,
        HUIT,
        NEUF,
        DIX;
    }
    public static void main(String[] args){
        Carte Ma_Carte = new Carte(a_valeur.ROI, a_couleur.PIQUE);
        Carte.afficher(Ma_Carte);
        Ma_Carte.setValeur(a_valeur.AS);
        Ma_Carte.setType(a_couleur.COEUR);
        Ma_Carte.afficher();
        Carte a_Carte2 = new Carte(Ma_Carte);
        a_Carte2.afficher();
    }
}