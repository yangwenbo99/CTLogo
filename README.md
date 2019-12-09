# CTLogo

Our real CS3343 project: CTLogo.

## Introduction 

CTLogo is a modern simple [Logo language][logo] interpreter. 

### Aim of the program

As we have observed, although the technology has been improved a lot since the last few decades, the computer education in primary school has not. 
We, the developing team of this program aim at making a new alternative to old or non-standard existing Logo interpreters for current primary school student. 

### Highlights

- Simple
- Easy to learn
- Almost compatible with old-school PC Logo and MSW Logo.


## Using the interpreter

### System requirement

The interpreter requires JRE (Java Runtime Environment) 10 or above. Compiling or using lower version of JRE may produce unexpected results. Theoretically, this program shall runs on multiple platform, but only the following platforms has been tested by the developers:

- Java 10 (OpenJDK) on Arch Linux 
- Java 10 (zulu-10) on Windows 10 Build 1903


### Run the interpreter

Run the following command on the terminal containing the downloaded `.jar` file. After that, you will see a promote `>>> `, then you can type-in commands. 

```bash
$ {full_path_to_java} -jar CTLogo_version.jar
```

Try the following commands on the program.

```logo
>>> MAKE "A 1
>>> PR :A 
>>> PR SIN :A
>>> MAKE "A :A + 12
>>> MAKE "A 3.14 / 2
>>> PR SIN :A
```

### Language specification

You can refer to wiki or files inside `Docs/language_specificatrion` folder.


[logo]: https://en.wikipedia.org/wiki/Logo_(programming_language)
