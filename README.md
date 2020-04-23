# springTiendaCuadros

Tenim una franquicia de botiga de quadres illegals que fa veure que ven collarets blancs, per aixo es diu "white collar".

Aquesta franquicia te varies botigues, cadascuna amb un nom i una capacitat maxima de quadres (o collars^^).

El client ens demana implementar una API amb Spring amb les seguents funcionalitats:

- POST/shops/
Crear botiga: li direm el nom i la capacitat

- GET/shops/
Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat

- POST/shops/{ID}/pictures
Afegir quadre: li donarem el nom del quadre i el del autor

- GET/shops/{ID}/pictures
Llistar els quadres de la botiga

- DELETE/shops/{ID}/pictures
Incendiar quadres: per si ve la policia, es poden eliminar tots els quadres de la botiga sense deixar rastre.

