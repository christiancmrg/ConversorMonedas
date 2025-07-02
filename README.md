💱 Conversor de Monedas  
📌 Descripción  
Aplicación desarrollada en Java que permite realizar conversiones de monedas utilizando una API de tipo de cambio en tiempo real.

🚀 Funcionalidades  

✅ Conversión entre monedas predefinidas (USD, MXN, COP, BRL).    
✅ Historial de conversiones almacenado en archivo `HistorialConversiones.json`.
✅ Integración con API pública para obtener tasas actualizadas.

🎯 Funcionalidades Extras 
✅ Conversión personalizada entre cualquier par de divisas.  
✅ Conversión múltiple desde una moneda base hacia varias monedas destino.
✅ Validación de entradas numéricas y de texto.    
✅ Sistema de menú principal y menú de funciones extra.  
✅ Visualización del historial de conversiones.  


🛠️ Tecnologías utilizadas  
☕ Java 17+  
📦 Gson (para manejo de JSON)  
🌐 API externa: [ExchangeRate API](https://www.exchangerate-api.com)

📂 Estructura del proyecto  
ConversorMonedas/  
│── src/  
│   ├── principal/Principal.java       # Punto de entrada del programa  
│   ├── conversion/Conversor.java      # Lógica principal de conversión  
│   ├── conversion/ExchangeAPI.java    # Conexión con la API  
│   ├── extras/FuncionesAdicionales.java  # Funciones de menú extra  
│   ├── modelos/RegistroHistorial.java # Estructura de un registro (record)  
│   ├── registro/HistorialConversiones.java # Lectura/Escritura del historial  
│── HistorialConversiones.json         # Archivo donde se guarda el historial  
│── README.md                          # Documentación del proyecto

📖 Instrucciones de uso  
1. Clona este repositorio o descarga los archivos.  
2. Abre el proyecto en tu IDE de Java favorito (Eclipse, IntelliJ, VS Code, etc).  
3. Asegúrate de tener configurado el SDK de Java 17 o superior.  
4. Ejecuta la clase `Principal.java`.  
5. Sigue el menú en consola para elegir las conversiones.

📷 Imagenes
Menu Principal: 
![Menu Principal](https://github.com/user-attachments/assets/00b34c01-07af-4764-9ed4-b31a82a22b08)

Eleccion de moneda predefinida
![Moneda Predefinida](https://github.com/user-attachments/assets/6f43316a-5f09-46b7-884b-ad6d8947ddb7)

Menu Opciones Extra: 
![Moneda Opciones Extra](https://github.com/user-attachments/assets/41695c7f-dd36-4c7d-a1c8-bb3f1bd01b11)

Conversión Personalizada
![Conversion Personalizada](https://github.com/user-attachments/assets/d2098f50-4534-482b-b183-6b9647c35ccd)

Conversión Multiple
![Conversion Multiple](https://github.com/user-attachments/assets/f22a0e23-08d4-40cd-9587-1851c8aeca63)

Historial de Conversiones
![Historial de Conversiones](https://github.com/user-attachments/assets/feb0c338-df6f-4ae2-b824-fbade3b5fca2)

Validacion de Errores:
![Validación de Errores](https://github.com/user-attachments/assets/67e22c27-f11a-4438-849f-fd6c0ec73927)
![Validación de Errores 2](https://github.com/user-attachments/assets/04403e0f-4aac-4ce0-a381-7290f3c945f0)

Salida del Programa:
![Salida](https://github.com/user-attachments/assets/6f5a4541-a595-4026-9028-d6bc6ed76ac2)

📌 Requisitos  
✅ Java 17 o superior  
✅ Acceso a internet (para consultar tasas desde la API)

📌 Desarrollado por  
#Christian Peralta Camargo  
Inspirado en prácticas del programa de formación de #AluraLatam.
