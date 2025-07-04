# BF Compiler

[![Brainfuck Wikipedia](https://img.shields.io/badge/Wikipedia-Brainfuck-blue)](https://en.wikipedia.org/wiki/Brainfuck)
[![fasm](https://img.shields.io/badge/fasm-1.73.32-orange)](https://en.wikipedia.org/wiki/FASM)

This project this is a lightweight Brainfuck compiler written in C. It parses Brainfuck 
source code and generates x86-64 assembly (FASM syntax) targeting Linux. 
The output can be assembled into a native ELF executable. The compiler supports 
all standard Brainfuck instructions and optimizes memory usage with a 
fixed-size tape. Ideal for learning or experimenting with simple compiler 
design.

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
[ This program prints "Hello World!" and a newline to the screen, its
  length is 106 active command characters. [It is not the shortest.]

  This loop is an "initial comment loop", a simple way of adding a comment
  to a BF program such that you don't have to worry about any command
  characters. Any ".", ",", "+", "-", "<" and ">" characters are simply
  ignored, the "[" and "]" characters just have to be balanced. This
  loop and the commands it contains are ignored because the current cell
  defaults to a value of 0; the 0 value causes this loop to be skipped.
]
++++++++               Set Cell #0 to 8
[
    >++++               Add 4 to Cell #1; this will always set Cell #1 to 4
    [                   as the cell will be cleared by the loop
        >++             Add 2 to Cell #2
        >+++            Add 3 to Cell #3
        >+++            Add 3 to Cell #4
        >+              Add 1 to Cell #5
        <<<<-           Decrement the loop counter in Cell #1
    ]                   Loop until Cell #1 is zero; number of iterations is 4
    >+                  Add 1 to Cell #2
    >+                  Add 1 to Cell #3
    >-                  Subtract 1 from Cell #4
    >>+                 Add 1 to Cell #6
    [<]                 Move back to the first zero cell you find; this will
                        be Cell #1 which was cleared by the previous loop
    <-                  Decrement the loop Counter in Cell #0
]                       Loop until Cell #0 is zero; number of iterations is 8

The result of this is:
Cell no :   0   1   2   3   4   5   6
Contents:   0   0  72 104  88  32   8
Pointer :   ^

>>.                     Cell #2 has value 72 which is 'H'
>---.                   Subtract 3 from Cell #3 to get 101 which is 'e'
+++++++..+++.           Likewise for 'llo' from Cell #3
>>.                     Cell #5 is 32 for the space
<-.                     Subtract 1 from Cell #4 for 87 to give a 'W'
<.                      Cell #3 was set to 'o' from the end of 'Hello'
+++.------.--------.    Cell #3 for 'rl' and 'd'
>>+.                    Add 1 to Cell #5 gives us an exclamation point
>++.                    And finally a newline from Cell #6

```

Program listing:
```
Hello World
```





