
# Utilizzo della radice quadrata per il calcolo dei numeri primi

Il ragionamento matematico dietro l'uso della radice quadrata per verificare se un numero è primo si basa sul fatto che **se un numero `n` non è primo, deve avere almeno un divisore `d` tale che $`d ≤ \sqrt{n}`$**. 

## Dettagli del ragionamento:

### 1. Fattorizzazione:
Ogni numero non primo può essere scritto come prodotto di due fattori:

$[
n = a \times b
]$


Dove `a` e `b` sono divisori di `n`.

### 2. Distribuzione dei divisori:
Se entrambi i fattori fossero maggiori di $\sqrt{n}$, il loro prodotto supererebbe $n$:
$[a > \sqrt{n} \text{ e } b > \sqrt{n} \implies a \times b > n]$
Questo è un'assurdità, poiché $(a 	\times b = n)$. Quindi, almeno uno dei due fattori deve essere **≤ $\sqrt{n}$**.

### 3. Conclusione:
Per verificare se $(n$) è divisibile da qualche numero, è sufficiente controllare tutti i numeri da \(2\) a $(\sqrt{n}$). Se non troviamo divisori in questo intervallo, $(n$) è primo.

## Esempio pratico:
Verifichiamo se $(n = 36)$ è primo:  
- Divisori: \(1, 2, 3, 4, 6, 9, 12, 18, 36\).  
- $(\sqrt{36} = 6)$.  
- I divisori \(2, 3, 4, 6\) si trovano entro \(6\). Quindi, per testare la primalità di \(36\), basta verificare i numeri \(2, 3, 4, 5, 6\).

## Implicazioni:

### 1. Riduzione della complessità:
Invece di testare tutti i numeri da \(2\) a $(n-1)$, basta verificarne $(\sqrt{n})$. Questo riduce significativamente il numero di calcoli per numeri grandi.

### 2. Ottimizzazione algoritmica:
Questo principio è fondamentale per algoritmi efficienti di verifica della primalità, come il $Crivello di Eratostene$.

### 3. Validità universale:
Il ragionamento vale per qualsiasi $(n > 1$), rendendolo un'ottima strategia per migliorare algoritmi legati ai numeri primi.
