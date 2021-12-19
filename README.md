# BF_Interpreter

[![Java version](https://img.shields.io/badge/Java-15.0.1-blue)](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html)
[![Brainfuck Wikipedia](https://img.shields.io/badge/Wikipedia-Brainfuck-blue)](https://en.wikipedia.org/wiki/Brainfuck)


BF interpreter is a interpreter for esoteric programming language called "Brainfuck" created by  Urban Müller.

## Brainfuck

### Commands 
| Character | Meaning |
|:---:|---|
| `>` | Increment the data pointer (to point to the next cell to the right). |
| `<` | Decrement the data pointer (to point to the next cell to the left). |
| `+` | Increment (increase by one) the byte at the data pointer. |
| `-` | Decrement (decrease by one) the byte at the data pointer. |
| `.` | Output the byte at the data pointer. |
| `,` | Accept one byte of input, storing its value in the byte at the data pointer. |
| `[` | If the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching command. |
| `]` | If the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [ command. |


### Example code in BF

There is a symple bf's code for print Hello World taken from wikipedia.

```bf
>+++++++++
[
  <++++++++
  >-
]
<.
>+++++++
[
  <++++
  >-
]
<+.
+++++++..
+++.
[
  -
]
>++++++++
[
  <++++
  >-
] 
<.
>+++++++++++
[
  <++++++++
  >-
]
<-.
--------.
+++.
------.
--------.
[
  -
]
>++++++++
[
  <++++
  >- 
]
<+.
[
  -
]
++++++++++. 

```

Program listing:
```
Hello World
```


## How to use interpreter?

Using this program is quite simple. You need prepare .bf file for interpt and give the path to it in the interpreter's arguments.

```
> BF_Interpreter <Path>/<name your file>.bf
```

You can use `--help` or `-h` to print all information you need to use this program.



