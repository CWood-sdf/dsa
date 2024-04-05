# Data types/sizes

`byte` 8bit signed int
`short` 16bit signed int (use Short for unsigned)
`int` 32bit signed int (use Int for unsigned)
`long` 64bit signed
`float` 32bit ieee 754
`double` 64bit ieee 754
`char` 16bit unicode char
`boolean` bool ig

# Read stdin

use `java.util.Scanner`

call constructor with `new Scanner(System.in)`

don't forget to call `Scanner::close()`

# Methods (epic)

# Strong types (also epic)

# Casting

Auto widening, manual narrowing with c-style cast

# Exceptions

`try`, `catch`, `throw`, and `finally`

# if else and else if

# for loops (C++ style)

# for-each

```java

int[] arr = {1, 2, 3};
for(int num : arr){

}
```

# While loops

# switch

```java
switch (expr) {
    case yeet:

    break;
    ...
    default:
}
```

# obj1.compareTo(obj2)

returns 0 if obj2 == obj1, <0 if obj1 < obj2, >0 if obj1 > obj2

(at least defined for strs or on Object)

# `==`

Is a pointer comparison if the two inputs are objects, otherwise is a normal primitive ==

# .equals()

A commonly used method to say if two objects are equal (by value)

(defined on Object, can @Override tho)

# References

Everything's a pointer (exc for primitives) so all basic parameter passing is by ref

# Classes

```java
class Yeet {
    // constructor
    public Yeet() {

    }
};
```

# Compilation

Not to machine code, but instead to java bytecode

jvm then runs the bytecode (so that it's "cross platform")

## Advantages

Cross platform

faster than interpreter

## Disadvantages

Slower than actual compiled binary

# Using basic data structures

```java
interface java.util.List {};
class java.util.LinkedList implements java.util.List {};
class java.util.ArrayList implements java.util.List {};
class java.util.Vector implements java.util.List {};
```

# Interfaces

```java
interface Yeet {
    // the children must impl
    public void yeet();
}

class Child implements Yeet {
    public void yeet(){
        System.out.println("yeet");
    }
}
```

## Polymorphism

Can declare then interface as the type of variable

(Dynamic dispatch)

# Vector

`.size()`: count of elements
`.capacity()`: size of array buffer

## Advantages

so epic (random access)

## Disadvantages

Slower delete

# Generics

```java
class Yeet<T> {

}

// or for constraining

// to ensure t has .compareTo()
class Yeet<T extends Comparable> {

}
```

# Type erasure

Replacing generics with actual types and doing static checking

# LinkedList (so epic)

## Advantages

insert and delete in const times

## Disadvantages

hella slower (cache missing constantly)

no random access

# Iterators

```java

import java.util.*;

class YeetIterator implements Iterator<String> {
  public int i = 0;

  @Override
  public boolean hasNext() {
    return i <= 1;
  }

  @Override
  public String next() {
    if (i == 0) {
      i++;
      return "sdf";
    }
    if (i == 1) {
      i++;
      return "asdf";
    }
    i++;
    return "urmom";
  }

  public YeetIterator() {}
}

class Yeet implements Iterable<String> {
  @Override
  public YeetIterator iterator() {
    return new YeetIterator();
  }
}

```

# Queue

## Array based

Just keep track of end node

front is just arr\[0]

when popping off, have to shift all the elements

## LinkedList based

Keep track of head and tail

adding = append to tail, update tail

removing = return head, move head to head->next

# Stack

## Array based

keep track of last index, just add and remove

## LinkedList based

technically only have to keep track of tail

# Big notation

Big o = time complexity

Big omega = lower bound

big theta = upper bound (the worst case)

# Complexity classes

- P — Polynomial time
- NP — Nondeterministic Polynomial time: (verified in polynomial time by a nondeterministic algo)
- NP complete — all problems at least as hard as the hardest problems in NP (reduced to an NP in polynomial time)
- NP hard — at least as hard as NP complete and can be used to simulate any problem in NP in polynomial time.
- EXPTIME — exponential time
- PSPACE — polynomial space

# Trees (epic)

## Preorder

Do action on node before calling recursion (it will do action top down)

## inorder (binary tree)

Recurse on left, do action, recurse right

## post order

Recurse before action

# Tower of hanoi

(using recursion)

move everything in the stack above the base to the aux rod, move the base to the target, move the big stack from the aux rod to the target

O(n) = 2^n (time)
O(n) = n (space (for callstack))

# AVL Tree

Diff between height of left and right subtree <= 1

Rotation: if tree out of balance, then rotate

Basically if we have tree A -> B -> C,

then rotation produces

B < A,C

right rotation is when B is right of A and C is right of B

left rotation is the opposite

left-right is when A is left of C, and B is right of A (C -> A -> B). First swap A and B, but make A left of B. then do left rotation

right-left is basically same

# Stable sorts

Preserve order if vals are same

R == S -> \[R, S, ...] sorted => \[... R, S, ...]

In place: does not allocate new memory

# Hash collision strats

## Open hashing (chaining)

Every el in table does not actually contain an el, but a linked list of els (bucket) with the matching hash

### Adv/disadv

Efficient for high collision scenarios 

Extra memory 

Lookup/insert/delete = O(1+k/n) (k = num elements)

## Closed hashing

Stores all elements in the table, if a collision, then advance until u find an empty slot, then fill it with element

### Linear Probing

Looks for the next available slot linearly to fix collisions

#### Adv/disadv

Simple impl and cache friendly

Primary clustering (lotsa elements with similar hash leading to only one area in table filled)

Lookup/insert/delete = O(1) on avg, but can degrade to O(n) in worst case

### Quadratic probing

searches with a quadratic function

`H(key, i) = (Hash(key) + c_1 * i + c_2 * i * i) % table.size`

#### Adv/disadv

Less primary clustering

Secondary clustering

Same performance as Linear

### Double hashing

`H(key, i) = (Hash1(key) + i * Hash2(key)) % table.size`

#### Adv/disadv

Uniform distr + less clustering

Requires careful selection of hash fn

Lookup/insert/delete = O(1), but perf can lose if hash fn creates many collisions

# Concurrency

## Process

A seperate program instance that has its own memory and stuff

## Thread

A concurrent line of execution of a program that shares memory with the rest of the process

Proc > thread

### User threads

managed by process and not kernel. faster to make and require less overhead (POSIX and pthread and MS fibers)

### Kernel threads

Managed by kernel. support multiprocessor systems and system scheduling. slower bc context switching bt kernel and user code

### Hybrid threading

putting multiple user threads on one kernel thread

## Deadlock

When two processes or threads depend on each other to finish to continue executing

## Race conditions

When a resource is read by proc A, then written to by proc B, then written to by proc A with a value that is dependent on the read value

(basically two procs or threads accessing same resource at same time)

# Java threading

For a class to be runnable, implement the `Runnable` interface

```java
class YeetThreadable implements Runnable {
    public void run() {
        // idk bro just do some stuff
    }
}
```

Then a thread can be created with:

```java
Thread epic = new Thread(new ThreadClass());
epic.start();
```

## Interrupts

```java
// stops the thread if it is sleeping or otherwise waiting (causes the sleep to throw InterruptedException)
// tho thread still finishes being called (so it might just not yield ctl back)
thread.interrupt();
```

# Java exception handling

just use try-catch-finally

# shared resources and race conditions

ifjsadfjad

# Basic locks

The whole point is to prevent race conditions

one thread is like dawg I got this resource rn, and all the other threads that are waiting to access that resource are like dawg sure then wait for the other thread before accessing the resource

# Deadlocks

oogabooga

# Blocking queue

blocks if trying to read empty queue or put to full queue
