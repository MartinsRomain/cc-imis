TD Noté IMIS - 2022
==
Description
-
Vous devez compléter une application de gestion de clientèle.
Le schéma UML est fourni (fichier imis.png).
A vous de l'implanter en java et de coder les méthodes permettant de l'exploiter.

**Remarques:**
- **Les noms des attributs-relations ne sont pas indiqués. A vousnde choisir.**
- **Les clés ne sont pas nécessairement mentionnées. A vous de choisir l'attribut clé ou de l'ajouter.**

On gère une liste de clients (entreprises). Pour chaque entreprise on dispose d'informations générales et d'une liste de contacts. A chaque contact on attache une fonction.

On liste les dates d'échange avec les différents contacts (date, nature de l'échange, personne(s) de notre entreprise, personne(s) de l'entreprise client, compte rendu écrit).
Les "natures d'échanges" indiquent la modalité (téléphone, mail, courrier, visite...) prise dans une liste préétablie.

Pour chaque entreprise on associe une liste de mot-clés (qui peuvent concerner leur domaine d'activité, leur taille,...).

On gère la liste des ventes (date, montant global, nature -sous forme de simple texte-).

On souhaite :
- ajouter une entreprise
- ajouter une fonction
- ajouter un contact à une entreprise avec une fonction
- avoir la liste des entreprises attachées à un certain mot-clé (nom de l'entreprise; le mot-clé recherché peut être un sous-mot-clé).
- identifier l'entreprise dans laquelle on a le plus de contacts (personnes)

Consignes
-

- Les FETCH EAGER sont interdits
- Vous devez compléter les entities et les services.
- Vous devez ajouter dans les pages web les morceaux manquants (essentiellement accès aux champs).
- Dans le contrôleur les méthodes sont fournies mais vous devez les compléter.
- Il n'y a a prori rien à faire dans les vues.

- Vous pouvez utiliser Lombok
- Vous pouvez utiliser des dtos mais ce n'est pas obligatoire
- Vous pouvez utiliser spring data jpa (les repositories) si vous le souhaitez
- Vous pouvez créer à la main des classes "DAO" si vous le souhaitez

