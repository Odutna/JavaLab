# Java Sorting Algorithms Lab

## Obiettivi del Laboratorio
Esplorazione e implementazione di diversi algoritmi di ordinamento in Java, analizzando prestazioni, complessità e caratteristiche di ciascun metodo.

## Algoritmi Implementati

### 1. Bubble Sort
```java
public void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Scambio elementi
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```
- **Complessità**: O(n²)
- **Caratteristiche**: Semplice ma inefficiente per array grandi
- **Funzionamento**: Confronta elementi adiacenti e li scambia se in ordine sbagliato

### 2. Selection Sort
```java
public void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Scambio con il minimo trovato
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}
```
- **Complessità**: O(n²)
- **Caratteristiche**: Meno scambi rispetto a Bubble Sort
- **Funzionamento**: Trova il minimo a ogni iterazione e lo sposta

### 3. Insertion Sort
```java
public void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
```
- **Complessità**: O(n²)
- **Caratteristiche**: Efficiente per piccoli array
- **Funzionamento**: Costruisce l'array ordinato un elemento alla volta

### 4. QuickSort
```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
}
```
- **Complessità**: O(n log n)
- **Caratteristiche**: Molto efficiente, divide et impera
- **Funzionamento**: Sceglie un pivot e partiziona l'array

### 5. MergeSort
```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    // Implementazione del merge
}
```
- **Complessità**: O(n log n)
- **Caratteristiche**: Stabile, prestazioni costanti
- **Funzionamento**: Divide l'array, ordina e ricombina

## Confronto Prestazioni
- **Array Piccoli**: Insertion/Selection Sort
- **Array Grandi**: QuickSort, MergeSort
- **Metodo Consigliato**: `Arrays.sort()` di Java

## Note Conclusive
- Ogni algoritmo ha pro e contro
- La scelta dipende dalla dimensione e tipo di dati
- Importante fare benchmark specifici