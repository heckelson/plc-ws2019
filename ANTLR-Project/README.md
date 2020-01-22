# A smol ANTLR v4 Interpreter for arithmetic expressions

## Generating the required files
1. Put the `antlr-4.7.1-complete.jar` into a folder with the `.g4` file and the `readGrammar.sh` script.
2. run `readGrammar.sh` to generate the `.java` files or run the third line manually in a console or shell.

You can now import the java files into an IDE (Eclipse, IntelliJ, ...) or use other stuff.

## Showing the parse tree
1. first generate the required files (see above)
2. run `build.sh` to build the `.class` files
3. run `showTree.sh` to launch the program
4. enter a couple of lines of arithmetic expressions. Make sure you end your input with a newline (press Enter).
5. To launch the GUI, press **CTRL+d**.

Example input:

```bash
heckelson@device:AdvancedCalculator$./showTree.sh
a = 10
b = 20

c = 300 + 2 * b

a + b + c
```

## Using the generated `.java` files with an IDE
1. import the files:
    * all generated `.java` files
    * `AdvancedCalculatorVisitorImpl.java`
    * `AdvancedCalculator.java`
2. Before launching, make sure you uncomment the filenames of your programs in `AdvancedCalculator.java`.

Enjoy!
