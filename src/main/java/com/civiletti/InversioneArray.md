## Struttura Array

 <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 800 400">
  <text x="400" y="50" text-anchor="middle" font-size="24" font-weight="bold">
    Struttura e Operazioni su un Array in Java
  </text>
  <rect x="100" y="100" width="600" height="80" fill="none" stroke="black"/>
  <g font-size="18">
    <rect x="100" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="150" y="150" text-anchor="middle">5</text>
    <rect x="200" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="250" y="150" text-anchor="middle">12</text>
    <rect x="300" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="350" y="150" text-anchor="middle">7</text>
    <rect x="400" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="450" y="150" text-anchor="middle">3</text>
    <rect x="500" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="550" y="150" text-anchor="middle">9</text>
    <rect x="600" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="650" y="150" text-anchor="middle">1</text>
  </g>
  <g font-size="14" fill="gray">
    <text x="125" y="90">indice 0</text>
    <text x="225" y="90">indice 1</text>
    <text x="325" y="90">indice 2</text>
    <text x="425" y="90">indice 3</text>
    <text x="525" y="90">indice 4</text>
    <text x="625" y="90">indice 5</text>
  </g>
  <g stroke="red" stroke-dasharray="5,5">
    <line x1="150" y1="200" x2="150" y2="250" stroke="red"/>
    <text x="160" y="240" fill="red" font-size="16">
      Accesso: array[0] = 5
    </text>
    <line x1="450" y1="200" x2="450" y2="250" stroke="blue"/>
    <text x="460" y="240" fill="blue" font-size="16">
      Modifica: array[3] = 15
    </text>
  </g>
</svg>

# Test

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 800 400">
<text x="400" y="320" text-anchor="middle" font-size="20" font-weight="bold"> Inversione Array </text>
  <g transform="translate(0, 350)">
    <g font-size="18">
      <rect x="100" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="150" y="100" text-anchor="middle">1</text>
      <rect x="200" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="250" y="100" text-anchor="middle">9</text>
      <rect x="300" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="350" y="100" text-anchor="middle">3</text>
      <rect x="400" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="450" y="100" text-anchor="middle">7</text>
      <rect x="500" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="550" y="100" text-anchor="middle">12</text>
      <rect x="600" y="50" width="100" height="80" fill="#f0f0f0" stroke="black"/>
      <text x="650" y="100" text-anchor="middle">5</text>
    </g>
  </g>
 <rect x="100" y="100" width="600" height="80" fill="none" stroke="black"/>
<g font-size="14" fill="gray">
    <text x="125" y="90">indice 0</text>
    <text x="225" y="90">indice 1</text>
    <text x="325" y="90">indice 2</text>
    <text x="425" y="90">indice 3</text>
    <text x="525" y="90">indice 4</text>
    <text x="625" y="90">indice 5</text>
  </g>
  <g stroke="red" stroke-dasharray="5,5">
    <line x1="150" y1="200" x2="150" y2="250" stroke="red"/>
    <text x="160" y="240" fill="red" font-size="16">
      Accesso: array[0] = 5
    </text>
    <line x1="450" y1="200" x2="450" y2="250" stroke="blue"/>
    <text x="460" y="240" fill="blue" font-size="16">
      Modifica: array[3] = 15
    </text>
  </g>
</svg>

# TEST 2

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 800 400">
  <!-- Titolo -->
  <text x="400" y="50" text-anchor="middle" font-size="24" font-weight="bold">
    Struttura e Operazioni su un Array in Java
  </text>

  <!-- Array base -->
  <rect x="100" y="100" width="600" height="80" fill="none" stroke="black"/>

  <!-- Celle dell'array -->
  <g font-size="18">
    <rect x="100" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="150" y="150" text-anchor="middle">5</text>
    <rect x="200" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="250" y="150" text-anchor="middle">12</text>
    <rect x="300" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="350" y="150" text-anchor="middle">7</text>
    <rect x="400" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="450" y="150" text-anchor="middle">3</text>
    <rect x="500" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="550" y="150" text-anchor="middle">9</text>
    <rect x="600" y="100" width="100" height="80" fill="#f0f0f0" stroke="black"/>
    <text x="650" y="150" text-anchor="middle">1</text>
  </g>

  <!-- Indici -->
  <g font-size="14" fill="gray">
    <text x="125" y="90">indice 0</text>
    <text x="225" y="90">indice 1</text>
    <text x="325" y="90">indice 2</text>
    <text x="425" y="90">indice 3</text>
    <text x="525" y="90">indice 4</text>
    <text x="625" y="90">indice 5</text>
  </g>

  <!-- Frecce e annotazioni -->
  <g stroke="red" stroke-dasharray="5,5">
    <line x1="150" y1="200" x2="150" y2="250" stroke="red"/>
    <text x="160" y="240" fill="red" font-size="16">
      Accesso: array[0] = 5
    </text>
    <line x1="450" y1="200" x2="450" y2="250" stroke="blue"/>
    <text x="460" y="240" fill="blue" font-size="16">
      Modifica: array[3] = 15
    </text>
  </g>

  <!-- Inversione array -->
  <text x="400" y="320" text-anchor="middle" font-size="20" font-weight="bold">
    Inversione Array
  </text>

  <g transform="translate(0, 350)">
    <rect x="100" y="50" width="600" height="80" fill="none" stroke="black"/>
    <g font-size="18">
      <rect x="100" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="150" y="100" text-anchor="middle">1</text>
      <rect x="200" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="250" y="100" text-anchor="middle">9</text>
      <rect x="300" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="350" y="100" text-anchor="middle">3</text>
      <rect x="400" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="450" y="100" text-anchor="middle">7</text>
      <rect x="500" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="550" y="100" text-anchor="middle">12</text>
      <rect x="600" y="50" width="100" height="80" fill="#e0e0e0" stroke="black"/>
      <text x="650" y="100" text-anchor="middle">5</text>
    </g>
  </g>
</svg>