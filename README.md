# Proyecto-Aerith

## Descripción del Proyecto
Proyecto-Aerith es un juego de rol (RPG) basado en texto desarrollado en Java. El juego permite al jugador controlar a un personaje llamado Aerith, moverse por un mapa, interactuar con NPCs, recoger objetos y luchar contra enemigos y un jefe final.

### Clases Principales

#### Personajes
- `Character`: Clase abstracta base para todos los personajes
- `Player`: Representa al personaje controlado por el jugador
- `Enemy`: Enemigos básicos que pueden atacar al jugador
- `Boss`: Enemigo final con habilidades especiales
- `NPC`: Personajes no jugables que pueden interactuar con el jugador

#### Objetos
- `Item`: Clase abstracta base para todos los objetos
- `Potion`: Permite recuperar salud
- `Weapon`: Proporciona bonificaciones de ataque
- `Shield`: Proporciona protección (en desarrollo)

#### Interfaces
- `Attackable`: Define comportamiento de ataque
- `Healable`: Define comportamiento de curación
- `Interactable`: Define comportamiento de interacción
- `Movable`: Define comportamiento de movimiento

#### Excepciones
- `CharacterDeadException`: Lanzada cuando se intenta interactuar con un personaje muerto
- `CombatException`: Lanzada cuando hay errores en el sistema de combate
- `InvalidMovementException`: Lanzada cuando se intenta realizar un movimiento inválido

#### Sistema
- `Game`: Clase principal que contiene el bucle de juego
- `Inventory`: Sistema para gestionar los objetos del jugador
- `GameUtils`: Utilidades para generar elementos del juego

## Características del Juego
- Mapa de 10x10 casillas
- Movimiento en cuatro direcciones (WASD)
- Interacción con NPCs (E)
- Sistema de combate por turnos
- Inventario para recoger y usar objetos
- Jefe final en la posición (9,9)
- Encuentros aleatorios con enemigos

## Cómo Jugar
1. Ejecuta la clase `Game` para iniciar el juego
2. Usa las teclas WASD para moverte por el mapa:
   - W: Arriba
   - A: Izquierda
   - S: Abajo
   - D: Derecha
3. Usa la tecla E para interactuar con NPCs cuando estés en la misma posición
4. Los combates se inician automáticamente al encontrarte con un enemigo
5. El objetivo es llegar a la posición (9,9) y derrotar al jefe final

## Requisitos del Sistema
- Java 22 o superior
- JDK compatible

## Desarrollo
Este proyecto fue desarrollado utilizando NetBeans IDE y sigue los principios de la programación orientada a objetos, incluyendo:
- Herencia y polimorfismo
- Encapsulamiento
- Abstracción
- Manejo de excepciones
- Interfaces

## Autor
Facundo Vera
