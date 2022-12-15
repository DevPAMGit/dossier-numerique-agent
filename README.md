
# Dossier Numérique de l'Agent
## Objectifs
Le but de ce projet est de gérer numériquement les dossiers des agents du département du Nord. Ceux-ci sont générés par un applicatif appelé Pléiades et doivent ensuite être stocké dans une **GED** (*pour Gestion Electronique Documentaire*) Alfresco pour poursuivre des traitements supplémentaires si besoin tel que la mise en signature électronique de documents, leurs archivages etc...

## Mise en place
### Contraintes et préconisations technique
Comme indiqué plus tôt nous utilisons une GED Alfresco pour la gestion des documents et celle-ci vient avec quelques   
préconisations à prendre en compte lors de la mise en place de notre projet.
1. Il est préconisé de ne pas afficher plus de cinq cent dossiers/fichiers sur une page de consultation.

### Contraintes et règles métier
*A remplir si besoin*

## Modèles
**Alfresco est une GED qui enrichit ses nœuds (fichiers/dossiers) de métadonnées qui seront inclus dans des types ou aspects**. Ces métadonnées sont des informations complémentaires sur le document permettant en back (côté serveur) de les **utiliser comme discriminant pour une gestion d'actions ou de workflow**.

Pour gérer le dossier numérique de l'agent, nous avons créé types et aspects qui suivent.

### Le modèle "*Agent*"
Un document concerne un agent. En conséquence, nous avons créé un modèle **agent (*agent59:agent*)**. Ce modèle comporte **deux aspects**: celui comportant ** les données de base d'un agent (*agent59:agentBase*)** et celui comportant **les données d'identité de l'agent (*agent59:agentIdentite*)**.

### Le modèle "*Pléiades*"
Les documents avant d'être stockés ont une vie au sein d'un applicatif appelé *Pléiades*. Ces données nous serviront  tout d'abord au **stockage des documents**.

Selon le type/groupement/famille le document sera à classer dans un dossier du plan de classement.

Ensuite, elles serviront au **débogage**, ces données devront nous permettre de **définir la chaîne de traitement** et **l'origine du document**.

Pour cela, nous avons créer un modèle **pléiades (*pleiades59:pleiades*)** comportant cinq aspects.

Le premier est un **aspect général** permettant de **gérer le duo *code*, *libellé* (*pleiades:donneeTypee*)**.

**Trois aspects** hériteront de cet aspect pour implémenter ce duo :
1. **Le code de groupement du document (*pleiades:codeGroupementPleiades*)**
2.  **Le code famille du document (*pleiades:codeFamillePleiades*)**
3.  **Le code type document (*pleiades:codeTypeDocumentPleiades*)**

Enfin, le dernier aspect est celui que devra porter tous les documents, celui-ci utilisera les aspects définit précédemment qui contiendra toutes les **données pléiades (*pleiades:donneesPleiades*)**.

## Plan de classement
*A remplir*

## Etapes
Pour le développement de cette solution, nous envisageons tout d'abord deux actions : Le stockage, l'envoie en signature  si nécessaire et l'envoi en archivage.

Pour ces deux dernières actions nous utiliseront un ordonnanceur de flux: Pastell.

## Actions
*A remplir*