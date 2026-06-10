# Examen_JavaAdvanced

#  PARTIE	01	Design Patterns

Singleton · Builder · Decorator · Factory Method · Bridge · State · Chain of Responsibility — 35 points

## A. Singleton — le serveur de jeu [5 pts]

* Q1 : Pourquoi le mot-clé `volatile` est-il indispensable sur l'instance dans le Double- Checked Locking ?

    * R1 : Sans le mot-clé `volatile`, le processeur ou le compilateur peut réorganiser ces étapes. Ainsi, un autre thread pourrait considérer l'instance comme étant déjà initialisée avant que l'objet ne soit entièrement créé et utiliser un objet corrompu. Le mot-clé `volatile` empêche cette réorganisation.

* Q2 : Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est- elle préférable ?

    * R2 : 

* CODE : src/main/java/partie1/GameServer.java

## B. Builder — créer un personnage [6 pts]

On veut créer des personnages de jeu avec de nombreuses propriétés optionnelles. Le constructeur classique devient vite illisible.

* CODE : src/main/java/partie1/Personnage.java

## C. Factory Method — forger une arme [5 pts]

Contexte. Un Forgeron (classe abstraite) sait forger une arme, mais c'est la sous-classe qui décide laquelle.

* CODE : src/main/java/partie1/Forgeron.java

## D. Decorator — améliorer une potion [6 pts]

Contexte. Une PotionDeBase restaure 50 PV. On veut lui ajouter des effets supplémentaires par composition.

* CODE : src/main/java/partie1/Potion.java

## E. Bridge — système de notification [6 pts]

Contexte. On veut envoyer des notifications (Urgente, Normale) via différents canaux (Email, SMS). Le Bridge découple le type du canal.

* CODE : src/main/java/partie1/Notification.java

## F. State — le personnage et ses états [7 pts]

Contexte. Un personnage peut être dans 3 états : Vivant, Empoisonné, Mort. Son comportement change selon l'état.

* Q1 : Quelle est la différence entre le pattern State et un simple if/else sur un attribut enum ? Donne un avantage concret du State dans ce contexte.

    * R1 : À mesure que la classe de personnages s'étoffe, ces blocs deviennent plus complexes ; pour ajouter un nouvel état, il faut modifier un par un tous les blocs if/else.
Avec State, chaque état est logé dans sa propre classe. Si tu souhaites ajouter un nouvel état, il te suffit de créer une nouvelle classe, sans toucher au code existant. 

* Example : Si tu veux ajouter un état « paralysé », il te suffit d'écrire la classe EtatParalyse. Tu ne touches à aucune des autres classes (EtatVivant, EtatMort, etc.). Avec des instructions if/else, tu devrais modifier chaque bloc individuellement.

* CODE : src/main/java/partie1/EtatPersonnage.java

# PARTIE 02	Génériques, Lambdas & Streams
Types génériques · Interfaces fonctionnelles · Stream API · Optional — 30 points

## A. Classe et méthodes génériques [8 pts]

* Q1 : Implémente la classe Paire<A,B> qui stocke deux valeurs de types différents.

    * CODE : src/main/java/partie2/Paire.java

* Q2 : Implémente les méthodes génériques suivantes dans OutilsGeneriques. 

    * CODE : src/main/java/partie2/OutilsGeneriques.java


## B. Interfaces fonctionnelles & lambdas [8 pts]

* Q1 : Définis l'interface fonctionnelle Transformation<T> avec une méthode appliquer(T valeur) retournant T.

    * CODE : src/main/java/partie2/Transformation.java

* Q2 : Dans LambdaFactory, implémente les méthodes suivantes en utilisant des lambdas.

    * CODE : src/main/java/partie2/LambdaFactory.java

## C. Stream API [14 pts]

Contexte. On travaille sur une liste de produits d'une boutique en ligne :

* Q1 : Implémente toutes les méthodes ci-dessous en une chaîne Stream. Pas de boucle for.

    * CODE : src/main/java/partie2/BoutiqueService.java

# PARTIE 03	Réflexion & Annotations
Annotations custom · Introspection · Traitement par réflexion — 25 points

## A. Créer ses propres annotations [6 pts]

Définis les annotations suivantes qui serviront de base aux exercices B et C.

* CODE : src/main/java/partie3/Entite.java
* CODE : src/main/java/partie3/Colonne.java
* CODE : src/main/java/partie3/Loggable.java

## B. Introspection par réflexion [10 pts]

Contexte. La classe Joueur (fournie) utilise tes annotations :

* CODE : src/main/java/partie3/Inspecteur.java
* CODE : src/main/java/partie3/Joueur.java

## C. Générateur de requête SQL par réflexion [9 pts]

Contexte. En t'appuyant sur tes annotations, génère automatiquement des requêtes SQL à partir d'un objet Java.

* CODE : src/main/java/partie3/GenerateurSQL.java

* Q1 : Pourquoi faut-il appeler field.setAccessible(true) avant field.get(objet)
pour les champs privés ?

    * R1 : Par défaut, Java interdit l'accès aux champs private même via la réflexion. Sans setAccessible(true), appeler field.get(objet) lève une IllegalAccessException. setAccessible(true) lève cette restriction et permet de lire ou modifier le champ privé depuis l'extérieur de la classe.

* Q2 : Cite un risque de sécurité lié à l'utilisation de setAccessible() en production.

    * R1 : Un code malveillant peut utiliser setAccessible(true) pour lire des champs private sensibles comme des mots de passe ou des clés de chiffrement, contournant totalement l'encapsulation et les contrôles d'accès de la classe.

# PARTIE 04	I/O, Regex & REST

Fichiers · Expressions régulières · Mini-framework HTTP — 10 points

## A. Gestion de fichiers CSV [4 pts]

Implémente un gestionnaire de sauvegarde de scores au format CSV (une ligne par joueur : pseudo,score).

* CODE : src/main/java/partie4/ScoreManager.java

## B. Validation & extraction par regex [4 pts]

* CODE : src/main/java/partie4/ValidateurJeu.java

## Étendre le mini-framework REST [2 pts]

Contexte. Le projet contient un mini-framework REST maison basé sur les annotations @Rest, @Get, @Post et @QueryParam. Il démarre un serveur HTTP et route les requêtes par réflexion.

* CODE : src/main/java/partie4/ScoreController.java

* Q1 : Le RestEngine lit les annotations @Rest, @Get, @Post via réflexion pour construire la table de routage. Explique en 3 lignes comment fonctionne ce mécanisme.

    * R1 : Au démarrage, le RestEngine parcourt les classes annotées @Rest pour extraire le chemin de base. Il itère ensuite sur leurs méthodes et enregistre celles annotées @Get ou @Post dans une table de routage (Map<String, Method>). À chaque requête entrante, il cherche le chemin dans cette table et invoque la méthode correspondante via method.invoke().


Yarkin ONER
