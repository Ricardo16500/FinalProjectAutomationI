# FinalProjectAutomationI

## Integrantes

- Yamil Ignacio Paz Sea
- Fabio Ricardo Vaquera Montero

## Configuración del proyecto

El proyecto contempla los siguientes sistemas operativos:

- Windows 10 (64 bits)
- MacOS Sonoma (14.0) (M1)
- Ubuntu 20.04.3 LTS (64 bits)

** Otros sistemas operativos no han sido probados y probablemente no funcionen correctamente **

## Lineamientos del proyecto

Automatizar la compra de un artículo en el sitio web https://www.demoblaze.com/ utilizando Selenium, Java y TestNG implica los siguientes pasos:

1. Configurar el proyecto: Se debe crear un proyecto Java y agregar las dependencias necesarias de Selenium y TestNG. Luego, configurar el proyecto para admitir tanto Chrome como Firefox.

2. Automatizar la compra: El script de Selenium debe abrir el sitio web, navegar a la sección de laptops, seleccionar un producto, ver los detalles del producto y agregarlo al carrito. Además, debe validar que el producto esté en el carrito y que el resumen del producto sea correcto. Finalmente, se debe completar la compra proporcionando la información necesaria.

3. Generar un reporte HTML: Se debe configurar TestNG para generar un informe HTML que muestre los resultados de los casos de prueba. Esto se logra mediante anotaciones y un archivo XML de configuración.

4. Tomar capturas de pantalla: Es importante capturar pantallas relevantes en cada paso del proceso de automatización. Selenium permite tomar capturas de pantalla y guardarlas en una ubicación específica.

5. Crear un repositorio de GitHub: Se debe crear un repositorio en GitHub que incluya el código fuente, el archivo de configuración de TestNG, las capturas de pantalla y el informe HTML.

6. Agregar un README: En el repositorio, se debe incluir un archivo README.md que explique cómo configurar y ejecutar el proyecto, junto con cualquier información adicional.

7. Compartir el proyecto: Finalmente, se debe compartir el enlace del repositorio de GitHub o un archivo .zip que contenga el proyecto con la solución a la dirección de correo electrónico juandlopezf@gmail.com.

# TODO

- [x] Configurar el proyecto
  - [x] Driver de Chrome para Windows y MacOS(Linux)
  - [x] Driver de Firefox para Windows y MacOS(Linux)
- [x] Automatizar la compra
  - [x] Abrir el sitio web
  - [x] Iniciar sesión
  - [x] Navegar a la sección de laptops
  - [x] Seleccionar un producto
  - [x] Ver los detalles del producto
  - [x] Agregar el producto al carrito
  - [x] Validar que el producto esté en el carrito
  - [x] Validar que el resumen del producto sea correcto
- [x] Generar un reporte HTML
- [x] Tomar capturas de pantalla