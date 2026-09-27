# Formation RESTful API — Labs du jour 1

## Contenu
| Dossier | Usage |
|---|---|
| `.devcontainer/` | Environnement Codespaces : Java 21, Maven, VS Code + extensions Java, Spring, REST Client |
| `labs/lab1/petstore.http` | Lab 1 : requêtes vers l'API publique Petstore |
| `labs/banque-api/` | Labs 2 et 3 : API Spring Boot du fil rouge |

## Pour le formateur (une seule fois, avant la session)
1. Créer un dépôt GitHub (ex. `restful-api-labs-j1`) et y pousser ce dossier :
   `git init && git add . && git commit -m "Labs J1" && git branch -M main && git remote add origin <url> && git push -u origin main`
2. Dans **Settings > General**, cocher **Template repository**.
3. Rendre le dépôt public, ou ajouter chaque participant·e en collaborateur.
4. Tester : **Code > Codespaces > Create codespace on main**, puis `cd labs/banque-api && mvn spring-boot:run`.
5. Partager le lien du dépôt aux participant·es le matin du jour 1.

## Pour les participant·es
1. Se connecter à GitHub, ouvrir le lien du dépôt.
2. **Use this template > Create a new repository** (dépôt personnel), puis dans ce nouveau dépôt : **Code > Codespaces > Create codespace on main**.
3. Attendre la fin de l'installation (2 à 3 minutes la première fois).
4. Lab 1 : ouvrir `labs/lab1/petstore.http` et cliquer sur **Send Request**.
5. Labs 2 et 3 : dans le terminal, `cd labs/banque-api` puis `mvn spring-boot:run`.
   - Swagger UI : onglet **Ports**, port 8080, icône globe, puis ajouter `/swagger-ui.html` à l'URL.
   - Tests : ouvrir `labs/banque-api/requetes.http`.

## En cas de problème
- Port 8080 déjà utilisé : `Ctrl+C` dans le terminal où l'API tourne, puis relancer.
- Codespace lent ou bloqué : **Code > Codespaces > ... > Rebuild container**.
- Quota : un compte GitHub gratuit dispose de 120 heures-cœur par mois, largement suffisant (machine 2 cœurs). Arrêter le Codespace le soir.
