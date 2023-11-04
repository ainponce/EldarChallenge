# EldarChallenge
1. Clonar el repositorio usando los comandos correspondientes.
2. Abrir con el IDE a elección (Intellij, Eclipse, etc).
3. En dicho proyecto nos encontrarmeos dos carpetas "database" y "request_postman".
4. Importaremos el archivo "credit_card.sql" que se encuentra dentro de la carpeta "database", en dicha base hay dos tarjetas agregadas.
5. Run/Corremos la aplicación (la clase EldarAplication).
6. Abrimos nuestra herramienta para testear API's que usemos, en mi caso use Postman, pero pueden usar la que quieran.
7. Testeamos la API, hay creados 5 endpoints en total

## Ejercicio 3 - PL/SQL
La respuesta correcta es 10, solo imprimirá 10 registros.

## Ejercicio 4 - PL/SQL
Le falta un retorno, por lo que no compila (falta la sentencia RETURN del select).

## Ejercicio 5

### Función en JavaScript:
```javascript
let myArray = ["FirstWorld", "SecondWord", "THIRDWORD"];
let result = myArray.join(" ");
result = result.toLowerCase();
console.log(result);

/*JAVA version*/
public String convertirStringArray(String[] arrayEntrada){
  String result = String.join(" ", arrayEntrada);
  result = result.toLowerCase();
  return result;
}
