# Family Tree
## A plain simple JAVA CLI tool to store your family tree

Dillinger is a simple CLI tool made to store your family history in a elaborate manner.

## Features

- Various RelationShip supported - Father , Mother , Son , Daughter , Wife, Husband
- Options to add any  relationShip without changing base models (we can add Uncles, nephews , son-in-laws ,etc. quite easily)
- Data store is implemented by a Interface , so user can use any data store they want (Mysql , Redis , etc)
- Simple and understanble queries

## Queries example
- family-tree add person {full Name}
- family-tree add relationship {name}
- family-tree connect {full name 1} as <relationship> of {full name 2}
- family-tree count sons of {full name}
- family-tree count daughters of {full name}
- family-tree count wives of {full name}
- family-tree count husbands of {full name}
- family-tree father of {full name}
- family-tree mother of {full name}
- family-tree childrens of {full name}
- family-tree sons of {full name}
- family-tree daughters of {full name}
- family-tree wives of {full name}
- family-tree husbands of {full name}


## Pre-requisites
- Java installed
## How to Run

- if you are opening it in a IDE , simple run ``` Main.java ```
- To manually Run
-  - Go to src Folder ,  type ```  javac  Main.java ```
-  - Then type ```  java Main ```,

## How to stop the program
` simple type ``` exit ``` to exit the program.

## Important Point
suppose we have added a father and son relationShip ,
then we add a person Aman,
then we add a person Shivraj,

Now if Shivraj is the father of Aman ,  then their queries will look like this
``` family-tree connect Aman as son of Shivraj ```
``` family-tree connect Shivraj as  father of Aman ```

>this double query to add a single relation is needed because in the given google doc,
> there was no mention of any query which will assign gender , so techincally if Aman is son of Shivraj , then there is no
> way to know wheather Shivraj will be the father or mother of Aman , unless we assign gender , that's why we have to explicitly create both side relationship
>
>
>
> so this double query can be resolved to a single query , if we have some more concrete requirements with some clarificaions
> like is storing gender mandatory to store

