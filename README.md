# Sistema de Control de Acceso a Laboratorio

## 📌 Descripción

Este proyecto consiste en el desarrollo de una aplicación en Java que permite gestionar y controlar el acceso de usuarios a un laboratorio técnico.

El sistema registra usuarios, controla entradas y salidas, y genera reportes del tiempo que cada usuario permanece dentro del laboratorio.

Se implementa utilizando arquitectura por capas, almacenamiento en archivos de texto y validaciones para garantizar la integridad de los datos.

---

## 🎯 Objetivo

Desarrollar una aplicación que permita administrar el ingreso de usuarios a un laboratorio, aplicando buenas prácticas de programación, manejo de archivos y separación por capas.

---

## ⚙️ Funcionalidades

### 👤 Gestión de usuarios

* Registro de usuarios (ID, nombre, rol)
* Consulta de usuarios registrados
* Eliminación de usuarios

### 🚪 Control de accesos

* Registro de entrada al laboratorio
* Registro de salida del laboratorio

### ✅ Validaciones

* No permite registrar usuarios con ID duplicado
* No permite doble entrada sin salida previa
* No permite salida sin una entrada registrada
* No permite datos incompletos

### 📊 Reportes

* Historial de accesos por usuario
* Cálculo del tiempo total dentro del laboratorio (en minutos)

---

## 🏗️ Arquitectura del sistema

El proyecto está desarrollado utilizando una arquitectura en capas:

* **entidades:** contiene las clases modelo (Usuario, Acceso)
* **accesodatos:** maneja la lectura y escritura en archivos .txt
* **logicadenegocio:** contiene las reglas del sistema y validaciones
* **presentacion:** interfaz de usuario por consola
* **util:** funciones auxiliares (manejo de fechas y tiempo)

⚠️ Importante: La capa de presentación NO accede directamente a acceso a datos.

---

## 💾 Persistencia de datos

El sistema utiliza archivos de texto para almacenar la información:

* `usuarios.txt`
* `accesos.txt`

Los datos se guardan en formato separado por comas.

Ejemplo:

```
001,Juan,Estudiante
002,Ana,Docente
```

---

## ▶️ Cómo ejecutar el proyecto

1. Abrir el proyecto en Apache NetBeans
2. Ejecutar la clase principal:

```
presentacion.Main
```

3. Utilizar el menú en consola para interactuar con el sistema

---

## 🛠️ Tecnologías utilizadas

* Java
* Programación Orientada a Objetos (POO)
* Manejo de archivos (.txt)
* Arquitectura en capas

---

## 📂 Estructura del proyecto

```
src/
 ├── entidades
 ├── accesodatos
 ├── logicadenegocio
 ├── presentacion
 └── util
```

---

## 📊 Ejemplo de uso

1. Registrar un usuario
2. Registrar entrada al laboratorio
3. Registrar salida
4. Consultar historial
5. Ver tiempo total acumulado

---

## 📌 Autor

Estudiante de Programación III
Universidad Latina de Costa Rica

---

## ✅ Estado del proyecto

✔ Proyecto funcional
✔ Cumple con los requisitos solicitados
✔ Incluye validaciones y manejo de errores
✔ Documentación completa incluida
