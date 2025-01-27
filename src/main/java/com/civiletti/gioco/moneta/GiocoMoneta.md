# Flowchart del lancio di una moneta

All'inizio, il giocatore effettua una scelta: Testa (0) o Croce (1). Durante ogni lancio, il programma mostra il risultato parziale. Al termine di 5 lanci, il vincitore sarà determinato in base al punteggio più alto, sia del giocatore che del PC.

Per la generazione di lanci casuali, si suggerisce di utilizzare la classe Random, del package java.util

```Java
import java.util.Random;
    ...
    int lancio = random.nextInt(2); // Genera un numero casuale (0 o 1)
```


[![](https://mermaid.ink/img/pako:eNp9kkGL2zAQhf_KoBKchYRmW3oxZUsSJxBooXS9ObTuYSKPHVFZCrKcdtf2f-8o6rI5LPVJft_Tm2c8vZC2JJGKyaRXRvkU-sQfqaEkheSALSUziMIencKDppZJD8nJqQbd49pq64L3TVVVwftPz-mPf2GLxeKKrawryV1RiYFqZehF3G6zd--3QW9JWlO-NsuT8-o1cED5q3a2M-UVklUyjuNkUphK29_yiM5DnhWmMMsf9_nyW_4T5vM7GPaq7VCrpyeEVpL2NMCqh5xaj2_Xzkr6NBZmE7yFWcUri4jhFi6GAbLpjsshfICz5QQgqMkEoTNwRq5EIDGMIfCsLthwexOqZDFwWdfKOoOgwHEd7dGrATbTnZGO_4XhSG25XgiyUJKGr-t40EnnA7-kbWJaRlymURx3VkYqz7cG2PbxemHgPw_HzuGBE2kMgdsYmMAdd06G3XT_HMjOmyv-8cI_X_GHWEvMRMNlUJW8dH0YXojLfhUi5WNJFfLnFqIwI1ux8_b-0UiRetfRTHSnEj1lCmuHjUgr1C2rVIYRX-IiX_Z5Jk5ovlvbPF_kZaiP8WX8C6ns8gY?type=png)](https://mermaid.live/edit#pako:eNp9kkGL2zAQhf_KoBKchYRmW3oxZUsSJxBooXS9ObTuYSKPHVFZCrKcdtf2f-8o6rI5LPVJft_Tm2c8vZC2JJGKyaRXRvkU-sQfqaEkheSALSUziMIencKDppZJD8nJqQbd49pq64L3TVVVwftPz-mPf2GLxeKKrawryV1RiYFqZehF3G6zd--3QW9JWlO-NsuT8-o1cED5q3a2M-UVklUyjuNkUphK29_yiM5DnhWmMMsf9_nyW_4T5vM7GPaq7VCrpyeEVpL2NMCqh5xaj2_Xzkr6NBZmE7yFWcUri4jhFi6GAbLpjsshfICz5QQgqMkEoTNwRq5EIDGMIfCsLthwexOqZDFwWdfKOoOgwHEd7dGrATbTnZGO_4XhSG25XgiyUJKGr-t40EnnA7-kbWJaRlymURx3VkYqz7cG2PbxemHgPw_HzuGBE2kMgdsYmMAdd06G3XT_HMjOmyv-8cI_X_GHWEvMRMNlUJW8dH0YXojLfhUi5WNJFfLnFqIwI1ux8_b-0UiRetfRTHSnEj1lCmuHjUgr1C2rVIYRX-IiX_Z5Jk5ovlvbPF_kZaiP8WX8C6ns8gY)


