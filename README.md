# Conversor de Monedas

Conversor de monedas potenciado por la API: **[ExchangeRate-API.](https://www.exchangerate-api.com/")**

Permite convertir la mayoría de las [monedas existentes](https://www.exchangerate-api.com/docs/supported-currencies "monedas existentes") con valores que se actualizan cada 24 horas.

## Modo de uso

### Selección de moneda de origen

![Moneda_Origen](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/4ebe7137-081c-4ad8-b816-5846b000ee77)

##### Funcionalidades:
- Selección de la moneda de origen:
  - Una de las 8 opciones suministradas.
  - Una búscada por el usuario.
- Cerrar el programa.

### Selección moneda de destino

![Moneda_Destino](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/5916e1b1-4d27-417b-8f79-3abb5038f2f3)

##### Funcionalidades:
- Selección de la moneda de origen:
  - En caso de haber utilizado una de las monedas del menú:
	  - Una de las 7 opciones restantes.
	  - Una búscada por el usuario.
  - En caso de haber buscado una moneda diferente a las suministradas:
	  - Una de las 8 opciones suministradas.
	  - Una búscada por el usuario.
- Ingresar al menú de selección de operaciones.

### Monto a convertir

![Monto_A_Convertir](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/d42b9aea-8c5b-4f8f-b35c-07ee79ba342d)

##### Funcionalidades:
- Ingresar monto a convertir.
- Mostrar conversión:
	- Mostrar moneda origen.
	- Mostrar moneda destino.
	- Mostrar **valor a cambiar**.
	- Mostrar el valor equivalente al **valor a cambiar ** en la moneda de destino.
	- Última actualización del valor de la moneda por parte de la [API](https://www.exchangerate-api.com/ "API").
	- Prócima actualización del valor de la moneda por parte de la [API](https://www.exchangerate-api.com/ "API").
	- Fecha y hora en que se realizó la consulta.
- Mostrar el menú de seleccción de operaciones.}

### Selección de operaciones.

![Seleccion_Operaciones](https://github.com/Anbeld/Challenge-ConversorDeMonedas_BackEnd/assets/147835151/5389b899-b4bd-445e-939c-acce6154bcda)

##### Funcionalidades:

- Realizar otra operación.
	- Mostrar menú de selección de moneda de origen.
- Mostrar historial.
	- Mostrar todas las conversiones realizadas desde el momento en que se inicio la ejecución del programa hasta el momento en que es solicitado dicho historial.
- Cerrar el programa.

