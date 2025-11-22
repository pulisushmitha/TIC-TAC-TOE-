# TIC-TAC-TOE-
# Tic Tac Toe – Java Console (OOP)
 
I built this using **Object-Oriented Programming (OOP)** concepts to improve my Java skills and understand how a real game works behind the scenes.

---

## Overview

This game is a normal Tic Tac Toe game but with a clean structure and extra options.

It supports:

- Two players (X and O)
- Choice of who should play first
- Automatic win and draw checking
- Option to restart after the match

Basically, it’s a simple game but very useful to understand **arrays, loops, methods, input handling and OOP design** in Java.

---

## Features

- Players can choose **X or O** at the beginning
- The board gets printed **after every move**
- Detects:
  - Win
  - Draw
  - Invalid move
- Replay option available after each match
- Code written using **OOP principles**, so logic is clean and easy to understand

---

## Technologies Used

| Category        | Details |
|----------------|---------|
| Language       | Java 8+ |
| IDE            | VS Code |
| Concepts Used  | OOP, Arrays, Loops, Methods, Input Validation, Exception Handling |

---

## How the Game Works

1. First, the game asks which player should start — **X or O**.
2. Each player enters a number (1–9) to choose a slot on the board.
3. After every move:
   - The board updates
   - The game checks if someone won
   - If no one won, it checks if the game is a draw
4. If the match is completed, the players can choose to **play again** or **exit**.

---

## Sample Console Output

```text
Welcome to the Tic Tac Toe Game!
Who should play first? (X/O): X
X will play first.

|---|---|---|
| 1 | 2 | 3 |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|

X's turn. Enter a slot number (1-9): 5

|---|---|---|
| 1 | 2 | 3 |
|-----------|
| 4 | X | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|