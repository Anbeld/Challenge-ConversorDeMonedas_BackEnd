# Conversor de Monedas

Conversor de monedas potenciado por la API: **[ExchangeRate-API.](https://www.exchangerate-api.com/ "ExchangeRate-API.")**

Permite convertir la mayoría de las [monedas existentes](https://www.exchangerate-api.com/docs/supported-currencies "monedas existentes") con valores que se actualizan cada 24 horas.

## Modo de uso

### Selección de moneda de origen

##### Funcionalidades:
- Selección de la moneda de origen:
  - Una de las 8 opciones suministradas.
  - Una buscada por el usuario.
- Cerrar el programa.

![Moneda_Origen](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/4ebe7137-081c-4ad8-b816-5846b000ee77)

### Selección moneda de destino

##### Funcionalidades:
- Selección de la moneda de origen:
  - En caso de haber utilizado una de las monedas del menú:
	  - Una de las 7 opciones restantes.
	  - Una buscada por el usuario.
  - En caso de haber buscado una moneda diferente a las suministradas:
	  - Una de las 8 opciones suministradas.
	  - Una buscada por el usuario.
- Ingresar al menú de selección de operaciones.

![Moneda_Destino](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/5916e1b1-4d27-417b-8f79-3abb5038f2f3)

### Monto a convertir

##### Funcionalidades:
- Ingresar monto a convertir.
- Mostrar conversión:
	- Mostrar moneda origen.
	- Mostrar moneda destino.
	- Mostrar **valor a cambiar**.
	- Mostrar el valor equivalente al **valor a cambiar** en la moneda de destino.
	- Última actualización del valor de la moneda por parte de la [API](https://www.exchangerate-api.com/ "API").
	- Prócima actualización del valor de la moneda por parte de la [API](https://www.exchangerate-api.com/ "API").
	- Fecha y hora en que se realizó la consulta.
- Mostrar el menú de seleccción de operaciones.

![Monto_A_Convertir](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/d42b9aea-8c5b-4f8f-b35c-07ee79ba342d)

### Selección de una moneda diferente a las suministradas.

##### Funcionalidades:
- Buscar por su código correspondiente la moneda deseado por el usuario.

![Moneda_Busqueda](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/0b4e81d3-3c61-4174-8e58-4ac3059981ba)

### Selección de operaciones.

##### Funcionalidades:

- Realizar otra operación.
	- Mostrar menú de selección de moneda de origen.
- Mostrar historial.
	- Mostrar todas las conversiones realizadas desde el momento en que se inicio la ejecución del programa hasta el momento en que es solicitado dicho historial.
- Cerrar el programa.

![Seleccion_Operaciones](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/c50569d3-4b68-4f21-bb36-aa788a6505d2)

## Historial
Por cada finalización correcta del código se crea un archivo *json* con la información de todas las conversiones realizadas durante la ejecución del conversor. Estos archivos se nombran siguiendo el siguiente patrón **"historialConversiones-yyyy-MM-dd'T'HH-mm-ss"**, siendo la fecha local al momento de cierre del programa la que se registre en el nombre del mismo.

Estos se guardan en la siguiente dirección: **src/com/aluracursos/desafio_challenge_1_back_end/historial**

![Historial_Json](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/0d1fee2e-2c1f-4b6a-8b96-3c22170e1f19)
