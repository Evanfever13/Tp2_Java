class PCarte{
    class Carte{
        String a_valeur;

        public Carte(String valeur, a_couleur couleur){
            this.a_valeur = valeur;
            this.a_couleur = couleur;
        }

        public Carte(Carte carte){
            this.a_valeur = carte.a_valeur;
            this.a_couleur = carte.a_couleur;
        }   
        public static void afficher(){
            System.out.println("Valeur : " + this.a_valeur + " Couleur : " + this.a_couleur);
        }

        public static void afficher(Carte carte){
            return System.out.println("Valeur : " + carte.a_valeur + " Couleur : " + carte.a_couleur);
        }

        public static bool equals(Carte){
            return this.a_valeur == carte.a_valeur && this.a_couleur == carte.a_couleur;
        }

        public static void setType(Couleur){
            return a_couleur = Couleur;
        }

        public static void setValeur(){
            return a_valeur = Valeur;
        }
    }

    class Enum a_couleur{
        PIQUE,
        TREFLE,
        COEUR,
        CARREAU
    }
}