                                                    PROJET COMPETITION VERSION 2

# But du projet


Le but du projet est de concevoir une application java qui permet de jouer des competitions qui peuveut être des tournois ou des league.
Les matchs de ces differentes competitions peuvent varier, en effet il peut y avoir des matchs où les competiteurs qui s'affrontes sont choisis au hasard, ou pipés etc .

Le but de ce projet est aussi de savoir faire une bonne conception objet notament en appliquant le principe SOLID et les design pattern.
Il faudra tenir compte des changement possible de l'utilisation du code de départ.

# Récuperer le dépot


Sur la console, placez vous où vous voulez déposer le dossier clonné.

Tapez la commande : 

`git clone https://gitlab-etu.fil.univ-lille1.fr/ghelani/projetcoo-gestion-des-competitions`


# Génerer la documentation

On veut génerer la documentation pour les packages 'competition' et 'util' que l'on place dans un dossier _doc_ à la racine du projet.

1. Se placer dans le dossier _src_ à la racine du projet. 

2. Tapez la commande suivante :
     
`javadoc -d ../doc competition/*.java competition/*/*.java util`


# Génerer l'archive du projet

### Première étape : Compiler les fichiers sources


1. Se placer dans le dossier src à la racine du projet

2. On va compiler tous les fichiers sources java et les placer à la racine du projet dans le dossier 'classes'
 
    `javac competition/*.java competition/*/*.java util/*.java`
    

### Deuxième Etape : Génération de l'archive executable

1. Se placer à la racine du projet

2. Tapez la commande :

`jar cvmf MANIFEST.MF competition.jar classes/competition/*.class classes/competition/*/*.class classes/util/*.class`


# Executer l'archive

1. Se placer dans le *même dossier* que celui de l'archive competition.jar

2. Tapez la commande :

`java -jar competition.jar`


# Diagramme UML (VOIR SUR LA BRANCHE MASTER)



# Elements de conception intérressant


1. Toutes les compétitions hérite de la classe abstraite Competition et ne redefinissent que deux méthodes abstraites qui sont playAllMatchs() et displayWelcome().
PlayAllMatchs fait dérouler l'ensemble des matchs selon une certaine logique, mais playMatch() qui permet de jouer un seul match est commune a toutes les classes filles de Competition. Donc si on veut ajouter un type de competition, il faut seulement définir la maniere dont on joue tout les matchs (la logique du jeu). 
Ainsi, créer une nouvelle competition est rapide (on a que deux méthodes a définir) et facile à tester car on n'a que peu de methodes propres à la classe fille.
 **Template Method Pattern**

2. Il existe un Builder (CompetitionBuilder) qui permet de créer des instances de sous-type de competition sans avoir à renseigner tous les parametres. **Pattern Builder**
   Il permet de créer des instances de League, Tournament et Master.

3. Il existe une interface Displayer qui permet d'afficher toutes les actions affichable d'une competition, la classe abstraite Competition utilise ce type pour afficher des  messages, un match ou encore la table des score. Pour l'instant il existe qu'une classe qui implemente cette interface, c'est la classe StdDisplayer qui affiche sur la console. **Pattern Decorator**
De plus on respecte le principe _OCP et LSP_.

4. La classe abstraite Competition peut jouer avec n'importe quel type de match tant qu'il implémente la classe abstraite Match. Principe OCP et LSP.
   Pour la classe Match on utilise le **template method pattern**.

5. Il existe une classe abstraite nommée _FinalistsSelector_ qui permet de selectionner les finalistes pour la deuxieme phase d'un Master. 
   Comme le nombre de finalistes quoi être une puissance de 2 et que c'est ici que l'on définit les finalistes, c'est cette classe qui doit nous donner le nombre de poule à créer pour la première phase du Master.
   Pour créer un selecteur il faut implementer cette classe abstraite et de définir la methode abstraite _getPoolFinalists_ qui renvoie les finalistes d'une poule(selon la table des scores qu'elle reçoit) et la methode  _getNbOfPools_ qui définit le nombre de poule à avoir (Pour avoir un nb de finaliste qui soit une puissance 2).
   On utilise le **template method pattern** ici aussi.


6. Pour tester les classes filles de Competition (League, Master, Tournament) on a :
   1. Une classe abstraite CompetitionTest avec ses propre tests
   2. Des classes LeagueTest, MasterTest et TournamentTest qui hérite de la classe CompetitionTest
   3. Une **factory method** qui est définit dans les classes filles pour appliquer les tests sur la bonne instance
   4. L'avantage est que les tests des classes filles sont très court.

7. Chaque methode a une responsabilité unique. Facile à tester. Principe _SRP_.







