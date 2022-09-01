# Family Tree
## A plain simple JAVA CLI tool to store your family tree

Dillinger is a simple CLI tool made to store your family history in a elaborate manner.

## Features

- Various RelationShip supported - Father , Mother , Son , Daughter , Spouse
- Options to add any  relationShip without changing base models (we can add Uncles, nephews , son-in-laws ,etc. quite easily)
- Data store is implemented by a Interface , so user can use any data store they want (Mysql , Redis , etc)
- Simple and understanble queries

## Queries example
- family-tree add person <full Name>
- family-tree add relationship <name>
- family-tree connect <full name 1> as <relationship> of <full name 2>
- family-tree count sons of <full name>
- family-tree count daughters of <full name>
- family-tree count wives of <full name>
- family-tree father of <full name>
- family-tree mother of <full name>
- family-tree childrens of <full name>
- family-tree sons of <full name>
- family-tree daughters of <full name>


## Pre-requisites
- Java installed
## How to Run

- if you are opening it in a IDE , simple run ``` Main.java ```
- To manually Run
-  - Go to src Folder ,  type ```  javac  Main.java ```
-  - Then type ```  java Main ```,

## How to stop the program
` simple type ``` exit ``` to exit the program.


