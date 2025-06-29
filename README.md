ed_clone_by_Mudassir (Kotlin Edition)

A minimalist, line-based text editor inspired by the original UNIX 'ed'.  
Rebuilt in Kotlin for clean structure and modern syntax, while keeping the retro hacker feel — no GUI, no colors, just raw terminal commands.

GitHub Repository: https://github.com/mudassir-92/ed_clone_by_Mudassir

Features:
- a  → Append lines after a specific line
- i  → Insert lines before a specific line
- d  → Delete a line or range of lines
- p  → Print one or more lines
- w  → Write the buffer to file
- q  → Quit the editor
- h  → Help (optional)

How to Run (Kotlin):
1. Make sure you have Kotlin installed.
2. Compile:
   kotlinc Editor.kt -include-runtime -d ed_clone_by_Mudassir.jar
3. Run:
   java -jar ed_clone_by_Mudassir.jar myfile.txt

Command Examples:
1a
This is line 2
.
2i
This goes above line 2
.
3d
1p,2p
w
q

Rules:
- End a or i input with a single dot (.) on a new line
- Line numbers must be valid, or it will show an error
- If no line number is given, the editor uses the current line

Why This Project:
This project recreates the original 'ed' line editor experience using Kotlin. It's ideal for learning how text editors work from the ground up — managing buffers, parsing commands, handling files — all in a clean, modern language.

Author:
Mudassir  
BS Software Engineering | Junior Developer

License:
MIT License
